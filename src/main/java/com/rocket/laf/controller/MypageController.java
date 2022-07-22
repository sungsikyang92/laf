package com.rocket.laf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.service.MypageService;

@Controller
@RequestMapping("/myPage") //로컬호스트 뜨고 마이페이지 경로로 가는데,
//URL 카멜케이스(?)
public class MypageController {
    
    @Autowired
    private MypageService mypageService;

    //기본 페이지
    @GetMapping("")
    public String getmypage(Model model, MypageDto dto) {
        model.addAttribute("dto", mypageService.userinfo(dto));
        return "/mypage/myPage";
    }
    /* *********************************************************************************************** */
     /* 페이지 전환할 것들 
     * 1. 내가 찾아준 내역, 2. 내 후기 모아보기
     * 마이페이지에서 내가 찾아준 내역으로 이동 */
    @GetMapping("/foundByme")
    public String FromMypagetoFoundSpecific(){
        return "/foundbyme/founddetail";
    }
    @GetMapping("/myreview")
    public String FromMypagetoReviewAll(){
        return "/myreview/reviewdetail";
    }
    /* *********************************************************************************************** */
    //기능들git s
    //3. 동네설정 토글?
    
    //1. 프사
    @GetMapping("/uploadProfile")
    public String upLoadProfile(){
        return "/myPage";
    }

    //2. 아이디 이름 수정
    @GetMapping("/updateform")
    public String updateForm(Model model, long userNo){
        model.addAttribute("dto",mypageService.selectOne(userNo));
        return "/myPage";
    }

    @PostMapping("/update")
    public String update(MypageDto dto){
        if(mypageService.update(dto)>0){
            return "redirect:/myPage?userno=" +dto.getUserNo();
        }else{
            return "redirect:/myPage/updateform?userno=" +dto.getUserNo();
        }
    }

    //3. 동네설정 토글?
    // @GetMapping("/")

}
