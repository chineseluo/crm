<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~ser/CstService.js"></script>
<c:if test="${responseText ne null}"><%="<script type='text/javascript' >alert('"+request.getAttribute("responseText")+"');</script>"%></c:if>
</head>
<body>
	<div class="page_title">客户服务管理 &gt; 服务创建</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="formCheck('editFrom');">保存</button>
	</div>
	<form action="<%=path%>/service/CstServiceAction_addCstServiceByManager" name="editFrom" method="post">
		<input type="hidden" name="svrCreatorDTO.id" value="${sessionScope.userDto.id }">

		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input disabled="disabled" /></td>
				<th>服务类型</th>
				<td><select name="svrTypeDTO.id" tip="请选择服务类型" reg="^.+$">
						<option value="">请选择...</option>
						<c:forEach items="${svrTypeList}" var="type" varStatus="vs">
							<option value="${type.id}">${type.dictItem }</option>
						</c:forEach>
				</select><span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>概要</th>
				<td colspan="3"><input size="53" name="svrTitle" tip="概要不能为空" reg="^.+$"/><span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>客户</th>
				<td><select name="svrCustomerDTO.id" tip="请选择客户" reg="^.+$">

						<option value="">请选择...</option>
						<c:forEach items="${svrCustomerList}" var="customer" varStatus="vs">
							<option value="${customer.id}">${customer.custName }</option>
						</c:forEach>

				</select> <span class="red_star">*</span></td>
				<th>状态</th>
				<td><input name="svrStatus" value="新创建" readonly="readonly" ></td>
			</tr>
			<tr>
				<th>服务请求</th>
				<td colspan="3"><textarea rows="6" cols="50" name="svrRequest" tip="服务请求不能为空" reg="^.+$"></textarea><span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>创建人</th>
				<td><input name="svrCreateBy" readonly="readonly" value="${sessionScope.userDto.usrName }" readonly size="20" /><span class="red_star">*</span></td>
				<th>创建时间</th>
				<td><input id="svrCreateDate" name="svrCreateDate" readonly="readonly" size="20" /><span class="red_star">*</span></td>
			</tr>
		</table>
	</form>
	<br />


	<table class="query_form_table" id="table3">
		<tr>
			<th>分配给</th>
			<td><select disabled="disabled">
					<option>请选择...</option>
			</select> <span class="red_star">*</span></td>
			<th>分配时间</th>
			<td><input id="t2" name="T18" readonly size="20" disabled="disabled" /><span class="red_star">*</span></td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table1">
		<tr>
			<th>服务处理</th>
			<td colspan="3"><textarea rows="6" cols="50" disabled="disabled"></textarea><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>处理人</th>
			<td><input readonly size="20" disabled="disabled" /><span class="red_star">*</span></td>
			<th>处理时间</th>
			<td><input id="t3" name="T16" readonly size="20" disabled="disabled" /><span class="red_star">*</span></td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table2">
		<tr>
			<th>处理结果</th>
			<td><input name="T10" size="20" disabled="disabled" /><span class="red_star">*</span></td>
			<th>满意度</th>
			<td><select name="D1" disabled="disabled">
					<option>请选择...</option>
					<option>☆☆☆☆☆</option>
					<option>☆☆☆☆</option>
					<option>☆☆☆</option>
					<option>☆☆</option>
					<option>☆</option>
			</select><span class="red_star">*</span></td>
		</tr>
	</table>
	<script type="text/javascript">
		setCurTime('svrCreateDate');
	</script>
</body>
</html>