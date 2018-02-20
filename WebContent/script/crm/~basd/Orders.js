

// 给查询条件赋值
function setConditionValue() {
	$("#queryOdrCustomer").val($("input[name='ordersQueryDTO.odrCustomer']").val());
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


