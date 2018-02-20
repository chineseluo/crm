<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~ser/CstService.js"></script>
</head>
<body>

	<div class="page_title">客户服务管理 &gt; 服务分配</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="search('searchForm');">查询</button>
	</div>
	<form name="searchForm" action="<%=path%>/service/CstServiceAction_toDispatchCstServicePage" method="post">

		<table class="query_form_table" height="53">
			<tr>
				<th height="28">客户</th>
				<td><input name="cstServiceQueryDTO.svrCustName" value="${requestScope.queryCondition.svrCustName}" /></td>
				<th height="28">概要</th>
				<td><input name="cstServiceQueryDTO.svrTitle" value="${requestScope.queryCondition.svrTitle}" /></td>
				<th height="28">服务类型</th>
				<td><select name="cstServiceQueryDTO.svrTypeId">
						<option value="" ${requestScope.queryCondition.svrTypeId == null ? "selected='selected'" : "" }>全部</option>
						<c:forEach items="${svrTypeList }" var="svrType">
							<option value="${svrType.id }" ${requestScope.queryCondition.svrTypeId eq svrType.id ? "selected='selected'" : ""}>${svrType.dictItem }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th height="22">创建日期</th>
				<td colspan="3">
					<input name="cstServiceQueryDTO.svrCreateDateFrom" id="date01" readonly="readonly" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'date02\')}',dateFmt:'yyyy-MM-dd 00:00:00'})" value="<fmt:formatDate value="${requestScope.queryCondition.svrCreateDateFrom }" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
					到 <input name="cstServiceQueryDTO.svrCreateDateTo" id="date02" readonly="readonly" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'date01\')}',dateFmt:'yyyy-MM-dd 23:59:59'})" value="<fmt:formatDate value="${requestScope.queryCondition.svrCreateDateTo }" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
				</td>
				<th height="22">状态</th>
				<td><select disabled="disabled" name="cstServiceQueryDTO.svrStatus">
						<c:forEach items="${svrStatusList }" var="svrStatus">
							<option value="${svrStatus}" ${requestScope.queryCondition.svrStatus eq svrStatus ? "selected='selected'" : ""}>${svrStatus }</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>客户</th>
			<th>概要</th>
			<th>服务类型</th>
			<th>创建人</th>
			<th>创建日期</th>
			<th>分配给</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${requestScope.pageResult.list }" var="service">
			<tr>
				<td class="list_data_number">${service.id }</td>
				<td class="list_data_text">${service.svrCustName }</td>
				<td class="list_data_ltext">${service.svrTitle }</td>
				<td class="list_data_text">${service.svrTypeDTO.dictItem }</td>
				<td class="list_data_text">${service.svrCreateBy }</td>
				<td class="list_data_text"><fmt:formatDate value="${service.svrCreateDate }" pattern="yyyy年MM月dd日" /></td>
				<td class="list_data_text">
					<form action="<%=path%>/service/CstServiceAction_dispatchCstServiceBySale" method="post">
						<input type="hidden" value="${service.id }" name="id"/>
						<select name="svrDueDTO.id" tip="请选择客户经理" reg="^.+$">
							<option value="">请选择...</option>
							<c:forEach items="${svrManagerList }" var="manager">
								<option value="${manager.id }" ${manager.id eq service.svrDealerDTO.id ? "selected='selected'":"" }>${manager.usrName }</option>
							</c:forEach>
						</select>
						<button class="common_button" type="button" onclick="dispatchForm(this);">分配</button>
					</form>

				</td>
				<td class="list_data_op"><img onclick="del('${service.svrTitle}','<%=path %>/service/CstServiceAction_removeCstServiceBySale?id=${service.id }');" title="删除" src="<%=path %>/images/bt_del.gif" class="op_button" /></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<form action="<%=path%>/service/CstServiceAction_toDispatchCstServicePage" method="post" name="pagingForm">
					<div class="pager">
						共${requestScope.pageResult.recTotal }条记录 每页 <input name="cstServiceQueryDTO.pageSize" size="2" value="${requestScope.pageResult.pageSize }" /> 条 第${requestScope.pageResult.currentPage }页/共${requestScope.pageResult.totalPage }页 <a href="#" onclick="setPage(1,'pagingForm')">第一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage - 1 < 1 ? 1:requestScope.pageResult.currentPage - 1},'pagingForm')">上一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.currentPage + 1 > requestScope.pageResult.totalPage ? requestScope.pageResult.totalPage:requestScope.pageResult.currentPage + 1},'pagingForm')">下一页</a> <a href="#" onclick="setPage(${requestScope.pageResult.totalPage},'pagingForm')">最后一页</a> 转到 <input size="2" id="ownerPageNum" value="${requestScope.pageResult.currentPage }" onblur="setNavigatePage(this.value)" />页
						<button type="submit">GO</button>
						<input type="hidden" name="cstServiceQueryDTO.currentPage" id="queryCurrentPage" value="${requestScope.pageResult.currentPage}" /> <input type="hidden" name="cstServiceQueryDTO.svrCustName" id="querySvrCustName" value="${requestScope.queryCondition.svrCustName}" /> <input type="hidden" name="cstServiceQueryDTO.svrTitle" id="querySvrTitle" value="${requestScope.queryCondition.svrTitle}" /> <input type="hidden" name="cstServiceQueryDTO.svrTypeId" id="querySvrTypeId" value="${requestScope.queryCondition.svrTypeId}" /> <input type="hidden" name="cstServiceQueryDTO.svrCreateDateFrom" id="querySvrCreateDateFrom" value="${requestScope.queryCondition.svrCreateDateFrom}" /> <input type="hidden" name="cstServiceQueryDTO.svrCreateDateTo" id="querySvrCreateDateTo" value="${requestScope.queryCondition.svrCreateDateTo}" /> <input type="hidden" name="cstServiceQueryDTO.svrStatus" id="querySvrStatus" value="${requestScope.queryCondition.svrStatus}" />
					</div>
				</form>
			</th>
		</tr>
	</table>
</body>
</html>