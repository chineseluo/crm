<%@page import="org.jb.crm.sys.dto.SysRoleDTO"%>
<%@page import="org.jb.common.bean.Page"%>
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
<script type = "text/javascript"  src = "<%=path %>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script type="text/javascript" src="<%=path%>/script/crm/~sys/SysRole.js"></script>

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
		<div class="left">当前位置:权限管理>>角色管理</div>
		<div class="right">
			<span name="新增角色">
				<img src="<%=path%>/images/bt_add.png" />
				<a href="<%=path%>/~sys/role/role_add.jsp">新增角色</a>
			</span>
		</div>
	</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="search('loadRoleByNameAndFlagForm');">查询</button>
	</div>
	<form action="<%=path%>/sys/loadAllRolesAction.action" method="post" name="loadRoleByNameAndFlagForm">
		<table class="query_form_table">
			<tr>
				<th>角色名</th>
				<td><input name="sysRoleQueryDTO.roleName" value="${requestScope.queryCondition.roleName }"/></td>
				<th>状态</th>
				<td><select name="sysRoleQueryDTO.roleFlag">
						<option value="">全部</option>
						<option value="1" ${requestScope.queryCondition.roleFlag == 1 ? "selected=selected" :"" }>正常</option>
						<option value="0" ${requestScope.queryCondition.roleFlag == 0 ? "selected=selected" :"" }>已删除</option>
				</select></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>序号</th>
			<th>角色编号</th>
			<th>角色名</th>
			<th>角色描述</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list }" var="roleDTO" varStatus="vs">
				<tr>
					<td class="list_data_number">${vs.index}</td>
					<td class="list_data_text">${roleDTO.id }</td>
					<td class="list_data_ltext">${roleDTO.roleName }</td>
					<td class="list_data_text">${roleDTO.roleDesc }</td>
					<td class="list_data_text">${roleDTO.roleFlag == 0 ? "已删除" : "正常" }</td>
					<td class="list_data_op">
					<span name="查看角色信息">
						<img onclick="to('<%=path%>/sys/loadRoleByIdAction.action?oper=detail&sysRoleQueryDTO.id=${roleDTO.id }');" title="查看角色信息" src="<%=path%>/images/bt_detail.gif" class="op_button" />
						查看角色信息
					</span>
					<span name="编辑角色">
						<img onclick="to('<%=path%>/sys/loadRoleByIdAction.action?oper=modify&sysRoleQueryDTO.id=${roleDTO.id }');" title="编辑角色" src="<%=path%>/images/bt_edit.gif" class="op_button" />
						编辑角色
					</span>
						<c:if test="${roleDTO.roleFlag eq 1 }">
							<span name="删除角色">
								<img onclick="delRole('${roleDTO.roleName }',${roleDTO.id });" title="删除角色" src="<%=path%>/images/bt_del.gif" class="op_button" />
								删除角色
							</span>
						</c:if>
					
					</td>
				</tr>
			</c:forEach>
		<tr>
			<%
				Page<SysRoleDTO> pageResult = (Page<SysRoleDTO>)request.getAttribute("pageResult");
			%>
			<form name="loadRolesPaggingForm" action="<%=path%>/sys/loadAllRolesAction.action" method="post">
			<th colspan="100" class="pager">
				<div class="pager">
					共<%=pageResult.getRecTotal() %>条记录 每页<input name="sysRoleQueryDTO.pageSize"  size="2" value="<%=pageResult.getPageSize()%>"/>条 第<%=pageResult.getCurrentPage() %>页/共<%=pageResult.getTotalPage() %>页
					<a href="#" onclick="setPage(1,'loadRolesPaggingForm')">第一页</a> 
					<a href="#" onclick="setPage(<%=pageResult.getCurrentPage()-1 < 1 ? 1 : pageResult.getCurrentPage()-1%>,'loadRolesPaggingForm')">上一页</a> 
					<a href="#" onclick="setPage(<%=pageResult.getCurrentPage() + 1 > pageResult.getTotalPage() ? pageResult.getTotalPage() : pageResult.getCurrentPage() + 1 %>,'loadRolesPaggingForm')">下一页</a> <a
						href="#" onclick="setPage(<%=pageResult.getTotalPage() %>,'loadRolesPaggingForm')">最后一页</a> 转到<input size="2" id="ownerPageNum" onblur="setNavigatePage(this.value)" value="<%=pageResult.getCurrentPage()%>"/>页
					<button type="submit">GO</button>
					<input type="hidden" name="sysRoleQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage }" />
					<input type="hidden" name="sysRoleQueryDTO.roleName" id="queryRoleName" value="${requestScope.queryCondition.roleName}"/>
					<input type="hidden" name="sysRoleQueryDTO.roleFlag" id="queryRoleFlag" value="${requestScope.queryCondition.roleFlag}"/>
				</div>
			</th>
			</form>
		</tr>
	</table>
</body>
</html>