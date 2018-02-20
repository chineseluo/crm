<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script src="<%=path %>/script/My97DatePicker/WdatePicker.js"></script>
<script type = "text/javascript"  src = "<%=path %>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/crm/~rept/rept.js"></script>
</head>
<body>

<div class="page_title">客户贡献分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="findInstantCust();">查询</button> 
	</div>
<form action="<%=path %>/rept/loadAllInstantCustomerAction.action" name="loadByConditionForm" method="post">
<table class="query_form_table">
	<tr>
		<th>客户名称</th>
		<td><input name="instantCustomerQueryDTO.name" value="${requestScope.instantCustomerQueryDTO.name }"/></td>
		<th>年份</th>
		<td>
			<input name="instantCustomerQueryDTO.year" value="${requestScope.instantCustomerQueryDTO.year }" type="text" id="d243" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" class="Wdate"/>
		</td>
	</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>订单金额（元）</th>
	</tr>
	<c:forEach items="${requestScope.resultList }" var="InstantCustomer" varStatus="vs">
	<tr>
		<td class="list_data_number">${vs.index+1 }</td>
		<td class="list_data_ltext">${InstantCustomer.name }</td>
		<td class="list_data_number">${InstantCustomer.allMoney }</td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>