package com.rocket.laf.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

import com.rocket.laf.dto.PictureDto;

public interface PictureService {

    List<PictureDto> getAllPictuer(String picNo);

    String getMainPicLoc(long picNo);

    //    모든 사진 가져오기
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

    // filesystem

    void init();

    void store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
