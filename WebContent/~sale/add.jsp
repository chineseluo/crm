<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.jb.crm.sale.dto.SalChanceDTO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/script/easyvalidator/css/validate.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/easyvalidator/js/easy_validator.pack.js"></script>
<script src="<%=path%>/script/easyvalidator/js/jquery.bgiframe.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script src="<%=path%>/script/crm/~sale/SalChance.js"></script>
</head>
<body>

	<div class="page_title">销售机会管理&nbsp; &gt; 新建销售机会</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="addSalChance();">保存</button>
	</div>
	<form name ="salChanceAddForm" action="<%=path%>/sale/addSalChanceAction.action" method="post">
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td><input readonly/></td>
			<th>机会来源</th>
			<td><input name="salChanceDto.chcSource" size="20" tip="可以为空,输入请不要超过25个字" reg="(^$)|(^.{1,25}$)" /></td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td><input name="salChanceDto.chcCustName" tip="不能为空，且请不要超过50个字" reg="^.{1,50}$"/><span class="red_star">*</span></td>
			<th>成功机率</th>
			<td><input name="salChanceDto.chcRate" tip="不能为空:请输入1-100的数字" reg="^(\d{1,2}|[1][0][0])$"/><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3"><input name="salChanceDto.chcTitle" size="52" tip="不能为空，且不能超过100个字" reg="^.{1,100}$"/><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>联系人</th>
			<td><input name="salChanceDto.chcLinkMan" size="20" tip="可以为空，输入请不起超过25个字" reg="(^$)|(^.{1,25}$)" /></td>
			<th>联系人电话</th>
			<td><input name="salChanceDto.chcTel" size="20" tip="可以为空，输入请输入正确的号码，例如：15920345620或020-5866059"  reg="(^$)|(^1\d{10}$)|^(\d{3,4}-)?\d{7,8}$"/></td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3"><textarea rows="6" cols="50" name="salChanceDto.chcDesc" tip="不能为空，且不能超过1000字" reg="^.{1,1000}$"></textarea><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>创建人</th>
			<td><input name="salChanceDto.chcCreateBy" value="${sessionScope.userDto.usrName}" readonly size="20" /><span class="red_star">*</span></td>
			<th>创建时间</th>
			<td><input id="t1" name="salChanceDto.chcCreateDate" readonly size="20" /><span class="red_star">*</span></td>
		</tr>
	</table>
	<input type="hidden" name="salChanceDto.id" value="${requestScope.salChanceDto.id }">
	</form>
	<br />
	<table  class="query_form_table" id="table1">
		<tr>
			<th>指派给</th>
			<td><select name="D1" disabled="disabled">
					<option>请选择...</option>
			</select> <span class="red_star">*</span></td>
			<th>指派时间</th>
			<td><input id="t2" name="T20" readonly size="20" disabled="disabled"/><span class="red_star">*</span></td>
		</tr>
	</table>
	
	<script>
		setCurTime('t1');
		setCurTime('t2');
	</script>
</body>
</html>