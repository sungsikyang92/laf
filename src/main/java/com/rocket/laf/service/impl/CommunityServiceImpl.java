package com.rocket.laf.service.impl;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
import com.rocket.laf.common.FileUtils;
>>>>>>> 0346a107d07d6b2a795aada837d5676f666eb4d9
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
    public CommunityDto getComBoardDetail(String cBoardNo) {
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
    public int deleteComBoardDetail(String cBoardNo) {
        return communityMapper.deleteComBoardDetail(cBoardNo);
    }

    @Override
    public String getLastCBoardNo() {
        return communityMapper.getLastCBoardNo();
    }
}