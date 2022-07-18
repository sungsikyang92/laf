<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

	
	<div class="userReg-box">
		<h2>회원가입</h2>
		<form action="/user/regUser" method="post" onsubmit="return submit()">
			<div class="id-box">
				<label>아이디</label>
				<br>
				<input type="text" name="userId"> <!--dto3-->
				<input type="button" name="chkDuplicatedID" value="중복확인" onclick="chkDuplicatedID()">
			</div>
			<div class="pw-box">
				<label>비밀번호</label>
				<br>
				<input type="password" name="userPw" > <!--dto5-->
			</div>
			<div class="pw-box">
				<label>비밀번호 재확인</label>
				<br>
				<input type="password" name="userPwChk" > 
			</div>
			<div class="name-box">
				<label>이름</label>
				<br>
				<input type="text" name="userName" > <!--dto2-->
			</div>
			<div class="birth-box">
				<label>생년월일</label>
				<br>
				<select id="birthYear">
					<option>선택하세요</option>
				</select>
				<select id="birthMonth">
					<option>선택하세요</option>
				</select>
				<select id="birthDay">
					<option>선택하세요</option>
				</select>
			</div>
			<div class="sex-box">
				<label>성별</label>
				<br>
				<input type="text" name="userSex" > <!--dto7-->
			</div>
			<div class="address-box">
				<label>주소</label>
				<br>
				<input type="text" name="userLocation" > <!--dto8-->
				<br>
				<input type="text" name="userLocation_2nd" >
			</div>
			<div class="contact-box">
				<label>전화번호</label>
				<br>
				<input type="text" name="userPhone" > <!--dto6-->
				<input type="button" value="인증번호 받기" onclick="contactIdentification()">
				<br>
				<input type="text" name="contactCertNo" placeholder="인증번호를 입력해주세요" >
			</div>
			<div class="email-box">
				<label>이메일</label>
				<br>
				<input type="text" name="userEmail" > <!--dto 4-->
			</div>
			<div class="acc-box">
				<label>사례금 환급 계좌 (선택)</label>
				<br>
				<input type="text" name="userAcc" >
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

    
</body>
</html>