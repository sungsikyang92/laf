<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

	<script src='../resources/js/terms.js'></script>

</head>
<body>

	

    <table border="1">
		<tr>
			<th>${terms.TPolicyTitle } (필수)</th>
		</tr>
		<tr>
			<td><textarea rows="10" cols="30">${terms.TPolicyContent}</textarea></td>
		</tr>
		<tr>
			<td>LaF 이용약관 동의 <input type="checkbox" name="chk" value="policy" onclick='checkSelectAll()'/></td>
		</tr>

		<tr>
			<th>${terms.TLocationTitle } (필수)</th>
		</tr>
		<tr>
			<td><textarea rows="10" cols="30">${terms.TLocationContent}</textarea></td>
		</tr>
		<tr>
			<td>위치기반 서비스 동의  <input type="checkbox" name="chk" value="location" onclick='checkSelectAll()'/></td>
		</tr>

		<tr>
			<th>${terms.TPrivacyTitle} (필수)</th>
		</tr>
		<tr>
			<td><textarea rows="10" cols="30">${terms.TPrivacyContent}</textarea></td>
		</tr>
		<tr>
			<td>개인정보 이용 동의 <input type="checkbox" name="chk" value="privacy" onclick='checkSelectAll()'/></td>
		</tr>
		<tr>
			<td>전체 이용 동의 <input type="checkbox" name="selectall" onclick='selectAll(this)'/></td>
		</tr>
		<tr>
			<td colspan="1">
				<input type="button" value="취소" onclick="location.href='/user/login'">
				<input type="button" value="확인" onclick="cfmReg()">
				

			</td>
		</tr>
	</table>


</body>
</html>