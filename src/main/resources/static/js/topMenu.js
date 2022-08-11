//window.onload하면 html문서를 읽고 js를 읽는다. 
window.onload =function(){
    console.log("연결완료");

    //html 클래스 노드 중 navbar_toggleBtn, menu(center), login(right) 에 연결
}


const toogleBtn = document.querySelector('.navbar_toggleBtn');
const menu = document.querySelector('.center_nav');
const login = document.querySelector('.right_nav');

//클릭될 때마다 이벤트 처리하기.
//addEventListner에서 클릭이 될 때마다 지정된 함수를 호출하라.
toogleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    login.classList.toggle('active');
});
