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
                data: {"boardNo": "l"},
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
    <%-- 찾아줄게요 버튼 ajax --%>
    <script type="text/javascript">
        function getFoundId(data) {
            let found = data;
            $.ajax({
                type: "get",
                data: "lCategory=" + found,
                dataType: "json",
                url: "/lafList/found/" + found,
                success: function (mainFoundListDtos) {
                    let tags = '';
                    for (let i = 0; i < mainFoundListDtos.length; i++) {
                        if (mainFoundListDtos[i].picExt == true) {
                            tags += "<div class='lostBoardListContainer' onclick='location.href=/" + mainFoundListDtos[i].boardNo + "'>";
                            tags += "<div>" + mainFoundListDtos[i].boardNo + "</div>";
                            tags += "<div>" + mainFoundListDtos[i].title + "</div>";
                            tags += "<div>" + mainFoundListDtos[i].createDate + "</div>";
                            tags += "<div>" + mainFoundListDtos[i].location + "</div>";
                            tags += "<img width='300' height='169' src='" + mainFoundListDtos[i].storedFilePath + "' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        } else {
                            tags += "<div class='lostBoardListContainer' onclick='location.href=/" + mainFoundListDtos[i].boardNo + "'>";
                            tags += "<div>" + mainFoundListDtos[i].boardNo + "</div>";
                            tags += "<div>" + mainFoundListDtos[i].title + "</div>";
                            tags += "<div>" + mainFoundListDtos[i].createDate + "</div>";
                            tags += "<div>" + mainFoundListDtos[i].location + "</div>";
                            tags += "<img width='300' height='169' src='/resources/img/woo.png' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        }
                    }
                    $("#test").html(tags);
                }
            })
        }
    </script>
    <%-- 찾아주세요 버튼 ajax --%>
    <script type="text/javascript">
        function getFoundId(data) {
            let lost = data;
            $.ajax({
                type: "get",
                data: "lCategory=" + lost,
                dataType: "json",
                url: "/lafList/lost/" + lost,
                success: function (mainLostListDtos) {
                    let tags = '';
                    for (let i = 0; i < mainLostListDtos.length; i++) {
                        if (mainLostListDtos[i].picExt == true) {
                            tags += "<div class='lostBoardListContainer' onclick='location.href=/" + mainLostListDtos[i].boardNo + "'>";
                            tags += "<div>" + mainLostListDtos[i].boardNo + "</div>";
                            tags += "<div>" + mainLostListDtos[i].title + "</div>";
                            tags += "<div>" + mainLostListDtos[i].createDate + "</div>";
                            tags += "<div>" + mainLostListDtos[i].location + "</div>";
                            tags += "<img width='300' height='169' src='" + mainLostListDtos[i].storedFilePath + "' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        } else {
                            tags += "<div class='lostBoardListContainer' onclick='location.href=/"+mainLostListDtos[i].boardNo+"'>";
                            tags += "<div>"+mainLostListDtos[i].boardNo+"</div>";
                            tags += "<div>"+mainLostListDtos[i].title+"</div>";
                            tags += "<div>"+mainLostListDtos[i].createDate+"</div>";
                            tags += "<div>"+mainLostListDtos[i].location+"</div>";
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
<div class="wrapper">

    <jsp:include page="UI/topMenu.jsp" flush="true"/>

    <!-- 컨텐츠 삽입부분-->
    <div class="contents_container">

        <div class="child-page-listing">

            <h2 style="text-align: center;">실시간베너 만들것 </h2>
            <div>
                <input type="button" value="찾아줄게요" id="foundBtn" class="foundBtn" onclick="getFoundId('습득')"/>
                <input type="button" value="찾아주세요" id="lostBtn" class="lostBtn" onclick="getFoundId('분실')"/>
            </div>
            <div class="grid-container" id="test">

                <c:choose>
                    <c:when test="${empty lostlist }">
                        <td colspan="4">----작성된 글이 존재하지 않습니다----</td>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${lostlist}" var="lostboard">
                            <div class="lostBoardListContainer" onclick="location.href='/${lostboard.boardNo}'">
                                <div>${lostboard.boardNo}</div>
                                <div>${lostboard.title}</div>
                                <div>${lostboard.createDate}</div>
                                <div>${lostboard.location}</div>
                                <div id="lostBoardListMainImg${lostboard.boardNo}">
                                    <c:choose>
                                        <c:when test="${empty picList}">
                                            <img width='300' height='169' src='/resources/img/woo.png'
                                                 alt='사진을 불러올수가 엄써'
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
            </div>
        </div>
    </div>

<%--    <jsp:include page="UI/sideMenu.jsp" flush="true"/>--%>
</div>

</body>

</html>