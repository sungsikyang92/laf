package com.rocket.laf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.mapper.PictureMapper;
import com.rocket.laf.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<PictureDto> getAllPictuer(String picNo) {
        return pictureMapper.getAllPictuer(picNo);
    }

    @Override
    public String getMainPicLoc(long picNo) {
        return pictureMapper.getMainPicLoc(picNo);
    }

    @Override
    public PictureDto getAllPictureByPicNo(long picNo) {
        return pictureMapper.getAllPictureByPicNo(picNo);
    }

}
