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
    <script src='/resources/js/main_sidebar.js'></script>
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
        <form method="post" onsubmit="return chkBlank()">
            <div class="user-box">
                <label>Username</label>
                <br>
                <input type="text" name="username" id="sublogin">
            </div>
            <div class="user-box">
                <label>Password</label>
                <br>
                <input type="password" name="password">
            </div>
            <input type="submit" value="로그인">
            <input type="button" value="회원가입" onclick="location.href='/user/signUp'">
        </form>
		<input type="button" value="구글 로그인" onclick="location.href='/oauth2/authorization/google'">
    </div>

    <jsp:include page="../UI/sideMenu.jsp" flush="true"/>
</div>
</body>

</html>