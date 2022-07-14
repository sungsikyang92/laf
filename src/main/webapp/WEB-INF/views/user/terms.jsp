<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table >
		<tr>
			<th>${terms.tPolicyTitle}</th>
		</tr>
		<tr>
			<td><textarea rows="10" cols="30">${terms.tPolicyContent}</textarea></td>
		</tr>
		<tr>
			<td>이용약관에 동의합니다 <input type="radio" name="chk_policy"></td>
		</tr>
		<tr>
			<th>${terms.tPrivacyTitle}</th>
		</tr>
		<tr>
			<td><textarea rows="10" cols="30">${terms.tPrivacyContent}</textarea></td>
		</tr>
		<tr>
			<td>개인정보 처리방침에 동의합니다 <input type="radio" name="chk_policy"></td>
		</tr>
		<tr>
			<td colspan="1">
				<input type="button" value="to list" onclick="location.href='/myboard/list'">
				<input type="button" value="modify" onclick="location.href='update?myno=${mydto.myno }'">
			</td>
		</tr>
	</table>
</body>
</html>