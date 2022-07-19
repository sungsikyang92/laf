package com.rocket.laf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.UserDto;
import com.rocket.laf.mapper.UserMapper;
import com.rocket.laf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto secUser = userMapper.secLogin(username);

        if (secUser == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }
        List<GrantedAuthority> auth = new ArrayList<>();
        if (secUser.getUserGrade().equals("BASIC")){
            auth.add(new SimpleGrantedAuthority("USER"));
        }else{
            auth.add(new SimpleGrantedAuthority("ADMIN"));
        }
        User secReturnUser = new User(secUser.getUserId(), secUser.getUserPw(), auth);
        return secReturnUser;
    }
}
