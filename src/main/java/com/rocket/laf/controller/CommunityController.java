package com.rocket.laf.controller;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.service.impl.CommunityServiceImpl;
import com.rocket.laf.dto.CommunityDto;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cBoard")
public class CommunityController {

    @Autowired
    private CommunityServiceImpl communityService;

    @GetMapping("")
    public String getComBoardList(Model model) {
        model.addAttribute("cbList", communityService.getComBoardList());
        return "/community/comBoardList";
    }

    @GetMapping("/write")
    public String openComBoardWrite() {
        return "/community/comBoardWrite";
    }

    @PostMapping("/write")
    public String insertComBoard(CommunityDto communityDto) {
        if (communityService.insertComBoard(communityDto) > 0) {
            return "redirect:/cBoard";
        } else {
            return "comBoardWrite";
        }
    }

    @GetMapping("/{cBoardNo}")
    public String getComBoardDetail(@PathVariable(name = "cBoardNo") int cBoardNo, Model model) {
        model.addAttribute("cbDetail", communityService.getComBoardDetail(cBoardNo));
        return "/community/comBoardDetail";
    }

    @GetMapping("/update/{cBoardNo}")
    public String updateComBoardForm(@PathVariable(name = "cBoardNo") int cBoardNo, Model model) {
        model.addAttribute("cbDetail", communityService.getComBoardDetail(cBoardNo));
        return "/community/comBoardUpdate";
    }
    @PostMapping("/update/{cBoardNo}")
    public String updateComBoardDetail(@PathVariable(name = "cBoardNo") int cBoardNo, CommunityDto communityDto, @RequestParam("pic") MultipartFile pic) {

        List<PictureDto> pList = new ArrayList<>();
//        for (MultipartFile file : pic) {
//            PictureDto pictureDto = new PictureDto(file.getOriginalFilename(), file.getContentType());
//
//        }
        if (communityService.updateComBoardDetail(communityDto) > 0) {
            return "redirect:/cBoard/" + cBoardNo;
        } else {
            return "/community/comBoardUpdate";
        }
    }

    @GetMapping("/delete/{cBaordNo}")
    public String deleteComBoardDetail(@PathVariable(name = "cBoardNo") int cBoardNo) {
        communityService.deleteComBoardDetail(cBoardNo);
        return "redirect:/cBoard";
    }
}
