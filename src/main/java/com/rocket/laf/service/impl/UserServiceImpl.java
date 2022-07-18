package com.rocket.laf.service.impl;


import com.rocket.laf.dto.UserDto;
import com.rocket.laf.mapper.UserMapper;
import com.rocket.laf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
@Override
    public UserDto login(UserDto dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public UserDto getUserById(long userNo) {
        return userMapper.getUserById(userNo);
    }
}
