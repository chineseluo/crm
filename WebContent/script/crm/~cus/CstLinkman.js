function search(searchForm){
	$("form[name='"+searchForm+"']").submit();
}

// 给查询条件赋值
function setConditionValue() {
	$("#queryLkmName").val($("input[name='cstLinkmanQueryDTO.lkmName']").val());
	$("#queryLkmCustomerId").val($("input[name='cstLinkmanQueryDTO.lkmCustomerId']").val());
}

// 分页按钮的控制
function setPage(currentPage, formName) {
	setConditionValue();
	$("#queryCurrentPage").val(currentPage);
	$("form[name=" + formName + "]").submit();
}

// 设置自定义导航页数
function setNavigatePage(pageNum) {
	setConditionValue();
	$("#queryCurrentPage").val(pageNum);
}


function formCheck(customerForm){
	var c_form=$("form[name='"+customerForm+"']:first");
//	if($(c_form).find("input[name='lkmName']").val().length<=0 || $(c_form).find("input[name='lkmName']").val().length>50)
//	{
//		alert("联系人姓名不能为空");
//		return false;
//	}
//	
//	if($(c_form).find("input[name='lkmPostion']").val().length<=0 || $(c_form).find("input[name='lkmPostion']").val().length>50)
//	{
//		alert("联系人职位不能为空");
//		return false;
//	}
//	
//	if($(c_form).find("input[name='lkmTel']").val().length<=0 || $(c_form).find("input[name='lkmTel']").val().length>50)
//	{
//		alert("联系人电话不能为空");
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


