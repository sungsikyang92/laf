<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();
	});
	
	function login(){
		let memberid = $("#memberid").val().trim();
		let memberpw = $("#memberpw").val().trim();
		
		let loginVal = {
			"memberid": memberid,
			"memberpw": memberpw
		};
		
		if(memberid==null || memberid=="" || memberpw==null || memberpw==""){
			alert("ID 및 PW를 확인해 주세요");	
		}else{
			$.ajax({
				url:"ajaxlogin.do", //어디로보내줄것인가? (?memberpw="123" 이렇게 제이슨 명하고 같으면 dto.get할수있는데, no="123"이러면 dto.get 하면 안됨)
				type:"post",
				data: JSON.stringify(loginVal), //체크
				dataType: "json", //서버에서 반환되는 데이터 형식
				contentType: "application/json",
				success: function(msg){
					if(msg.check==true){
						alert("mvclogin.jsp _ ajax 로그인 결과 성공");
						location.href='list.do';
					} else{
						alert("mvclogin.jsp _ ajax 로그인 결과 실패ㅜㅜ");
						$("#loginChk").show();
						$("#loginChk").html("ID혹은 PW가 잘못되었습니다.")
					}
					
					
				},
				error:function(){
					alert("mvclogin.jsp _ ajax 통신 실패");
				}
				
			
			
			});
			}
		}


	
	

</script>

<body>
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="memberpw"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="login" onclick="login();"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="loginChk"></td>
			</tr>
	</table>

</body>
</html>