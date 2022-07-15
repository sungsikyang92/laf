package com.rocket.laf.service;

import com.rocket.laf.dto.CommunityDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface CommunityService {

    List<CommunityDto> getComBoardList();

    int insertComBoard(CommunityDto communityDto);

    CommunityDto getComBoardDetail(int cBoardNo);

    int updateComBoardDetail(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest);

    int deleteComBoardDetail(int cBoardNo);
}
