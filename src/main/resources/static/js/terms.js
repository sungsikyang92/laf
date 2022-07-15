

    //여기에 동건님 JS 넣기

//약관동의 하나라도 select 안되면 전체선택 헤제
function checkSelectAll()  {

  console.log("checkSelectAll 실행");
  // 전체 체크박스
  var checkboxes = document.querySelectorAll('input[name="chk"]');
  console.log(checkboxes);

  // 선택된 체크박스
  var checked  = document.querySelectorAll('input[name="chk"]:checked');
  console.log(checked);
  
  // select all 체크박스
  var selectAll  = document.querySelector('input[name="selectall"]');
  
  if(checkboxes.length === checked.length)  {
    selectAll.checked = true;
  }else {
    selectAll.checked = false;
  }

}


 //약관동의 전체선택 JS
 function selectAll(selectAll)  {
    var checkboxs = document.querySelectorAll('input[type="checkbox"]');
    
    console.log("select all 실행");

    checkboxs.forEach((checkbox) => {
        checkbox.checked = selectAll.checked
    })
}

//이용약관 확인 버튼 눌르면 실행되는 펑션 
function cfmReg()  {
    
    if (document.getElementsByName('chk').length == 
        document.querySelectorAll('input[name="chk"]:checked').length) {

        console.log(document.getElementById("allchked"))
        document.getElementById("allchked").submit();
          
        
       return false;
       //return "/user/signUpForm";
       //폼에서 액션에 리턴페이지 입력하지않고 리턴으로 입력하면 서브밋한데이터가 서버로 넘어가지 않는다.

    }else{
      window.alert("필수 이용약관에 동의하여 주십시오")
      return false;
    }



}




