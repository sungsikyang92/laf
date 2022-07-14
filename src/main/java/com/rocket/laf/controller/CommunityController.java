package com.rocket.laf.controller;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.service.impl.CommunityServiceImpl;
import com.rocket.laf.dto.CommunityDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        communityService.insertComBoard(communityDto);
        return "redirect:/cBoard";
    }

    @GetMapping("/{cBoardNo}")
    public String getComBoardDetail(@PathVariable(name = "cBoardNo") int cBoardNo, Model model) {
        model.addAttribute("cbDetail", communityService.getComBoardDetail(cBoardNo));
        return "/community/comBoardDetail";
    }
}
