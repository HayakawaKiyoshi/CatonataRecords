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