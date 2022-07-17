package com.rocket.laf.common;

import com.rocket.laf.dto.ComPicTestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {

    @Autowired
    ResourceLoader resourceLoader;

    public List<ComPicTestDto> parseFileInfo(long cBoardNo, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;
        }
        List<ComPicTestDto> fileList = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String rootPath = Path.of(resourceLoader.getResource("classpath:static").getURI()).toString() + "/img/communityBoard/";
        String path = rootPath + current.format(format);
        File file = new File(path);
        if (file.exists() == false) {
            file.mkdir();
        }

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFileName, originalFileExtension, contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                if (multipartFile.isEmpty() == false) {
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    } else {
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
                    ComPicTestDto comPicTestDto = new ComPicTestDto();
                    comPicTestDto.setCBoardNo(cBoardNo);
                    comPicTestDto.setFileSize(multipartFile.getSize());
                    comPicTestDto.setOriginalFileName(multipartFile.getOriginalFilename());
                    comPicTestDto.setStoredFilePath(path + "/" + newFileName);
                    fileList.add(comPicTestDto);

                    file = new File(path + "/" + newFileName);
                    multipartFile.transferTo(file);
                }
            }
        }
        return fileList;
    }
}
