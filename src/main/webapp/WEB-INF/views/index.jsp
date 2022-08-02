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
    <title>LaF</title>


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
                data: {"boardNo":"l"},
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
                        $("#lostBoardListMainImg" + mainPicList[i].boardNo).html(tags);
                        tags = '';
                    }
                }
            })
        });
    </script>
</head>

<body class="body_container">
<div class="wrapper">

    <jsp:include page="UI/topMenu.jsp" flush="true"/>


    <!-- 컨텐츠 삽입부분-->
    <div class="contents_container">

        <div class="child-page-listing">

            <h2 style="text-align: center;">실시간베너 만들것 </h2>

            <div class="grid-container">

                <c:choose>
                    <c:when test="${empty lostlist }">
                        <td colspan="4">----작성된 글이 존재하지 않습니다----</td>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${lostlist}" var="lostboard">
<%--                            <article class="location-listing">--%>
<%--                                <a class="location-title" href="${lostboard.LBoardNo}" name="lBoardNo">--%>
<%--                                        ${lostboard.LTitle} </a>--%>
<%--                                <div class="location-image">--%>
<%--                                    <a href="#">--%>
<%--                                        <img width="300" height="169" src="${lostboard.storedFilePath}"--%>
<%--                                             alt="${lostboard.LTitle}">--%>
<%--                                    </a>--%>
<%--                                </div>--%>
<%--                            </article>--%>
                            <div class="lostBoardListContainer" onclick="location.href='/${lostboard.LBoardNo}'">
                                <div>${lostboard.LBoardNo}</div>
                                <div>${lostboard.LTitle}</div>
                                <div>${lostboard.LCreateDate}</div>
                                <div>${lostboard.LLocation}</div>
                                <div id="lostBoardListMainImg${lostboard.LBoardNo}">
                                    <c:choose>
                                        <c:when test="${empty picList}">
                                            <img width='300' height='169' src='/resources/img/woo.png' alt='사진을 불러올수가 엄써'
                                                 class='img'/>
                                        </c:when>
                                        <c:otherwise>사진있어용</c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <jsp:include page="" flush="true"/>
</div>

</body>

</html>