package com.rocket.laf.service.impl;

import java.util.List;

import com.rocket.laf.common.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.mapper.LostMapper;
import com.rocket.laf.mapper.PictureMapper;
import com.rocket.laf.service.LostService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LostServiceImpl implements LostService {

    @Autowired
    private final LostMapper lostMapper;
    private final PictureMapper pictureMapper;
    private final FileUtils fileUtils;

    @Override
    public List<LostDto> getLostBoardList() {
        return lostMapper.getLostBoardList();
    }

    public LostDto getLostBoardOne(String lBoardNo) {
        return lostMapper.getLostBoardOne(lBoardNo);
    }

    @Transactional
    @Override
    public void insertLostBoard(LostDto LostDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        List<PictureDto> list = fileUtils.parseFileInfo(LostDto.getLBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            lostMapper.writelBoardFileList(list);
            lostMapper.insertLostBoard(LostDto);
        } else {
            lostMapper.insertLostBoard(LostDto);
            pictureMapper.insertPicBoardNo(LostDto.getLBoardNo());
        }
    }

    @Override
    public void updatelBoardDetail(LostDto LostDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        List<PictureDto> list = fileUtils.parseFileInfo(LostDto.getLBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            lostMapper.updatelBoardDetail(LostDto);
            lostMapper.writelBoardFileList(list);
        } else {
            lostMapper.updatelBoardDetail(LostDto);
            pictureMapper.insertPicBoardNo(LostDto.getLBoardNo());
        }
    }

}
