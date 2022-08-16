<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>signUp</title>
		<link rel="stylesheet" href="/resources/css/button.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/user.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
		<link rel="icon" href="data:;base64,iVBORw0KGgo=">
		<script>
			let policyOn = "${policyOn}";
		</script>

		<script src='../resources/js/signUp.js'></script>


	</head>

	<body class="body_container">
		<div class="wrapper">
		<jsp:include page="../UI/topMenu.jsp" flush="true" />

		<div class="userReg-box">
			<h1>회원가입</h1>
			<!-- 리턴연결필요 submitBtn() -->
			<hr><br><br>
			<form action="/user/regUser" method="post" onsubmit="return submitBtn()" id="formTag">
				<div class="id-box">
					<label><h3>아이디</h3></label>
					<input type="text" name="userId" title="아이디" blur="chkIdJs();">
					<!--dto3-->
					<input type="button" name="chkDuplicatedID" value="중복확인" onclick="chkDuplicatedId();">
				</div>
				<hr><br><br>
				<div class="pw-box">
					<label><h3>비밀번호</h3></label>
					<input type="password" name="userPw" id="비밀번호" title="비밀번호">
					<!--dto5-->
				</div>
				<hr><br><br>
				<div class="pw-box">
					<label><h3>비밀번호 재확인</h3></label>
					<input type="password" name="userPwChk" title="비밀번호 재확인">
				</div>
				<hr><br><br>
				<div class="name-box">
					<label><h3>이름</h3></label>
					<input type="text" name="userName" title="이름">
					<!--dto2-->
				</div>
				<hr><br><br>
				<!-- <div class="birth-box">
					<label>생년월일</label>
					<br>
					<select id="birthYear" name="bY">
						<option>선택하세요</option>
					</select>
					<select id="birthMonth" name="bM">
						<option>선택하세요</option>
					</select>
					<select id="birthDay" name="bD">
						<option>선택하세요</option>
					</select>
				</div>
				<div class="sex-box">
					<label>성별</label>
					<br>
					<input type="text" name="userSex" title="성별">
				</div>
				<div class="address-box">
					<label>주소</label>
					<br>
					<input type="text" name="userLocation" title="주소 상단">
					<br>
					<input type="text" name="userLocation_2nd" title="주소 하단">
				</div> -->
				<div class="contact-box">
					<label><h3>전화번호</h3></label>
					<input type="text" name="userPhone" title="전화번호">
					<!--dto6-->
					<input type="button" value="인증번호 받기" onclick="contactIdentification()" title="전화 번호">
					<br>
					<input type="text" name="contactCertNo" placeholder="인증번호를 입력해주세요" title="인증번호">
				</div>
				<hr><br><br>
				<div class="email-box">
					<label><h3>이메일</h3></label>
					<input type="text" name="userEmail" title="이메일">
					<!--dto 4-->
				</div>
				<!-- <div class="acc-box">
					<label>사례금 환급 계좌 (선택)</label>
					<br>
					<input type="text" name="userAcc" title="사례금 환급 계좌">
					<select id="selectBank">
						<option>선택하세요</option>
					</select>
					<br>
					<span>주의: 입력시 본인계좌가 아닌경우 회원가입이 어렵습니다.</span>
					<input type="button" value="계좌인증" onclick="bankIdentification()">
				</div> -->
				<br>
				<input class="inp" type="button" value="취소" onclick="location.href='/user/login'">
				<input class="inp" type="submit" value="회원가입">
			</form>
		</div>
		<%--<jsp:include page="../UI/sideMenu.jsp" flush="true"/>--%>
		</div>	
	</body>
</html>
