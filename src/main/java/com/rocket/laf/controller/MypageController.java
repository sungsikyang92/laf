package com.rocket.laf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.dto.PictureDto;
import com.rocket.laf.dto.UserDto;
import com.rocket.laf.service.CommunityService;
import com.rocket.laf.service.MypageService;
import com.rocket.laf.service.PictureService;
import com.rocket.laf.service.impl.MypageServiceImpl;

@Controller
@RequestMapping("/myPage") //로컬호스트 뜨고 마이페이지 경로로 가는데,
//URL 카멜케이스(?)
public class MypageController {
    
    @Autowired
    private MypageServiceImpl mypageServiceImpl;

    @Autowired
    private MypageService mypageService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private CommunityService communityService;

    @GetMapping("")
    public String viemypage(HttpServletRequest request, Model model, @AuthenticationPrincipal User userInfo, Authentication auth) throws Exception {
        AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
        if (trustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
            System.out.println("익명의 사용자 _________ " +  userInfo);
            System.out.println("익명의 사용자 인증정보_________ " +  auth);
            return "/user/secTest";
        }else {
            System.out.println("로그인한 사용자_________ " +  userInfo.getUsername());
            System.out.println("로그인한 사용자 인증정보_________ " +  auth);
            String name = userInfo.getUsername();
            UserDto name1= mypageService.selectOne(name);
            model.addAttribute("dto", name1);
            System.out.println("name = " + name);
            System.out.println("dto = " + name1);
            return "/mypage/myPage";
        }
    }

    @PostMapping("")
    public String mypage(MypageDto dto, Model model, MultipartFile file, HttpServletRequest request, @AuthenticationPrincipal User userInfo) throws Exception{
        mypageServiceImpl.picwrite(dto, file);
        String name = userInfo.getUsername();
        UserDto name1= mypageService.selectOne(name);
        
        model.addAttribute("dto", name1);
        System.out.println("name = " + name);
        String user_id = request.getParameter("userId");
        System.out.println("아이디 : " + user_id);
        // List<UserDto> uslist = mypageServiceImpl.selectOne(name1);
        
        // model.addAttribute("ulist", uslist);
        System.out.println("Controller file = " + file);
        System.out.println("Controller dto = " + dto);
        System.out.println("filename ? = " +dto.getOriginalFileName());
        System.out.println("filepath ? = " +dto.getStoredFilePath());
        
        model.addAttribute("img",dto);
        System.out.println("Postdto=" +dto);
        return "mypage/myPage";
    }  

    @GetMapping("/founddetail")
    public String MypagetoFounddetail(Model model, HttpServletRequest request) throws Exception{
        //cBoardNo 쓸라고.
        List<CommunityDto> cl = communityService.getComBoardList();
        model.addAttribute("clist",cl);
        
        //cBoardNo에 맞는 사진 가져오기.
        String cBoardNo = request.getParameter("cl.cBoardNo");
        List<PictureDto> ctop = pictureService.getAllPictureByBoardNo(cBoardNo);
        model.addAttribute("pPath",ctop);


        System.out.println("cl = " + cl);
        System.out.println("ctop = " +ctop);
        

        
        return "/foundbyme/founddetail";
    }
    @GetMapping("/reviewdetail")
    public String FromMypagetoReviewAll(){
        return "/review";
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
