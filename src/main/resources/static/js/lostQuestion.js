//topmenu js 충돌 수정
window.addEventListener('load', function(){
// window.onload = function () {



    function Quiz(answer1, answer2, answer3, answer4, answer) {

        let QArray = [answer1, answer2, answer3, answer4, answer];
        console.log(QArray);

        shuffle(QArray);
        console.log(QArray);

        let formq = document.getElementById('form_Q');
        for (let i = 0; i < QArray.length; i++) {
            addforminput(formq, QArray[i], i);
        }
        let button = document.createElement('button');
        button.setAttribute("type", "submit");
        button.setAttribute("id", "toChatBtn")
        button.innerHTML = "1:1대화";
        formq.appendChild(button);
        let updateButton = document.createElement('button');
        updateButton.setAttribute("type", "button")
        //lostfix001 --
        updateButton.setAttribute("id", "updateBtn")
        //--
        updateButton.innerHTML = "수정하기";
        updateButton.setAttribute("onclick", "location.href='/update/" + boardNo + "'");
        formq.appendChild(updateButton);
    }
    function shuffle(array) {

        for (let i = array.length - 1; i > 0; i--) {
            let j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    }

    function addforminput(formq, nm, i) {
        let input = document.createElement('input');
        let div = document.createElement('div');
        let br = document.createElement('br');
        let h3 = document.createElement('h3');

        input.setAttribute("type", 'radio');
        input.setAttribute("id", String('answ' + (i + 1)));
        input.setAttribute("value", String(nm));
        input.setAttribute("name", "ans");
        input.setAttribute("required", "required")

        h3.innerHTML = String(nm);
        div.setAttribute("class", 'input_container');
        formq.appendChild(div);
        div.appendChild(input);
        div.appendChild(h3);
        formq.appendChild(br);
    }

    Quiz(answer1, answer2, answer3, answer4, answer);

    //BLOCK 1. 현재접속해 있는 보드 넘버를 가져온다. -> jsp에 boardNo로 저장됨
    //BLOCK 2. 로그인한 사용자가 현재 보드넘버에서 누적 페널티를 확인한다.
    var wrongCnt = 0;
    
    if (penaltyArrList != null){
        penaltyArrList[0].forEach(function(element){
            if (element.pBoardNo == boardNo){
                wrongCnt = wrongCnt + element.penaltyCnt;
            }       
        });
        console.log(wrongCnt);
        localStorage.setItem("wrongCnt", wrongCnt);
    }else{
        wrongCnt = null;
    }
    
    //lostfix001 ---
    const toChatBtn = document.getElementById("toChatBtn");
    const updateBtn = document.getElementById("updateBtn");
    let backBtn = document.createElement('button');
    //BLOCK 3. 누적페널티 값이 3이면 1:1 버튼을 안보이게 하고 뒤로가기 버튼을 만든다.
    if (wrongCnt == 3 || wrongCnt == null){
        console.log("이프실행");
        console.log(toChatBtn);
        toChatBtn.setAttribute("type", "button");
        toChatBtn.innerHTML = "1:1 대화 불가";
        //toChatBtn.remove();

        backBtn.setAttribute("type", "button");
        backBtn.setAttribute("onclick", "history.back()");
        backBtn.innerHTML = "뒤로가기";
        let formq = document.getElementById('form_Q');
        formq.appendChild(backBtn);
    }

    if (userNo == boardUserNo) {
        toChatBtn.remove();
        backBtn.setAttribute("type", "button");
        backBtn.setAttribute("onclick", "history.back()");
        backBtn.innerHTML = "뒤로가기";
        let formq = document.getElementById('form_Q');
        formq.appendChild(backBtn);  
    }else{
        updateBtn.remove();

    }
    // ---
});

function lostSubmitBtn(){
    console.log("JS funtion call _________ lostSubmitBtn");
    
    //BLOCK 4. 누적페널티가 3 미만인경우
    var wrongCnt = localStorage.getItem("wrongCnt");
    console.log("wrongCnt1 _________" + wrongCnt);
    
    if (wrongCnt < 3){
        console.log("wrongCnt < 3 이프실행");
        //(1)오답을 눌렀을 경우 누적페널티를 추가하여 세션에 저장한다.
        if (document.querySelector('input:checked').value != answer){
            console.log("wrongCnt2 if > if_________" + wrongCnt);
            wrongCnt = parseInt(wrongCnt) + 1;
            console.log("wrongCnt3 if > if _________" + wrongCnt);
            localStorage.setItem("wrongCnt", wrongCnt);
            if (wrongCnt < 3) { //오답이 아직 3미만 일때 다시 되돌린다.
                console.log("wrongCnt4 if > if > if _________" + wrongCnt);
                callAjax(boardNo,wrongCnt);
                return false;
            }else{ //오답이 3이상일때 세션에 저장하고 1:1버튼을 지운다.
                console.log("wrongCnt5 if > if > else _________" + wrongCnt);
                //보드 번호와 숫자 3을 비동기통신으로 컨트롤러로 보낸다.
                callAjax(boardNo,wrongCnt);
                const toChatBtn = document.getElementById("toChatBtn");
                console.log(toChatBtn);
                //lostfix001 --
                toChatBtn.setAttribute("type", "button");
                toChatBtn.innerHTML = "1:1 대화 불가";
                // --
                let backBtn = document.createElement('button');
                backBtn.setAttribute("type", "button");
                backBtn.setAttribute("onclick", "history.back()");
                backBtn.innerHTML = "뒤로가기";
                let formq = document.getElementById('form_Q');
                formq.appendChild(backBtn);
                return false;
            }


        //(2). 정답을 눌렀을 경우 누적페널티를 세션에서 삭제하고 1:1 체팅으로 연결된다.
        }else{
            callAjax(boardNo,wrongCnt=0);
            return true;
        }

    //BLOCK 4. 누적페널티가 3 이상인경우   
    }else{
        console.log("엘스실행");
        callAjax(boardNo,wrongCnt);
        return false;
    }
}

function callAjax(param1, param2){

    var reqJson = new Object(); //제이슨 유사한 객체생성
        reqJson.param1 = param1; //받아온 아이디 제이슨 타입으로 저장
        reqJson.param2 = param2;

    var httpRequest = new XMLHttpRequest(); // 비동기통신 객체생성
        httpRequest.onreadystatechange = function() {
            if (httpRequest.readyState === XMLHttpRequest.DONE) {
                if (httpRequest.status === 200){
                    var jsonFromController = httpRequest.response;
                    if (jsonFromController.res == "correct"){
                        window.alert("정답을 입니다. 1:1채팅으로 이동합니다.");
                    }else if (jsonFromController.res == "wrong"){
                        window.alert("오답을 선택하셨군요. 다시선택하여 주십시오.");
                    }else{
                        window.alert("이런 사기꾼 색기!");
                    }            
                }
            }
        };
        httpRequest.open('POST', '/user/penalty/ajaxcall', true); //비동기통신 콜
        httpRequest.responseType = "json"; //응답 타입 설정 마찬가지로 제이슨
        httpRequest.setRequestHeader('Content-Type', 'application/json'); // 요청 헤더에 컨텐츠 타입 제이슨 정의
        httpRequest.send(JSON.stringify(reqJson)); //요청시 제이슨 데이터를 넣어서 전송

}
