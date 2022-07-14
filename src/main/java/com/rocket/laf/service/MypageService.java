package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.UserDto;

public interface MypageService {
    List<UserDto> getUserList();
    int insertUserBoard(UserDto userDto);
}









