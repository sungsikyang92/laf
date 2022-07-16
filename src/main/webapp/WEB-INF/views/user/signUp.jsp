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

    <form action="" method="postmapping">
		<table border="">
			<tr>
			<th>noname</th>
			<td><input type="text" name="myname"></td>
			</tr><tr>
			<th>noname</th>
			<td><input type="text" name="mytitle"></td>
			</tr><tr>
			<th>noname</th>
			<td><textarea rows="10" cols="80" name="mycontent"></textarea><td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="완료">
					<input type="button" value="취소" onclick="location.href='list'">
				</td>
			</tr>
		</table>
	
	</form>

    
</body>
</html>