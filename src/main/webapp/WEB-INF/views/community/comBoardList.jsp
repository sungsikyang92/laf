<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        </head>

        <body class="body_container">

            <jsp:include page="UI/topMenu.jsp" flush="true" />


            <div class="contents_container">
                <c:choose>
                    <c:when test="${empty cbList }">
                        <div>
                            ----작성된 글이 존재하지 않습니다----
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${cbList}" var="cbl">
                            <div class="comBoardListContainer" onclick="location.href='/cBoard/${cbl.CBoardNo}'">
                                <div>${cbl.CBoardNo}</div>
                                <div>${cbl.CTitle}</div>
                                <div>${cbl.CCreateDate}</div>
                                <div>${cbl.CLocation}</div>
                                <div>${cbl.picNo}</div>
                                <div>${cbl.CIsModified}</div>
                                <%-- <div>${cbl.picRmd}
                            </div>--%>
                            <div><img width="300" height="169" src="${cbl.storedFilePath}" alt="넌병신이야"></div>
            </div>
            </c:forEach>
            </c:otherwise>
            </c:choose>
            </div>


            <jsp:include page="UI/sideMenu.jsp" flush="true" />



        </body>

        </html>