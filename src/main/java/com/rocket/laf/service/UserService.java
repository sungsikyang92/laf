package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.PenaltyDto;
import com.rocket.laf.dto.UserDto;

public interface UserService {

    public UserDto login(UserDto dto);
    public int regUser(UserDto dto);
    public int chkDuplicatedId(String idFromJson);
    UserDto getUserById(long userNo);
    public int regUserSocial(UserDto dto);
    public UserDto chkUserSocialData(String userEmail);
    public void deletePenalty(String userId);
    public void updatePenalty(List<PenaltyDto> list);
}