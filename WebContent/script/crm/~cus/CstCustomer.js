function search(searchForm){
	$("form[name='"+searchForm+"']").submit();
}


// 给查询条件赋值
function setConditionValue() {
	var queryCustNo = $("input[name='cstCustomerQueryDTO.custNo']").val();
	var queryCustName = $("input[name='cstCustomerQueryDTO.custName']").val();
	var queryCustRegion = $("input[name='cstCustomerQueryDTO.custRegion']").val();
	var queryCustManagerName = $("input[name='cstCustomerQueryDTO.custManagerName']").val();
	var queryCustLevelLabel = $("input[name='cstCustomerQueryDTO.custLevelLabel']").val();
	
	$("#queryCustNo").val(queryCustNo);
	$("#queryCustName").val(queryCustName);
	$("#queryCustRegion").val(queryCustRegion);
	$("#queryCustManagerName").val(queryCustManagerName);
	$("#queryCustLevelLabel").val(queryCustLevelLabel);
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
//	if($(c_form).find("input[name='custName']").val().length<=0 || $(c_form).find("input[name='custName']").val().length>100)
//	{
//		alert("客户名称不能为空");
//		return false;
//	}
//	
//	if($(c_form).find("select[name='custRegion.id']").val().length<=0 )
//	{
//		alert("客户地区不能为空");
//		return false;
//	}
//	if($(c_form).find("select[name='custManager.id']").val().length<=0 )
//	{
//		alert("客户经理不能为空");
//		return false;
//	}
//	if($(c_form).find("select[name='custLevel.id']").val().length<=0)
//	{
//		alert("客户等级不能为空");
//		return false;
//	}
//	if($(c_form).find("select[name='custSatisfy']").val().length<=0)
//	{
//		alert("客户满意度不能为空");
//		return false;
//	}
//	if($(c_form).find("select[name='custCredit']").val().length<=0)
//	{
//		alert("客户信用不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custAddr']").val().length<=0)
//	{
//		alert("客户地址不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custZip']").val().length<=0 || $(c_form).find("input[name='custZip']").val().length>10)
//	{
//		alert("客户邮编不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custTel']").val().length<=0 || $(c_form).find("input[name='custTel']").val().length>50)
//	{
//		alert("客户电话不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custFax']").val().length<=0 || $(c_form).find("input[name='custFax']").val().length>50)
//	{
//		alert("客户传真不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custWebsite']").val().length<=0)
//	{
//		alert("客户网址不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custChieftain']").val().length<=0)
//	{
//		alert("客户法人不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custBank']").val().length<=0)
//	{
//		alert("客户银行不能为空");
//		return false;
//	}
//	if($(c_form).find("input[name='custBankAccount']").val().length<=0)
//	{
//		alert("客户账号不能为空");
//		return false;
//	}
//	
//	var reg = /^\d+$/;
//	if($(c_form).find("input[name='custBankroll']").val()!="" && !$(c_form).find("input[name='custBankroll']").val().match(reg))
//	{
//		alert("注册资金只能是数字");
//		return false;
//	}
//	if($(c_form).find("input[name='custTurnover']").val()!="" && !$(c_form).find("input[name='custTurnover']").val().match(reg))
//	{
//		alert("年营业额只能是数字");
//		return false;
//	}
    
	$(c_form).submit();
	
}

function del(name, url){
	var flag = window.confirm("您确定要删除:" + name + "吗?");
	if(flag == true){
		window.location.href=url;
	}
	
}



