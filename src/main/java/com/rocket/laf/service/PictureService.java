package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.PictureDto;

public interface PictureService {
    //    모든 사진 가져오기
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

    //대표 사진 한장 가져오기
    PictureDto getMainPictureByBoardNo(String boardNo);
}
