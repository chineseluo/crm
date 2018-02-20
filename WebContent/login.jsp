<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户登录 - 客户关系管理系统</title>
	<link href="<%=path%>/css/login.css" rel="stylesheet"/>
	<script type = "text/javascript"  src = "<%=path%>/script/jquery/src/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/script/crm/login.js"></script>
	<c:if test="${responseText ne null}"><%="<script type='text/javascript' >alert('"+request.getAttribute("responseText")+"');</script>"%></c:if>

</head>

<body>
<!----------------------------------------------------------------------------------------->
<div class="header_wrap">
 <!-- <div class="header">
  </div>--->
  <div style="height:6px; width:100%; background-color:#23354d; margin-top:103px"></div>
  
</div>
<!----------------------------------------------------------------------------------------->
<div class="login_main_wrap">
  <div class="login_main">
    <form  action="<%=path%>/sys/loginAction.action?sysUserQueryDTO.opeartorType=login"  method="post" onsubmit="return checkForm();">
      <div class="input_border" ><input class="user_name" type="text" name="sysUserQueryDTO.usrName" id="username" value="用户名/绑定的手机号/邮箱" onblur="UserNameOnblur(this)" onfocus="UserNameOnfocus(this)" /></div>
      <div class="input_border"><input class="user_pwd" type="password" name="sysUserQueryDTO.usrPassword" id="password" /></div>
      <div style="margin-top:20px"><input class="login_sumit" type="submit" id="rptLogin" value="登&nbsp;录" /></div>
    </form>
  </div>
    
</div>
<script type="text/javascript">
    $(".input_border input").focus(function () {
	$(".input_border").removeClass("selected");
	$(this).parent().addClass("selected");
});
</script>
<!----------------------------------------------------------------------------------------->
<div class="footer_wrap">
  <div style="height:8px; width:100%; background-color:#23354d;"></div>
</div>
<!----------------------------------------------------------------------------------------->
</body>
</html>

