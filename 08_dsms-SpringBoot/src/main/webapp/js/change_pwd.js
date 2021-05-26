function changepwd() {
	if (checkpassword() && checkpAgainPwd()) {
		changepwd_form.submit();		
	}
}

function removemsg() {
	a=new Object();
	a=document.getElementById("changePwd_msg");
	a.style.visibility="hidden";   
}

function checkpassword() {
	password = changepwd_form.password.value; 
	a=new Object();
	a=document.getElementById("password");
	if (password == "") {
		a.innerText="请输新入密码";
		a.style.visibility="visible"; 
		return false;
	} else if (password.length < 4 || password.length > 10) {
		a.innerText="密码只能为4到10位";
		a.style.visibility="visible"; 
		return false;
	}else {
		a.style.visibility="hidden";
		return true;
	}
}

function checkpAgainPwd() {
	againPwd = changepwd_form.againPwd.value; 
	b=new Object();
	b=document.getElementById("againPwd");
	if (againPwd == "") {
		b.innerText="请再次输入新密码";
		b.style.visibility="visible"; 
		return false;
	} else if (againPwd.length < 4 || againPwd.length > 10) {
		b.innerText="密码只能为4到10位";
		b.style.visibility="visible"; 
		return false;
	}else {
		b.style.visibility="hidden"; 
		return true;
	}
}