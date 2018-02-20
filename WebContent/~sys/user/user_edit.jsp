<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script src="<%=path%>/script/crm/~sys/SysUser.js"></script>
</head>
<body>

<div class="page_map">当前位置:权限管理 >> 用户管理 >> 编辑用户</div>

<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="modify('sysUserModifyForm');">保存</button>  
</div>
<form name="sysUserModifyForm" action="<%=path%>/sys/modifyUserAction.action" method="post">
<table class="query_form_table">
	<tr>
		<th>用户名</th>
		<td><input name="sysUserDTO.usrName" value="${requestScope.userDTO.usrName }"/><span class="red_star">*</span></td>
		<th>密码</th>
		<td>
			<input name="sysUserDTO.usrPassword" size="20" type="password"  value="${requestScope.userDTO.usrPassword }"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>角色</th>
		<td>
			<select name="sysUserDTO.sysRole.id">
					<c:forEach items="${requestScope.roleDtoList }" var="roleDTO">	
						<option ${roleDTO.id == requestScope.userDTO.sysRole.id ? "selected=selected" : "" }  value="${roleDTO.id }">${roleDTO.roleName }</option>
					</c:forEach>
					
			</select>
		<span class="red_star">*</span></td>
		<th>状态</th>
		<td>
			<select name="sysUserDTO.usrFlag">
				<option value="1" ${requestScope.userDTO.usrFlag == 1 ? "selected=selected" : "" }>正常</option>
				<option value="0" ${requestScope.userDTO.usrFlag == 0 ? "selected=selected" : "" }>已删除</option>
			</select>
		</td>
	</tr>	
</table>
<input type="hidden" name="sysUserDTO.id" value="${requestScope.userDTO.id}" >
</form>
</body>
</html>