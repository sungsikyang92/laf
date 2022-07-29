package com.rocket.laf.service.impl;

import com.rocket.laf.common.FileUtils;
import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.mapper.CommunityMapper;
import com.rocket.laf.mapper.PictureMapper;
import com.rocket.laf.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;
    private final PictureMapper pictureMapper;
    private final FileUtils fileUtils;

    @Override
    public List<CommunityDto> getComBoardList() {
        return communityMapper.getComBoardList();
    }

    @Transactional
    @Override
    public void writeComBoard(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        List<PictureDto> list = fileUtils.parseFileInfo(communityDto.getCBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            communityMapper.writeComBoard(communityDto);
            communityMapper.writeComBoardFileList(list);
        } else {
            communityMapper.writeComBoard(communityDto);
//            pictureMapper.insertPicBoardNo(communityDto.getCBoardNo());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public CommunityDto getComBoardDetail(String cBoardNo) throws Exception {
        CommunityDto communityDto = communityMapper.getComBoardDetail(cBoardNo);
        return communityDto;
    }

    @Transactional
    @Override
    public void updateComBoardDetail(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        communityMapper.updateComBoardDetail(communityDto);
        List<PictureDto> list = fileUtils.parseFileInfo(communityDto.getCBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            for (PictureDto pictureDto : list) {
                System.out.println(pictureDto.getOriginalFileName());
            }
            communityMapper.writeComBoardFileList(list);
        }

    }

    @Transactional
    @Override
    public int deleteComBoardDetail(String cBoardNo) {
        return communityMapper.deleteComBoardDetail(cBoardNo);
    }

    @Transactional(readOnly = true)
    @Override
    public String getLastCBoardNo() {
        return communityMapper.getLastCBoardNo();
    }
}