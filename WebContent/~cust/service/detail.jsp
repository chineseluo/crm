<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = this.getServletContext().getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script src="<%=path%>/script/crm/~ser/CstService.js"></script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path%>/service/CstServiceAction_toArchCstServicePage');">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${model.id }</td>
		<th>服务类型</th>
		<td>${model.svrTypeDTO.dictItem}</td>
	</tr>
	<tr>
		<th>概要</th>
		<td colspan="3">${model.svrTitle }</td>
	</tr>	
	<tr>
		<th>客户</th>
		<td>${model.svrCustName }</td>
		<th>状态</th>
		<td>${model.svrStatus }</td>
	</tr>	
	<tr>
		<th>服务请求</th>
		<td colspan="3">${model.svrRequest }<br>
　</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${model.svrCreateBy }</td>
		<th>创建时间</th>
		<td><fmt:formatDate value="${model.svrCreateDate }" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
	</tr>
	</table>
<br />
<table class="query_form_table" id="table3">
	<tr>
		<th>分配给</th>
		<td>
			${model.svrDueTo }</td>
		<th>分配时间</th>
		<td><fmt:formatDate value="${model.svrDueDate }" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
	</tr>
</table>
<br />	
<table class="query_form_table" id="table1">
	<tr>
		<th>服务处理</th>
		<td colspan="3">${model.svrDeal }</td>
	</tr>
	<tr>
		<th>处理人</th>
		<td>${model.svrDealBy }</td>
		<th>处理时间</th>
		<td><fmt:formatDate value="${model.svrDealDate }" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>处理结果</th>
		<td>${model.svrResult }</td>
		<th>满意度</th>
		<td>
		<c:forEach begin="1" end="5" varStatus="status">
			<c:if test="${model.svrSatisfy >= status.index }">
				<img src="<%=path %>/images/star.jpg" class="star_pic" />
			</c:if>
		</c:forEach>
	</tr>
</table>
</body>
</html>