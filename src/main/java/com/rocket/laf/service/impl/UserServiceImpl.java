package com.rocket.laf.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import com.rocket.laf.dto.UserDto;
import com.rocket.laf.mapper.UserMapper;
import com.rocket.laf.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
public class UserServiceImpl implements UserService, UserDetailsService, AuthenticationSuccessHandler{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto login(UserDto dto) {
        return userMapper.login(dto);
    }

    @Override
    public int regUser(UserDto dto) {
        return userMapper.register(dto);
    }

    @Override
    public UserDto getUserById(long userNo) {
        return userMapper.getUserById(userNo);
    }

    @Override
    public int chkDuplicatedId(String idFromJson) {
        return userMapper.chkDuplicatedId(idFromJson);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto secUser = userMapper.secLogin(username);

        if (secUser == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }
        List<GrantedAuthority> auth = new ArrayList<>();
        if (secUser.getUserGrade().equals("BASIC")){
            auth.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            auth.add(new SimpleGrantedAuthority("ADMIN"));
        }
        User secReturnUser = new User(secUser.getUserId(), secUser.getUserPw(), auth);
        System.out.println(secReturnUser);
        return secReturnUser;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
            System.out.println("잘연결됬습니깡? 넵");
            
            WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
            System.out.println("Session ID ________ " + web.getSessionId());
            System.out.println("인증 name : " + authentication.getName());

            String uri = "/";

            //접근권한이없는 경우 시큐리티가 로그인 페이지로 강제이동시킬때 사용자가 직전에 권한이있던 요청한 정보 저장
            RequestCache requestCache = new HttpSessionRequestCache(); 
            SavedRequest savedRequest = requestCache.getRequest(request, response);


        //로그인 버튼을 눌러 접속한경우
            String dataFromIndex = (String) request.getSession().getAttribute(("index"));
            
            //세션에 "index" 값이 있다는 뜻이면 로그인버튼통해서 들어옴. 메모리관리를 위해 지우자
            if (dataFromIndex != null) {
                request.getSession().removeAttribute("index");
            }
            if(savedRequest != null) {
                uri = savedRequest.getRedirectUrl();
            }else if (dataFromIndex != null && dataFromIndex.equals("")){
                uri = dataFromIndex;
            } 

            response.sendRedirect(uri);


    }
}
