
function formCheck(customerForm){
	var c_form=$("form[name='"+customerForm+"']:first");
//	if($(c_form).find("input[name='atvDate']").val().length<=0)
//	{
//		alert("时间为空");
//		return false;
//	}
//	
//	if($(c_form).find("input[name='atvPlace']").val().length<=0 || $(c_form).find("input[name='atvPlace']").val().length>200)
//	{
//		alert("地址不能为空");
//		return false;
//	}
//	
//	if($(c_form).find("input[name='atvTitle']").val().length<=0 || $(c_form).find("input[name='atvTitle']").val().length>500)
//	{
//		alert("概要不能为空");
//		return false;
//	}
//	
    
	$(c_form).submit();
	
}

function del(name, url){
	var flag = window.confirm("您确定要删除:" + name + "吗?");
	if(flag == true){
		window.location.href=url;
	}
	
}


