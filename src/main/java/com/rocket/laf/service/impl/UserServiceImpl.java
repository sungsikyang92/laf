package com.rocket.laf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.UserDto;
import com.rocket.laf.mapper.UserMapper;
import com.rocket.laf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto login(UserDto dto) {
        return userMapper.login(dto);
    }

    @Override
    public int regUser(UserDto dto) {
        return userMapper.register(dto);
    }
    
    @Override
    public UserDto getUserById(long userNo) {
        return userMapper.getUserById(userNo);
    }

    @Override
    public int chkDuplicatedId(String idFromJson) {
        return userMapper.chkDuplicatedId(idFromJson);
    }
}
