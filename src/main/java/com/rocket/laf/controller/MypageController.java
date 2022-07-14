package com.rocket.laf.controller;

import com.rocket.laf.service.impl.MypageServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageServiceImpl mypageService;
}
