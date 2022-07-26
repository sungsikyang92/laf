<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <title>Laf Lostwrite</title>

            <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

            <link rel="stylesheet" href="resources/css/header_footer.css" type="text/css">
            <link rel="stylesheet" href="resources/css/header_footer_btn.css" type="text/css">
            <link rel="stylesheet"
                href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
            <link rel="stylesheet" href="resources/css/lostwrite.css" type="text/css">

            <script type="text/javascript"
                src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri"></script>
            <script type="text/javascript"
                src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri&submodules=geocoder"></script>

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
                            <!-- security tags starts-->
                            <sec:authorize access="isAnonymous()">
                                <button class="btn" sec:authorize="isAnonymous()"
                                    onclick="location.href='/user/login'">로그인</button>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <sec:authentication property="principal.username" var="loginUserName" />
                                <span class="item">${loginUserName}님 환영합니다</span>
                                <button class="btn" onclick="location.href='/Lostwrite'">글쓰기</button>
                                <button class="btn" onclick="location.href=''">마이페이지</button>
                                <button class="btn" onclick="location.href='/user/logout'">로그아웃</button>
                            </sec:authorize>
                            <!-- security tags ends-->
                        </div>
                    </div>
                </div>

                <!-- 컨텐츠 삽입부분-->
                <div class="contents_container">
                    <form action="write" method="post" enctype="multipart/form-data">
                        <div id="image_container"></div>
                        <input type="file" id="pictureUpload" name="pictureUpload" accept="image/*"
                            onchange="setThumbnail(event);" multiple />
                        <button type="button" onclick="resetFile()">올린파일 초기화</button>
                        <button type="submit"> ddddd </button>
                        <br>
                        <h2>분실<input type="radio" name="" id=""> &nbsp;&nbsp; 습득<input type="radio" name="" id="" />
                        </h2>
                        <br>
                        <h1 style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;">글 제목 :
                            <input type="text" name="lTitle" placeholder="글 제목을 입력해주세요" />
                        </h1>
                        <br>
                        <h2>글 내용 : <br>
                            <textarea cols="150" rows="15" name="lContent" placeholder="글 내용을 입력해주세요"></textarea>
                        </h2>
                        <br>
                        <h3 style="border-top:solid 2px rgb(169, 169, 169);">
                            문제 :<input type="text" name="lQuestion" placeholder="질문을 입력해 주세요" />
                        </h3>
                        <br>
                        <h3>
                            정답 :<input type="text" name="lAnswers" placeholder="정답을 입력해 주세요" />
                        </h3>
                        <br>
                        <h3>
                            오답 :<input type="text" name="lAnswers1" placeholder="오답을 입력해 주세요" />
                        </h3>
                        <br>
                        <h3>
                            오답 :<input type="text" name="lAnswers2" placeholder="오답을 입력해 주세요" />
                        </h3>
                        <br>
                        <h3>
                            오답 :<input type="text" name="lAnswers3" placeholder="오답을 입력해 주세요" />
                        </h3>
                        <br>
                        <h3>
                            오답 :<input type="text" name="lAnswers4" placeholder="오답을 입력해 주세요" />
                        </h3>
                        <br>
                        <h2>지도</h2>
                        <div id="map" style="width:60%;height:400px;">
                            <div class="search">
                                <input id="address" type="text" placeholder="검색할 주소" value="" />
                                <input id="addsubmit" type="button" value="주소 검색" />
                            </div>
                        </div>
                        <br>
                        <div id="location" class="location"></div>
                        <h4>지도로 위치를 설정하시면 해당위치로 검색시 노출됩니다.</h4>
                        <br>
                        <h2>HashTag</h2>
                        <input id="hashtag" name="hashtag" type="text" size="50" value="검색 노출 태그 입력 ,로 입력해주세요.">
                        <br>
                        <button id="submit" type="submit">ㅋㅋ임시제출임</button>
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
            <script src='resources/js/main_sidebar.js'></script>
            <script src='resources/js/naverMapApiTest3.js'></script>

        </body>

        </html>