package com.rocket.laf.controller;

import java.io.Console;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        //약관버전 설정
        int tVersion = 1;
        model.addAttribute("terms", termsService.selectOne(tVersion));
        System.out.println("-----------------------chk-----------------------" + model);

        return "user/terms";
    }

    //signUpForm 강제 주소창 입력시get 방식으로 전송되고 약관확인시 post로 전달
    @RequestMapping(value ="/signUpForm")
    public String userSignUpFrom(HttpServletRequest request, Model model){
        logger.info("------------------------Controller mapping 'signUp form call'");

        // // jsp에서 넘어오는 파라미터 확인
        // Enumeration params = request.getParameterNames();
        // while(params.hasMoreElements()) {
        // String name = (String) params.nextElement();
        // System.out.print(name + " : " + request.getParameter(name) + "     "); 
        // }
        //System.out.println(request.getParameter("selectall").getClass().getName());

        String param = request.getParameter("selectall");
        
        if (param == null){
            return "redirect:/user/login";     
        }else if (param.equals("on")){
            model.addAttribute("policyOn", request.getParameter("selectall"));
            return "user/signUp";
        }else{
            return "/user/login";
        }
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