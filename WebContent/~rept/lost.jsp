<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script src="<%=path%>/script/crm/~rept/rept.js"></script>
</head>
<body>

	<div class="page_title">客户流失分析</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="add('searchForm');">查询</button>
	</div>
	<form name="searchForm" action="<%=path%>/rept/loadAllInstantCustomerLostAction.action" method="post">
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th>客户名称</th>
				<td><input type="text" name="cstLostQueryDTO.lstCustName" value="${requestScope.queryCondition.lstCustName }"></td>
				<th>客户经理</th>
				<td><input type="text" name="cstLostQueryDTO.lstCustManagerName" value="${requestScope.queryCondition.lstCustManagerName }"></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th height="28">编号</th>
			<th height="28">年份</th>
			<th height="28">客户</th>
			<th height="28">客户经理</th>
			<th height="28">流失原因</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list}" var="cstLost" varStatus="status">
			<tr>
				<td class="list_data_number">${cstLost.id }</td>
				<td class="list_data_text"><fmt:formatDate value="${cstLost.lstLostDate }" pattern="yyyy年" type="date" /></td>
				<td class="list_data_text">${cstLost.lstCustName }</td>
				<td class="list_data_text">${cstLost.lstCustManagerName }</td>
				<td class="list_data_text">${cstLost.lstReason }</td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/rept/loadAllInstantCustomerLostAction.action" method="post" name="listCstLost">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页<input name="cstLostQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }" />条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'listCstLost')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'listCstLost')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'listCstLost')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'listCstLost')">最后一页</a> 转到<input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>

						<input type="hidden" name="cstLostQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> <input type="hidden" name="cstLostQueryDTO.lstCustName" id="queryLstCustName" value="${requestScope.queryCondition.lstCustName}" /> <input type="hidden" name="cstLostQueryDTO.lstCustManagerName" id="queryLstCustManagerName" value="${requestScope.queryCondition.lstCustManagerName}" /> 
					</div>
				</form>
			</th>
		</tr>

	</table>
</body>
</html>