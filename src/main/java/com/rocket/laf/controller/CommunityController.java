package com.rocket.laf.controller;

import com.rocket.laf.dto.*;
import com.rocket.laf.service.impl.*;
import com.rocket.laf.dto.CommunityDto;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cBoard")
public class CommunityController {

    private final CommunityServiceImpl communityService;
    private final PictureServiceImpl pictureService;
    private final HashTagServiceImpl hashTagService;
    private final UserServiceImpl userService;
    private final BoardNoServiceImpl boardNoService;

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
    public String writeComBoard(CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        String symbol = "com";
        long bnumbering = boardNoService.getMaxBoardNo() + 1;
        boardNoService.addBoardNo(bnumbering);
        String numbering = String.format("%08d", bnumbering);
        String comBoardNo = symbol + numbering;
        communityDto.setCBoardNo(comBoardNo);
        communityService.writeComBoard(communityDto, multipartHttpServletRequest);
        String cBNo = communityService.getLastCBoardNo();
        return "redirect:/cBoard/"+cBNo;
    }

    @GetMapping("/{cBoardNo}")
    public String getComBoardDetail(@PathVariable(name = "cBoardNo") String cBoardNo, Model model) {
        CommunityDto comDto = communityService.getComBoardDetail(cBoardNo);
        long hashNo = comDto.getHashNo();
        long userNo = comDto.getUserNo();
        List<PictureDto> picList = pictureService.getAllPictureByBoardNo(cBoardNo);

        HashTagDto hashTagDto = hashTagService.getHashTagById(hashNo);
        UserDto userDto = userService.getUserById(userNo);
        model.addAttribute("cbDetail", comDto);
        model.addAttribute("pDetail", picList);
        model.addAttribute("hDetail", hashTagDto);
        model.addAttribute("uDetail", userDto);
        return "/community/comBoardDetail";
    }

    @GetMapping("/update/{cBoardNo}")
    public String updateComBoardForm(@PathVariable(name = "cBoardNo") String cBoardNo, Model model) {
        model.addAttribute("cbDetail", communityService.getComBoardDetail(cBoardNo));
        return "/community/comBoardUpdate";
    }
    @PostMapping("/update/{cBoardNo}")
    public String updateComBoardDetail(@PathVariable(name = "cBoardNo") String cBoardNo, CommunityDto communityDto, MultipartHttpServletRequest multipartHttpServletRequest) {
        if (communityService.updateComBoardDetail(communityDto, multipartHttpServletRequest) > 0) {
            return "redirect:/cBoard/" + cBoardNo;
        } else {
            return "/community/comBoardUpdate";
        }
    }

    @GetMapping("/delete/{cBaordNo}")
    public String deleteComBoardDetail(@PathVariable(name = "cBoardNo") String cBoardNo) {
        communityService.deleteComBoardDetail(cBoardNo);
        return "redirect:/cBoard";
    }
}
