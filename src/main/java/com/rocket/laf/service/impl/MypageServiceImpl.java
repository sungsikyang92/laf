package com.rocket.laf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.dto.UserDto;
import com.rocket.laf.mapper.MypageMapper;
import com.rocket.laf.service.MypageService;

@Service
public class MypageServiceImpl implements MypageService {
    
    @Autowired
    private MypageMapper mypageMapper;

    @Override
    public MypageDto userinfo(MypageDto mypageDto) {
        return mypageMapper.userinfo(mypageDto);
    }

    @Override
    public MypageDto selectOneforPicture(long picNo) {
        return mypageMapper.selectOneforPicture(picNo);
    }

    @Override
    public String uploadPic(long picNo) {
        return mypageMapper.uploadPic(picNo);
    }

    @Override
    public UserDto selectOneforLocation(String userLocation) {
        return mypageMapper.selectOneforLocation(userLocation);
    }

    @Override
    public MypageDto selectOne(long userNo) {
        return mypageMapper.selectOne(userNo);
    }

    @Override
    public int update(MypageDto dto) {
        return mypageMapper.update(dto);
    }

    
}
