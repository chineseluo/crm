// 给查询条件赋值
function setConditionValue() {
	var prodName = $("input[name='productQueryDTO.prodName']").val();
	var stkWarehouse = $("input[name='productQueryDTO.stkWarehouse']").val();
	$("#prodName").val(prodName);
	$("#stkWarehouse").val(stkWarehouse);

}

// 分页按钮的控制
function setPage(currentPage) {
	setConditionValue();
	$("#queryCurrentPage").val(currentPage);
	$("form[name='loadProductAndStorageByPageForm']").submit();
}

// 设置自定义导航页数
function setNavigatePage(pageNum) {
	setConditionValue();
	$("#queryCurrentPage").val(pageNum);
}


//按多条件条件查询产品库存
function reloadProductAndStorage(){
	$("form[name='loadProductAndStorageByConditionForm']").submit();
}

