package com.rocket.laf.controller;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.service.impl.CommunityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class CommunityController {
<<<<<<< HEAD
    System.out.println("kk");
=======

    private final CommunityServiceImpl communityService;

    @GetMapping("/cBoard")
    public String getComBoardList(Model model) {
        model.addAttribute("cbList", communityService.getComBoardList());
        return "/community/comBoardList";
    }

    @GetMapping("/cBoard/write")
    public String openComBoardWrite() {
        return "/community/comBoardWrite";
    }

    @PostMapping("/cBoard/write")
    public String insertComBoard(CommunityDto communityDto) {
        communityService.insertComBoard(communityDto);
        return "redirect:/cBoard";

    }

>>>>>>> com004
}
