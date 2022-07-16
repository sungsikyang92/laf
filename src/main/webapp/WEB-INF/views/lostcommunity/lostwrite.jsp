<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Laf Lostwrite</title>


            <link rel="stylesheet" href="resources/css/header_footer.css" type="text/css">
            <link rel="stylesheet" href="resources/css/header_footer_btn.css" type="text/css">
            <link rel="stylesheet"
                href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
            <script src='resources/js/main_sidebar.js'></script>

            <link rel="stylesheet" href="resources/css/lostwrite.css" type="text/css">


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

                        </div>
                    </div>
                </div>


                <!-- 컨텐츠 삽입부분-->
                <div class="contents_container">

                    <input style="display: block;" type="file" id="input-multiple-image" multiple="multiple">
                    <div id="multiple-container"></div>

                    <h1 style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;">글 제목 :
                        ${boardDetail[0].LTitle}</h1>
                    <br>
                    <h2>현재 동네 : ${boardDetail[0].LLocation}</h2>
                    <div class="child-page-listing">
                        <br>
                        <br>
                        <h2>사진 </h2>
                        <div class="grid-container"
                            style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;padding-top:20px">
                            <c:choose>
                                <c:when test="${empty allpicture }">
                                    <td colspan="4">----사진이 없다----</td>
                                </c:when>
                                <c:otherwise>
                                    <article class="location-listing">
                                        <div class="location-title" href="">대표사진 </div>
                                        <div class="location-image">
                                            <img width="300" height="169" src="${allpicture[0].mainPicLoc}" alt="">
                                        </div>
                                    </article>
                                    <article class="location-listing">
                                        <div class="location-title" href="">사진 1 </div>
                                        <div class="location-image">
                                            <img width="300" height="169" src="${allpicture[0].picLoc1}" alt="">
                                        </div>
                                    </article>
                                    <article class="location-listing">
                                        <div class="location-title" href="">사진 2 </div>
                                        <div class="location-image">
                                            <img width="300" height="169" src="${allpicture[0].picLoc2}" alt="">
                                        </div>
                                    </article>
                                    <article class="location-listing">
                                        <div class="location-title" href="">사진 3 </div>
                                        <div class="location-image">
                                            <img width="300" height="169" src="${allpicture[0].picLoc3}" alt="">
                                        </div>
                                    </article>
                                    <article class="location-listing">
                                        <div class="location-title" href="">사진 4 </div>
                                        <div class="location-image">
                                            <img width="300" height="169" src="${allpicture[0].picLoc4}" alt="">
                                        </div>
                                    </article>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <!-- end grid container -->
                    </div>
                    <br>
                    <h2>작성일 : ${boardDetail[0].LCreateDate}</h2>
                    <h3>글내용 : ${boardDetail[0].LContent}</h3>
                    <br>
                    <h3 style="border-top:solid 2px rgb(169, 169, 169);">문제 : ${boardDetail[0].LQuestion}</h3>

                    <form action="/post_Quiz" id="form_Q" style="border-bottom:solid 2px rgb(169, 169, 169);"
                        method="post"><br>
                    </form>

                </div>















                <!-- TOP menu -->
                <div class="sidebar">
                    <div class="sidetop">
                        <div class="sidetop_left">
                            <a href="/" class="logo">
                                <img src="resources/img/logo/laf6.png" alt="">
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
                            <a href="cBoard" class="cboard">
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

            <script src='resources/js/readImage.js'></script>

        </body>

        </html>