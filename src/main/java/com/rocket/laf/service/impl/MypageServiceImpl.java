package com.rocket.laf.service.impl;

import java.util.List;

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
    public MypageDto userinfo(MypageDto mypagedto) {
        return mypageMapper.userinfo(mypagedto);
    }

    @Override
    public MypageDto selectOneforPicture(long picno) {
        return mypageMapper.selectOneforPicture(picno);
    }

    @Override
    public String uploadPic(long picno) {
        return mypageMapper.uploadPic(picno);
    }

    @Override
    public UserDto selectOneforLocation(String userlocation) {
        return mypageMapper.selectOneforLocation(userlocation);
    }

    @Override
    public List<UserDto> selectOne(String userId) {
        return mypageMapper.selectOne(userId);
    }

    @Override
    public int update(MypageDto dto) {
        return mypageMapper.update(dto);
    }

    @Override
    public List<UserDto> selectList(long userNo) {
        return mypageMapper.selectlist(userNo);
    }

    
}
