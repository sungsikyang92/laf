package com.rocket.laf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user") 
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    
    @GetMapping("/signUp")
    public String userSignUpBotton(){
        logger.info("Controller mapping 'signUp'");

        return "";
    }

    @GetMapping("/signOut")
    public String userSignOut(){
        logger.info("------------------------Controller mapping 'signOut'");

        return "";
    }

    @GetMapping("/login")
    public String userLogin(){
        logger.info("------------------------Controller mapping 'login'");

        return "/member/login";
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