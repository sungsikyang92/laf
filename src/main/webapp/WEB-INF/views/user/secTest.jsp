<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>SecTest</title>
        
        <link rel="stylesheet" href="/resources/css/button.css" type="text/css">
        <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
        <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
        <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
        <link rel="icon" href="data:;base64,iVBORw0KGgo=">
      </head>

      <body>


        <!--ROLE_USER 권한을 갖는다면 이 글이 보임-->
        <h1 sec:authorize="hasRole('ADMIN')">Has admin Role</h1>

        <!--ROLE_ADMIN 권한을 갖는다면 이 글이 보임-->
        <h1 sec:authorize="hasRole('USER')">Has user Role</h1>

        <!--어떤 권한이건 상관없이 인증이 되었다면 이 글이 보임-->
        <div sec:authorize="isAuthenticated()">
          Only Authenticated user can see this Text
        </div>

        <!--인증시 사용된 객체에 대한 정보-->
        <b>Authenticated DTO:</b>
        <div sec:authentication="principal"></div>

        <!--인증시 사용된 객체의 Username (ID)-->
        <b>Authenticated username:</b>
        <div sec:authentication="name"></div>

        <!--객체의 권한-->
        <b>Authenticated user role:</b>
        <div sec:authentication="principal.authorities"></div>

        <!-- 안먹힘 shit -->
        <a class="nav-link" sec:authorize="isAnonymous()">로그인</a>
        <a class="nav-link" sec:authorize="isAuthenticated()">로그아웃</a>


        <sec:authorize access="isAnonymous()">
          Login
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
          Logout
          <sec:authentication property="name" var="username" />
          <p>${username}</p>

          <sec:authentication property="principal" var="pcp" />
          <p>${pcp}</p>
        </sec:authorize>



      </body>

      </html>