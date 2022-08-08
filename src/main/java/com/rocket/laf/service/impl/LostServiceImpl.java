package com.rocket.laf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rocket.laf.common.FileUtils;
import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.mapper.LostMapper;
import com.rocket.laf.mapper.PictureMapper;
import com.rocket.laf.service.LostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LostServiceImpl implements LostService {

    private final LostMapper lostMapper;
    private final PictureMapper pictureMapper;
    private final FileUtils fileUtils;

    @Override
    public List<LostDto> getLostBoardList() {
        return lostMapper.getLostBoardList();
    }

    @Override
    public List<LostDto> getLostBoardLostList() {
        return lostMapper.getLostBoardLostList();
    }

    @Override
    public List<LostDto> getLostBoardFindList() {
        return lostMapper.getLostBoardFindList();
    }

    public LostDto getLostBoardOne(String boardNo) {
        return lostMapper.getLostBoardOne(boardNo);
    }

    @Transactional
    @Override
    public void insertLostBoard(LostDto LostDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        List<PictureDto> list = fileUtils.parseFileInfo(LostDto.getBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            lostMapper.insertLostBoard(LostDto);
            lostMapper.writelBoardFileList(list);
        } else {
            lostMapper.insertLostBoard(LostDto);
            pictureMapper.insertPicBoardNo(LostDto.getBoardNo());
        }
    }

    @Override
    public void updatelBoardDetail(LostDto LostDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        List<PictureDto> list = fileUtils.parseFileInfo(LostDto.getBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            lostMapper.updatelBoardDetail(LostDto);
            lostMapper.writelBoardFileList(list);
        } else {
            lostMapper.updatelBoardDetail(LostDto);
            pictureMapper.insertPicBoardNo(LostDto.getBoardNo());
        }
    }

   
}