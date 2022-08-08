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

    <title>채팅리스트</title>


    <link rel="stylesheet" href="/resources/css/button.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="stylesheet" href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
    <script src='/resources/js/main_sidebar.js'></script>

</head>

<body class="body_container">
<div class="wrapper">
    <jsp:include page="../UI/comTopMenu.jsp" flush="true"/>
    <div class="contents_container">
        <div class="row">
            <div class="col-md-12">
                <h3>채팅</h3>
            </div>
        </div>
<!-- <%--        <div class="input-group">--%>
<%--            <div class="input-group-prepend">--%>
<%--                <label class="input-group-text">방제목</label>--%>
<%--            </div>--%>
<%--            <form>--%>
<%--            <input type="text" class="form-control" name="room_name">--%>
<%--                <div class="input-group-append">--%>
<%--                    <button class="chatInputBtn" type="button" onclick="createRoom(this.id)"></button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%> -->
        <div class="chat_list">
            <c:choose>
                <c:when test="${empty chatRoomList}">
                    <div>아직 진행된 채팅이 없습니다!</div>
                </c:when>
                <c:otherwise>
                   <c:forEach items="${chatRoomList}" var="crl">
                       <div onclick="location.href='/chat/room/enter/${crl.roomId}'">${crl.name}</div>
                   </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <!-- <%-- contents_container --%> -->
</div>
<!-- <%--wrapper--%> -->
</body>
</html>