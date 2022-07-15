package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.PictureDto;

public interface PictureService {

    List<PictureDto> getAllPictuer(String picNo);

    String getMainPicLoc(long picNo);

    //    모든 사진 가져오기
    PictureDto getAllPictureByPicNo(long picNo);

}
