var reg = /^(?:[\u4e00-\u9fa5]*\w*\s*)+$/;


// �û���
function checkUserName() {
	var user = $("input[name=sysUserQueryDTO.usrName]");

	if (user.val() == "") {
		alert("用户名不能为空!");
		user.focus();
		user.select();
		return false;
	} else if (!reg.test(user.val())) {
		alert("用户名不能有特殊字符！");
		user.focus();
		user.select();
		return false;
	}
	return true;
}

/*
 * ������֤
 */
function checkPwd() {
	var password = $("input[name=sysUserQueryDTO.usrPassword]");
	if (password.val() == "") {
		alert("密码不能为空!");
		password.focus();
		password.select();
		return false;
	} else if (!reg.test(password.val())) {
		alert("密码不能有特殊字符！");
		password.focus();
		password.select();
		return false;
	}
	return true;
}

function check() {
	if (checkUserName() && checkPwd()) {
		document.forms[0].submit();
	} 
}

$(document).ready(function() {
	$("input[name=sysUserQueryDTO.usrName]").focus();
});


function checkForm() {
    var userName = document.getElementById("username");
    var passWord = document.getElementById("password");

    if (userName.value == "" || userName.value == "用户名/绑定的手机号/邮箱") {
        alert("请输入用户名！");
        userName.focus();
        return false;
    }
    if (passWord.value == "") {
        alert("请输入密码！");
        passWord.focus();
        return false;
    }
}
function UserNameOnblur(obj) {
    if (obj.value == "") {
        obj.value = "用户名/绑定的手机号/邮箱";
        obj.className = "user_name";
    }

}
function UserNameOnfocus(obj) {
    if (obj.value == "用户名/绑定的手机号/邮箱") {
        obj.value = "";
        obj.className = "user_name_input";
    }
}