package com.rocket.laf.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rocket.laf.dto.LostDto;

public interface LostService {
    List<LostDto> getLostBoardList();

    List<LostDto> getLostBoardLostList();

    List<LostDto> getLostBoardFindList();

    LostDto getLostBoardOne(String lBoardNo);

    void insertLostBoard(LostDto LostDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

    void updatelBoardDetail(LostDto LostDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;

}