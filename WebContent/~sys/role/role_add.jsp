<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title>毕业设计项目</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
<meta http-equiv="Pragma" content="no-cache"></meta>
<meta http-equiv="Cache-Control" content="no-cache"></meta>
<meta http-equiv="Expires" content="0"></meta>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css"></link>
<link href="<%=path %>/script/jquery/css/tree.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/script/jquery/src/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=path%>/script/jquery/src/Plugins/jquery.tree.js"></script>
<script src="<%=path %>/script/common.js"></script>
<script src="<%=path %>/script/crm/~sys/SysRole.js"></script>
<script type="text/javascript">
        var userAgent = window.navigator.userAgent.toLowerCase();
        $.browser.msie8 = $.browser.msie && /msie 8\.0/i.test(userAgent);
        $.browser.msie7 = $.browser.msie && /msie 7\.0/i.test(userAgent);
        $.browser.msie6 = !$.browser.msie8 && !$.browser.msie7 && $.browser.msie && /msie 6\.0/i.test(userAgent);
        function load() {        
            var o = {showcheck: true,
              url: "<%=path %>/sys/loadRightsAction.action" 
            };
            $("#tree").treeview(o);            
        }   
        if( $.browser.msie6)
        {
            load();
        }
        else{
            $(document).ready(load);
        }
    </script>
</head>
<body>
<div class="page_map">当前位置:权限管理 >> 角色管理 >> 新建角色</div>
<div class="button_bar">
	<button class="common_button" onclick="help('');">帮助</button>
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" id="sysRoleSave" onclick="addRole()">保存</button>  
</div>
<form name="sysRoleAddForm" action="<%=path%>/sys/addRoleAction.action" method="post">
<table class="query_form_table">
	<tr>
		<th>角色名</th>
		<td><input name="sysRoleDTO.roleName"/><span class="red_star">*</span></td>
		<th>角色描述</th>
		<td>
			<input name="sysRoleDTO.roleDesc" size="50" type="text"/><span class="red_star">*</span></td>
	</tr>
	<tr>
		<th>权限</th>
		<td>
			<div id="tree"></div>
        </td>
		<th>状态</th>
		<td>正常<input type="hidden" name="sysRoleDTO.roleFlag" value="1"/></td>
	</tr>	
</table>
</form>
</body>
</html>