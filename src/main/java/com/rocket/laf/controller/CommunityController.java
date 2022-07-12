package com.rocket.laf.controller;

import com.rocket.laf.service.impl.CommunityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comBoard")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityServiceImpl communityService;

    @GetMapping("/")
    public String getComBoardList(Model model) {
        model.addAttribute("cbList", communityService.getComBoardList());
        return "/community/ComBoardList";
    }

}
