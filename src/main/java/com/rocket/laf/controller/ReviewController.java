package com.rocket.laf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/review")
public class ReviewController {
    

    @GetMapping("/reviewWritre")
    public String reviewWritre(Model model, HttpServletRequest request) {
        
        //String reviewee = request.getParameter("1:1채팅에서 보내는 name값");
        model.addAttribute("revieweeId", "나중에 1:1 채팅에서 받아와서 바꿀것");
        
        return "/review/reviewWrite";

    }

    @GetMapping("")
    public String reviewList(HttpServletRequest request) {
        
        //String loginId = request.getParameter("view에서 보내는 id 네임값");
        
        return "/review/reviewList";

    }
    


}
