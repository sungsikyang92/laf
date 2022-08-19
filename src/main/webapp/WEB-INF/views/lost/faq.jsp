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
    <link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <script src='../resources/js/login.js'></script>

    <style>
        .wrapper{
            width: 100%;
            text-align: left;
        }

        .faq-container{
            position: relative;
            width: 90%;
            top: 5em;
            left: 10%;
        }

        @media(max-width: 1024px){
            .faq-container{
                width: 70%;
            }
        }


    </style>

</head>


<body>
<div class="wrapper">
    <jsp:include page="../UI/topMenu.jsp" flush="true"/>
    <div class="faq-container">

      
        <!-- <div id="test" style="CURSOR: hand" onclick="if(plain.style.display=='none') {plain.style.display='';} else {plain.style.display='none';}"><b>서비스를 가입해야만 꼭이용할 수 있나요?</b></div>
        <div div id="plain" style="display: none">
            네 그렇습니다. 사용자는 회원가입을 해야지 이용할 수 있습니다. 이는 불법적인 행위를 방지 하기 위함 입니다
        </div> -->
        <div><b>서비스를 가입해야만 꼭이용할 수 있나요?</b></div>
        <div><br>
            네 그렇습니다. 사용자는 회원가입을 해야지 이용할 수 있습니다. 이는 불법적인 행위를 방지 하기 위함 입니다
        </div>
        <br><br>
        <div>
            <b>
                분실물 찾아주는 서비스를 이용하려면 어떻게 해야하나요?
            </b>
        </div><br>
        <div>
            분실자와 습득자는 각각 아래와 같이 다른 절차로 이용을 하실 수 있습니다.<br>
            습득자의 경우 아래와 같은 순서로 서비스 이용을 하시면 됩니다.<br>
            &nbsp;1. 회원가입<br>
            &nbsp;2. 로그인<br>
            &nbsp;3. 분실물 등록 또는 습득물 등록<br>
            &nbsp;4. 1:1 채팅후 분실자와 약속후 돌려줌<br>
            분실자의 경우 아래와 같은 순서로 서비스 이용을 하시면 됩니다.<br>
            &nbsp;1. 회원가입<br>
            &nbsp;2. 로그인<br>
            &nbsp;3. 분실물글 혹은 습득물글 열람<br>
            &nbsp;4. 분실물 글 정보 퀴즈 맞추기<br>
            &nbsp;5. 1:1 채팅후 분실자와 약속후 돌려줌<br>
        </div> <br><br>
        <div class="">
            <b>
                경찰청 서비스와 무엇이 다른가요?
            </b>
        </div><br>
        <div class="">
            LAF 서비스는 복잡한 가입절차를 간소화 시켰고, 분실물을 찾을 때 문제로 확인함으로서, 실소유주에 대한 검증절차를 강화시켰습니다
        </div><br><br>
        <div class="">
            <b>
                사례금은 없나요? 
            </b>
        </div><br>
        <div class="">
            사례금은 유실물법 4조 의해 물건 가액의 5% ~ 20%까지 받으실수 있습니다. 다만, 분실자와 협의하셔야 하고, LAF는 유실물에 대한 금전 거래로 파생되는 어떠한 절차 및 결과에도 책임이 없습니다.

        </div><br><br>
        <div class="">
            <b>
                불법으로 물건을 잃어 버렸다고 거짓말 한사람들은 어떻게 대처해야하나요?
            </b>
        </div><br>
            거짓말하는 사람들을 신고해 주시면 확인후 블랙리스트 처리가 가능합니다. <br>
            그리고 글작성 하실때 최대한 분실자만 알아볼 수 있는 특징으로 질문과 답변을 적어주시므로 사전에 예방하는 방법이 있습니다.    
        <div class=""><br><br>
            <b>
                휴대폰으로도 이용이 가능한가요?
            </b>
        </div>
        <div class=""><br>
            물론입니다. 저희 LAF 서비스는 휴대폰에도 최적화가 되어있어 매우 편리하게 언제 어디서나 휴대폰만 있으면 사용이 가능합니다.
        </div>

        

    </div>
</div>




