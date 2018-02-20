<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~cus/CstLinkman.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 联系人 &gt; 新建联系人</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="to('<%=path %>/cus/CstLinkmanAction_loadAllCstLinkmans?cstLinkmanQueryDTO.lkmCustomerId=${cstLinkmanQueryDTO.lkmCustomerId }');">返回</button>
		<button class="common_button" onclick="formCheck('addCstLinkman');">保存</button>
	</div>
	<form name="addCstLinkman" action="<%=path %>/cus/CstLinkmanAction_addCstLinkman" method="post">
		<input type="hidden" name="cstLinkmanQueryDTO.lkmCustomerId" value="${cstLinkmanQueryDTO.lkmCustomerId }" />
		<table class="query_form_table">
			<tr>
				<th>姓名</th>
				<td><input name="lkmName" tip="姓名不能为空" reg="^.+$"/><span class="red_star">*</span></td>
				<th>性别</th>
				<td><input type="radio" name="lkmSex" checked value="男" />男 <input type="radio" name="lkmSex" value="女" />女</td>
			</tr>
			<tr>
				<th>职位</th>
				<td><input name="lkmPostion" tip="职位不能为空" reg="^.+$"/><span class="red_star">*</span></td>
				<th>办公电话</th>
				<td><input name="lkmTel" reg="^(\d{3,4}-)?\d{7,8}$" tip="请输入正确的号码"/><span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>手机</th>
				<td><input name="lkmMobile" size="20" reg="(^$)|(^1\d{10}$)$" tip="请输入正确的号码"/></td>
				<th>备注</th>
				<td><input name="lkmMemo" size="20" /></td>
			</tr>
		</table>
	</form>
</body>
</html>