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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/script/easyvalidator/css/validate.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/easyvalidator/js/easy_validator.pack.js"></script>
<script src="<%=path%>/script/easyvalidator/js/jquery.bgiframe.min.js"></script>
<script src="<%=path%>/script/crm/~sale/SalChance.js"></script>
<script src="<%=path %>/script/common.js"></script>
<script src="<%=path %>/script/My97DatePicker/WdatePicker.js"></script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 制定计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<span name="查看执行开发计划">
	<button class="common_button" onclick="executeSalPlan(${requestScope.salChanceDto.id });">执行计划</button>
	</span>
	<button class="common_button" onclick="back();">返回</button>
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
		<td>&nbsp;${requestScope.salChanceDto.chcRate }</td>
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
	<tr>
		<th>指派给</th>
		<td>${requestScope.salChanceDto.chcDueTo }</td>
		<th>指派时间</th>
		<td><fmt:formatDate value="${requestScope.salChanceDto.chcDueDate }" pattern="yyyy-MM-dd" /></td>
	</tr>
</table>
<br />

<table class="data_list_table" id="table1">
	<tr>
		<th width="150px">日期</th>
		<th height="31">计划项</th>
	</tr>
	
	<c:forEach items="${requestScope.salPlanDtoList }" var="salPlanDto" varStatus="vs">
	<c:if test="${salPlanDto.plaResult != null}">
	<tr>
		<td class="list_data_text" height="24"><fmt:formatDate value="${salPlanDto.plaDate }" pattern="yyyy-MM-dd" /></td>
		<td class="list_data_ltext" height="24">${salPlanDto.plaToDo }
		<input type = "hidden" id="salChanceId" value="${salPlanDto.id }" >
		</td>
	</tr>
	</c:if>
	</c:forEach>
	
	<c:forEach items="${requestScope.salPlanDtoList }" var="salPlanDto" varStatus="vs">
	<c:if test="${salPlanDto.plaResult == null}">
	<tr>
		<td class="list_data_text" height="24"><fmt:formatDate value="${salPlanDto.plaDate }" pattern="yyyy-MM-dd" /></td>
		<td class="list_data_ltext" height="24"><input size="50" id="toDo${vs.index }" value="${salPlanDto.plaToDo }"/>
	<button class="common_button" onclick="updateSalPlan(${salPlanDto.id },${vs.index },${requestScope.salChanceDto.id });">更改</button>
	<button class="common_button" onclick="deleteSalPlan(${salPlanDto.id },${requestScope.salChanceDto.id });">删除</button>
		</td>
	</tr>
	</c:if>
	</c:forEach>
</table>

<div class="button_bar">
	<span name="保存客户开发计划">
	<button class="common_button" onclick="savePlan();">保存</button>
	</span>
	</div>
<form action="<%=path %>/sale/savePlanAction.action" method="post" name="savePlanForm">
<table class="query_form_table" id="table2">
	<tr>
		<th>日期</th>
		<td><input name="salPlanDto.plaDate" id="d233" onFocus="WdatePicker({startDate:'%y-%M-01 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true})" tip="不能为空" class="Wdate" reg="^.+$"/><span class="red_star">*</span></td>
		<th>计划项</th>
		<td>
			<input size="50" name="salPlanDto.plaToDo" tip="不能为空,且请不要超过250个字符" reg="^.{1,250}$"/><span class="red_star">*</span>
		</td>
	</tr>
</table>
<input type="hidden" name="salPlanDto.salChanceDTO.id" value="${requestScope.salChanceDto.id }">
<input type="hidden" name="salChanceQueryDto.id" value="${requestScope.salChanceDto.id }">
</form>

<script>
</script>
</body>
</html>