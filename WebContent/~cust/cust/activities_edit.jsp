<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~cus/CstActivity.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path %>/cus/CstActivityAction_loadAllCstActivitys?cstActivityQueryDTO.atvCustomerId=${cstActivityQueryDTO.atvCustomerId }');">返回</button>
	<button class="common_button" onclick="formCheck('modifyCstActivity');">保存</button>
</div>
<form name="modifyCstActivity" action="CstActivityAction_modifyCstActivity" method="post">
		<input type="hidden" name="cstActivityQueryDTO.atvCustomerId" value="${cstActivityQueryDTO.atvCustomerId }"/>
		<input type="hidden" name="id" value="${model.id }"/>
		<input type="hidden" name="cstCustomerDTO.id" value="${model.cstCustomerDTO.id }"/>
		<input type="hidden" name="atvCustName" value="${model.atvCustName}"/>
<table class="query_form_table" id="table1">
	<tr>
		<th>时间</th>
		<td>
		<input name="atvDate" tip="时间不能为空" reg="^.+$" readonly="readonly" type="text" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${model.atvDate }" pattern="yyyy-MM-dd" type="date" />" size="20" /><span class="red_star">*</span></td>
		<th>地点</th>
		<td>
			<input name="atvPlace" value="${model.atvPlace }" size="20" tip="地点不能为空" reg="^.+$"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>概要</th>
		<td><input name="atvTitle" value="${model.atvTitle }" size="20" tip="概要不能为空" reg="^.+$"/><span class="red_star">*</span></td>
		<th>备注</th>
		<td><input size="20" /></td>
	</tr>	
	<tr>
		<th>详细信息</th>
		<td colspan="3">
			<textarea name="atvDesc" cols="50" rows="6" >${model.atvDesc }</textarea>
		</td>
	</tr>
</table>
</form>
</body>
</html>