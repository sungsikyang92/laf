var file_number_sum = 0;
function setThumbnail(event) {
    //lostfix002--
    resetFile(1);
    //--
    var img_con_init = document.getElementById("image_container");
    while (img_con_init.hasChildNodes()) {
        img_con_init.removeChild(img_con_init.firstChild);
    }
    
    
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

                // var img_con_init = document.getElementById("image_container");
                // if (img_con_init = false) {
                //     console.log(img_con_init);
                //     img_con_init.removeChild(img_con_init);
                // }

                let img = document.createElement("img");
                let button = document.createElement("input");
                img.setAttribute("src", event.target.result);
                img.setAttribute("width", "300px");
                img.setAttribute("height", "169px");
                img.setAttribute("name", "selectImg");
                // lostfix002--
                img.setAttribute("id", "F00"+image.lastModified);
                // --
                document.querySelector("div#image_container").appendChild(img);
                button.setAttribute("type", "button");
                button.setAttribute("class", "imgDeleteBtn");
                button.setAttribute("value", "삭제");
                // lostfix002--
                button.setAttribute("id", "B00"+image.lastModified);
                button.setAttribute("onclick", "removePic("+image.lastModified+");");
                if (document.location.href == "http://localhost:8787/write"){
                    button.setAttribute("disabled", "disabled");
                }
                // --
               document.querySelector("div#image_container").appendChild(button);
            };
            
            console.log(image);
            reader.readAsDataURL(image);
            
        }
        file_number_sum = file_number_sum + file_number;
        
    } else {
        document.getElementById("pictureUpload").value = null;
        alert("이미지는 5개까지 등록 가능합니다. 파일을 다시올려 주십시오");
        event.stopImmediatePropagation();
        return false;
    }
    
    //lostfix002--
    if (document.location.href == "http://localhost:8787/write" && file_number_sum < 6) {
        let r = Math.floor(Math.random() * file_number_sum);
        let pixObj = document.getElementById("pictureUpload").files[r];
        let pixForm = new FormData();
        pixForm.append('tempPix', pixObj);
        if (pixObj != null){
            callAjaxForm(pixForm);
        }
    }
    
    var newfiles = Array.from(document.getElementById('pictureUpload').files);
    console.log(newfiles)
    
    //--
    
}
function resetFile(param) {
    if (document.location.href == "http://localhost:8787/write"){

        if (param == 2){
            document.getElementById("pictureUpload").value = null;
            var img_con_init = document.getElementById("image_container");
            while (img_con_init.hasChildNodes()) {
                img_con_init.removeChild(img_con_init.firstChild);
            }
        }; 
    
        //lostfix002--
        var resTags = document.getElementById("objResContainer");
        while(resTags.hasChildNodes()){
            resTags.removeChild(resTags.firstChild);
        }
    
        document.getElementsByName("question")[0].setAttribute("value","");
        document.getElementsByName("answers")[0].setAttribute("value","");
        document.getElementsByName("answers1")[0].setAttribute("value","");
        document.getElementsByName("answers2")[0].setAttribute("value","");
        document.getElementsByName("answers3")[0].setAttribute("value","");
        document.getElementsByName("answers4")[0].setAttribute("value","");
        
        var objTags = document.getElementById("quesQuery");
        objTags.firstChild.selected = true;
        if (document.getElementById("objOptionBox") != null){
            document.getElementById("objOptionBox").remove();
        }
    
        document.getElementById("category").setAttribute("value", "")
    
    
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
}

// 삭제 하는 거 추가할껏
function removePic(param){
    document.getElementById("F00"+param).remove();
    document.getElementById("B00"+param).remove();
    file_number_sum--;


    console.log("param to delete: "+ param);
    var dataTranster = new DataTransfer();
    var files = document.querySelector('#pictureUpload').files;
    var fileArray = Array.from(files);
    i = 0;
    for (var image of fileArray){
        console.log(image.lastModified);
        if(image.lastModified == param){
            break;
        }
        i++
    }
    console.log("아이는" + i);
    fileArray.splice(i, 1);
    fileArray.forEach(function(file){
        dataTranster.items.add(file);
    });
    document.getElementById('pictureUpload').files = dataTranster.files;
    
    var newfiles = Array.from(document.getElementById('pictureUpload').files);
    console.log(newfiles)


    // Array.from(files)
    //     .filter(file => file.lastModified != removeTargetId)
    //     .forEach(file => {
    //         dataTranster.items.add(file);
    //     });
    
    // document.querySelector('#file-input').files = dataTranster.files;
    // removeTarget.remove();

    console.log(file_number_sum);
}



function callAjaxForm(param1){
    console.log("에이젝스실행");
    
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', 'picture/objDect', true);
    httpRequest.responseType = "json";
    httpRequest.send(param1);
    document.getElementById("loadingContainer").style = "display:block"
    
    //lostfix002 --
    document.getElementById("pictureUpload").disabled = true;
    document.getElementById("fileResetBtn").disabled = true;
    // --

    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState === XMLHttpRequest.DONE){    
            document.getElementById("loadingContainer").style = "display:none"

            //lostfix002 --
            document.getElementById("pictureUpload").disabled = false;
            document.getElementById("fileResetBtn").disabled = false;
            console.log(document.querySelectorAll(".imgDeleteBtn"));
            document.querySelectorAll(".imgDeleteBtn").forEach(function(e){
                e.disabled=false;
            });
            // --

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
                tag.innerHTML = "사물을 정상적으로 인식하였습니다. 인식된 사물 ( " + objRes.papagoName.slice(0,i) +" )";
                tag.id = 'objResult';
                tag.style.fontSize = "10px"
                tag.style.color = "blue";
                document.querySelector("div#objResContainer").appendChild(tag);
                document.getElementById("category").setAttribute("value", objRes.papagoName[0])
                autoQ(objRes.predictions[0].detection_names[0], objRes.papagoName[0]);


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

function autoQ(stuff, stuffKor){
    var option = document.createElement("option");
    option.innerHTML = "사물인식 결과 적용";
    option.setAttribute("id", "objOptionBox");
    option.selected = true;
    document.getElementById('quesQuery').appendChild(option);
    if (stuff == "scissors"){
        document.getElementsByName("question")[0].setAttribute("value",stuffKor + "의 원산지는 어디입니까?");
        document.getElementsByName("answers")[0].setAttribute("value","중국");
        document.getElementsByName("answers1")[0].setAttribute("value","미국");
        document.getElementsByName("answers2")[0].setAttribute("value","한국");
        document.getElementsByName("answers3")[0].setAttribute("value","홍콩");
        document.getElementsByName("answers4")[0].setAttribute("value","우간다");
    }else if (stuff == "mobile" || stuff == "cell phone"){
        document.getElementsByName("question")[0].setAttribute("value",stuffKor + "의 배경화면은 무었입니까?");
        document.getElementsByName("answers")[0].setAttribute("value","기본바탕화면");
        document.getElementsByName("answers1")[0].setAttribute("value","색상");
        document.getElementsByName("answers2")[0].setAttribute("value","케릭터");
        document.getElementsByName("answers3")[0].setAttribute("value","인물사진");
        document.getElementsByName("answers4")[0].setAttribute("value","배경사진");
    }else if (stuff == "mouse") {
        document.getElementsByName("question")[0].setAttribute("value",stuffKor + "의 바닥은 어떤색입니까?");
        document.getElementsByName("answers")[0].setAttribute("value","검은색");
        document.getElementsByName("answers1")[0].setAttribute("value","흰색");
        document.getElementsByName("answers2")[0].setAttribute("value","핑크색");
        document.getElementsByName("answers3")[0].setAttribute("value","노란색");
        document.getElementsByName("answers4")[0].setAttribute("value","하얀색");
    }else if (stuff == "clock") {
        document.getElementsByName("question")[0].setAttribute("value",stuffKor + "의 바닥은 어떤색입니까?");
        document.getElementsByName("answers")[0].setAttribute("value","은색");
        document.getElementsByName("answers1")[0].setAttribute("value","검은색");
        document.getElementsByName("answers2")[0].setAttribute("value","갈색");
        document.getElementsByName("answers3")[0].setAttribute("value","회색");
        document.getElementsByName("answers4")[0].setAttribute("value","초록색");
    }else if (stuff == "keyboard") {
        document.getElementsByName("question")[0].setAttribute("value",stuffKor + "의 고무는 몇개입니까");
        document.getElementsByName("answers")[0].setAttribute("value","6개");
        document.getElementsByName("answers1")[0].setAttribute("value","4개");
        document.getElementsByName("answers2")[0].setAttribute("value","3개");
        document.getElementsByName("answers3")[0].setAttribute("value","2개");
        document.getElementsByName("answers4")[0].setAttribute("value","1개");
    }else{
    }

}
