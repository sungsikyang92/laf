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
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">

    <script src="/webjars/bootstrap/4.3.1/dist/js/bootstrap.min.js"></script>
    <script src="/webjars/sockjs-client/1.1.2/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/2.3.3-1/stomp.min.js"></script>
    <script>
        // websocket & stomp initialize
        let sock = new SockJS("/ws-stomp");
        let ws = Stomp.over(sock);
        let reconnect = 0;


    </script>
</head>

<body class="body_container">
<div class="wrapper">
    <jsp:include page="../UI/comTopMenu.jsp" flush="true"/>
    <div class="contents_container">
        <div class="row">
            <div class="col-md-12">
                <h3>채팅해보자</h3>
                <h3>${roomInfo.name}</h3>
            </div>
        </div>
    </div><%-- contents_container --%>
</div><%--wrapper--%>
</body>
</html>