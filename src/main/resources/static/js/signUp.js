var x = function(){
    if (policyOn == "on"){
        return false
    }else{
        alert("약관에 동의 하셔야 합니다")
        return location.href="/user/login"
    }
};
x();

// window.onload = function(){
//     console.log(policyOn);  
// }
