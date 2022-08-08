package com.rocket.laf.service;

import com.rocket.laf.dto.MainListDto;

import java.util.List;

public interface MainListService {
    List<MainListDto> getTestComBoardList();
    List<MainListDto> getBoardListByCategory(String category);
}