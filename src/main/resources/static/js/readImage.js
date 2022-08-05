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