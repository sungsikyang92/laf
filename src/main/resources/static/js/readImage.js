var file_number_sum = 0;
function setThumbnail(event) {
    let file_number = 0;
    let max_file_number = 5;
    var img_con_init = document.getElementById("image_container");

    for (let img of event.target.files) {
        file_number++; 
    }
    if (file_number + file_number_sum <= max_file_number) {
        for (let image of event.target.files) {
            let reader = new FileReader();
            reader.onload = function (event) {
                /*
                var img_con_init = document.getElementById("image_container");
                if (img_con_init = false) {
                    console.log(img_con_init);
                    //img_con_init.removeChild(img_con_init);
                }
                */
                let img = document.createElement("img");
                let button = document.createElement("input");
                img.setAttribute("src", event.target.result);
                img.setAttribute("width", "300px");
                img.setAttribute("height", "169px");
                img.setAttribute("name", "selectImg");
                document.querySelector("div#image_container").appendChild(img);
                button.setAttribute("type", "button");
                button.setAttribute("class", "imgDeleteBtn");
                button.setAttribute("value", "삭제");
                document.querySelector("div#image_container").appendChild(button);
            };
            
            console.log(image);
            reader.readAsDataURL(image);
            
        }
        file_number_sum = file_number_sum + file_number;
        
    } else {
        document.getElementById("pictureUpload").value = null;
        alert("이미지는 5개까지 등록 가능합니다.");
    }
    
    //objdect001 --
    if (file_number_sum == 1) {
        let pixObj = document.getElementById("pictureUpload").files[0];
        let pixForm = new FormData();
        pixForm.append('tempPix', pixObj);
        callAjaxForm(pixForm);
    
        //6. 제이슨으로 받아오던가 스트링으로 받아서 적절한 view를 JS로 뿌려준다 8/10일 해보기


    }
}
function resetFile() {
    document.getElementById("pictureUpload").value = null;
    var img_con_init = document.getElementById("image_container");
    
    while (img_con_init.hasChildNodes()) {
        img_con_init.removeChild(img_con_init.firstChild);
    }
    
    /*
    if (img_con_init = true) {
        var img_init = document.getElementsByName("selectImg");
        img_init.remove();
    }
    */
   //추가할것
}
// 삭제 하는 거 추가할껏

function callAjaxForm(param1){
    console.log("에이젝스실행");
    
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', 'picture/objDect');
    httpRequest.responseType = "json";
    httpRequest.send(param1);

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

}
