package com.rocket.laf.service.impl;

import com.rocket.laf.common.FileUtils;
import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.mapper.CommunityMapper;
import com.rocket.laf.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
    private final FileUtils fileUtils;

    @Override
    public List<CommunityDto> getComBoardList() {
        return communityMapper.getComBoardList();
    }

    @Override
    public void writeComBoard(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        communityMapper.writeComBoard(communityDto);
        List<PictureDto> list = fileUtils.parseFileInfo(communityDto.getCBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            communityMapper.writeComBoardFileList(list);
        }
    }

    @Override
    public CommunityDto getComBoardDetail(String cBoardNo) throws Exception {
        CommunityDto communityDto = communityMapper.getComBoardDetail(cBoardNo);
        return communityDto;
    }

    @Override
    public void updateComBoardDetail(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        communityMapper.updateComBoardDetail(communityDto);
        List<PictureDto> list = fileUtils.parseFileInfo(communityDto.getCBoardNo(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            communityMapper.writeComBoardFileList(list);
        }

    }

    @Override
    public int deleteComBoardDetail(String cBoardNo) {
        return communityMapper.deleteComBoardDetail(cBoardNo);
    }

    @Override
    public String getLastCBoardNo() {
        return communityMapper.getLastCBoardNo();
    }
}