package com.rocket.laf.controller;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.dto.TestDto;
import com.rocket.laf.service.impl.CommunityServiceImpl;
import com.rocket.laf.service.impl.PictureServiceImpl;
import com.rocket.laf.service.impl.TestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final CommunityServiceImpl communityService;
    private final PictureServiceImpl pictureService;
    private final TestServiceImpl testService;

    @GetMapping("")
    public List<TestDto> getTestComBoardList(Model model) {
        List<TestDto> testDtoList = testService.getTestComBoardList();
        for (TestDto testDto : testDtoList) {
            if (testDto.isPicExt() == true) {
                String testPicOriginPath = testDto.getStoredFilePath();
                testDto.setStoredFilePath("/resources/img/communityBoard/" + testPicOriginPath.substring(45));
            }
        }
        model.addAttribute("tList", testDtoList);
        return testDtoList;
    }

}