//进行表单提交
function search(formName) {
	$("form[name=" + formName + "]").submit();
}

// 给查询条件赋值
function setConditionValue() {
	var queryRoleName = $("input[name='sysRoleQueryDTO.roleName']").val();
	var queryRoleFlag = $("select[name='sysRoleQueryDTO.roleFlag']").val();
	$("#queryRoleName").val(queryRoleName);
	$("#queryRoleFlag").val(queryRoleFlag);
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

// 更新角色
function modifyRole() {
	var s = $("#tree").getCheckedNodes();
	// 99,102
	for ( var i = 0; i < s.length; i++) {
		$("form[name='sysRoleModifyForm']").append(
				"<input type='hidden' name='sysRoleDTO.sysRights' value='"
						+ s[i] + "'/>");
	}
	$("form[name='sysRoleModifyForm']").submit();
}

// 删除角色
function delRole(roleName, roleId) {
	var flag = window.confirm("您确定要删除:" + roleName + "吗?")
	if (flag == true) {
		window.location.href = "/crm/sys/deleteRoleAction.action?sysRoleDTO.id="
				+ roleId;
	}
}

// 添加角色
function addRole() {
	var s = $("#tree").getCheckedNodes();
	for ( var i = 0; i < s.length; i++) {
		$("form[name='sysRoleAddForm']").append(
				"<input type='hidden' name='sysRoleDTO.sysRights' value='"
						+ s[i] + "'/>");
	}
	$("form[name='sysRoleAddForm']").submit();
}
