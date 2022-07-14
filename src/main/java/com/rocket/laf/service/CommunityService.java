package com.rocket.laf.service;

import com.rocket.laf.dto.CommunityDto;

import java.util.List;

public interface CommunityService {
    List<CommunityDto> getComBoardList();
    int insertComBoard(CommunityDto communityDto);
    CommunityDto getComBoardDetail(int cBoardNo);
}
