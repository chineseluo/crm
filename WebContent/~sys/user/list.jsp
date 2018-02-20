<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script src="<%=path%>/script/crm/~sys/SysUser.js"></script>
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
	<div class="page_map">
		<div class="left">当前位置:权限管理>>用户管理</div>
		<div class="right">
			<span name="新增用户"> <img src="<%=path%>/images/bt_add.png" />
				<a
				href="<%=path%>/sys/loadAllNormalRoleAction.action?sysRoleQueryDTO.roleFlag=1">新增用户</a>
			</span>
		</div>
	</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button"
			onclick="search('loadUserByNameAndFlagForm');">查询</button>
	</div>
	<form action="<%=path%>/sys/loadAllUsersAction.action" method="post"
		name="loadUserByNameAndFlagForm">
		<table class="query_form_table">
			<tr>
				<th>用户名</th>
				<td><input name="sysUserQueryDTO.usrName"  value="${requestScope.queryCondition.usrName }"/></td>
				<th>状态</th>
				<td><select name="sysUserQueryDTO.usrFlag">
						<option value="">全部</option>
						<option value="1" ${requestScope.queryCondition.usrFlag == 1 ? "selected=selected" : "" }>正常</option>
						<option value="0" ${requestScope.queryCondition.usrFlag == 0 ? "selected=selected" : "" }>已删除</option>
				</select></td>
			</tr>
		</table>
		<input type="hidden" name="sysUserQueryDTO.opeartorType" value="search"/>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>序号</th>
			<th>用户编号</th>
			<th>用户名</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list }" var="userDTO" varStatus="vs">
			<tr>
				<td class="list_data_number">${vs.index }</td>
				<td class="list_data_text">${userDTO.id }</td>
				<td class="list_data_ltext">${userDTO.usrName }</td>
				<td class="list_data_text">${userDTO.usrFlag == 1 ? "正常" : "已删除" }</td>
				<td class="list_data_op"><span name="查看用户详细信息"> <img
						onclick="to('<%=path%>/sys/loadUserByIdAction.action?oper=detail&sysUserQueryDTO.id=${userDTO.id }');"
						title="查看用户详细信息" src="<%=path %>/images/bt_detail.gif"
						class="op_button" /> 查看用户详细信息
				</span> <span name="编辑用户"> <img
						onclick="to('<%=path%>/sys/loadUserByIdAction.action?oper=modify&sysUserQueryDTO.id=${userDTO.id }');"
						title="编辑用户" src="<%=path %>/images/bt_edit.gif" class="op_button" />
						编辑用户
				</span> 
					<c:if test="${userDTO.usrFlag eq 1 }">
						<span name="删除用户"> <img
							onclick="del('${userDTO.usrName }',${userDTO.id });" title="删除用户"
							src="<%=path %>/images/bt_del.gif" class="op_button" /> 删除用户
						</span>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<form action="<%=path%>/sys/loadAllUsersAction.action" method="post"
		name="loadUserByPaggingForm">
			<th colspan="100" class="pager">
				<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页<input name="sysUserQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }"/>条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页
						<a href="#" onclick="setPage(1,'loadUserByPaggingForm')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'loadUserByPaggingForm')">上一页</a>
						<a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'loadUserByPaggingForm')">下一页</a>
						<a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'loadUserByPaggingForm')">最后一页</a>
						转到<input  size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)"/>页
						<button type="submit">GO</button>

						<input type="hidden" name="sysUserQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}"  />
						<input type="hidden" name="sysUserQueryDTO.usrName" id="queryUsrName"  value="${requestScope.queryCondition.usrName }" /> 
						<input type="hidden" name="sysUserQueryDTO.usrFlag" id="queryUsrFlag"  value="${requestScope.queryCondition.usrFlag }" />
				</div>
			</th>
			<input type="hidden" name="sysUserQueryDTO.opeartorType" value="search"/>
			</form>
		</tr>
	</table>
</body>
</html>