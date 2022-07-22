function setThumbnail(event) {
    let file_number = 0;
    let max_file_number = 5;


    for (let img of event.target.files) {
        file_number++;
    }


    if (file_number <= max_file_number) {
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
                button.setAttribute("value", "삭제")
                document.querySelector("div#image_container").appendChild(button);
            };

            console.log(image);
            reader.readAsDataURL(image);
        }
    } else {
        document.getElementById("pictureUpload").value = null;
        alert("이미지는 5개까지 등록 가능합니다.");
    }
}
