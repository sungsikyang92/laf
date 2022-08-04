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
    <title>LAF커뮤니티</title>

    <link rel="stylesheet" href="/resources/css/button.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="stylesheet"
          href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
    <script src='/resources/js/main_sidebar.js'></script>


    <%-- ajax를 위한 script START--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <%-- ajax를 위한 script END--%>
    <script>
        $(document).ready(function () {
            $.ajax({
                type: "get",
                data: {"boardNo":"com"},
                dataType: "json",
                url: "/picture",
                success: function (mainPicList) {
                    let tags = '';
                    for (let i = 0; i < mainPicList.length; i++) {
                        if (mainPicList[i].picExt == false) {
                            tags += "<article class='location-listing'>";
                            tags += "<div class='location-image'>";
                            tags += "<img width='300' height='169' src='/resources/img/woo.png' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                            tags += "</article>";
                        } else {
                            tags += "<article class='location-listing'>";
                            tags += "<div class='location-image'>";
                            tags += "<img width='300' height='169' src='" + mainPicList[i].storedFilePath + "' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                            tags += "</article>";
                        }
                        $("#comBoardListMainImg" + mainPicList[i].boardNo).html(tags);
                        tags = '';
                    }
                }
            })
        });
    </script>
</head>

<body class="body_container">
<div class="wrapper">
    <jsp:include page="../UI/comTopMenu.jsp" flush="true"/>
    <div class="contents_container">
        <c:choose>
            <c:when test="${empty cbList }">
                <div><img width="300" height="169" src="/resources/img/woo.png"></div>
                <div>----작성된 글이 존재하지 않습니다----</div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${cbList}" var="cbl">
                    <div class="comBoardListContainer" onclick="location.href='/cBoard/${cbl.boardNo}'">
                        <div>${cbl.boardNo}</div>
                        <div>${cbl.title}</div>
                        <div>${cbl.createDate}</div>
                        <div>${cbl.location}</div>
                        <div>글 : ${cbl.modified}</div>
                        <div id="comBoardListMainImg${cbl.boardNo}">
                            <c:choose>
                                <c:when test="${empty picList}">
                                    <img width='300' height='169' src='/resources/img/woo.png' alt='사진을 불러올수가 엄써'
                                         class='img'/>
                                </c:when>
                                <c:otherwise><img width='300' height='169' src='/resources/img/woo.png'
                                                  alt='사진을 불러올수가 엄써'
                                                  class='img'/></c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <div id=""></div>
    </div>
    <jsp:include page="../UI/sideMenu.jsp" flush="true"/>
</div>
</body>
</html>