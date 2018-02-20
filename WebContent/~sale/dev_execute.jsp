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
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/crm/~sale/SalChance.js"></script>
<script src="<%=path %>/script/common.js"></script>
</head>
<body>

<div class="page_title">客户开发计划 &gt; 执行计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<span name="">
	<button class="common_button" onclick="stopSalPlan(${requestScope.salChanceDto.id })">终止开发</button>
	</span>
	<button class="common_button" onclick="back();">返回</button>
	<span name="制定计划">
	<button class="common_button" onclick="to('<%=path %>/sale/developmentPlanAction.action?salChanceQueryDto.id=${requestScope.salChanceDto.id }');">制定计划</button>
	</span>
	<span name="查看完成开发计划">
	<button class="common_button" onclick="to('<%=path %>/sale/developmentSuccessAction.action?salChanceQueryDto.id=${requestScope.salChanceDto.id }');">开发成功</button>
	</span>
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
		<th>日期</th>
		<th>计划</th>
		<th>执行效果</th>
	</tr>
	
	<c:forEach items="${requestScope.salPlanDtoList }" var="salPlanDto">
	<c:if test="${salPlanDto.plaResult != null}">
	<tr>
		<td class="list_data_text"><fmt:formatDate value="${salPlanDto.plaDate }" pattern="yyyy-MM-dd" /></td>
		<td class="list_data_ltext">${salPlanDto.plaToDo }</td>
		<td class="list_data_ltext">${salPlanDto.plaResult }</td>	
	</tr>
	</c:if>
	</c:forEach>
	
	<c:forEach items="${requestScope.salPlanDtoList }" var="salPlanDto" varStatus="vs">
	<c:if test="${salPlanDto.plaResult == null}">
	<tr>
		<td class="list_data_text"><fmt:formatDate value="${salPlanDto.plaDate }" pattern="yyyy-MM-dd" /></td>
		<td class="list_data_ltext">${salPlanDto.plaToDo }</td>
		<td class="list_data_ltext"><input id="result${vs.index }" value="${salPlanDto.plaResult }" />　
		<span name="">
		<button class="common_button" onclick="saveExecutePlan(${salPlanDto.id },${vs.index },${requestScope.salChanceDto.id });">保存</button>
		</span>
		</td>
		
	</tr>
	</c:if>
	</c:forEach>
	</table>
</body>
</html>