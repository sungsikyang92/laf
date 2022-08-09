<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- security teglibrary -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="resources/css/header_footer_btn.css" type="text/css">
    <link rel="stylesheet"
          href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
          <link rel="icon" href="data:;base64,iVBORw0KGgo=">


    <script src='resources/js/main_sidebar.js'></script>
    <link rel="stylesheet" href="resources/css/lostdetail.css" type="text/css">

    <script>
        let answer1 = "${boardDetail.answers1}";
        let answer2 = "${boardDetail.answers2}";
        let answer3 = "${boardDetail.answers3}";
        let answer4 = "${boardDetail.answers4}";
        let answer = "${boardDetail.answers}";
        let boardNo = "${boardDetail.boardNo}";

        var penaltyObj = '<%= session.getAttribute("penaltyObj") %>'
        var penaltyArrList = JSON.parse(penaltyObj);

        //lostfix010 --
        <sec:authorize access="isAuthenticated()">
            let userNo = "<sec:authentication property='principal.userNo'/>";
        </sec:authorize>
        let boardUserNo = "${boardDetail.userNo}";
        //--
    </script>

</head>

<body class="body_container">
<div class="wrapper">

<jsp:include page="../UI/topMenu.jsp" flush="true"/>

<!-- 컨텐츠 삽입부분-->
<div class="contents_container">
    <h1 style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;">글 제목 :
        ${boardDetail.title}</h1>
    <br>
    <h2>현재 동네 : ${boardDetail.location}</h2>
    <div class="child-page-listing">
        <br>
        <br>
        <h2>사진 </h2>
        <div class="grid-container"
             style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;padding-top:20px">
            <c:forEach items="${picturelist}" var="plist">
                <c:choose>
                    <c:when test="${empty plist.storedFilePath}">
                        <div><img width="300" height="169" src="/resources/img/woo.png"></div>
                    </c:when>
                    <c:otherwise>
                        <article class="location-listing">
                            <div class="location-image">
                                <img width="300" height="169" src="${plist.storedFilePath}" alt="">
                            </div>
                        </article>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <!-- end grid container -->
    </div>
    <br>
    <h3>작정자 : ${writerInfo.userName}</h3>
    <h2>작성일 : ${boardDetail.createDate}</h2>
    <h3>글내용 : ${boardDetail.content}</h3>
    <br>
    <h3 style="border-top:solid 2px rgb(169, 169, 169);">문제 : ${boardDetail.question}</h3>

    <form action="/post_Quiz" id="form_Q" style="border-bottom:solid 2px rgb(169, 169, 169);" method="post" onsubmit="return lostSubmitBtn();">
        <br>
        <input type="hidden" name="boardNo" value="${boardDetail.boardNo}">
        <input type="hidden" name="writerName" value="${writerInfo.userName}">
        <sec:authentication property="name" var="loginUserName"/>
        <input type="hidden" name="loginUserName" value="${loginUserName}"/>
    </form>

</div>
</div>
<%--<jsp:include page="../UI/sideMenu.jsp" flush="true"/>--%>


<script src='resources/js/lostQuestion.js'></script>

</body>

</html>
