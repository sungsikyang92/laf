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

    /* ***동작***
     * /logo : 홈 화면으로 -- jsp
     * /menu : 메뉴바 눌러 메뉴 펼치기 -- jsp
     * /search : 검색 -- jsp
     * /Iprofile : 프사등록 -- controller
     * /locarrow : 기존 설정 동네 두 개 -- controller
     * /locnew : 동네설정 박스 누르면 새로운 동네 설정 -- controller
     * /foundbyme : 내가 찾아준 내역 -- 단순 클릭
     * /reviewall : 내 후기 모아보기 -- 단순 클릭
     */
    @GetMapping("/logo")
    public String logo(){
        return "index";
    }

    @GetMapping("/menu")
    public String menu(){
        return "/mypage/mypagedetail";
    }

    @GetMapping("/search")
    public String search(){
        return "/mypage/mypagedetail";
    }

    @GetMapping("/Iprofile")
    public String Iprofile(){
        return "/mypage/mypagedetail";
    }

    @GetMapping("/locarrow")
    public String locarrow(){
        return "/mypage/mypagedetail";
    }

    @GetMapping("/locnew")
    public String locnew(){
        return "/mypage/mypagedetail";
    }

    @GetMapping("/foundbyme")
    public String foundbyme(){
        return"/foundbyme/founddetail";
    }
    @GetMapping("/reviewall")
    public String reviewall(){
        return"review/reviewdetail";
    }

    /* ***단순 표시***
     * /Userinfo : 유저 아이디 이름 --controller
     * /locview : 00동  
     * /rewardtotal : 누적사례금 | 000000원
     * /rewardcount : 사례 횟수 | 000번
     * /rewardremain : 사례금 잔액 | 000000원
     */
    @GetMapping
    public String userinfo(){
        return "";
    }

    @GetMapping
    public String locview(){
        return "";
    }

    @GetMapping
    public int rewardtotal (){
        return 0;
    }

    @GetMapping
    public int rewardcount (){
        return 0;
    }

    @GetMapping
    public int rewardremain(){
        return 0;
    }



}
