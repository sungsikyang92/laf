package com.rocket.laf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.UserDto;
import com.rocket.laf.mapper.UserMapper;
import com.rocket.laf.service.MypageService;

@Service
public class MypageServiceImpl implements MypageService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
    public List<UserDto> getUserList() {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public int insertUserBoard(UserDto userDto) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
