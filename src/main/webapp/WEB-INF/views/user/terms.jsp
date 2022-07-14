<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table border="1">
		<tr>
		<th>NAME</th><td>${mydto.myname }</td>
		</tr>
		<tr>
		<th>title</th><td>${mydto.mytitle }</td>
		</tr>
		<tr>
		<th>content</th><td><textarea rows="10" cols="30">${mydto.mycontent }</textarea></td>
		<tr>
			<td colspan="2">
			<input type="button" value="to list" onclick="location.href='/myboard/list'">
			<input type="button" value="modify" onclick="location.href='update?myno=${mydto.myno }'">
			<input type="button" value="delete" onclick="location.href='delete?myno=${mydto.myno }'">
			</td>
		</tr>
	</table>
</body>
</html>