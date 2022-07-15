package com.rocket.laf.controller;

import com.rocket.laf.service.impl.MypageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @Autowired
    private MypageServiceImpl mypageService;

    /*
     * /logo : 홈 화면으로
     * /menu : 메뉴바 눌러 메뉴 펼치기
     * /search : 검색
     * /Iprofile : 프사등록
     * /locarrow : 기존 설정 동네 두 개
     * /locnew : 동네설정 박스 누르면 새로운 동네 설정
     * /foundbyme : 내가 찾아준 내역
     * /reviewall : 내 후기 모아보기
     */
    @GetMapping("/logo")
    public String logo(){
        return "";
    }

    @GetMapping("/menu")
    public String menu(){        
        return "";
    }

    @GetMapping("/search")
    public String search(){
        return "";
    }

    @GetMapping("/Iprofile")
    public String Iprofile(){
        return "";
    }

    @GetMapping("/locarrow")
    public String locarrow(){
        return "";
    }

    @GetMapping("/locnew")
    public String locnew(){
        return "";
    }

    @GetMapping("/foundbyme")
    public String foundbyme(){
        return"";
    }
    @GetMapping("/reviewall")
    public String reviewall(){
        return"";
    }





}
