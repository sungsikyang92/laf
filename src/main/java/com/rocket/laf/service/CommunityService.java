package com.rocket.laf.service;

import com.rocket.laf.dto.CommunityDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

import com.rocket.laf.dto.CommunityDto;

public interface CommunityService {

    List<CommunityDto> getComBoardList();

    void writeComBoard(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    CommunityDto getComBoardDetail(String cBoardNo);

    int updateComBoardDetail(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest);

    int deleteComBoardDetail(String cBoardNo);

    String getLastCBoardNo();
}
