// 给查询条件赋值
function setConditionValue() {
	var prodName = $("input[name='productQueryDTO.prodName']").val();
	var prodType = $("input[name='productQueryDTO.prodType']").val();
	var prodBatch = $("input[name='productQueryDTO.prodBatch']").val();
	$("#prodName").val(prodName);
	$("#prodType").val(prodType);
	$("#prodBatch").val(prodBatch);

}

// 分页按钮的控制
function setPage(currentPage) {
	setConditionValue();
	$("#queryCurrentPage").val(currentPage);
	$("form[name='loadProductByPageForm']").submit();
}

// 设置自定义导航页数
function setNavigatePage(pageNum) {
	setConditionValue();
	$("#queryCurrentPage").val(pageNum);
}


//按多条件条件查询产品
function reloadProduct(){
	$("form[name='loadProductByConditionForm']").submit();
}

