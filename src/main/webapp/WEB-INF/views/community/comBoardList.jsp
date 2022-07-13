<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CommunityBoardList</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>BoardNo</th>
            <th>Title</th>
            <th>Content</th>
            <th>CreateDate</th>
            <th>IsModified</th>
            <th>Location</th>
            <th>Category</th>
            <th>userNo</th>
            <th>hashNo</th>
            <th>picNo</th>
        </tr>
        <c:choose>
            <c:when test="${empty cbList}">
                <tr>
                    <td colspan="4">----작성된 글이 존재하지 않습니다.----</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${cbList}" var="cbl">
                    <tr>
                        <td>${cbl.CBoardNo}</td>
                        <td>${cbl.CTitle}</td>
                        <td>${cbl.CContent}</td>
                        <td>${cbl.CCreateDate}</td>
                        <td>${cbl.CIsModified}</td>
                        <td>${cbl.CLocation}</td>
                        <td>${cbl.CCategory}</td>
                        <td>${cbl.userNo}</td>
                        <td>${cbl.hashNo}</td>
                        <td>${cbl.picNo}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>