package com.rocket.laf.service;

import com.rocket.laf.dto.UserDto;

public interface UserService {

    public UserDto login(UserDto dto);
    public int regUser(UserDto dto);
    public int chkDuplicatedId(String idFromJson);
    UserDto getUserById(long userNo);
}
