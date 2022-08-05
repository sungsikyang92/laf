<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>terms</title>
		<link rel="stylesheet" href="/resources/css/user.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/button.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/comBoard.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/header_footer.css" type="text/css">
		<link rel="stylesheet" href="/resources/css/header_footer_btn.css" type="text/css">
		<link rel="stylesheet"
			  href="https://cdn-uicons.flaticon.com/uicons-regular-rounded/css/uicons-regular-rounded.css">
		<script src='../resources/js/terms.js'></script>

	</head>

	<body>

		<jsp:include page="../UI/topMenu.jsp" flush="true" />

		<form id="allchked" method="post" action="/user/signUpForm">
			<table border="0">
				<tr>
					<th>${terms.TPolicyTitle } (필수)</th>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50">${terms.TPolicyContent}</textarea></td>
				</tr>
				<tr>
					<td>LaF 이용약관 동의 <input type="checkbox" name="chk" value="policy" onclick='checkSelectAll()' /></td>
				</tr>

				<tr>
					<th>${terms.TLocationTitle } (필수)</th>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50">${terms.TLocationContent}</textarea></td>
				</tr>
				<tr>
					<td>위치기반 서비스 동의 <input type="checkbox" name="chk" value="location" onclick='checkSelectAll()' />
					</tdid>
				</tr>

				<tr>
					<th>${terms.TPrivacyTitle} (필수)</th>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50">${terms.TPrivacyContent}</textarea></td>
				</tr>
				<tr>
					<td>개인정보 이용 동의 <input type="checkbox" name="chk" value="privacy" onclick='checkSelectAll()' /></td>
				</tr>
				<tr>
					<td>전체 이용 동의 <input type="checkbox" name="selectall" onclick='selectAll(this)' /></td>
				</tr>
				<tr>
					<td colspan="1">
						<input id="vol" type="button" value="취소" onclick="location.href='/user/login'">
						<input id="vol" type="button" value="확인" onclick="cfmReg()">


					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="../UI/sideMenu.jsp" flush="true" />

	</body>

	</html>