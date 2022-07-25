package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.dto.UserDto;

public interface MypageService {

    public List<UserDto> selectList(long userNo);
    public List<UserDto> selectOne(String userId);
    
    public MypageDto userinfo(MypageDto mypagedto);
    MypageDto selectOneforPicture(long picno);
    String uploadPic(long picno);
    UserDto selectOneforLocation(String userlocation);
    public int update(MypageDto dto);
}
