<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
<script src="<%=path%>/script/common.js"></script>
<script src="<%=path%>/script/crm/~basd/BasDict.js"></script>
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
	String result = (String) session.getAttribute("rightStr");
	out.print("<script type='text/javascript'> var result = '" + result + "'</script>");
%>
<body>
	<div class="page_title">当前位置:基础数据 &gt;&gt;数据字典管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="to('../~basd/dict_add.jsp');">新建</button>
		<button class="common_button" onclick="search('loadDictByTIVForm');">查询</button>
	</div>
	<form action="<%=path%>/basd/loadAllBasDictsAction.action" method="post" name="loadDictByTIVForm">
		<table class="query_form_table">
			<tr>
				<th>类别</th>
				<td><input name="basDictQueryDTO.dictType" value="${requestScope.queryCondition.dictType }" /></td>
				<th>条目</th>
				<td><input name="basDictQueryDTO.dictItem" value="${requestScope.queryCondition.dictItem }" /></td>
				<th>值</th>
				<td><input name="basDictQueryDTO.dictValue" value="${requestScope.queryCondition.dictValue }" /></td>
			</tr>
		</table>
		<!--<input type="hidden" name="basDictQueryDTO.opeartorType" value="search"/>  -->
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>类别</th>
			<th>条目</th>
			<th>值</th>
			<th>是否可编辑</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list }" var="dictDTO" varStatus="vs">
			<tr>
				<td class="list_data_number">${dictDTO.id }</td>
				<td class="list_data_ltext">${dictDTO.dictType }</td>
				<td class="list_data_text">${dictDTO.dictItem }</td>
				<td class="list_data_text">${dictDTO.dictValue }</td>
				<td class="list_data_text">${dictDTO.dictIsEditable == 1 ? "是" : "否" }</td>
				<td class="list_data_op"><c:if test="${dictDTO.dictIsEditable eq 1 }">
						<span title="编辑数据字典管理"> <img onclick="to('<%=path%>/basd/loadBasDictByIdAction.action?oper=modify&BasDictQueryDTO.id=${dictDTO.id }');" title="编辑数据字典管理" src="<%=path %>/images/bt_edit.gif" class="op_button" />
						</span>
						<span title="删除数据字典管理"> <img onclick="del('${dictDTO.dictType }',${dictDTO.id });" title="删除数据字典管理" src="<%=path %>/images/bt_del.gif" class="op_button" />
						</span>
					</c:if></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/basd/loadAllBasDictsAction.action" method="post" name="loadBasDictByPaggingForm">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页<input name="basDictQueryDTO.pageSizes" size="2" value="${requestScope.pageResult.pageSize }" />条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'loadBasDictByPaggingForm')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'loadBasDictByPaggingForm')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'loadBasDictByPaggingForm')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'loadBasDictByPaggingForm')">最后一页</a> 转到<input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>

						<input type="hidden" name="basDictQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> <input type="hidden" name="basDictQueryDTO.dictType" id="queryDictType" value="${requestScope.queryCondition.dictType }" /> <input type="hidden" name="basDictQueryDTO.dictItem" id="queryDictItem" value="${requestScope.queryCondition.dictItem }" /> <input type="hidden" name="basDictQueryDTO.dictValue" id="queryDictValue" value="${requestScope.queryCondition.dictValue }" />
					</div>
					<!--<input type="hidden" name="basDictQueryDTO.opeartorType" value="search"/>  -->
				</form>
			</th>
		</tr>
	</table>
</body>
</html>