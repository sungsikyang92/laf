var x = function(){
    if (policyOn == "on"){
        return false
    }else{
        alert("약관에 동의 하셔야 합니다")
        return location.href="/user/login"
    }
};
x();
window.onload = function(){
    
    onloadCalan();
    onloadBank();
    localStorage.setItem("dupliChk", "")
    console.log(localStorage.getItem("dupliChk"));

    //임시
    //submitBtn();
    

}
function onloadCalan(){
    var element = '<option>년 선택</option>';
    for (var i = 2022; i > 1920; i--) {
        element = element + '<option value="' + i + '">' + i + '</option>';
    }
    document.getElementById('birthYear').innerHTML = element;
    var element = '<option>월 선택</option>';
    for (var i = 1; i < 13; i++) {
        element = element + '<option value="' + i + '">' + i + '</option>';
    }
    document.getElementById('birthMonth').innerHTML = element;
    var element = '<option>일 선택</option>';
    for (var i = 1; i < 32; i++) {
        element = element + '<option value="' + i + '">' + i + '</option>';
    }
    document.getElementById('birthDay').innerHTML = element;
}
function onloadBank(){
    var element = '<option>은행선택</option> <option>신한은행</option> <option>우리은행</option>';
    document.getElementById('selectBank').innerHTML = element;
}

function chkDuplicatedId(){
    console.log("TBD_______calling checking duplicated id")
    // 추가기능
    //  - 아이디 중복확인
    var inputId = document.getElementsByName("userId")[0].value; //아이디값받아오기
    var reqJson = new Object(); //제이슨 유사한 객체생성
    reqJson.id = inputId; //받아온 아이디 제이슨 타입으로 저장
    var httpRequest = new XMLHttpRequest(); // 비동기통신 객체생성
    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState === XMLHttpRequest.DONE) {
            if (httpRequest.status === 200){
                var jsonFromController = httpRequest.response;
                if (jsonFromController.res == true){
                    var newTag = setEmptyMsg("사용가능한 아이디 입니다", "blue");
                    var himSelf = document.querySelector(".id-box").querySelector("#emptyMsg");
                    if (himSelf != null) {
                    himSelf.parentNode.removeChild(himSelf);
                    }
                    document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
                    localStorage.setItem("dupliChk", "vaild")
                    console.log(localStorage.getItem("dupliChk") == "invalid")

                }else{
                    var newTag = setEmptyMsg("사용 불가능한 아이디 입니다", "red");
                    var himSelf = document.querySelector(".id-box").querySelector("#emptyMsg");
                    if (himSelf != null) {
                    himSelf.parentNode.removeChild(himSelf);
                    }
                    document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
                    localStorage.setItem("dupliChk", "invalid")
                    console.log(localStorage.getItem("dupliChk") == "invalid")
                }
                
            }

        }

    };
    httpRequest.open('POST', '/user/chkDuplicatedId', true); //비동기통신 콜
    httpRequest.responseType = "json"; //응답 타입 설정 마찬가지로 제이슨
    httpRequest.setRequestHeader('Content-Type', 'application/json'); // 요청 헤더에 컨텐츠 타입 제이슨 정의
    httpRequest.send(JSON.stringify(reqJson)); //요청시 제이슨 데이터를 넣어서 전송

    //console.log(reqJson.id);
    
    return false;
}

function contactIdentification(){
    console.log("TBD_______calling Contact identification")
    
    // 추가기능
    //  - 본인 인증 api 실행

}

function bankIdentification(){
    console.log("TBD_______calling Bank identification()")

    // 추가기능
    //  - 은행 계좌 인증 api 실행

}

function submitBtn(){
    console.log("TBD_______calling submit()");
    console.log(localStorage.getItem("dupliChk"))
    

    if (document.querySelector("p") != null) {
        document.querySelectorAll('p').forEach(function(each){
        each.parentNode.removeChild(each);
        });
    }

    // 추가기능
    // - 빈항목확인
    var emptyRes = true;
    document.querySelectorAll('input').forEach(function(each){  
        if (each.value == ""){
            var newTag = setEmptyMsg(each.title + "을/를 확인해 주세요", "red");
            each.parentNode.appendChild(newTag);
            emptyRes = false;
        }
    });
    
    //생년월일 옵션 확인
    if (document.getElementById("birthYear").value == "년 선택" || 
        document.getElementById("birthMonth").value == "월 선택" || 
        document.getElementById("birthDay").value == "일 선택"){
        var newTag = setEmptyMsg("생년월일을 확인해 주세요", "red");
        document.getElementById("birthDay").parentNode.appendChild(newTag);
        emptyRes = false;
    }

    // - 비밀번호 일치확인후 html에표시
    if(document.getElementsByName("userPw")[0].value != document.getElementsByName("userPwChk")[0].value){
        var newTag = setEmptyMsg("비밀번호가 일치하지 않습니다", "red");
        document.getElementsByName("userPwChk")[0].parentNode.appendChild(newTag);
        emptyRes = false;
    }

    // ID 중복여부 확인
    if(localStorage.getItem("dupliChk") == "invalid") { // 중복일시
        var newTag = setEmptyMsg("사용 불가능한 아이디 입니다", "red");
        var himSelf = document.querySelector(".id-box").querySelector("#emptyMsg");
        if (himSelf != null) {
        himSelf.parentNode.removeChild(himSelf);
        }
        document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
        localStorage.setItem("dupliChk", "");
        emptyRes = false;
    }else if (localStorage.getItem("dupliChk") == "") { // 중복확인 안했을시
        var newTag = setEmptyMsg("아이디 중복확인을 해주세요", "red");
        var himSelf = document.querySelector(".id-box").querySelector("#emptyMsg");
        if (himSelf != null) {
        himSelf.parentNode.removeChild(himSelf);
        }
        document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
        localStorage.setItem("dupliChk", "");
        emptyRes = false;
    }
    return emptyRes;
}

function setEmptyMsg(msg, clr){
    var newTag = document.createElement("p");
    newTag.innerHTML = msg;
    newTag.id = 'emptyMsg';
    newTag.style.fontSize = "10px"
    newTag.style.color = clr;
    return newTag
}