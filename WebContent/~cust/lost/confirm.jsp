<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~cus/CstLost.js"></script>
</head>
<body>

<div class="page_title">客户流失管理 &gt; 确认流失</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	
	<button class="common_button" onclick="to('CstLostAction_loadCstLostsByManager');">返回</button>
	<button class="common_button" onclick="to('CstLostAction_toModifyPutoffCstLostPage?cstLostQueryDTO.id=${model.id}');">暂缓流失</button>
	<button class="common_button" onclick="formCheck('confirmForm','流失原因');">保存</button>
</div>
<form name="confirmForm" action="CstLostAction_confirmPutoffCstLost" method="post">
	<input type="hidden" name="id" value="${model.id }"/>
<table class="query_form_table">
	<tr>
		<th>编号</th>
		<td>${model.lstCustomerDTO.custNo }</td>
		<th>客户</th>
		<td>${model.lstCustName }</td>
	</tr>
	<tr>
		<th>客户经理</th>
		<td>
			${model.lstCustManagerName }</td>
		<th>上次下单时间</th>
		<td>
			<fmt:formatDate value="${model.lstLastOrderDate }" type="date" pattern="yyyy年MM月dd日" /></td>
	</tr>
	<tr>
		<th>暂缓措施</th>
		<td colspan="3">${model.lstDelay }</td>
	</tr>	
	<tr>
		<th>流失原因</th>
		<td colspan="3">
			<textarea name="lstReason" rows="6" cols="50"  tip="流失原因不能为空" reg="^.+$">${model.lstReason }</textarea><span class="red_star">*</span></td>
	</tr>
</table>
</form>
<br />
</body>
</html>