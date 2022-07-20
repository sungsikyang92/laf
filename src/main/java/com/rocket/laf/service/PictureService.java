package com.rocket.laf.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

import com.rocket.laf.dto.PictureDto;

public interface PictureService {

    // 모든 사진 가져오기
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

    List<PictureDto> getMainPictureByBoardNo(String boardNo);
}
