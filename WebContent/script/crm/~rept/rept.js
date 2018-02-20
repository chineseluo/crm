
function findInstantCust(){
	$("form[name='loadByConditionForm']").submit();
}
function findAllCustCons(){
	$("form[name='loadAllCustConsForm']").submit();
}

//给查询条件赋值
function setConditionValue() {
	$("#queryLstCustName").val($("input[name='cstLostQueryDTO.lstCustName']:first").val());
	$("#queryLstCustManagerName").val($("input[name='cstLostQueryDTO.lstCustManagerName']:first").val());
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



