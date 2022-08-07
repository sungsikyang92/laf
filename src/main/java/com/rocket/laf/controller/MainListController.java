package com.rocket.laf.controller;

import com.rocket.laf.dto.MainListDto;
import com.rocket.laf.service.impl.CommunityServiceImpl;
import com.rocket.laf.service.impl.PictureServiceImpl;
import com.rocket.laf.service.impl.MainListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lafList")
public class MainListController {

    private final CommunityServiceImpl communityService;
    private final PictureServiceImpl pictureService;
    private final MainListServiceImpl mainListService;

    @GetMapping("/found/{lCategory}")
    public List<MainListDto> getFoundBoardList(@PathVariable String lCategory) {
        List<MainListDto> mainFoundListDtos = mainListService.getBoardFoundListByCategory(lCategory);
        System.out.println(mainFoundListDtos);
        for (MainListDto mainListDto : mainFoundListDtos) {
            if (mainListDto.isPicExt() == true) {
                String picOriginPath = mainListDto.getStoredFilePath();
                mainListDto.setStoredFilePath("/resources/img/lostBoard/" + picOriginPath.substring(40));
            }
        }
        System.out.println(mainFoundListDtos);
        return mainFoundListDtos;
    }

    @GetMapping("/lost/{lCategory}")
    public List<MainListDto> getLostBoardList(@PathVariable String lCategory) {
        List<MainListDto> mainLostListDtos = mainListService.getBoardLostListByCategory(lCategory);
        System.out.println(mainLostListDtos);
        for (MainListDto mainListDto : mainLostListDtos) {
            if (mainListDto.isPicExt() == true) {
                String picOriginPath = mainListDto.getStoredFilePath();
                mainListDto.setStoredFilePath("/resources/img/lostBoard/" + picOriginPath.substring(40));
            }
        }
        System.out.println(mainLostListDtos);
        return mainLostListDtos;
    }
//    @GetMapping("/lost")
//    public List<MainListDto> getLostBoardList(Model model) {
//        List<MainListDto> mainLostListDtos = mainListService.getTestComBoardList();
//        for (MainListDto mainListDto : mainLostListDtos) {
//            if (mainListDto.isPicExt() == true) {
//                String testPicOriginPath = mainListDto.getStoredFilePath();
//                mainListDto.setStoredFilePath("/resources/img/communityBoard/" + testPicOriginPath.substring(45));
//            }
//        }
//        return mainLostListDtos;
//    }
}