package com.rocket.laf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LafController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/Lostwrite")
    public String Lostwrite() {
        return "lostcommunity/lostwrite";
    }
}
