<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
</head>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path%>/basd/OrdersAction_loadAllOrders?ordersQueryDTO.odrCustomer=${model.odrCustomer }');">返回</button>  
</div>
<table class="query_form_table" height="59">
	<tr>
		<th>订单编号</th>
		<td>${model.id}</td>
		<th>日期</th>
		<td><fmt:formatDate value="${model.odrDate}" pattern="yyyy年MM月dd日" type="date" /></td>
	</tr>
	<tr>
		<th height="28">送货地址</th>
		<td>${model.odrAddr }　</td>
		<th height="28">总金额（元）</th>
		<td>
			<c:set var="total" value="0" />
			<c:forEach items="${model.ordersLineDTOs }" var="ordersLine">
				<c:set var="total" value="${total + ordersLine.oddPrice*ordersLine.oddCount}" />
			</c:forEach>
			${total}
		</td>
	</tr>
	<tr>
		<th height="28">状态</th>
		<td>${orders.odrStatus == "6" ? "已回款" : (orders.odrStatus == "5" ? "已发货" : "未回款")}</td>
		<th height="28">&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
	</table>
<br />
<table class="data_list_table">
	<tr>
		<th>商品</th>
		<th>数量</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>金额（元）</th>
	</tr>
	<c:forEach items="${model.ordersLineDTOs }" var="ordersLine">
		<tr>
		<td class="list_data_text">${ordersLine.productDTO.prodName}</td>
		<td class="list_data_ltext">${ordersLine.oddCount }</td>
		<td class="list_data_text">${ordersLine.oddUnit}</td>
		<td class="list_data_text">${ordersLine.oddPrice}</td>
		<td class="list_data_text">${ordersLine.oddPrice*ordersLine.oddCount}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>