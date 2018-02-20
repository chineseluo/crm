<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/script/easyvalidator/css/validate.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/easyvalidator/js/easy_validator.pack.js"></script>
<script src="<%=path%>/script/easyvalidator/js/jquery.bgiframe.min.js"></script>
<script src="<%=path%>/script/crm/~sale/SalChance.js"></script>
<script src="<%=path %>/script/common.js"></script>
</head>
<body>

<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="saveDispatchSalChance();">保存</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${requestScope.salChanceDto.id }</td>
		<th>机会来源</th>
		<td>${requestScope.salChanceDto.chcSource }</td>
	</tr>
	<tr>
		<th>客户名称</th>
		<td>${requestScope.salChanceDto.chcCustName }</td>
		<th>成功机率（%）</th>
		<td>&nbsp;${requestScope.salChanceDto.chcCustName }</td>
	</tr>	
	<tr>
		<th>概要</th>
		<td colspan="3">${requestScope.salChanceDto.chcTitle }</td>
	</tr>
	<tr>
		<th>联系人</th>
		<td>${requestScope.salChanceDto.chcLinkMan }</td>
		<th>联系人电话</th>
		<td>${requestScope.salChanceDto.chcTel }</td>
	</tr>
	<tr>
		<th>机会描述</th>
		<td colspan="3">${requestScope.salChanceDto.chcDesc }</td>
	</tr>
	<tr>
		<th>创建人</th>
		<td>${requestScope.salChanceDto.chcCreateBy }</td>
		<th>创建时间</th>
		<td><fmt:formatDate value="${requestScope.salChanceDto.chcCreateDate }" pattern="yyyy-MM-dd" /></td>
	</tr>
</table>
<br />
<form name="saveDispatchSalChanceForm" action="<%=path%>/sale/saveDispatchSalChanceAction.action" method="post">
<table class="query_form_table" id="table1">
	<tr>
		<th>指派给</th>
		<td>
			<select name="salChanceDto.dueUserDTO.id" reg="[^-1]" tip="请必须指派一个客户经理">
			    <option value="-1">请选择</option>
				<c:forEach items="${requestScope.dtoResult }" var="sysUserDTO">
				<option value="${sysUserDTO.id }">${sysUserDTO.usrName }</option>
				</c:forEach>
			</select> <span class="red_star">*</span></td>
		<th>指派时间</th>
		<td>
			<input id="t2" name="salChanceDto.chcDueDate" readonly size="20" /><span class="red_star">*</span></td>
	</tr>
</table>
<input type="hidden" name="salChanceDto.id" value="${requestScope.salChanceDto.id }">
</form>
<script>
	setCurTime('t2');
</script>
</body>
</html>