<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- security teglibrary -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <script src='../resources/js/topMenu.js' defer></script>
    <meta charset="utf-8">
    <script type="text/javascript">
        function searchArg(data) {
            let searchArg = data;
            $.ajax({
                type: "get",
                data: "searchArg=" + searchArg,
                dataType: "json",
                url: "/search/" + searchArg,
                success: function (searchListDtos) {
                    let tags = '';
                    for (let i = 0; i < searchListDtos.length; i++) {
                        if (searchListDtos[i].picExt == true) {
                            tags += "<div class='lostBoardListContainer' onclick='location.href=/" + searchListDtos[i].boardNo + "'>";
                            tags += "<div>" + searchListDtos[i].boardNo + "</div>";
                            tags += "<div>" + searchListDtos[i].title + "</div>";
                            tags += "<div>" + searchListDtos[i].createDate + "</div>";
                            tags += "<div>" + searchListDtos[i].location + "</div>";
                            tags += "<img width='300' height='169' src='" + searchListDtos[i].storedFilePath + "' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        } else {
                            tags += "<div class='lostBoardListContainer' onclick='location.href=/" + searchListDtos[i].boardNo + "'>";
                            tags += "<div>" + searchListDtos[i].boardNo + "</div>";
                            tags += "<div>" + searchListDtos[i].title + "</div>";
                            tags += "<div>" + searchListDtos[i].createDate + "</div>";
                            tags += "<div>" + searchListDtos[i].location + "</div>";
                            tags += "<img width='300' height='169' src='/resources/img/woo.png' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        }
                    }
                    $("#test").html(tags);
                }
            })
        }
    </script>
</head>

    <body class="body_container">

        <div class="section">
            <div class="top_navbar">

                <!--왼쪽 네비게이션 바-->
                <div class="left_nav">
                    <a href="/" class="logo">
                        <img src="/resources/img/logo/laf6.png" alt="">
                    </a>
                </div>
                <div class="input_search">
                    <input type="text" placeholder="검색어를 입력해주세요." id="search"/>
                    <input type="button" value="검색" onclick="searchArg(document.getElementById('search').value)">
                </div>
                
                <!--가운데 네비게이션 바-->
                <ul class="center_nav">
                    <li>
                        <a href='#' class='canfound' onclick="getFoundId('습득')">
                            <!--아이콘들 이미지로 변경할 것.-->
                            <span type="text" class="item">찾아줄게요</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="helpfound" onclick="getLostId('분실')">
                            <span class="item">찾아주세요</span>
                        </a>
                    </li>
                    
                    <li>
                        <a href="/faq" class="qna">
                        <span class="item">자주묻는질문</span>
                        </a>
                    </li>
                </ul>

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

                <!--togglebutton-->
                <a href="#" class="navbar_toggleBtn">
                    <img src = "/resources/img/logo/Hamburger_icon.svg.png" alt="">
                </a>
                
            </div>
        </div>
    </body>
</html>