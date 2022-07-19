function chkBlank(){
		console.log("chkBlank js 호출");
		if (document.getElementsByName("userId") != "" || document.getElementsByName("userPw") != ""){
			alert("아이디 혹은 비밀번호를 입력하여 주세요");
			return false;
		} else {
			return true;
		}
}




	// if (msg == "fail") {
	// 	alert("아이디 또는 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
	// }else if (msg == ""){
	// 	document.getElementById("sublogin").focus();
	// }else if (msg == "empty"){
	// 	alert("아이디 또는 비밀번호를 입력해 주세요.");
	// }
