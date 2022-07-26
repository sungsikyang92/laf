package com.rocket.laf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.mapper.LostMapper;
import com.rocket.laf.service.LostService;

@Service
public class LostServiceImpl implements LostService {

    @Autowired
    private LostMapper lostMapper;

    @Override
    public List<LostDto> getLostBoardList() {
        return lostMapper.getLostBoardList();
    }

    @Override
    public int insertLostBoard(LostDto LostDto) {
        return lostMapper.insertLostBoard(LostDto);
    }

    @Override
    public List<LostDto> getLostBoardOne(String lBoardNo) {
        return lostMapper.getLostBoardOne(lBoardNo);
    }

}