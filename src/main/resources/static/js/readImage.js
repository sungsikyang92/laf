let file_number_sum = 0;
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
                let img = document.createElement("img");
                img.setAttribute("src", event.target.result);
                img.setAttribute("width", "200px");
                img.setAttribute("height", "125px");
                img.setAttribute("name", "selectImg");
                document.querySelector("div#image_container").appendChild(img);
            };
            console.log(image);
            reader.readAsDataURL(image);
        }
        file_number_sum = file_number_sum + file_number;

    } else {
        alert("이미지는 5개까지 등록 가능합니다.");
    }
    /*
        else if (file_number_sum < max_file_number) {
            console.log(event.target.files);
            while (img_con_init.hasChildNodes()) {
                img_con_init.removeChild(img_con_init.firstChild);
            }
            console.log("file_number4 : " + file_number);
            console.log("file_number_sum4 : " + file_number_sum);
            console.log(event.target.files);
            file_number_sum = 0;
        }
        */
}
function resetFile() {
    let img_con_init = document.getElementById("image_container");
    while (img_con_init.hasChildNodes()) {
        img_con_init.removeChild(img_con_init.firstChild);
    }
}