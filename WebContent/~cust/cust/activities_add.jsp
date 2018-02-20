<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~cus/CstActivity.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path %>/cus/CstActivityAction_loadAllCstActivitys?cstActivityQueryDTO.atvCustomerId=${cstActivityQueryDTO.atvCustomerId }');">返回</button>
	<button class="common_button" onclick="formCheck('addCstActivity');">保存</button>
</div>
<form name="addCstActivity" action="<%=path %>/cus/CstActivityAction_addCstActivity" method="post">
<input type="hidden" name="cstActivityQueryDTO.atvCustomerId" value="${cstActivityQueryDTO.atvCustomerId }" />
<table class="query_form_table">
	<tr>
		<th>时间</th>
		<td><input name="atvDate" tip="时间不能为空" reg="^.+$" readonly="readonly" type="text" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/><span class="red_star">*</span></td>
		<th>地点</th>
		<td>
			<input name="atvPlace" size="20" tip="地点不能为空" reg="^.+$"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>概要</th>
		<td><input name="atvTitle" tip="概要不能为空" reg="^.+$"/><span class="red_star">*</span></td>
		<th>备注</th>
		<td><input /></td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<textarea name="atvDesc" cols="50" rows="6"> </textarea>
		</td>
	</tr>
</table>
</form>
</body>
</html>