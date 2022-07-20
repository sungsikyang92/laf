package com.rocket.laf.controller;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rocket.laf.dto.UserDto;
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

    // 로그인 창에서 회원가입으로 이동
    @GetMapping("/signUp")
    public String userSignUpBotton(Model model) {
        logger.info("------------------------Controller mapping 'signUp button call'");

        // 약관버전 설정
        int tVersion = 1;
        model.addAttribute("terms", termsService.selectOne(tVersion));
        System.out.println("-----------------------chk-----------------------" + model);

        return "user/terms";
    }

<<<<<<< HEAD
    //강제 주소창 입력시get 방식으로 전송되고 약관확인시 post로 전달
    @RequestMapping(value ="/signUpForm", method= {RequestMethod.GET, RequestMethod.POST})
    public String userSignUpFrom(HttpServletRequest request, Model model){
=======
    // 강제 주소창 입력시get 방식으로 전송되고 약관확인시 post로 전달
    @RequestMapping(value = "/signUpForm")
    public String userSignUpFrom(HttpServletRequest request, Model model) {
>>>>>>> 9190f859712551f581a4eaf935057e54e934f729
        logger.info("------------------------Controller mapping 'signUp form call'");

        // // jsp에서 넘어오는 파라미터 확인
        // Enumeration params = request.getParameterNames();
        // while(params.hasMoreElements()) {
        // String name = (String) params.nextElement();
        // System.out.print(name + " : " + request.getParameter(name) + " ");
        // }
        // System.out.println(request.getParameter("selectall").getClass().getName());

        String param = request.getParameter("selectall");

        if (param == null) {
            return "redirect:/user/login";
        } else if (param.equals("on")) {
            model.addAttribute("policyOn", request.getParameter("selectall"));
            return "user/signUp";
        } else {
            return "/user/login";
        }
    }

    @PostMapping("/chkDuplicatedId")
    @ResponseBody
    public Map<String, Boolean> chkDuplicatedId(@RequestBody Map<String, Object> idFromJson) {
        logger.info("------------------------Controller mapping 'chkDuplicatedId called'");

        System.out.println(idFromJson.get("id").toString());
        int res = userService.chkDuplicatedId(idFromJson.get("id").toString());
        Map<String, Boolean> jsonResponse = new HashMap<String, Boolean>();
        if (res == 0) { // 중복이 없을시
            jsonResponse.put("res", true);
        } else { // res == 1 중복이 있음
            jsonResponse.put("res", false);
        }

        System.out.println(res);

        return jsonResponse;
    }

    // 회원가입 페이지 입력정보 db에 저장
    @PostMapping("/regUser")
    public String resUser(UserDto userRegDto, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        logger.info("------------------------Controller mapping 'regUser'");
        String userBirth = combineBirth(request);
        userRegDto.setUserBirth(userBirth);
        String userLocation = combineLocation(request);
        userRegDto.setUserLocation(userLocation);
        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        userRegDto.setUserPw(pwdEncoder.encode(userRegDto.getUserPw()));

        int res = userService.regUser(userRegDto);

        if (res == 1) {
            alertToJsp(response, "회원가입을 축하드립니다.  로그인 페이지로 이동합니다.", 0);
            return "/user/login";
        } else {
            alertToJsp(response, "예상치 못하게 에러가 발생했습니다. 회원가입을 다시진행해 주십시오", 1);
            return "/user/login";
        }
    }

    @GetMapping("/signOut")
    public String userSignOut() {
        logger.info("------------------------Controller mapping 'signOut'");

        return "";
    }

    // 로그인 창에서 회원가입으로 이동
    @GetMapping("/login")
    public String userLogin() {
        logger.info("------------------------Controller mapping 'login'");

        return "/user/login";
    }

    @PostMapping("/loginChk")
    public String loginChk(UserDto userdto) {
        logger.info("------------------------Controller mapping 'loginChk'");
        // System.out.println(userdto.toString());

        UserDto loggedinfo = userService.login(userdto);
        System.out.println(loggedinfo);

        return "user/terms";
    }

    @GetMapping("/logout")
    public String userLogOut() {
        logger.info("------------------------Controller mapping 'logout'");

        return "";
    }

    @GetMapping("/socialLogin")
    public String userSocialLogin() {
        logger.info("------------------------Controller mapping 'socialLogin'");

        return "";
    }

    public String combineBirth(HttpServletRequest request) {
        int birthY_int = Integer.parseInt(request.getParameter("bY"));
        int birthM_int = Integer.parseInt(request.getParameter("bM"));
        int birthD_int = Integer.parseInt(request.getParameter("bD"));
        String birthM_str = "";
        String birthD_str = "";
        if (birthM_int >= 1 && birthM_int < 10) {
            birthM_str = "0" + Integer.toString(birthM_int);
        } else {
            birthM_str = request.getParameter("bM");
        }
        if (birthD_int >= 1 && birthD_int < 10) {
            birthD_str = "0" + Integer.toString(birthD_int);
        } else {
            birthD_str = request.getParameter("bD");
        }
        String userBirth = request.getParameter("bY") + birthM_str + birthD_str;
        return userBirth;
    }

    public String combineLocation(HttpServletRequest request) {
        String userLocation = request.getParameter("userLocation") + request.getParameter("userLocation_2nd");

        return userLocation;
    }

    public String alertToJsp(HttpServletResponse response, String msg, int option) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script type='text/javascript'>");
        writer.println("alert('" + msg + "');");
        if (option == 1) {
            writer.println("history.back();");
        } else {
        }
        writer.println("</script>");
        writer.flush();

        return null;
    }

}