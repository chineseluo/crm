<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path =request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户关系管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript">
	function logout(){
		window.parent.location.href="<%=path%>/sys/loginoutAction.action";	
	}
	
</script>
</head>

<body>

<TABLE style="width:100%; color:#5687C8; font-weight:bold;">
<TR >
	<td ><img src="images/logo.jpg"></td>
	<td width="25%" align="right" style="font-size:12px;" valign="bottom">
		当前用户：${sessionScope.userDto.usrName }（${sessionScope.userDto.sysRole.roleName }）&nbsp;&nbsp; 
		<a onclick="logout()" href="#">退出系统</a>
	 </td>
</tr>
</table>
</body>
</html>
