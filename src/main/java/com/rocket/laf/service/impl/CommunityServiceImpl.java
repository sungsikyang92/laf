package com.rocket.laf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.mapper.CommunityMapper;
import com.rocket.laf.service.CommunityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private final CommunityMapper communityMapper;

    @Override
    public List<CommunityDto> getComBoardList() {
        return communityMapper.getComBoardList();
    }

    @Override
    public int insertComBoard(CommunityDto communityDto) {
        return communityMapper.insertComBoard(communityDto);
    }
}