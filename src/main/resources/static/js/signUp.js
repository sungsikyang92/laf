var x = function(){
    if (policyOn == "on"){
        return false
    }else{
        alert("약관에 동의 하셔야 합니다")
        return location.href="/user/login"
    }
};
x();
//topmenu js 충돌 수정
window.addEventListener('load', function(){
// window.onload = function(){

    console.log("signup js 연결");
    
    // onloadCalan();
    // onloadBank();
    localStorage.setItem("dupliChk", "");
    localStorage.setItem("idFrontRes", false);
    localStorage.setItem("pwFrontRes", false);
    localStorage.setItem("pwChkFrontRes", false);

    
    document.getElementsByName("userId")[0].onfocus = function(){
        if (document.getElementsByName("userId")[0].parentNode.querySelector("p") != null) {
            document.getElementsByName("userId")[0].parentNode.querySelectorAll('p').forEach(function(each){
                each.parentNode.removeChild(each);
            })
        }
    };
    document.getElementsByName("userPw")[0].onfocus = function(){
        if (document.getElementsByName("userPw")[0].parentNode.querySelector("p") != null) {
            document.getElementsByName("userPw")[0].parentNode.querySelectorAll('p').forEach(function(each){
                each.parentNode.removeChild(each);
            })
        }
        var newTag = setEmptyMsg("숫자, 특수문자, 영문 대소문자 각각 1개 이상 사용하여 8자리 이상 입력해 주세요", "red");
        document.getElementsByName("userPw")[0].parentNode.appendChild(newTag);
    };
    document.getElementsByName("userPwChk")[0].onfocus = function(){
        if (document.getElementsByName("userPwChk")[0].parentNode.querySelector("p") != null) {
            document.getElementsByName("userPwChk")[0].parentNode.querySelectorAll('p').forEach(function(each){
                each.parentNode.removeChild(each);
            })
        }
    };
    document.getElementsByName("userId")[0].onblur = function(){
        chkLogic("id");
    };
    document.getElementsByName("userPw")[0].onblur = function(){
        chkLogic("pw");
    };
    document.getElementsByName("userPwChk")[0].onblur = function(){
        chkLogic("pwChk");
    };
});

function chkLogic(parameter){
    console.log("calling chkLogic")
    let pattern = /\s/g;
    var idLogic = /^[0-9a-z]+$/;
    var idValue = document.getElementsByName("userId")[0].value;
    var pwLogic = /(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    var pwValue = document.getElementsByName("userPw")[0].value;
    switch (parameter){
        case 'id':
            console.log("calling IdLogic");
            console.log(idValue);
            if (idValue == ""){
                var newTag = setEmptyMsg("아이디를 입력하여 주십시오.", "red");
                document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
            }else if (pattern.test(idValue) == true){
                var newTag = setEmptyMsg("아이디에는 공백이 있으면 안됩니다.", "red");
                document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
            }else if (idLogic.test(idValue) == false || idValue.length<8) {
                var newTag = setEmptyMsg("아이디는 영문 소문자 숫자 합쳐 8자 이상 구성되어야 합니다.", "red");
                document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
            }else{
                localStorage.setItem("idFrontRes", true);
            }
            break;
        case 'pw':
            console.log("calling PwLogic");
            console.log(pwValue);
            if (pattern.test(pwValue) == true){
                if (document.getElementsByName("userPw")[0].parentNode.querySelector("p") != null) {
                    document.getElementsByName("userPw")[0].parentNode.querySelectorAll('p').forEach(function(each){
                        each.parentNode.removeChild(each);
                    })
                }
                var newTag = setEmptyMsg("비밀번호에는 공백이 있으면 안됩니다.", "red");
                document.getElementsByName("userPw")[0].parentNode.appendChild(newTag);
            }else if (pwValue == ""){
                if (document.getElementsByName("userPw")[0].parentNode.querySelector("p") != null) {
                    document.getElementsByName("userPw")[0].parentNode.querySelectorAll('p').forEach(function(each){
                        each.parentNode.removeChild(each);
                    })
                }
                var newTag = setEmptyMsg("비밀번호를 입력하여 주십시오.", "red");
                document.getElementsByName("userPw")[0].parentNode.appendChild(newTag);
            }else if (pwValue.length<8){
                if (document.getElementsByName("userPw")[0].parentNode.querySelector("p") != null) {
                    document.getElementsByName("userPw")[0].parentNode.querySelectorAll('p').forEach(function(each){
                        each.parentNode.removeChild(each);
                    })
                }
                var newTag = setEmptyMsg("비밀번호는 8자 이상이여야 합니다.", "red");
                document.getElementsByName("userPw")[0].parentNode.appendChild(newTag);

            }else if (pwLogic.test(pwValue) == false) {
                if (document.getElementsByName("userPw")[0].parentNode.querySelector("p") != null) {
                    document.getElementsByName("userPw")[0].parentNode.querySelectorAll('p').forEach(function(each){
                        each.parentNode.removeChild(each);
                    })
                }
                var newTag = setEmptyMsg("숫자, 특수문자 각 1회 이상, 영문은 대소문자 각각 1개 이상 사용하여 8자리 이상 입력해 주세요", "red");
                document.getElementsByName("userPw")[0].parentNode.appendChild(newTag);
            }else{
                if (document.getElementsByName("userPw")[0].parentNode.querySelector("p") != null) {
                    document.getElementsByName("userPw")[0].parentNode.querySelectorAll('p').forEach(function(each){
                        each.parentNode.removeChild(each);
                    })
                }
                var newTag = setEmptyMsg("사용가능한 비밀번호 입니다.", "green");
                document.getElementsByName("userPw")[0].parentNode.appendChild(newTag);
                localStorage.setItem("pwFrontRes", true);
            }

            break;
        case 'pwChk':
            console.log("calling PwLogic");
            if(document.getElementsByName("userPw")[0].value != document.getElementsByName("userPwChk")[0].value){
                var newTag = setEmptyMsg("비밀번호가 일치하지 않습니다. 다시 확인하여 주십시오.", "red");
                document.getElementsByName("userPwChk")[0].parentNode.appendChild(newTag);
            }else if (document.getElementsByName("userPw")[0].value == document.getElementsByName("userPwChk")[0].value){
                var newTag = setEmptyMsg("비밀번호가 일치 합니다.", "green");
                document.getElementsByName("userPwChk")[0].parentNode.appendChild(newTag);
                localStorage.setItem("pwChkFrontRes", true);
            }
            break;
    }


}

function chkDuplicatedId(){
    console.log("calling checking duplicated id")
    console.log(localStorage.getItem("idFrontRes"))
    if (localStorage.getItem("idFrontRes") == "false"){
        
        console.log("으메?")
        return false;
    }else{
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
                    var newTag = setEmptyMsg("이미존재하는 아이디이거나, 사용 불가능한 아이디 입니다", "red");
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
    console.log("우메" + localStorage.getItem("dupliChk"));
    
    
    if (document.querySelector("p") != null) {
        document.querySelectorAll('p').forEach(function(each){
            each.parentNode.removeChild(each);
        });
    }
    
    // 추가기능
    // - 빈항목확인
    var emptyRes = true;
    console.log(document.querySelector("#formTag").querySelectorAll("input"));
    console.log(document.querySelectorAll("input"));

    document.querySelector("#formTag").querySelectorAll("input").forEach(function(each){  
        if (each.value == ""){
            var newTag = setEmptyMsg(each.title + "을/를 확인해 주세요", "red");
            each.parentNode.appendChild(newTag);
            emptyRes = false;
        }
    });
    
    
    //이메일 검증
    var mailLogic = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (document.getElementsByName("userEmail")[0].value == ""){
        emptyRes = false;
    }else if(document.getElementsByName("userEmail")[0].value.match(mailLogic) == null){
            var newTag = setEmptyMsg("유효하지 않은 이메일 형식입니다.", "red");
            document.getElementsByName("userEmail")[0].parentNode.appendChild(newTag);
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
        var newTag = setEmptyMsg("아이디를 (중복)확인을 해주세요", "red");
        var himSelf = document.querySelector(".id-box").querySelector("#emptyMsg");
        if (himSelf != null) {
            himSelf.parentNode.removeChild(himSelf);
        }
        document.getElementsByName("userId")[0].parentNode.appendChild(newTag);
        localStorage.setItem("dupliChk", "");
        emptyRes = false;
    }
    
    //생년월일 옵션 확인
    // if (document.getElementById("birthYear").value == "년 선택" || 
    //     document.getElementById("birthMonth").value == "월 선택" || 
    //     document.getElementById("birthDay").value == "일 선택"){
        //     var newTag = setEmptyMsg("생년월일을 확인해 주세요", "red");
        //     document.getElementById("birthDay").parentNode.appendChild(newTag);
        //     emptyRes = false;
        // }
    if (emptyRes == true && localStorage.getItem("idFrontRes") == "true" && localStorage.getItem("pwFrontRes") == "true" && localStorage.getItem("pwChkFrontRes") == "true"){
        return emptyRes;
    }else{
        return false;
    }
    }
    
    function setEmptyMsg(msg, clr){
        var newTag = document.createElement("p");
        newTag.innerHTML = msg;
        newTag.id = 'emptyMsg';
        newTag.style.fontSize = "10px"
        newTag.style.color = clr;
        return newTag
    }

    // function onloadCalan(){
    //     var element = '<option>년 선택</option>';
    //     for (var i = 2022; i > 1920; i--) {
    //         element = element + '<option value="' + i + '">' + i + '</option>';
    //     }
    //     document.getElementById('birthYear').innerHTML = element;
    //     var element = '<option>월 선택</option>';
    //     for (var i = 1; i < 13; i++) {
    //         element = element + '<option value="' + i + '">' + i + '</option>';
    //     }
    //     document.getElementById('birthMonth').innerHTML = element;
    //     var element = '<option>일 선택</option>';
    //     for (var i = 1; i < 32; i++) {
    //         element = element + '<option value="' + i + '">' + i + '</option>';
    //     }
    //     document.getElementById('birthDay').innerHTML = element;
    // }
    // function onloadBank(){
    //     var element = '<option>은행선택</option> <option>신한은행</option> <option>우리은행</option>';
    //     document.getElementById('selectBank').innerHTML = element;
    // }