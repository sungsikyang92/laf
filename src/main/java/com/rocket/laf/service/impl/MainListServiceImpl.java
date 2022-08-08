package com.rocket.laf.service.impl;

import com.rocket.laf.dto.MainListDto;
import com.rocket.laf.mapper.MainListMapper;
import com.rocket.laf.service.MainListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainListServiceImpl implements MainListService {

    private final MainListMapper mainListMapper;

    @Override
    public List<MainListDto> getTestComBoardList() {
        return mainListMapper.getTestComBoardList();
    }

    @Override
    public List<MainListDto> getBoardListByCategory(String category) {
        return mainListMapper.getBoardListByCategory(category);
    }
}