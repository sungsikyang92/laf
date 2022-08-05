<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <script src='resources/js/main_sidebar.js'></script>
            <link rel="stylesheet" href="resources/css/lostdetail.css" type="text/css">

            <script>
                let answer1 = "${boardDetail.LAnswers1}";
                let answer2 = "${boardDetail.LAnswers2}";
                let answer3 = "${boardDetail.LAnswers3}";
                let answer4 = "${boardDetail.LAnswers4}";
                let answer = "${boardDetail.LAnswers}";
                let boardNo = "${boardDetail.LBoardNo}";

                var penaltyObj = '<%= session.getAttribute("penaltyObj") %>'
                var penaltyArrList = JSON.parse(penaltyObj);
                
                console.log(typeof(penaltyArrList));

                //console.log(typeof(penaltyArrList));
              

            </script>




        </head>

        <body class="body_container">
            <jsp:include page="../UI/topMenu.jsp" flush="true" />


            <!-- 컨텐츠 삽입부분-->
            <div class="contents_container">
                <h1 style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;">글 제목 :
                    ${boardDetail.LTitle}</h1>
                <br>
                <h2>현재 동네 : ${boardDetail.LLocation}</h2>
                <div class="child-page-listing">
                    <br>
                    <br>
                    <h2>사진 </h2>
                    <div class="grid-container"
                        style="border-bottom: solid 2px rgb(169, 169, 169);padding-bottom: 20px;padding-top:20px">
                        <c:choose>
                            <c:when test="${empty picturelist }">
                                <td colspan="4">----사진이 없다----</td>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${picturelist}" var="plist">

                                    <article class="location-listing">
                                        <div class="location-title" href="">사진 </div>
                                        <div class="location-image">
                                            <img width="300" height="169" src="${plist.storedFilePath}" alt="">
                                        </div>
                                    </article>
                                </c:forEach>

                            </c:otherwise>
                        </c:choose>
                    </div>
                    <!-- end grid container -->
                </div>
                <br>
                <h2>작성일 : ${boardDetail.LCreateDate}</h2>
                <h3>글내용 : ${boardDetail.LContent}</h3>
                <br>
                <h3 style="border-top:solid 2px rgb(169, 169, 169);">문제 : ${boardDetail.LQuestion}</h3>

                <!-- 성식님 1:1대화 눌렀을때 체팅으로 연결되야 되는데 action을 어떻게 잡을지 확인 부탁해요~~ -->
                <form action="/chat" id="form_Q" style="border-bottom:solid 2px rgb(169, 169, 169);" method="post" onsubmit="return lostSubmitBtn()">
                    <br>
                    <input type="hidden" name="boardNo" value="${boardDetail.LBoardNo}">
                </form>

            </div>

            <jsp:include page="../UI/sideMenu.jsp" flush="true" />


            <script src='resources/js/lostQuestion.js'></script>
        </body>

        </html>