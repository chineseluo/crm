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
<script src="<%=path%>/script/crm/~cus/CstLinkman.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理  &gt; 客户信息 &gt; 联系人</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="to('<%=path%>/cus/CstLinkmanAction_toAddCstLinkmanPage?cstLinkmanQueryDTO.lkmCustomerId=${cstLinkmanQueryDTO.lkmCustomerId}');">新建</button>
		<button class="common_button" onclick="search('searchForm');">查询</button>
		<button class="common_button" onclick="to('<%=path %>/cus/CstCustomerAction_loadCstCustomersByManager');">返回</button>
	</div>


	<table class="query_form_table">
		<tr>
			<th>客户编号</th>
			<td>${cstCustomer.custNo}</td>
			<th>客户名称</th>
			<td>${cstCustomer.custName}</td>
			<th>联系人名称</th>
			<td>
				<form action="<%=path%>/cus/CstLinkmanAction_loadAllCstLinkmans" name="searchForm">
					<input name="cstLinkmanQueryDTO.lkmName" value="${requestScope.queryCondition.lkmName}" /> <input type="hidden" name="cstLinkmanQueryDTO.lkmCustomerId" value="${requestScope.queryCondition.lkmCustomerId}" />
				</form>
			</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>职位</th>
			<th>办公电话</th>
			<th>手机</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list}" var="linkman" varStatus="status">
			<tr>
				<td class="list_data_text">${linkman.lkmName}</td>
				<td class="list_data_ltext">${linkman.lkmSex}</td>
				<td class="list_data_text">${linkman.lkmPostion }</td>
				<td class="list_data_text">${linkman.lkmTel }</td>
				<td class="list_data_text">${linkman.lkmMobile}</td>
				<td class="list_data_op">${linkman.lkmMemo}</td>
				<td class="list_data_op"><img onclick="to('CstLinkmanAction_toModifyCstLinkmanPage?id=${linkman.id}&cstLinkmanQueryDTO.lkmCustomerId=${cstLinkmanQueryDTO.lkmCustomerId }');" title="编辑" src="<%=path%>/images/bt_edit.gif" class="op_button" /> 
				<img onclick="del('${linkman.lkmName }','CstLinkmanAction_removeCstLinkman?id=${linkman.id}&cstLinkmanQueryDTO.lkmCustomerId=${cstLinkmanQueryDTO.lkmCustomerId }');" title="删除" src="<%=path %>/images/bt_del.gif" class="op_button" /></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/cus/CstLinkmanAction_loadAllCstLinkmans" method="post" name="listLinkman">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页<input name="cstLinkmanQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }" />条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'listLinkman')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'listLinkman')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'listLinkman')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'listLinkman')">最后一页</a> 转到<input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>

						<input type="hidden" name="cstLinkmanQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> <input type="hidden" name="cstLinkmanQueryDTO.lkmName" id="queryLkmName" value="${requestScope.queryCondition.lkmName}" /> <input type="hidden" name="cstLinkmanQueryDTO.lkmCustomerId" id="queryLkmCustomerId" value="${requestScope.queryCondition.lkmCustomerId}" />
					</div>
				</form>
			</th>
		</tr>
	</table>
</body>
</html>