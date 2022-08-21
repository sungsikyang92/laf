state = 0;
function changeImage(){
    
    if(state ==0){
        state = 1;
        document.getElementById('img1').src = "resources/img/woo.png";
    }
    else{
        state = 0;
        document.getElementById('img1').src = "resources/img/profile/img";
    }
}