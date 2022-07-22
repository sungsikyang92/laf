<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>LAF커뮤니티</title>

    <link rel="stylesheet" href="/resources/css/button.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="stylesheet"
          href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
    <script src='/resources/js/main_sidebar.js'></script>
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
            <div class="right_nav">
                <button class="btn" onclick="location.href='#'">글쓰기</button>
                <button class="btn">로그인/마이페이지</button>
            </div>
        </div>
    </div>


    <div class="contents_container">
        <form action="/cBoard/update/${cbDetail.CBoardNo}" method="post" enctype="multipart/form-data">
            <div>
                <c:choose>
                    <c:when test="${empty pDetail}">
                        <td>등록된 사진이 없습니다</td>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${pDetail}" var="pd">
                            <article class="location-listing">
                                <div class="location-image">
                                    <img width="300" height="169" src="${pd.storedFilePath}" alt="">
                                </div>
                            </article>
                            <div>
                                <input type="button" value="삭제" onclick="location.href='/picture/delete/'+${pd.picNo}" class="imgDeleteBtn">
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>

            </div>
            <input type="hidden" name="cBoardNo" value="${cbDetail.CBoardNo}">
            <table>
                <tr>
                    <div id="image_container"/>
                    <td><input type="file" name="pictureUpload" id="pictureUpload" multiple="multiple" accept="image/*" onchange="setThumbnail(event);"></td>
                </tr>
                <tr>
                    <td><input type="text" name="cTitle" value="${cbDetail.CTitle}"></td>
                </tr>
                <tr>
                    <td>
                        <textarea name="cContent">${cbDetail.CContent}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" value="취소" onclick="location.href='/cBoard'">
                        <input type="submit" value="확인"></td>
                </tr>
            </table>
        </form>
    </div>


    <!-- TOP menu -->
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
                <a href="MyPage" class="mypage">
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
                <a href="Chat" class="chat">
                    <span class="icon"><i class="fi fi-rr-smartphone"></i></span>
                    <span class="item">진행중인 1:1 채팅</span>
                </a>
            </li>
            <li>
                <a href="MyReviews" class="myreviews">
                    <span class="icon"><i class="fi fi-rr-book-alt"></i></span>
                    <span class="item">내 후기 모아보기</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<script src='/resources/js/readImage.js'></script>

</body>

</html>