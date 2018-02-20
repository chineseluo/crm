//用户添加
function addUser(){
	$("form[name='sysUserAddForm']").submit();
}

//用户查询
function search(formName){
	$("form[name='"+formName+"']").submit();
}

// 给查询条件赋值
function setConditionValue() {
	var queryRoleName = $("input[name='sysUserQueryDTO.usrName']").val();
	var queryRoleFlag = $("select[name='sysUserQueryDTO.usrFlag']").val();
	$("#queryUsrName").val(queryRoleName);
	$("#queryUsrFlag").val(queryRoleFlag);
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
	//$("form[name=" + formName + "]").submit();
}

//用户更新
function modify(formName){
	$("form[name='"+formName+"']").submit();
}

//用户删除
function del(usrName, id){
	var flag = window.confirm("您确定要删除:" + usrName + "吗?");
	if(flag == true){
		window.location.href="/crm/sys/deleteUserAction.action?sysUserDTO.id="+id;
	}
	
}









