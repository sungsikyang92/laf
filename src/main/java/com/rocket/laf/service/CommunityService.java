package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.CommunityDto;

public interface CommunityService {
    List<CommunityDto> getComBoardList();

    int insertComBoard(CommunityDto communityDto);
}
