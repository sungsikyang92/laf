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

function chkDuplicatedID(){
    console.log("TBD_______calling checking duplicated id")

    // 추가기능
    //  - 아이디 중복확인

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

function submit(){
    console.log("TBD_______calling submit()")
    
    // 추가기능
    // - 빈항목확인
    // - 비밀번호 일치확인후 html에표시
    // - 서브밋
    
    return true;


}