<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title>毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<meta http-equiv="Pragma" content="no-cache"></meta>
<meta http-equiv="Cache-Control" content="no-cache"></meta>
<meta http-equiv="Expires" content="0"></meta>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css"></link>
<link href="<%=path %>/script/jquery/css/tree.css" rel="stylesheet" type="text/css" />

<script src="<%=path %>/script/jquery/src/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/script/jquery/src/Plugins/jquery.tree.js"></script>
<script src="<%=path %>/script/crm/~sys/SysRight.js" type="text/javascript" ></script>

</head>
<body>
<div class="page_title">当前位置:权限管理 >> 角色管理 >> 查看角色</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table" border="0" cellpadding="3" cellspacing="0">
	<tr>
		<th class="input_title">
			角色名
		</th>
		<td class="input_content">
			${requestScope.roleDto.roleName }
		</td>
		<th class="input_title">
			角色描述
		</th>
		<td class="input_content">
			${requestScope.roleDto.roleDesc}
		</td>
	</tr>
	<tr>
		<th class="input_title">
			权限
		</th>
		<td class="input_content">
			<div id="tree"></div>
		</td>
		<th class="input_title">
			状态
		</th>
		<td class="input_content">
			${requestScope.roleDto.roleFlag == 1 ? "正常" : "已删除"}
		</td>
	</tr>
</table>
<input type="hidden" id="roleId" name="sysRoleDTO.id" value="${requestScope.roleDto.id }"/>
</body>
</html>