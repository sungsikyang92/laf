function readMultipleImage(input) {
    const multipleContainer = document.getElementById("multiple-container")

    // 인풋 태그에 파일들이 있는 경우
    if (input.files) {
        // 이미지 파일 검사 (생략)
        console.log(input.files)
        // 유사배열을 배열로 변환 (forEach문으로 처리하기 위해)
        const fileArr = Array.from(input.files)
        const $colDiv1 = document.createElement("div")
        const $colDiv2 = document.createElement("div")
        $colDiv1.classList.add("column")
        $colDiv2.classList.add("column")
        fileArr.forEach((file, index) => {
            const reader = new FileReader()
            const $imgDiv = document.createElement("div")
            const $img = document.createElement("img")
            $img.classList.add("image")
            const $label = document.createElement("label")
            $label.classList.add("image-label")
            $label.textContent = file.name
            $imgDiv.appendChild($img)
            $imgDiv.appendChild($label)
            reader.onload = e => {
                $img.src = e.target.result

                $imgDiv.style.width = ($img.naturalWidth) * 0.2 + "px"
                $imgDiv.style.height = ($img.naturalHeight) * 0.2 + "px"
            }

            console.log(file.name)
            if (index % 2 == 0) {
                $colDiv1.appendChild($imgDiv)
            } else {
                $colDiv2.appendChild($imgDiv)
            }

            reader.readAsDataURL(file)
        })
        multipleContainer.appendChild($colDiv1)
        multipleContainer.appendChild($colDiv2)
    }
}
const inputMultipleImage = document.getElementById("input-multiple-image")
inputMultipleImage.addEventListener("change", e => {
    readMultipleImage(e.target)
})