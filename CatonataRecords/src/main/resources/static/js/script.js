/*パスワードの表示非表示*/
function pushHideButton() {
	var txtPass = document.getElementById("pass1");
	var btnEye = document.getElementById("buttonEye");
	if (txtPass.type === "text") {
		txtPass.type = "password";
		btnEye.className = "fa fa-eye";
	} else {
		txtPass.type = "text";
		btnEye.className = "fa fa-eye-slash";
	}
}


  //HTMLのid値を使って以下のDOM要素を取得
function cntdown () {
    const text = document.getElementById('textbox');
    if(text.value >= 2) {
    text.value--;
  	}
  }

function cntup () {
    const text = document.getElementById('textbox');
  	if(text.value <= 9){
    text.value++;
    	}
	}