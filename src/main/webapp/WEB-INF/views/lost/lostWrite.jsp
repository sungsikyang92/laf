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

    <title>Laf Lostwrite</title>

    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

    <link rel="stylesheet" href="resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="resources/css/header_footer_btn.css" type="text/css">
    
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <link rel="stylesheet" href="resources/css/lostwrite.css" type="text/css">
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">


    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri"></script>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=0dxd3s19ri&submodules=geocoder"></script>
    <script type="text/javascript" src="resources/js/lostWrite.js" async></script>

    
</head>

<body class="body_container">
    <div class="wrapper">
<jsp:include page="../UI/topMenu.jsp" flush="true"/>

<!-- 컨텐츠 삽입부분-->

<div class="contents_container">
    <!-- question001: id="formTag" onsubmit="return submitBtn();" 추가 -->
    <form action="/write" method="post" enctype="multipart/form-data" id="formTag" onsubmit="return submitBtn();">
        <sec:authentication property="principal.userNo" var="userNo"/>
        <input type="hidden" name="userNo" value="${userNo}">
        <div id="image_container"></div>
        <input type="file" id="pictureUpload" name="pictureUpload" accept="image/*" onchange="setThumbnail(event);" multiple>
        <!-- lostfix002 start -->
        <button type="button" onclick="resetFile(2)" id="fileResetBtn">올린파일 초기화</button>
        <!-- lostfix002 end -->
        <br>
        <!-- objdesc001-02 start-->
        <div id="loadingContainer">
            <br>
            <span style="font-size:15px;">사물인식 중</span> <img src='../resources/img/loading.gif' width="15%"/>
        </div>
        <!-- objdesc001-02 end-->
        <br>
        <h2>
            분실
            <input type="radio" name="category" id="" value="분실"/>
            습득
            <input type="radio" name="category" id="" value="습득" checked="checked"/>
        </h2>
        <!-- objdesc001-02 start-->
        <div id="objResContainer"></div>
        <br>
        <h2>카테고리 :
            <input type="text" id="category" readonly="true" placeholder="첫번째 사진을 올리시면 인공지능이 자동으로 등록합니다. (실패시 직접입력)"/>
        </h2>
        <!-- objdesc001-02 end -->
        <br>
        <h1 style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;">글 제목 :
            <input type="text" name="title" placeholder="글 제목을 입력해주세요"/>
        </h1>
        <br>
        <h2>글 내용 : <br>
            <textarea cols="150" rows="15" name="content" placeholder="글 내용을 입력해주세요"></textarea>
        </h2>
        <br>
        <!-- 문제 유형 선택 업데이트 question001 start -->
        <h3 style="border-top:solid 2px rgb(169, 169, 169);">
            문제 선택
            <select id="quesQuery" onchange="selectBoxChange(this.value);">
                <option>선택하세요</option>
            </select>
        </h3>
        <br>
        <!-- 문제 유형 선택 업데이트 question001 ens -->
        <h3>
            문제 :<input type="text" name="question" placeholder="질문을 입력해 주세요"/>
        </h3>
        <br>
        <h3>
            정답 :<input type="text" name="answers" placeholder="정답을 입력해 주세요"/>
        </h3>
        <br>
        <h3>
            오답 :<input type="text" name="answers1" placeholder="오답을 입력해 주세요"/>
        </h3>
        <br>
        <h3>
            오답 :<input type="text" name="answers2" placeholder="오답을 입력해 주세요"/>
        </h3>
        <br>
        <h3>
            오답 :<input type="text" name="answers3" placeholder="오답을 입력해 주세요"/>
        </h3>
        <br>
        <h3>
            오답 :<input type="text" name="answers4" placeholder="오답을 입력해 주세요"/>
        </h3>
        <br>
        <h2>지도</h2>
        <div id="map" style="width:60%;height:400px;">
            <div class="search">
                <input id="address" type="text" placeholder="검색할 주소" value=""/>
                <input id="addsubmit" type="button" value="주소 검색"/>
            </div>
        </div>
        <br>
        <div id="location" class="location"></div>
        <h4>지도로 위치를 설정하시면 해당위치로 검색시 노출됩니다.</h4>
        <br>
        <h2>HashTag</h2>
        <input id="hashtag" name="hashtag" type="text" size="50" placeholder="검색 노출 태그 입력 ,로 입력해주세요.">
        <br>
        <button id="submit" type="submit">작성완료</button>
    </form>
</div>
</div>

<%--<jsp:inlude page="../UI/sideMenu.jsp" flush="true"/>--%>


<script src='resources/js/readImage.js'></script>
<!-- main_sidebar js 에러뜸 주석처리 question001 -->
<%-- <script src='resources/js/main_sidebar.js'></script> --%> 
<script src='resources/js/naverMapApiTest3.js'></script>

</body>

</html>
