<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div class="page_title">客户开发计划</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="searchDispatchSalChance();">查询</button> 
	</div>
<form name="loadAllDispatcheSalChanceForm" action="<%=path %>/sale/loadAllDispatcheSalChanceAction.action" method="post">
 	<table class="query_form_table">
	  <tr>
		<th>客户名称</th>
		<td><input name="salChanceQueryDto.chcCustName" value="${requestScope.queryCondition.chcCustName }"/></td>
		<th>概要</th>
		<td><input name="salChanceQueryDto.chcTitle" value="${requestScope.queryCondition.chcTitle }" /></td>
		<th>联系人</th>
		<td>
			<input name="salChanceQueryDto.chcLinkMan" size="20" value="${requestScope.queryCondition.chcLinkMan }"/>
		</td>
	  </tr>
	  <input type="hidden" name="salChanceQueryDto.optionType" value="dispatched"/>
	</table>
</form>
<br />
<table class="data_list_table">
	<tr>
		<th>编号</th>
		<th>客户名称</th>
		<th>概要</th>
		<th>联系人</th>
		<th>联系人电话</th>
		<th>创建时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	
	<c:forEach items="${requestScope.pageResult.list }" var="salChanceDTO" varStatus="vs">
	<tr>
		<td class="list_data_number">${vs.index + 1}</td>
		<td class="list_data_text">${salChanceDTO.chcCustName }</td>
		<td class="list_data_ltext">${salChanceDTO.chcTitle }</td>
		<td class="list_data_text">${salChanceDTO.chcLinkMan }</td>
		<td class="list_data_text">${salChanceDTO.chcTel }</td>
		<td class="list_data_text"><fmt:formatDate value="${salChanceDTO.chcCreateDate }" pattern="yyyy-MM-dd" /></td>
		<c:if test="${salChanceDTO.chcStatus=='2' }">
		<td class="list_data_text">开发中</td>		
		<td class="list_data_op">
		<span name="制定计划">
			<img onclick="to('<%=path %>/sale/developmentPlanAction.action?salChanceQueryDto.id=${salChanceDTO.id }');" title="制定计划" src="../images/bt_plan.gif" class="op_button" />
		</span>
		<span name="查看执行开发计划">	
			<img onclick="executeSalPlan(${salChanceDTO.id });" title="执行计划" src="../images/bt_feedback.gif" class="op_button" />
		</span>
		<span name="查看完成开发计划">	
			<img onclick="to('<%=path %>/sale/developmentSuccessAction.action?salChanceQueryDto.id=${salChanceDTO.id }')" title="开发成功" src="../images/bt_yes.gif" class="op_button" />
		</span>
		</td>
		</c:if>
		
		<c:if test="${salChanceDTO.chcStatus =='3' }">
		<td class="list_data_text">已归档</td>
		<td class="list_data_op">
			<img onclick="to('<%=path %>/sale/viewTheFalseSalchanceAction.action?salChanceQueryDto.id=${salChanceDTO.id }');" title="查看" src="../images/bt_detail.gif" class="op_button" />
		</td>
		</c:if>
		
	</tr>
	</c:forEach>
	<tr>
		<form name="loadSalChanceByPageForm" action="<%=path %>/sale/loadAllDispatcheSalChanceAction.action" method="post" >
		<th colspan="8" class="pager">
			<div class="pager">
				共${requestScope.pageResult.recTotal }条记录 每页<input name="salChanceQueryDto.pageSize" value="${requestScope.pageResult.pageSize }" size="2" />条
				 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页
				<a href="#" onclick="setPage(1)">第一页</a>
				<a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1})">上一页</a>
				<a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1})">下一页</a>
				<a href="#" onclick="setPage(${requestScope.pageResult.totalPage})">最后一页</a>
				转到<input  size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)"/>页
				<button type="submit">GO</button>
				
				<input type="hidden" name="salChanceQueryDto.pageNum" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}"  />
				<input type="hidden" name="salChanceQueryDto.chcCustName" id="chcCustName" value="${requestScope.queryCondition.chcCustName }"/>
				<input type="hidden" name="salChanceQueryDto.chcTitle" id="chcTitle" value="${requestScope.queryCondition.chcTitle }"/>
				<input type="hidden" name="salChanceQueryDto.chcLinkMan" id="chcLinkMan" value="${requestScope.queryCondition.chcLinkMan }"/>
				<input type="hidden" name="salChanceQueryDto.optionType" value="dispatched"/>
			</div>
		</th>
		</form>
	</tr>
</table>
</body>
</html>