<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
    <b>시큐리티 테스트 페이지</b>

    <br>

    <p>
        aaa

        ${isAuthenticated}
        ${remoteUser}


    </p>

    <a class="nav-link" sec:authorize="isAnonymous()">로그인</a>
    

</body>
</html>