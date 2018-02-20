<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/script/common.js"></script>
</head>
<body>

<div class="page_title">当前位置:权限管理 >> 用户管理 >> 查看用户</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
</div>
<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th class="input_title">
					用户名
				</th>
				<td class="input_content">
					${requestScope.userDTO.usrName }
				</td>
				<th class="input_title">
					密码
				</th>
				<td class="input_content">
					******
				</td>
			</tr>
			<tr>
				<th class="input_title">
					角色
				</th>
				<td class="input_content">
					${requestScope.userDTO.sysRole.roleName }
				</td>
				<th class="input_title">
					状态
				</th>
				<td class="input_content">
					${requestScope.userDTO.usrFlag == 1 ? "正常" : "已删除" }
				</td>
			</tr>
		</table>
</body>
</html>