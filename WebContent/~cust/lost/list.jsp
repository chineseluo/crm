<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/script/common.js"></script>
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/crm/~cus/CstLost.js"></script>
</head>
<body>

	<div class="page_title">客户流失管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="search('cstLostQuery');">查询</button>
	</div>
	<form name="cstLostQuery" action="<%=path%>/cus/CstLostAction_loadCstLostsByManager" method="post">

		<table class="query_form_table">
			<tr>
				<th>客户</th>
				<td><input name="cstLostQueryDTO.lstCustName" value="${cstLostQueryDTO.lstCustName }"/></td>
				<th>客户经理</th>
				<td><input name="cstLostQueryDTO.lstCustManagerName" value="${cstLostQueryDTO.lstCustManagerName }"/></td>
				<th>状态</th>
				<td><select name="cstLostQueryDTO.lstStatus">
						<option value="">全部</option>
						<option value="1" ${cstLostQueryDTO.lstStatus eq "1"?"selected='selected'":"" }>预警</option>
						<option value="2" ${cstLostQueryDTO.lstStatus eq "2"?"selected='selected'":"" }>暂缓流失</option>
						<option value="3" ${cstLostQueryDTO.lstStatus eq "3"?"selected='selected'":"" }>确认流失</option>
				</select></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>客户</th>
			<th>客户经理</th>
			<th>上次下单时间</th>
			<th>确认流失时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list}" var="cstLost" varStatus="status">
		<tr>
			<td class="list_data_number">${cstLost.id }</td>
			<td class="list_data_text">${cstLost.lstCustName }</td>
			<td class="list_data_ltext">${cstLost.lstCustManagerName }</td>
			<td class="list_data_text"><fmt:formatDate value="${cstLost.lstLastOrderDate }" pattern="yyyy年MM月dd日" type="date" /></td>
			<td class="list_data_text"><fmt:formatDate value="${cstLost.lstLostDate }" pattern="yyyy年MM月dd日" type="date" /></td>
			<td class="list_data_text">${cstLost.lstStatus == "1" ? "预警": (cstLost.lstStatus == "2" ? "暂缓流失": "确认流失") }</td>
			<td class="list_data_op">
			<img onclick="to('<%=path %>/cus/CstLostAction_toConfirmPutoffCstLostPage?cstLostQueryDTO.id=${cstLost.id }');" title="确认流失" src="<%=path %>/images/bt_confirm.gif" class="op_button" /> 
			<img onclick="to('<%=path %>/cus/CstLostAction_toModifyPutoffCstLostPage?cstLostQueryDTO.id=${cstLost.id }');" title="暂缓流失" src="<%=path %>/images/bt_relay.gif" class="op_button" /></td>
		</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/cus/CstLostAction_loadCstLostsByManager" method="post" name="listCstLost">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页<input name="cstLostQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }" />条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'listCstLost')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'listCstLost')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'listCstLost')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'listCstLost')">最后一页</a> 转到<input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>

						<input type="hidden" name="cstLostQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> 
						<input type="hidden" name="cstLostQueryDTO.lstCustName" id="queryLstCustName" value="${requestScope.queryCondition.lstCustName}" /> 
						<input type="hidden" name="cstLostQueryDTO.lstCustManagerName" id="queryLstCustManagerName" value="${requestScope.queryCondition.lstCustManagerName}" />
						<input type="hidden" name="cstLostQueryDTO.lstStatus" id="queryLstStatus" value="${requestScope.queryCondition.lstStatus}" />
					</div>
				</form>
			</th>
		</tr>
	</table>
</body>
</html>