<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~cus/CstCustomer.js"></script>

</head>
<body>

<div class="page_title">客户信息管理 > 客户信息</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path%>/cus/CstLinkmanAction_loadAllCstLinkmans?cstLinkmanQueryDTO.lkmCustomerId=${model.id}');">联系人</button>
	<button class="common_button" onclick="to('<%=path%>/cus/CstActivityAction_loadAllCstActivitys?cstActivityQueryDTO.atvCustomerId=${model.id}');">交往记录</button>
	<button class="common_button" onclick="to('<%=path%>/basd/OrdersAction_loadAllOrders?ordersQueryDTO.odrCustomer=${model.custName}');">历史订单</button>
	
	<button class="common_button" onclick="to('<%=path %>/cus/CstCustomerAction_loadCstCustomersByManager');">返回</button>
	<button class="common_button" onclick="formCheck('modifyCstCustomer');">保存</button>
</div>
<form name="modifyCstCustomer" action="CstCustomerAction_modifyCstCustomer" method="post" onsubmit="return formCheck(this);">
<input type="hidden" name="id" value="${model.id }"/> 
<input type="hidden" name="custStatus" value="${model.custStatus }"/> 
<table class="query_form_table">
	<tr>
		<th>客户编号</th>
		<td><input type="hidden" name="custNo" value="${model.custNo}">${model.custNo }</td>
		<th>名称</th>
		<td><input name="custName" value="${model.custName }" tip="名称不能为空" reg="^.{1,50}$"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地区</th>
		<td>
			<select name="custRegion.id" tip="请选择地区" reg="^.+$">
				<option value="">请选择...</option>
				<c:forEach items="${customerRegions}" var="region">
						<option value="${region.id }" ${model.custRegion.id eq region.id? "selected=selected" : "" }>${region.dictItem }</option>
				</c:forEach>
			</select>
			<span class="red_star">*</span></td>
		<th>客户经理</th>
		<td>
			<select name="custManager.id" tip="请选择客户经理" reg="^.+$">
				<option value="">请选择...</option>
				<c:forEach items="${requestScope.cstCustomerManagers}" var="manager">
					<option value="${manager.id}" ${manager.id eq model.custManager.id? "selected='selected'":""}>${manager.usrName}</option>
				</c:forEach>
			</select><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>客户等级</th>
		<td>
			<select name="custLevel.id" tip="请选择客户等级" reg="^.+$">
				<option value="">请选择...</option>
				<c:forEach items="${customerLevels}" var="level">
					<option value="${level.id }" ${level.id eq model.custLevel.id ? "selected='selected'":""}>${level.dictItem}</option>
				</c:forEach>
			</select><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
	<tr>
		<th>客户满意度</th>
		<td>
			<select name="custSatisfy" tip="请选择客户满意度" reg="^.+$"><option value="">未指定</option>
					<option value="5" ${model.custSatisfy==5 ? "selected='selected'":""} >☆☆☆☆☆</option>
					<option value="4" ${model.custSatisfy==4 ? "selected='selected'":""}>☆☆☆☆</option>
					<option value="3" ${model.custSatisfy==3 ? "selected='selected'":""}>☆☆☆</option>
					<option value="2" ${model.custSatisfy==2 ? "selected='selected'":""}>☆☆</option>
					<option value="1" ${model.custSatisfy==1 ? "selected='selected'":""}>☆</option></select><span class="red_star">*</span>
		</td>
		<th>客户信用度</th>
		<td>
			<select name="custCredit" tip="请选择客户信用度" reg="^.+$"><option value="">未指定</option>
					<option value="5" ${model.custCredit==5 ? "selected='selected'":""} >☆☆☆☆☆</option>
					<option value="4" ${model.custCredit==4 ? "selected='selected'":""}>☆☆☆☆</option>
					<option value="3" ${model.custCredit==3 ? "selected='selected'":""}>☆☆☆</option>
					<option value="2" ${model.custCredit==2 ? "selected='selected'":""}>☆☆</option>
					<option value="1" ${model.custCredit==1 ? "selected='selected'":""}>☆</option></select><span class="red_star">*</span>
		</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table1">
	<tr>
		<th>地址</th>
		<td><input value="${model.custAddr}" name="custAddr" tip="地址不能为空" reg="^.+$"/><span class="red_star">*</span>
		</td>
		<th>邮政编码</th>
		<td><input value="${model.custZip}" name="custZip" size="20" tip="请输入正确的邮政编码" reg="^\d+$"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>电话</th>
		<td>
			<input value="${model.custTel}" name="custTel" size="20" reg="(^$)|(^1\d{10}$)|^(\d{3,4}-)?\d{7,8}$" tip="请输入正确的号码" /><span class="red_star">*</span></td>
		<th>传真</th>
		<td>
			<input value="${model.custFax}" name="custFax" size="20" tip="传真不能为空" reg="^.+$"/><span class="red_star">*</span>
		</td>
	</tr>	
	<tr>
		<th>网址</th>
		<td>
			<input value="${model.custWebsite}" name="custWebsite" size="20" tip="网址不能为空" reg="^.+$"/><span class="red_star">*</span>
		</td>
		<th>　</th>
		<td>　</td>
	</tr>
</table>
<br />
<table class="query_form_table" id="table2">
	<tr>
		<th>营业执照注册号</th>
		<td><input value="${model.custLicenceNo}" name="custLicenceNo" size="20" /></td>
		<th>法人</th>
		<td><input value="${model.custChieftain}" name="custChieftain"  size="20" tip="法人不能为空" reg="^.+$"/><span class="red_star">*</span>
		</td>
	</tr>
	<tr>
		<th>注册资金（万元）</th>
		<td>
			<input value="${model.custBankroll}" name="custBankroll" size="20" /> </td>
		<th>年营业额</th>
		<td>
			<input value="${model.custTurnover}" name="custTurnover" size="20" />
		</td>
	</tr>	
	<tr>
		<th>开户银行</th>
		<td>
			<input value="${model.custBank}" name="custBank" size="20" tip="开户银行不能为空" reg="^.+$"/><span class="red_star">*</span>
		</td>
		<th>银行帐号</th>
		<td><input value="${model.custBankAccount}" name="custBankAccount" size="20" tip="银行账号不能为空" reg="^.+$"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>地税登记号</th>
		<td>
			<input value="${model.custLocalTaxNo}" name="custLocalTaxNo"  size="20" /></td>
		<th>国税登记号</th>
		<td><input value="${model.custNationalTaxNo}" name="custNationalTaxNo" size="20" /></td>
	</tr>
</table>
</form>
</body>
</html>