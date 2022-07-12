package com.rocket.laf.controller;

import com.rocket.laf.service.impl.CommunityServiceImpl;
import com.rocket.laf.dto.CommunityDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comBoard")
@RequiredArgsConstructor
public class CommunityController {

    @Autowired
    private CommunityServiceImpl communityService;

    @GetMapping("/comboardlist")
    public String getComBoardList(Model model) {
        List<CommunityDto> list = communityService.getComBoardList();
        model.addAttribute("cbList", list);
        return "community/ComBoardList";
    }

}
