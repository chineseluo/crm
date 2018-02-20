function search(searchForm){
	$("form[name='"+searchForm+"']").submit();
}

// 给查询条件赋值
function setConditionValue() {
	$("#queryLstCustName").val($("input[name='cstLostQueryDTO.lstCustName']:first").val());
	$("#queryLstCustManagerName").val($("input[name='cstLostQueryDTO.lstCustManagerName']:first").val());
	$("#queryLstStatus").val($("input[name='cstLostQueryDTO.lstStatus']:first").val());
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


function formCheck(editForm,areaName){
	var c_form=$("form[name='"+editForm+"']:first");
//	if($(c_form).find("textarea:first").val().length<=0 || $(c_form).find("textarea:first").val().length>1000)
//	{
//		alert(areaName+"不能为空");
//		return false;
//	}    
	$(c_form).submit();
	
}

