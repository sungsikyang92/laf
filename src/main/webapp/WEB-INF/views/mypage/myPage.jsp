<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mypage</title>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="stylesheet" href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
    <link rel="stylesheet" href="/resources/css/myPage.css" type="text/css">
    <script type="text/javascript"
                src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri"></script>
            <script type="text/javascript"
                src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri&submodules=geocoder"></script>
    <script src='../resources/js/main_sidebar.js'></script>
    <script src='../resources/js/myPage.js'></script>
    <script>
        var img = "${img.originalFileName}";

    </script>

</head>

<body class="body_container">
    <div class="wrapper">
    <jsp:include page="../UI/topMenu.jsp" flush="true" />
    <!-- security tags starts-->
    <sec:authorize access="isAnonymous()">
        <button class="btn" sec:authorize="isAnonymous()"
            onclick="location.href='/user/login'">로그인</button>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" var="loginUserName" />
        
    </sec:authorize>
    <!-- security tags ends-->
    <br><br><br><br>

    <!--mypage start-->
    <div class = "mypage_container" id="mypage">
            <div class = "container">
                <div class = "item">
                    <form action = "" method="get" enctype="multipart/form-data">
                        <img id = "img1" onclick="changeImage()" border="0" src = "resources/img/profile/${img.originalFileName}">
                        
                    </form>
                </div>
                <div class = "item2">
                    <ul>
                        <li style ="margin-top:50px">ID <strong>${loginUserName}</strong></li>
                        <br>
                        <hr>
                        <br>
                        <li>NAME <strong>${dto.userName}</strong></li>
                        </li>
                    </ul>
                </div>
            </div>
            <div class = "item3">
                <form action = "" method="post" enctype="multipart/form-data">
                    <input type="file" name = "file">
                    <button type="submit" class = "button">프로필 업데이트</button>
                 </form>
            </div>
         <br>
            <ul>
                <li>
                    <a href = "/myPage/founddetail">
                        <span class="item">내가 찾아준 내역 ▷</span>
                    </a>
                </li>
                <li>
                    <a href = "/review">
                        <span class="item">내 후기 모아보기 ▷</span>
                    </a>
                </li>
            </ul>
        </div>


        <jsp:include page="../UI/sideMenu.jsp" flush="true" />
            <script src='../resources/js/readImage.js'></script>
            <script src='../resources/js/main_sidebar.js'></script>
            <script src='../resources/js/naverMapApiTest3.js'></script>

        
        </div>
</body>

</html>