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
                img.setAttribute("src", event.target.result);
                img.setAttribute("width", "200px");
                img.setAttribute("height", "125px");
                img.setAttribute("name", "selectImg");
                document.querySelector("div#image_container").appendChild(img);
            };

            console.log(image);
            reader.readAsDataURL(image);
        }
    } else {
        document.getElementById("image").value = null;
        alert("이미지는 5개까지 등록 가능합니다.");
    }
}
