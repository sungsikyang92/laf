window.onload = function () {

    sessionStorage.setItem("wrongCountJson", JSON.stringify([{name: '', value: ''}]));
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
        button.innerHTML = "1:1대화";
        formq.appendChild(button);
        let updateButton = document.createElement('button');
        updateButton.setAttribute("type", "button")
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


}

wrongCount = 0;

function lostSubmitBtn(){
    console.log("JS funtion call _________ lostSubmitBtn")

    if (document.querySelector('input:checked').value != answer){ //오답
        var wrongCntObj = JSON.parse(sessionStorage.getItem("wrongCountJson"));
        
        wrongCount = wrongCount + 1;
        var wrongCntCurObj = {name: boardNo, value: wrongCount}
        wrongCntObj = wrongCntObj.push(wrongCntCurObj);
        
        console.log(wrongCntObj);

        console.log(Object.keys(wrongCntObj));
        console.log(Object.values(wrongCntObj));

        // wrongCount = wrongCount + 1;
        // var odab = [boardNo = {name: "count", value: wrongCount}];
        // console.log(typeof(odab));
        // console.log(Object.keys(odab));
        // console.log(Object.values(odab));
        // console.log("오답 실행");
        


        return false;
    }else{ //정답
        console.log("else 실행")
        return ture;
    }
}

