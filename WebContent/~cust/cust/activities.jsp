<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/script/common.js"></script>
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/crm/~cus/CstActivity.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="to('<%=path%>/cus/CstActivityAction_toAddCstActivityPage?cstActivityQueryDTO.atvCustomerId=${cstActivityQueryDTO.atvCustomerId}');">新建</button>
		<button class="common_button" onclick="to('<%=path%>/cus/CstCustomerAction_loadCstCustomersByManager');">返回</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>客户编号</th>
			<td>${cstCustomer.custNo}</td>
			<th>客户名称</th>
			<td>${cstCustomer.custName}</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table">
		<tr>
			<th width="232">时间</th>
			<th>地点</th>
			<th>概要</th>
			<th>详细信息</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult}" var="activity" varStatus="status">
			<tr>
				<td class="list_data_text"><fmt:formatDate value="${activity.atvDate }" pattern="yyyy-MM-dd" type="date" /></td>
				<td class="list_data_ltext">${activity.atvPlace}</td>
				<td class="list_data_text">${activity.atvTitle }</td>
				<td class="list_data_text">${activity.atvDesc }</td>
				<td class="list_data_text"></td>
				<td class="list_data_op">
					<img onclick="to('CstActivityAction_toModifyCstActivityPage?id=${activity.id}&cstActivityQueryDTO.atvCustomerId=${cstActivityQueryDTO.atvCustomerId }');" title="编辑" src="<%=path %>/images/bt_edit.gif" class="op_button">
					<img onclick="del('${activity.atvDate }','CstActivityAction_removeCstActivity?id=${activity.id}&cstActivityQueryDTO.atvCustomerId=${cstActivityQueryDTO.atvCustomerId }');" title="删除" src="<%=path %>/images/bt_del.gif" class="op_button" />
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>