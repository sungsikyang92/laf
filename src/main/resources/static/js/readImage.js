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
        if (pixObj != null){
            callAjaxForm(pixForm);
        }
    }
}
function resetFile() {
    document.getElementById("pictureUpload").value = null;
    var img_con_init = document.getElementById("image_container");
    
    while (img_con_init.hasChildNodes()) {
        img_con_init.removeChild(img_con_init.firstChild);
    }

    //objdect001 --
    var resTags = document.getElementById("objResContainer");
    while(resTags.hasChildNodes()){
        resTags.removeChild(resTags.firstChild);
    }

    file_number_sum = 0;
    //--
    
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
    httpRequest.open('POST', 'picture/objDect', true);
    httpRequest.responseType = "json";
    httpRequest.send(param1);
    document.getElementById("loadingContainer").style = "display:block"

    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState === XMLHttpRequest.DONE){    
            document.getElementById("loadingContainer").style = "display:none"

            
            if(httpRequest.status === 200) {
            var objRes = httpRequest.response;
            var objCnt = objRes.predictions[0].num_detections[0];
            
            var i = 0;
            for (let score of objRes.predictions[0].detection_scores){
                console.log(score);
                if (score >= 0.85){
                    i ++
                }
            }
            var filteredObjCnt = i;
            if (filteredObjCnt == 0) {
                //인식된 사물이 없을때
                let tag = document.createElement("p");
                tag.innerHTML = "인식된 사물이 없습니다. 올린파일 초기화 버튼을 누른후 다른 사진을 올려주시던가 카테고리를 직접 입력하여 주십시오.";
                tag.id = 'objResult';
                tag.style.fontSize = "10px"
                tag.style.color = "red";
                document.querySelector("div#objResContainer").appendChild(tag);
                document.getElementById("category").removeAttribute("readonly")
                document.getElementById("category").setAttribute("placeholder", "직접 입력하여 주십시오")
            }else{
                //인식된 사물이 있을때 (상관없이 최대 값으로한다.)
                let tag = document.createElement("p");
                tag.innerHTML = "사물을 정상적으로 인식하였습니다. 인식된 사물 ( " + objRes.predictions[0].detection_names.slice(0,i) +" )";
                tag.id = 'objResult';
                tag.style.fontSize = "10px"
                tag.style.color = "blue";
                document.querySelector("div#objResContainer").appendChild(tag);
                document.getElementById("category").setAttribute("value", objRes.predictions[0].detection_names[0])
            }
            console.log("filteredObjCnt ___ " + filteredObjCnt)

            var scoreArr = objRes.predictions[0].detection_scores;
            var maxScore = Math.max.apply(null, objRes.predictions[0].detection_scores);
            var maxIdx = scoreArr.indexOf(maxScore);

            console.log(maxIdx);

            console.log(objRes.predictions[0]);
            console.log(objRes.predictions[0].detection_names[0]);
            console.log(objRes.predictions[0].detection_scores);

            console.log(Math.max.apply(null, objRes.predictions[0].detection_scores));


            }else{
            alert("사물인식에 실패 하였습니다. 올린파일 초기화 버튼을 누르고 다시 시작하여 주세요");
        }
        }
    };
}
