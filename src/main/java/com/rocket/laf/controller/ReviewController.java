package com.rocket.laf.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rocket.laf.dto.ReviewDto;
import com.rocket.laf.service.ReviewService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/review")
public class ReviewController {
    
    private Logger logger = LoggerFactory.getLogger(ReviewController.class);
   
    @Autowired
    private ReviewService reviewService;

    //27일 완료
    @GetMapping("/write")
    public String reviewWritre(Model model, HttpServletRequest request) {
        
        logger.info("logger _______________ mapped to reviewWrite");
        
        //String reviewee = request.getParameter("1:1채팅에서 보내는 name값");
        model.addAttribute("revieweeId", "revieweeNeedtoBeChanged");
        
        return "/review/reviewWrite";
    }
    
    //28일 시작 (내가쓴 후기 목록보여주기)
    @GetMapping("")
    public String reviewList(HttpServletRequest request) {
        logger.info("logger _______________ mapped to reviewList");
       
        // 아래 save review에서 넘기는 모델이나  서블릿 리퀘스트나 둘중하나 방법으로 해본다
        //넘겨받은 아이디 값기준으로 서비스로 매퍼실행해서 리스트 제네릭 타입으로 받아온다.
        //리스트 모델에 저장해 뷰로 전달한다.
        //뷰에서는 C for문사용해서 뿌려준다. (뷰에서 후기번호 보여줄때는 숫자 1부터 증가해서 보여준다
        //실제번호는 히든처리한다)

        //String loginId = request.getParameter("view에서 보내는 id 네임값");
        
        return "/review/reviewList";

    }

    //27일 완료
    @GetMapping("saveReview")
    public String saveReview(ReviewDto dto, HttpServletRequest request) {
        logger.info("logger _______________ mapped to saveReview");

        String requested  = request.getParameter("rOption");
        System.out.println(requested);
        System.out.println(dto);

        int res = reviewService.saveReview(dto);

        System.out.println("res ________________ " + res);

        //모델에 담아서 리다이렉트 시킬지, 서블렛에 담아서 넘길지 생각해보자


        return "redirect:/review"; // 페이지 리로드

    }

    //28일 시작
    @GetMapping(value="details")
    public String reviewDetails(int reviewNo) {
        //클릭하면 후기번호를 기준으로 찾아오는것으로 하자

        return "/review/reviewDetail";
    }
    

    


}
