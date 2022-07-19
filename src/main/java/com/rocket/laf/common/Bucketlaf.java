package com.rocket.laf.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class Bucketlaf {

    private final String endPoint = "https://kr.object.ncloudstorage.com";
    private final String regionName = "kr-standard";
    private final String accessKey = "A349D21955590B8D04CE";
    private final String secretKey = "B78947A41F569C599AACD1E4C1FDFA44F5854233";
    private String bucketName = "rocket-laf";

    // S3 client
    final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
            .build();

    private final Logger log = LoggerFactory.getLogger(Bucket.class.getName());

    public void BucketCreate() {
        try {
            // create bucket if the bucket name does not exist
            if (s3.doesBucketExistV2(bucketName)) {
                System.out.format("Bucket %s already exists.\n", bucketName);
            } else {
                s3.createBucket(bucketName);
                System.out.format("Bucket %s has been created.\n", bucketName);
            }
        }

        catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }

    }

    // 버킷 목록 조회
    public void bucketSearch() {

        try {
            List<Bucket> buckets = s3.listBuckets();
            System.out.println("Bucket List: ");
            for (Bucket bucket : buckets) {
                System.out.println("    name=" + bucket.getName() + ", creation_date=" +
                        bucket.getCreationDate()
                        + ", owner=" + bucket.getOwner().getId());
            }
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
        log.info("#############################1");
    }

    // 파일업로드
    public void bucketFileUpload(String boardNo, MultipartHttpServletRequest multipartHttpServletRequest)
            throws IllegalStateException, IOException {

        String folderName = "";
        // create folder
        if (boardNo.contains("com")) {
            folderName = "communityPic/";
        } else if (boardNo.contains("l")) {
            folderName = "lostPic/";
        } else {
            System.out.format("에러뜸 님", folderName);
        }

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(0L);
        objectMetadata.setContentType("application/x-directory");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
                folderName,
                new ByteArrayInputStream(new byte[0]), objectMetadata);
        try {
            s3.putObject(putObjectRequest);
            System.out.format("Folder %s has been created.\n", folderName);
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }

        // filePathtime
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();

        // filePath
        String filePath = "";

        if (boardNo.contains("com")) {
            filePath = "C" + current.format(format);
        } else if (boardNo.contains("l")) {
            filePath = "L" + current.format(format);
        } else {
            System.out.format("에러뜸 님", filePath);
        }

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFileName = "", originalFileExtension, contentType;

        File file = new File(filePath);
        if (file.exists() == false) {
            file.mkdir();
        }

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                if (multipartFile.isEmpty() == false) {
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
                        // 저장되는 파일의 형태를 확인 후, 해당하는 확장자명으로 저장합니다.
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        } else {
                            break;
                        }
                    }

                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

                    file = new File(filePath + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }

        // upload local file
        String objectName = filePath + "/" + newFileName;

        try {
            s3.putObject(bucketName, objectName, new File(filePath));
            System.out.format("Object %s has been created.\n", objectName);
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    // 파일리스트 조회
    public void bucketFileSearchList() {

        // list all in the bucket
        try {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                    .withBucketName(bucketName)
                    .withMaxKeys(300);

            ObjectListing objectListing = s3.listObjects(listObjectsRequest);

            System.out.println("Object List:");
            while (true) {
                for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                    System.out.println("    name=" + objectSummary.getKey() + ", size=" +
                            objectSummary.getSize()
                            + ", owner=" + objectSummary.getOwner().getId());
                }

                if (objectListing.isTruncated()) {
                    objectListing = s3.listNextBatchOfObjects(objectListing);
                } else {
                    break;
                }
            }
        } catch (AmazonS3Exception e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }

        // top level folders and files in the bucket
        try {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                    .withBucketName(bucketName)
                    .withDelimiter("/")
                    .withMaxKeys(300);

            ObjectListing objectListing = s3.listObjects(listObjectsRequest);

            System.out.println("Folder List:");
            for (String commonPrefixes : objectListing.getCommonPrefixes()) {
                System.out.println("    name=" + commonPrefixes);
            }

            System.out.println("File List:");
            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println("    name=" + objectSummary.getKey() + ", size=" +
                        objectSummary.getSize()
                        + ", owner=" + objectSummary.getOwner().getId());
            }
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

    // 버킷 멀티파트
    public void bucketFileUploadMultipart(String boardNo, List<MultipartFile> mlp)
            throws IllegalStateException, IOException {

        // Iterator<String> iterator = mlp.;





        

        /* 
        File file = new File("/tmp/sample.file");
        long contentLength = file.length();
        long partSize = 10 * 1024 * 1024;

        String folderName = "";
        // create folder
        if (boardNo.contains("com")) {
            folderName = "communityPic/";
        } else if (boardNo.contains("l")) {
            folderName = "lostPic/";
        } else {
            System.out.format("에러뜸 님", folderName);
        }

        // filePathtime
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();

        // filePath
        String filePath = "";

        if (boardNo.contains("com")) {
            filePath = "communityPic/" + current.format(format);
        } else if (boardNo.contains("l")) {
            filePath = "lostPic/" + current.format(format);
        } else {
            System.out.format("에러뜸 님", filePath);
        }

        String newFileName = "", originalFileExtension, contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                if (multipartFile.isEmpty() == false) {
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
                        // 저장되는 파일의 형태를 확인 후, 해당하는 확장자명으로 저장합니다.
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        } else {
                            break;
                        }
                    }

                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

                    file = new File(filePath + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }

        String objectName = newFileName;

        try {
            // initialize and get upload ID
            InitiateMultipartUploadResult initiateMultipartUploadResult = s3
                    .initiateMultipartUpload(new InitiateMultipartUploadRequest(bucketName,
                            objectName));
            String uploadId = initiateMultipartUploadResult.getUploadId();

            // upload parts
            List<PartETag> partETagList = new ArrayList<PartETag>();

            long fileOffset = 0;
            for (int i = 1; fileOffset < contentLength; i++) {
                partSize = Math.min(partSize, (contentLength - fileOffset));

                UploadPartRequest uploadPartRequest = new UploadPartRequest()
                        .withBucketName(bucketName)
                        .withKey(objectName)
                        .withUploadId(uploadId)
                        .withPartNumber(i)
                        .withFile(file)
                        .withFileOffset(fileOffset)
                        .withPartSize(partSize);

                UploadPartResult uploadPartResult = s3.uploadPart(uploadPartRequest);
                partETagList.add(uploadPartResult.getPartETag());

                fileOffset += partSize;
            }

            // abort
            // s3.abortMultipartUpload(new AbortMultipartUploadRequest(bucketName,
            // objectName, uploadId));

            // complete
            CompleteMultipartUploadResult completeMultipartUploadResult = s3.completeMultipartUpload(
                    new CompleteMultipartUploadRequest(bucketName, objectName, uploadId, partETagList));
        } catch (AmazonS3Exception e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }
*/
}
