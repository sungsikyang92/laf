package com.rocket.laf.service;

import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.dto.UserDto;

public interface MypageService {
    public MypageDto userinfo(MypageDto mypageDto);
    MypageDto selectOneforPicture(long picNo);
    String uploadPic(long picNo);
    UserDto selectOneforLocation(String userLocation);
    public MypageDto selectOne(long userNo);
    public int update(MypageDto dto);
}
