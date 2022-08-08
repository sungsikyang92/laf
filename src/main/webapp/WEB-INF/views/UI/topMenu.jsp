<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- security teglibrary -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body class="body_container">

    <div class="section">
        <div class="top_navbar">

             <!--왼쪽 네비게이션 바-->
             <div class = "left_nav">
                <a href="/" class="logo">
                    <img src="/resources/img/logo/laf6.png" alt="">
                </a>
            </div>
            <input id="menu-toggle" type = "checkbox"/>
            <label class='menu-button-container' for="menu-toggle">
                <div class='menu-button'></div>
            <!--가운데 네비게이션 바-->

            </label>
            <div class = "center_nav">
                <span>
                    <%--<a href="canfound" class="canfound">--%>
<%--                    <a href='#' class='canfound' onclick="getFoundId('습득')">--%>
                        <span class="icon"><i class="fi fi-rr-home"></i></span>
                        <span type = "text" class="item" onclick="getFoundId('습득')">찾아줄게요</span>
<%--                    </a>--%>
                </span>
                <input type="button" value="찾아줄게요" id="foundBtn" class="foundBtn" onclick="getFoundId('습득')"/>
                <input type="button" value="찾아주세요" id="lostBtn" class="lostBtn" onclick="getLostId('분실')"/>
                <span>
                    <%--<a href="helpfound" class="helpfound">--%>
                    <a href="#" class="helpfound" onclick="getLostId('분실')">
                        <span class="icon"><i class="fi fi-rr-users-alt"></i></span>
                        <span class="item">찾아주세요</span>
                    </a>
                </span>
                <span>
                    <input type = "text">
                    검색
                    </input>
                </span>
                <span>
                    <a href="QnA" class="qna">
                        <span class="icon"><i class="fi fi-rr-comment-alt"></i></span>
                        <span class="item">자주묻는질문</span>
                    </a>
                </span>
            </div>

            <!-- 오른쪽 네비게이션 바 -->
            <div class="right_nav">
                <!-- security tags starts-->
                <sec:authorize access="isAnonymous()">
                    <button class="btn" sec:authorize="isAnonymous()"
                            onclick="location.href='/user/login'">로그인
                    </button>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="principal.username" var="loginUserName"/>
                    <span class="item">${loginUserName}님 환영합니다</span>
                    <button class="btn" onclick="location.href='/write'">글쓰기</button>
                    <button class="btn" onclick="location.href='/myPage?userId=${loginUserName}'">마이페이지</button>
                    <button class="btn" onclick="location.href='/user/logout'">로그아웃</button>
                </sec:authorize>
                <!-- security tags ends-->
            </div>
        </div>


    </body>
</html>