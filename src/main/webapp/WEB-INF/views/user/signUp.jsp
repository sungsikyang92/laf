<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Document</title>

		<script>
			let policyOn = "${policyOn}";
		</script>

		<script src='../resources/js/signUp.js'></script>


	</head>

	<body>

		<jsp:include page="../UI/topMenu.jsp" flush="true" />

		<div class="userReg-box">
			<h2>회원가입</h2>
			<!-- 리턴연결필요 submitBtn() -->
			<form action="/user/regUser" method="post" onsubmit="return submitBtn()" id="formTag">
				<div class="id-box">
					<label>아이디</label>
					<br>
					<input type="text" name="userId" title="아이디">
					<!--dto3-->
					<input type="button" name="chkDuplicatedID" value="중복확인" onclick="chkDuplicatedId();">
				</div>
				<div class="pw-box">
					<label>비밀번호</label>
					<br>
					<input type="password" name="userPw" id="비밀번호" title="비밀번호">
					<!--dto5-->
				</div>
				<div class="pw-box">
					<label>비밀번호 재확인</label>
					<br>
					<input type="password" name="userPwChk" title="비밀번호 재확인">
				</div>
				<div class="name-box">
					<label>이름</label>
					<br>
					<input type="text" name="userName" title="이름">
					<!--dto2-->
				</div>
				<div class="birth-box">
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
					<!--dto7-->
				</div>
				<div class="address-box">
					<label>주소</label>
					<br>
					<input type="text" name="userLocation" title="주소 상단">
					<!--dto8-->
					<br>
					<input type="text" name="userLocation_2nd" title="주소 하단">
				</div>
				<div class="contact-box">
					<label>전화번호</label>
					<br>
					<input type="text" name="userPhone" title="전화번호">
					<!--dto6-->
					<input type="button" value="인증번호 받기" onclick="contactIdentification()" title="전화 번호">
					<br>
					<input type="text" name="contactCertNo" placeholder="인증번호를 입력해주세요" title="인증번호">
				</div>
				<div class="email-box">
					<label>이메일</label>
					<br>
					<input type="text" name="userEmail" title="이메일">
					<!--dto 4-->
				</div>
				<div class="acc-box">
					<label>사례금 환급 계좌 (선택)</label>
					<br>
					<input type="text" name="userAcc" title="사례금 환급 계좌">
					<select id="selectBank">
						<option>선택하세요</option>
					</select>
					<br>
					<span>주의: 입력시 본인계좌가 아닌경우 회원가입이 어렵습니다.</span>
					<input type="button" value="계좌인증" onclick="bankIdentification()">
				</div>
				<input type="button" value="취소" onclick="location.href='/user/login'">
				<input type="submit" value="회원가입">
			</form>
		</div>
		<jsp:include page="../UI/sideMenu.jsp" flush="true" />

	</body>

	</html>