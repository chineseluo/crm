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
<script type = "text/javascript"  src = "<%=path %>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/crm/~rept/rept.js"></script>
</head>
<body>

<div class="page_title">客户构成分析</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="findAllCustCons();">查询</button> 
	</div>
<form action="<%=path %>/rept/loadAllCustConsAction.action" name="loadAllCustConsForm" method="post">
<table class="query_form_table">
	<tr>
		<th>报表方式</th>
		<td>
			<select name="optionType">
				<option value="custLevel" ${requestScope.optionType == 'custLevel'? "selected=selected" : "" }>按等级</option>
				<option value="credit" ${requestScope.optionType == 'credit'? "selected=selected" : ""}>按信用度</option>
				<option value="satisfy" ${requestScope.optionType == 'satisfy'? "selected=selected" : ""}>按满意度</option>
			</select>
		</td>

	<th>&nbsp;</th>
		<td>
			&nbsp;
		</td>
			</tr>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>等级</th>
		<th>客户数量</th>
	</tr>
	<c:if test="${requestScope.optionType == 'custLevel' }">
	<c:forEach items="${requestScope.resultList }" var="instantCustomerComprise" varStatus="vs">
	<tr>
		<td class="list_data_number">${vs.index+1 }</td>
		<td class="list_data_text">${instantCustomerComprise.custLevel }</td>
		<td class="list_data_number">${instantCustomerComprise.custCount }</td>
	</tr>
	</c:forEach>
	</c:if>
	
	<c:if test="${requestScope.optionType == 'satisfy' }">
	<c:forEach items="${requestScope.resultList }" var="instantCustomerComprise" varStatus="vs">
	<tr>
		<td class="list_data_number">${vs.index+1 }</td>
		<td class="list_data_text">${instantCustomerComprise.sasifyOrCredit==1?'☆': instantCustomerComprise.sasifyOrCredit==2?'☆☆':instantCustomerComprise.sasifyOrCredit==3?'☆☆☆':instantCustomerComprise.sasifyOrCredit==4?'☆☆☆☆':'☆☆☆☆☆'}</td>
		<td class="list_data_number">${instantCustomerComprise.custCount }</td>
	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${requestScope.optionType == 'credit' }">
	<c:forEach items="${requestScope.resultList }" var="instantCustomerComprise" varStatus="vs">
	<tr>
		<td class="list_data_number">${vs.index+1 }</td>
		<td class="list_data_text">${instantCustomerComprise.sasifyOrCredit==1?'☆': instantCustomerComprise.sasifyOrCredit==2?'☆☆':instantCustomerComprise.sasifyOrCredit==3?'☆☆☆':instantCustomerComprise.sasifyOrCredit==4?'☆☆☆☆':'☆☆☆☆☆'}</td>
		<td class="list_data_number">${instantCustomerComprise.custCount }</td>
	</tr>
	</c:forEach>
	</c:if>
	

	</table>
</body>
</html>