

    //여기에 동건님 JS 넣기



 //약관동의 전체선택 JS
 function selectAll(selectAll)  {
    var checkboxs 
    = document.querySelectorAll('input[type="checkbox"]');
    
    checkboxs.forEach((checkbox) => {
        checkbox.checked = selectAll.checked
    })
}

 //약관동의 하나라도 select 안되면 전체선택 헤제
function checkSelectAll(checkbox)  {
    var selectall = document.querySelector('input[name="selectall"]');
    var selectlength = document.querySelector('input[name="chk"]').length;
    console.log(document.getElementsByName('chk'));
    
    if(checkbox.checked === false)  {
      selectall.checked = false;
    }
  }

function cfmReg()  {
    
    console.log(document.getElementByName('chk'));



}




