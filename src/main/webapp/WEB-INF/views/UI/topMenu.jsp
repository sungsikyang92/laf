<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- security teglibrary -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">

<head>


</head>

    <body class="body_container">
        <div class="wrapper">
            <div class="section">
                <div class="top_navbar">
                    <div class="hamburger">
                        <a href="#">
                            <i class="fi fi-rr-menu-burger"></i>
                        </a>
                    </div>

                                    <!-- TOP menu  ?userId=${loginUserName} -->
                <div class="sidebar">
                    <div class="sidetop">
                        <div class="sidetop_left">
                            <a href="/" class="logo">
                                <img src="/resources/img/logo/laf6.png" alt="">
                            </a>
                        </div>
                    </div>
                    <ul>
                        <li>
                            <a href="myPage?userId=${loginUserName}" class="mypage">
                                <span class="icon"><i class="fi fi-rr-home"></i></span>
                                <span class="item">마이페이지</span>
                            </a>
                        </li>
                        <li>
                            <a href="/cBoard" class="cboard">
                                <span class="icon"><i class="fi fi-rr-users-alt"></i></span>
                                <span class="item">커뮤니티</span>
                            </a>
                        </li>
                        <li>
                            <a href="QnA" class="qna">
                                <span class="icon"><i class="fi fi-rr-comment-alt"></i></span>
                                <span class="item">QnA</span>
                            </a>
                        </li>
                        <li>
                            <a href="Menual" class="menual">
                                <span class="icon"><i class="fi fi-rr-document"></i></span>
                                <span class="item">분실물 대처 방안</span>
                            </a>
                        </li>
                        <li>
                            <a href="PayReward" class="payreward">
                                <span class="icon"><i class="fi fi-rr-credit-card"></i></span>
                                <span class="item">사례금 환급 받기</span>
                            </a>
                        </li>
                        <li>
                            <a href="/chat" class="chat">
                                <span class="icon"><i class="fi fi-rr-smartphone"></i></span>
                                <span class="item">진행중인 1:1 채팅</span>
                            </a>
                        </li>
                        <li>
                            <a href="/review" class="myreviews">
                                <span class="icon"><i class="fi fi-rr-book-alt"></i></span>
                                <span class="item">내 후기 모아보기</span>
                            </a>
                        </li>
                    </ul>
                </div>
                </div>

                    <div class="right_nav">
                        <!-- security tags starts-->
                        <sec:authorize access="isAnonymous()">
                            <button class="btn" sec:authorize="isAnonymous()"
                                onclick="location.href='/user/login'">로그인</button>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <sec:authentication property="name" var="loginUserName" />
                            <sec:authentication property="principal" var="principal" />
                            <span class="item">${loginUserName}님 환영합니다</span>
                            <!-- <span class="item">${principal}번호님 환영합니다</span> -->
                            <button class="btn" onclick="location.href='/write'">글쓰기</button>
                            <button class="btn" onclick="location.href='myPage?userId=${loginUserName}'">마이페이지</button>
                            <button class="btn" onclick="location.href='/user/logout'">로그아웃</button>
                        </sec:authorize>
                        <!-- security tags ends-->
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>