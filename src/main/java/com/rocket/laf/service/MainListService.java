package com.rocket.laf.service;

import com.rocket.laf.dto.MainListDto;

import java.util.List;

public interface MainListService {
    List<MainListDto> getTestComBoardList();
    List<MainListDto> getBoardFoundListByCategory(String category);
    List<MainListDto> getBoardLostListByCategory(String category);
}