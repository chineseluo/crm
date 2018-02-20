<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~ser/CstService.js"></script>
</head>
<body>

<div class="page_title">客户服务管理 &gt; 服务处理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="to('<%=path%>/service/CstServiceAction_toFeedbackCstServicePage');">返回</button> 
	<button class="common_button" onclick="formCheck('editFrom');">保存</button>  
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
<form action="<%=path%>/service/CstServiceAction_feedbackCstServiceByManager" name="editFrom" method="post">
	<input type="hidden" name="id" value="${model.id }"/>
	<table class="query_form_table" id="table2">
		<tr>
			<th>处理结果</th>
			<td><input name="svrResult" size="20" value="${model.svrResult }" tip="处理结果不能为空" reg="^.+$"/><span class="red_star">*</span></td>
			<th>满意度</th>
			<td>
				<select name="svrSatisfy" tip="请选择客户满意度" reg="^.+$">
					<option value="">请选择...</option>
					<option value="5" ${model.svrSatisfy==5?"selected='selected'":"" }>☆☆☆☆☆</option>
					<option value="4" ${model.svrSatisfy==4?"selected='selected'":"" }>☆☆☆☆</option>
					<option value="3" ${model.svrSatisfy==3?"selected='selected'":"" }>☆☆☆</option>
					<option value="2" ${model.svrSatisfy==2?"selected='selected'":"" }>☆☆</option>
					<option value="1" ${model.svrSatisfy==1?"selected='selected'":"" }>☆</option>
				</select><span class="red_star">*</span></td>
		</tr>
	</table>
</form>
</body>
</html>