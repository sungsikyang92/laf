package com.rocket.laf.service.impl;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.mapper.CommunityMapper;
import com.rocket.laf.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;

    @Override
    public List<CommunityDto> getComBoardList() {
        return communityMapper.getComBoardList();
    }

    @Override
    public int insertComBoard(CommunityDto communityDto) {
        return communityMapper.insertComBoard(communityDto);
    }

    @Override
    public CommunityDto getComBoardDetail(int cBoardNo) {
        return communityMapper.getComBoardDetail(cBoardNo);
    }

    @Override
    public int updateComBoardDetail(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest) {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            String name;
            while (iterator.hasNext()) {
                name = iterator.next();
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
            }        }
        return communityMapper.updateComBoardDetail(communityDto);
    }

    @Override
    public int deleteComBoardDetail(int cBoardNo) {
        return communityMapper.deleteComBoardDetail(cBoardNo);
    }
}