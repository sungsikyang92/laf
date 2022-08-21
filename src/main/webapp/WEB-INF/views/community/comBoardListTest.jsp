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
    <title>LAF커뮤니티</title>

    <link rel="stylesheet" href="/resources/css/button.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <script src='/resources/js/main_sidebar.js'></script>


    <%-- ajax를 위한 script START--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <%-- ajax를 위한 script END--%>
    <script>
        $(document).ready(function () {
            $.ajax({
                type: "get",
                dataType: "json",
                url: "/test",
                //test시작
                success: function (testDtoList) {
                    let tags = '';
                    for (let i = 0; i < testDtoList.length; i ++) {
                        if (testDtoList[i].picExt == false) {
                            tags += "<div class='test'>";
                            tags += "<div>"+testDtoList[i].boardNo+"</div>";
                            tags += "<div>"+testDtoList[i].title+"</div>";
                            tags += "<div>"+testDtoList[i].createDate+"</div>";
                            tags += "<div>"+testDtoList[i].modified+"</div>";
                            tags += "<img width='300' height='169' src='/resources/img/woo.png' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        } else {
                            tags += "<div class='test'>";
                            tags += "<div>"+testDtoList[i].boardNo+"</div>";
                            tags += "<div>"+testDtoList[i].title+"</div>";
                            tags += "<div>"+testDtoList[i].createDate+"</div>";
                            tags += "<div>"+testDtoList[i].modified+"</div>";
                            tags += "<img width='300' height='169' src='" + testDtoList[i].storedFilePath + "' alt='사진을 불러올수가 엄써' class='img' />";
                            tags += "</div>";
                        }
                    }
                    $("#contents_container").html(tags);
                }
                //test끝
            })
        });
    </script>
</head>

<body class="body_container">
<div class="wrapper">
    <div id="contents_container">
        사진
    </div>
</div>
</body>
</html>