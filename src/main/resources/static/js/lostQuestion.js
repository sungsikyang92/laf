window.onload = function () {

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
        button.setAttribute("type", "submit")
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

