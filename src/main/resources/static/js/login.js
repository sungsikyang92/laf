window.onload = function(){
	// if (document.querySelector('p') != null){
	// 	document.querySelector('p').remove
	// }
	if (param == "true"){
		var errorTag = setErrorMsg("아이디 혹은 비밀번호가 일치하지 않습니다", "red");
		document.getElementsByName("password")[0].parentNode.appendChild(errorTag);
	}
}


function chkBlank(){
		console.log("chkBlank js 호출");
		if (document.getElementsByName("username")[0].value == "" || document.getElementsByName("password")[0].value == ""){
			alert("아이디 혹은 비밀번호를 입력하여 주세요");
			return false;
		} else {
			return true;
		}
}

function setErrorMsg(msg, clr){
    var newTag = document.createElement("p");
    newTag.innerHTML = msg;
    newTag.id = 'errorMsg';
    newTag.style.fontSize = "10px"
    newTag.style.color = clr;
    return newTag
}