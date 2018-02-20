<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/inc.jsp" %>
<script src="<%=path%>/script/crm/~basd/BasDict.js"></script>
<style type="text/css">
<!--

#dictTypeTip {
	position: absolute;
	color: #004a7e;
	font-size: 14px;
	font-family: Arial, Helvetica, sans-serif;
	background-color:#FFFFFF;
}

#dictTypeTip.show {
	border: 1px solid #004a7e;
}

#dictTypeTip.hide {
	border: none;
}

ul {
	list-style: none;
	margin: 0px;
	padding: 0px;
}

li{
	cursor:pointer;
}

li.mouseover {
	background-color: #004a7e;
	color: #FFFFFF;
}

li.mouseout {
	background-color: #FFFFFF;
	color: #004a7e;
}
-->
</style>
</head>
<body>
	<div class="page_title">数据字典管理 &gt; 新建数据字典条目</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="addDict('basDictAddForm');">保存</button>
	</div>
	<form name="basDictAddForm" action="<%=path%>/basd/saveBasDictAction.action" method="post">
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input type="text" name="basDictDTO.id" disabled="disabled"/></td>
				<th>类别</th>
				<td><input name="basDictDTO.dictType" tip="类别不能为空" reg="^.+$" value="${requestScope.dictDTO.dictType}" />
					<div id="dictTypeTip"><ul></ul></div> <span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>条目</th>
				<td><input name="basDictDTO.dictItem" value="${requestScope.dictDTO.dictItem}" tip="条目不能为空" reg="^.+$"/> <span class="red_star">*</span></td>
				<th>值</th>
				<td><input name="basDictDTO.dictValue" value="${requestScope.dictDTO.dictValue}" tip="值不能为空" reg="^.+$"/> <span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>是否可编辑</th>
				<td><select name="basDictDTO.dictIsEditable">
						<option value="1" ${requestScope.dictDTO.dictIsEditable == 1 ? "seected=selected" : "" }>是</option>
						<option value="0" ${requestScope.dictDTO.dictIsEditable == 0 ? "seected=selected" : "" }>否</option>
				</select></td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>