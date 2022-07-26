<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- security teglibrary -->
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <!-- security tags starts-->
    <sec:authorize access="isAnonymous()">
        <!-- <button class="btn" sec:authorize="isAnonymous()"
            onclick="location.href='/user/login'">로그인</button> -->
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="name" var="loginUserName" />
        <!-- <span class="item">${loginUserName}님 환영합니다</span>
        <button class="btn" onclick="location.href='/lostWrite'">글쓰기</button>
        <button class="btn" onclick="location.href=''">마이페이지</button>
        <button class="btn" onclick="location.href='/user/logout'">로그아웃</button> -->
    </sec:authorize>
    <!-- security tags ends-->

    <div class="userReview-box">
		<h2>후기페이지</h2>
		<form action="/review/saveReview" method="post" onsubmit="return submitBtn()" id="formTag">
            <input type="hidden" name="${loginUserName}">
			<div class="reviewee-id-text">
				<label>후기준 아이디</label><span>   1:1채팅에서 연결필요</span>
			</div>
			<div class="content-box">
				<label>후기내용</label>
				<br>
                <textarea rows="10" cols="80" name="contents"></textarea>
			</div>
			<div>
                <input type="radio" name="radio1" value="응답이빨라요">

            </div>
			<input type="button" value="취소" onclick="location.href='/user/login'">
			<input type="submit" value="회원가입">
		</form>
	</div>

    
</body>
</html>