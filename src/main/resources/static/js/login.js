function chkBlank(){
		console.log("chkBlank js 호출");
		if (document.getElementsByName("userId")[0].value == "" || document.getElementsByName("userPw")[0].value == ""){
			alert("아이디 혹은 비밀번호를 입력하여 주세요");
			return false;
		} else {
			return true;
		}
}

