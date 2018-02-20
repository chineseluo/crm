<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/script/common.js"></script>
<script type="text/javascript" src="<%=path%>/script/crm/~basd/Orders.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
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
	<table class="data_list_table">
		<tr>
			<th>订单编号</th>
			<th>日期</th>
			<th>送货地址</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list}" var="orders" varStatus="status">
			<tr>
				<td class="list_data_text">${orders.id}</td>
				<td class="list_data_ltext"><fmt:formatDate value="${orders.odrDate}" pattern="yyyy-MM-dd" type="date" /></td>
				<td class="list_data_text">${orders.odrAddr}</td>
				<td class="list_data_text">${orders.odrStatus == "6" ? "已回款" : (orders.odrStatus == "5" ? "已发货" : "未回款")}</td>
				<td class="list_data_op"><span style="cursor:pointer"><img onclick="to('<%=path %>/basd/OrdersAction_loadOrdersById?ordersQueryDTO.id=${orders.id }');" title="查看明细" src="<%=path%>/images/bt_detail.gif" class="op_button" /></span></td>
			</tr>
		</c:forEach>

		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/basd/OrdersAction_loadAllOrders" method="post" name="listOrders">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页<input name="ordersQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }" />条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'listOrders')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'listOrders')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'listOrders')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'listOrders')">最后一页</a> 转到<input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>

						<input type="hidden" name="ordersQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> <input type="hidden" name="ordersQueryDTO.odrCustomer" id="queryOdrCustomer" value="${requestScope.queryCondition.odrCustomer}" /> 
					</div>
				</form>
			</th>
		</tr>
	</table>
</body>
</html>