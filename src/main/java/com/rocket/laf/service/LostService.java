package com.rocket.laf.service;

import java.util.List;

import com.rocket.laf.dto.LostDto;

public interface LostService {
    List<LostDto> getLostBoardList();

    int insertLostBoard(LostDto LostDto);
}
