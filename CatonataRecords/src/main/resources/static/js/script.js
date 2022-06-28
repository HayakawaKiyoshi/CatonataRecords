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

(() => {
  //HTMLのid値を使って以下のDOM要素を取得
  const downbutton = document.getElementById('down');
  const upbutton = document.getElementById('up');
  const text = document.getElementById('textbox');

  //ボタンが押されたらカウント減
  downbutton.addEventListener('click', (event) => {
  //1以下にはならないようにする
  if(text.value >= 2) {
    text.value--;
  }
  });

  //ボタンが押されたらカウント増
  upbutton.addEventListener('click', (event) => {
  //10以上にはならないようにする。
  	if(text.value <= 9){
    text.value++;
    }
  })
})();