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
<script src="<%=path%>/script/crm/~basd/product.js"></script>
</head>
<body>

<div class="page_title">产品查询</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="reloadProduct();">查询</button>  
</div>
<form action="<%=path%>/basd/loadProductByConditionAction.action" name="loadProductByConditionForm" method="post">
<table class="query_form_table">
	<tr>
		<th>名称</th>
		<td><input name="productQueryDTO.prodName" value="${requestScope.queryCondition.prodName }"/></td>
		<th>型号</th>
		<td><input name="productQueryDTO.prodType" value="${requestScope.queryCondition.prodType }" /></td>
		<th>批次</th>
		<td><input name="productQueryDTO.prodBatch" value="${requestScope.queryCondition.prodBatch }"/></td>
	</tr>
</table>
</form>
<br />

<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>名称</th>
		<th>型号</th>
		<th>等级/批次</th>
		<th>单位</th>
		<th>单价（元）</th>
		<th>备注</th>
	</tr>
<c:forEach items="${requestScope.pageResult.list }" var="productDTO">
	<tr>
		<td class="list_data_number">${productDTO.id }</td>
		<td class="list_data_ltext">${productDTO.prodName}</td>
		<td class="list_data_text">${productDTO.prodType }</td>
		<td class="list_data_text">${productDTO.prodBatch }</td>
		<td class="list_data_text">${productDTO.prodUnit }</td>
		<td class="list_data_number">${productDTO.prodPrice }</td>
		<td class="list_data_ltext">${productDTO.prodMemo }&nbsp;</td>		
	</tr>
</c:forEach>	
	<tr>
		<form name="loadProductByPageForm" action="<%=path %>/basd/loadAllProductAction.action" method="post" >
		<th colspan="7" class="pager">
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
				<input type="hidden" name="productQueryDTO.prodType" id="prodType" value="${requestScope.queryCondition.prodType }"/>
				<input type="hidden" name="productQueryDTO.prodBatch" id=prodBatch value="${requestScope.queryCondition.prodBatch }"/>
			</div>
		</th>
		</form>
	</tr>
</table>
</body>
</html>