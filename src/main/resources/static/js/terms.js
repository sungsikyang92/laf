

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

function cfmReg()  {
    
    if (console.log(document.getElementsByName('chk').length) ==
    console.log(document.querySelectorAll('input[name="chk"]:checked'))) {

      location.href='/user/signUpFrom'

    }



}




