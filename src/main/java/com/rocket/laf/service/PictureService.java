package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.PictureDto;

public interface PictureService {

    List<PictureDto> getAllPicture(String picNo);

    String getMainPicLoc(long picNo);

}
