function login() {
	if (checkusername() && checkpassword()) {
		loginform.submit();		
	}
}
function removemsg() {
	a=new Object();
	a=document.getElementById("login_msg");
	a.style.visibility="hidden";  
}
function checkusername(){
	//用户名长度只能为4-10
	var username = loginform.username.value;
	a=new Object();
	a=document.getElementById("username");
	if (username == "" || username.length == 0) {
		a.innerText="请输入用户名";
		a.style.visibility="visible"; 
		return false;
	} else if (username.length < 4 || username.length > 10) {
		a.innerText="用户名长度只能为4到10位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden"; 
		return true;
	}
}
function checkpassword() {
	//密码只能为4到10位
	var password = loginform.password.value; 
	b=new Object();
	b=document.getElementById("password");
	if (password == "" || password.length == 0) {
		b.innerText="请输入密码";
		b.style.visibility="visible"; 
		return false;
	} else if (password.length < 4 || password.length > 10) {
		b.innerText="密码只能为4到10位";
		b.style.visibility="visible"; 
		return false;
	}else {
		b.style.visibility="hidden"; 
		return true;
	}
}