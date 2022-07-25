package com.rocket.laf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.dto.UserDto;
import com.rocket.laf.service.impl.MypageServiceImpl;
import com.rocket.laf.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/myPage") //로컬호스트 뜨고 마이페이지 경로로 가는데,
//URL 카멜케이스(?)
public class MypageController {
    
    @Autowired
    private MypageServiceImpl mypageServiceImpl;
    
    @Autowired
    private UserServiceImpl userServiceImpl;

    //기본 페이지 넘어오는 파라미터 X.
    //requsetParam으로도 해보기
    //유저넘버 받아오는 방법.

    @GetMapping("")
    public String viemypage(HttpServletRequest request, Model model){
        String user_id = request.getParameter("userId");
        System.out.println("아이디 : " + user_id);
        List<UserDto> uslist = mypageServiceImpl.selectOne(user_id);
        
        model.addAttribute("ulist", uslist);
        System.out.println("********************************************************************");
        System.out.println(uslist);
        System.out.println("********************************************************************");
        return "mypage/myPage";
    // dto를 받을게 아니고, 마이페이지 클릭 시 유저 아이디를 컨트롤러로 받음
    // 아이디를 기준으로 디비 접근
    // 쿼리문 실행
    // 마이페이지 돌려주기.
    }
    // @PostMapping("")
    // public String mpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    //     request.setCharacterEncoding("utf-8");
    //     String user_id = request.getParameter("userId");
    //     String user_name = request.getParameter("userName");
    //     System.out.println("아이디 = " + user_id);
    //     System.out.println("이름 = " + user_name);
    //     return "mypage/myPage";
    // }


    @PostMapping("")
    public String mypage(Model model, UserDto dto){
        System.out.println("dto = " +dto);
        return "mypage/myPage";
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

    // //2. 아이디 이름 수정
    // @GetMapping("/updateform")
    // public String updateForm(Model model, int userNo){
    //     model.addAttribute("dto",mypageServiceImpl.selectOne());
    //     return "/myPage";
    // }

    @PostMapping("/update")
    public String update(MypageDto dto){
        if(mypageServiceImpl.update(dto)>0){
            return "redirect:/myPage?userno=" +dto.getUserNo();
        }else{
            return "redirect:/myPage/updateform?userno=" +dto.getUserNo();
        }
    }

    //3. 동네설정 토글?
    // @GetMapping("/")

}
