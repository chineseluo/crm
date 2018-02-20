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
<script src="<%=path%>/script/crm/~basd/storage.js"></script>
</head>
<body>

<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reloadProductAndStorage();">查询</button>  
</div>
<form name="loadProductAndStorageByConditionForm" action="<%=path %>/basd/loadProductAndStorageByConditionAction.action" method="post">
<table class="query_form_table">
	<tr>
		<th>产品</th>
		<td><input name="productQueryDTO.prodName" value="${requestScope.queryCondition.prodName }"/></td>
		<th>仓库</th>
		<td><input name="productQueryDTO.stkWarehouse" value="${requestScope.queryCondition.stkWarehouse }"/></td>
		<th>&nbsp;</th>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>序号</th>
		<th>产品</th>
		<th>仓库</th>
		<th>货位</th>
		<th>件数</th>
		<th>备注</th>
	</tr>
<c:forEach items="${requestScope.pageResult.list }" var="productDTO" varStatus="vs">
	<tr>
		<td class="list_data_number">${vs.index+1 }</td>
		<td class="list_data_ltext">${productDTO.prodName }</td>
		<td class="list_data_ltext">${productDTO.storage.stkWarehouse }</td>
		<td class="list_data_text">${productDTO.storage.stkWare }</td>
		<td class="list_data_number">${productDTO.storage.stkCount }</td>
		<td class="list_data_ltext">${productDTO.storage.stkMemo }</td>		
	</tr>
</c:forEach>
	<tr>
		<form name="loadProductAndStorageByPageForm" action="<%=path %>/basd/findProductAndStorageAction.action" method="post" >
		<th colspan="6" class="pager">
			<div class="pager">
				共${requestScope.pageResult.recTotal }条记录 每页<input name="productQueryDTO.pageSize" value="${requestScope.pageResult.pageSize }" size="2" />条
				 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页
				<a href="#" onclick="setPage(1)">第一页</a>
				<a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1})">上一页</a>
				<a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1})">下一页</a>
				<a href="#" onclick="setPage(${requestScope.pageResult.totalPage})">最后一页</a>
				转到<input  size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)"/>页
				<button type="submit">GO</button>
				
				<input type="hidden" name="productQueryDTO.pageNum" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}"  />
				<input type="hidden" name="productQueryDTO.prodName" id="prodName" value="${requestScope.queryCondition.prodName }"/>
				<input type="hidden" name="productQueryDTO.stkWarehouse" id="stkWarehouse" value="${requestScope.queryCondition.stkWarehouse }"/>
			</div>
		</th>
		</form>
	</tr>
</table>
</body>
</html>