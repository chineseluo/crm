<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script type="text/javascript">
	$(document).ready(function(){
		$("span").hide();
		var splitResult = result.split(",");
		for(var i = 0 ; i < splitResult.length ; i++){
			var text = splitResult[i];
			$("span[name='"+text+"']").show();
		}
	});
</script>


</head>

<%
	String result = (String)session.getAttribute("rightStr");
	out.print("<script type='text/javascript'> var result = '"+result+"'</script>");

%>
<body>

<div class="page_title">销售机会管理</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<span name="添加销售机会">
	<button class="common_button" onclick="to('<%=path %>/~sale/add.jsp');">新建</button> 
	</span>
	<span name="查看销售机会">
	<button class="common_button" onclick="search();">查询</button>
	</span>
	</div>
	<form name="loadSalChanceByCondictionForm" action="<%=path %>/sale/loadAllSalChanceAction.action" method="post">
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
		<td class="list_data_op">
			<c:if test="${sessionScope.userDto.sysRole.roleName == '销售主管' }">
			<span name="指派销售机会">
				<img onclick="to('<%=path %>/sale/dispatchSalChanceAction.action?salChanceQueryDto.id=${salChanceDTO.id }&salChanceQueryDto.anotherOptionType=dispatch');" title="指派" src="../images/bt_linkman.gif" class="op_button" />
			</span>
			</c:if>	
			<span name="编辑销售机会">		
			<img onclick="to('<%=path %>/sale/loadSalChanceByIdAction.action?salChanceQueryDto.id=${salChanceDTO.id }&salChanceQueryDto.anotherOptionType=edit');" title="编辑" src="../images/bt_edit.gif" class="op_button" />			
			</span>
			<span name="删除销售机会">
			<c:if test="${(sessionScope.userDto.usrName == salChanceDTO.chcCreateBy) or (sessionScope.userDto.sysRole.roleName == '销售主管')}">
			<img onclick="del('${salChanceDTO.chcCustName }',${salChanceDTO.id });" title="删除" src="../images/bt_del.gif" class="op_button" />
			</c:if>
			</span>	
		</td>
	</tr>
	</c:forEach>
	<tr>
		<form name="loadSalChanceByPageForm" action="<%=path %>/sale/loadAllSalChanceAction.action" method="post" >
		<th colspan="7" class="pager">
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
			</div>
		</th>
		</form>
	</tr>
</table>
</body>
</html>