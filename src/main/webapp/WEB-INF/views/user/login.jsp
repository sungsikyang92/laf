<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="/resources/css/button.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/user.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="stylesheet"
          href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
          <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <!-- <script src='/resources/js/main_sidebar.js'></script> -->
    <script src='../resources/js/login.js'></script>
    <script>
        // 요놈!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        let param = "${param.error}";
    </script>

</head>


<body>
<div class="wrapper">
    <jsp:include page="../UI/topMenu.jsp" flush="true"/>
    <div class="login-box">
        <h2>Login</h2>
        <hr><br><br><br>
        <form method="post" onsubmit="return chkBlank()">
            <div class="user-box">
                <label>Username</label>
                <br>
                <input type="text" name="username" id="sublogin">
            </div>
            <hr><br><br><br>
            <div class="user-box">
                <label>Password</label>
                <br>
                <input type="password" name="password">
            </div>
            <hr><br><br>
            <div class="login_logon">
                <input id="login" type="submit" value="로그인">
                <input id="google" type="button" value="구글 로그인" onclick="location.href='/oauth2/authorization/google'">
                <input id="logon" type="button" value="회원가입" onclick="location.href='/user/signUp'">
            </div>
        </form>
        
    </div>

    <%--<jsp:include page="../UI/sideMenu.jsp" flush="true"/>--%>
    
</div>
</body>

</html>