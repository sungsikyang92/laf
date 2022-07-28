function getId(id) {
    return document.getElementById();
}

let data = {};
let ws;
let mid = getId('mid');
let btnLogin = getId('btnLogin');
let btnSend = getId('btnSend');
let talk = getId('talk');
let msg = getId('msg');

btnLogin.onclick = function () {
    ws = new WebSocket("ws://" + location.host + "/chat");

    ws.onmessage = function (msg) {
        let data = JSON.parse(msg.data);
        let css;

        if (data.mid == mid.value) {
            css = 'class=me';
        } else {
            css = 'class=other';
        }

        let item = '<div ${css} > ' +
            '<span><b>${data.mid}</b></span> ' +
            '[${data.date}] <br/> ' +
            '<span>${data.msg}</span> ' +
            '</div>';

        talk.innerHTML += item;
        talk.scrollTop = talk.scrollHeight;
    };
};

msg.onkeyup = function (ev) {
    if (ev.keyCode == 13) {
        send();
    }
};

btnSend.onclick = function () {
    send();
};

function send() {
    if (msg.value.trim() != '') {
        data.mid = getId('mid').value;
        data.msg = msg.value;
        data.date = new Date().toLocaleString();
        let temp = JSON.stringify(data);
        we.send(temp);
    }
    msg.value = '';
}