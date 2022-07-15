package com.rocket.laf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.laf.service.TermsService;
import com.rocket.laf.service.UserService;

@Controller
@RequestMapping("/user") 
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TermsService termsService;



    private Logger logger = LoggerFactory.getLogger(UserController.class);

    
    // 영재: 로그인 창에서 회원가입으로 이동
    @GetMapping("/signUp")
    public String userSignUpBotton(Model model){
        logger.info("------------------------Controller mapping 'signUp button call'");

        int tVersion = 1;
        model.addAttribute("terms", termsService.selectOne(tVersion));
        System.out.println("-----------------------chk-----------------------" + model);

        return "user/terms";
    }

    @GetMapping("/signOut")
    public String userSignOut(){
        logger.info("------------------------Controller mapping 'signOut'");



        return "";
    }

    // 영재: 로그인 창에서 회원가입으로 이동
    @GetMapping("/login")
    public String userLogin(){
        logger.info("------------------------Controller mapping 'login'");
        
        return "/user/login";
    }

    @GetMapping("/logout")
    public String userLogOut(){
        logger.info("------------------------Controller mapping 'logout'");

        return "";
    }

    @GetMapping("/socialLogin")
    public String userSocialLogin(){
        logger.info("------------------------Controller mapping 'socialLogin'");

        return "";
    }

}