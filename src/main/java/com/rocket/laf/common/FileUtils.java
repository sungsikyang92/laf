//package com.rocket.laf.common;
//
//import com.rocket.laf.dto.ComPicTestDto;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import java.io.File;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Component
//public class FileUtils {
//
//    public List<ComPicTestDto> parseFileInfo(long picNo, MultipartHttpServletRequest multipartHttpServletRequest) {
//        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
//            return null;
//        }
//        List<ComPicTestDto> fileList = new ArrayList<>();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
//        ZonedDateTime current = ZonedDateTime.now();
//        String path = "/resources/static/img/communityBoard/" + current.format(format);
//        File file = new File(path);
//        if (file.exists() == false) {
//            file.mkdir();
//        }
//
//        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//
//        String newFileName, originalFileExtension, contentType;
//
//        while (iterator.hasNext()) {
//            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
//            for (MultipartFile multipartFile : list) {
//                if (multipartFile.isEmpty() == false) {
//                    contentType = multipartFile.getContentType();
//                    if (ObjectUtils.isEmpty(contentType)) {
//                        break;
//                    } else {
//                        if (contentType.contains("image/jpeg")) {
//                            originalFileExtension = ".jpg";
//                        } else if (contentType.contains("image/png")) {
//                            originalFileExtension = ".png";
//                        } else if (contentType.contains("image/gif")) {
//                            originalFileExtension = ".gif";
//                        } else {
//                            break;
//                        }
//                    }
//
//                    newFileName
//                }
//            }
//        }
//    }
//}
