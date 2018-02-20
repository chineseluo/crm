<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script src="<%=path%>/script/crm/~cus/CstCustomer.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="search('searchForm');">查询</button>
	</div>
	<form action="<%=path%>/cus/CstCustomerAction_loadCstCustomersByManager" method="post" name="searchForm">
		<table class="query_form_table">
			<tr>

				<th>客户编号</th>
				<td><input name="cstCustomerQueryDTO.custNo" value="${requestScope.queryCondition.custNo}" /></td>
				<th>名称</th>
				<td><input name="cstCustomerQueryDTO.custName" value="${requestScope.queryCondition.custName}" /></td>
				<th>地区</th>
				<td><select name="cstCustomerQueryDTO.custRegion">
						<option value="" ${requestScope.queryCondition.custRegion == null ? "selected=selected" : "" }>全部</option>
						<c:forEach items="${customerRegions}" var="region">
							<option value="${region.id }" ${requestScope.queryCondition.custRegion eq region.id? "selected=selected" : "" }>${region.dictItem }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>客户经理</th>
				<td><input name="cstCustomerQueryDTO.custManagerName" value="${requestScope.queryCondition.custManagerName}" /></td>
				<th>客户等级</th>
				<td><select name="cstCustomerQueryDTO.custLevelLabel">
						<option value="" ${requestScope.queryCondition.custLevelLabel == null ? "selected=selected" : "" }>全部</option>
						<c:forEach items="${customerLevels}" var="customerLevel">
							<option value="${customerLevel.dictItem }" ${requestScope.queryCondition.custLevelLabel eq customerLevel.dictItem ? "selected=selected" : "" }>${customerLevel.dictItem}</option>
						</c:forEach>
				</select></td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>序号</th>
			<th>客户编号</th>
			<th>名称</th>
			<th>地区</th>
			<th>客户经理</th>
			<th>客户等级</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list }" var="customer">
			<tr>
				<td class="list_data_number">${customer.id}</td>
				<td class="list_data_text">${customer.custNo }</td>
				<td class="list_data_ltext">${customer.custName }</td>
				<td class="list_data_text">${customer.custRegion.dictItem }</td>
				<td class="list_data_text">${customer.custManagerName }</td>
				<td class="list_data_text">${customer.custLevelLabel }</td>
				<td class="list_data_op">
					<img onclick="to('<%=path%>/cus/CstCustomerAction_toModifyCstCustomerPage?cstCustomerQueryDTO.id=${customer.id }');" title="编辑" src="<%=path%>/images/bt_edit.gif" class="op_button" />
					<img onclick="to('<%=path%>/cus/CstLinkmanAction_loadAllCstLinkmans?cstLinkmanQueryDTO.lkmCustomerId=${customer.id}');" title="联系人" src="<%=path%>/images/bt_linkman.gif" class="op_button" /> 
					<img onclick="to('<%=path%>/cus/CstActivityAction_loadAllCstActivitys?cstActivityQueryDTO.atvCustomerId=${customer.id}');" title="交往记录" src="<%=path%>/images/bt_acti.gif" class="op_button" />
					<img onclick="to('<%=path%>/basd/OrdersAction_loadAllOrders?ordersQueryDTO.odrCustomer=${customer.custName }');" title="历史订单" src="<%=path%>/images/bt_orders.gif" class="op_button" /> 
					<c:if test="${customer.custStatus ne '3'}">
						<img onclick="del('${customer.custName }','<%=path%>/cus/CstCustomerAction_deleteCstCustomer?id=${customer.id}');" title="删除" src="<%=path%>/images/bt_del.gif" class="op_button" />
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/cus/CstCustomerAction_loadAllCstCustomers" method="post" name="pagingForm">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页 <input name="cstCustomerQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }" /> 条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'pagingForm')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'pagingForm')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'pagingForm')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'pagingForm')">最后一页</a> 转到 <input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>
						<input type="hidden" name="cstCustomerQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> <input type="hidden" name="cstCustomerQueryDTO.custNo" id="queryCustNo" value="${requestScope.queryCondition.custNo}" /> <input type="hidden" name="cstCustomerQueryDTO.custName" id="queryCustName" value="${requestScope.queryCondition.custName}" /> <input type="hidden" name="cstCustomerQueryDTO.custRegion" id="queryCustRegion" value="${requestScope.queryCondition.custRegion}" /> <input type="hidden" name="cstCustomerQueryDTO.custManagerName" id="queryCustManagerName" value="${requestScope.queryCondition.custManagerName}" /> <input type="hidden" name="cstCustomerQueryDTO.custLevelLabel" id="queryCustLevelLabel" value="${requestScope.queryCondition.custLevelLabel}" />
					</div>
				</form>
			</th>
		</tr>

	</table>
</body>
</html>