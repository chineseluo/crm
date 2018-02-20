<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<body>

	<div class="page_title">客户服务分析</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="add('serchForm');">查询</button>
	</div>
	<form name="serchForm" action="<%=path%>/rept/loadAllInstantCustomerServiceAction.action" method="post">
		<table class="query_form_table">
			<tr>
				<th>年份</th>
				<td><input name="instantCustomerServiceYear" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy'})" class="Wdate" value="${instantCustomerServiceYear}"/></td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>条目</th>
			<th>服务数量</th>
		</tr>
		<c:forEach items="${svrTypeList }" var="svrType" varStatus="status">
			<tr>
				<td class="list_data_number">${status.index+1}</td>
				<c:set var="flag" value="false"></c:set>
				<c:forEach items="${resultList}" var="instantService">
					<c:if test="${instantService.svrType == svrType.dictItem}">
						<td class="list_data_text">${instantService.svrType}</td>
						<td class="list_data_number">${instantService.svrCount}</td>
						<c:set var="flag" value="true"></c:set>
					</c:if>
				</c:forEach>
				<c:if test="${flag ==false }">
					<td class="list_data_text">${svrType.dictItem}</td>
					<td class="list_data_number">0</td>
				</c:if>
			</tr>
		</c:forEach>




	</table>
</body>
</html>