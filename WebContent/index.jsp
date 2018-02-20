<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
	<title>客户关系管理系统</title>
	<meta charset ="utf-8" />
	<link type="text/css" href="<%=path %>/script/jquery/css/ui-lightness/jquery-ui-1.8.5.custom.css" rel="stylesheet" />
	<link type="text/css" href="<%=path %>/script/jquery/css/jquery.layout.css" rel="stylesheet" />
	<link type="text/css" href="<%=path %>/script/jquery/css/myStyle.css" rel="stylesheet" />
	<script type = "text/javascript"  src = "<%=path %>/script/jquery/src/jquery-1.4.2.min.js"></script>
	<script type = "text/javascript"  src = "<%=path %>/script/jquery/src/jquery.layout.js"></script>
	<script type="text/javascript" src="<%=path %>/script/jquery/src/jquery-ui-1.8.5.custom.min.js"></script>
	<script type = "text/javascript">
		$(document).ready(function(){
			
			
			
			//进行权限控制
			$("#accordion > div").hide();
			$("#accordion > div li").hide();
			
			
			var splitResult = result.split(",");
			for(var i = 0 ; i < splitResult.length ; i++){
				var text = splitResult[i];
				$("#" + text).show();
				$("#accordion a:contains('"+text+"')").parent().show();
			}
			
			
			
			$('body').layout({
				applyDefaultStyles:false,
				north__resizable:false,
				west__resizable:false,
				spacing_open:10,//边框的间隙  
                spacing_closed:20//关闭时边框的间隙  
			});
			// Accordion
			$("#accordion").accordion({
				header : "h3",
				collapsible:true,
				clearStyle:true,
				active:false
			});
			//增加事件
			$("ol>li>a").click(function(){
				var pageURL  = this.name;
				$(".ui-layout-center").html('<iframe src="'+pageURL+'" width="100%" height="100%" frameborder="NO" scrolling="yes"></iframe>');
			});
		});
	</script>
</head>

<%
	String result = (String)session.getAttribute("rightStr");
	out.print("<script type='text/javascript'> var result = '"+result+"'</script>");

%>
<body> 
	<div class = "ui-layout-north"><iframe src="<%=path %>/top.jsp" frameborder="NO" scrolling="NO"  width="100%" height="90"></iframe></div>
	<div class = "ui-layout-west" >
		<div id="accordion">
			<div id="营销管理">
				<h3><a href="#">营销管理</a></h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content"><a href="#" name="<%=path %>/sale/loadAllSalChanceAction.action">销售机会管理</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/sale/loadAllDispatcheSalChanceAction.action">客户开发计划</a></li>
					</ol>	
				</div>
			</div>
			<div id="客户管理"  >
				<h3><a href="#" >客户管理</a></h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content"><a href="#" name="<%=path %>/cus/CstCustomerAction_loadCstCustomersByManager">客户信息管理</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/cus/CstLostAction_loadCstLostsByManager">客户流失管理</a></li>
					</ol>	
				</div>
			</div>
			<div id="服务管理"  >
				<h3><a href="#">服务管理</a></h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content"><a href="#" name="<%=path %>/service/CstServiceAction_toAddCstServicePage">服务创建</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/service/CstServiceAction_toDispatchCstServicePage">服务分配</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/service/CstServiceAction_toDealCstServicePage">服务处理</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/service/CstServiceAction_toFeedbackCstServicePage">服务反馈</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/service/CstServiceAction_toArchCstServicePage">服务归档</a></li>
					</ol>	
				</div>
			</div>
			<div id="统计报表"  >
				<h3><a href="#">统计报表</a></h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content"><a href="#" name="<%=path %>/rept/loadAllInstantCustomerAction.action">客户贡献分析</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/rept/loadAllCustConsAction.action?optionType=custLevel">客户构成分析</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/rept/loadAllInstantCustomerServiceAction.action">客户服务分析</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/rept/loadAllInstantCustomerLostAction.action">客户流失分析</a></li>
					</ol>	
				</div>
			</div>
			<div id="基础数据"  >
				<h3><a href="#" >基础数据</a></h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content"><a href="#" name="<%=path %>/basd/loadAllBasDictsAction.action" >数据字典管理</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/basd/loadAllProductAction.action">查询产品信息</a></li>
						<li class="ui-widget-content"><a href="#" name="<%=path %>/basd/findProductAndStorageAction.action">查询库存</a></li>
					</ol>	
				</div>
			</div>
			<div id="权限管理">
				<h3><a href="#">权限管理</a></h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content" ><a href="#" name="<%=path %>/sys/loadAllUsersAction.action?sysUserQueryDTO.opeartorType=search" >用户管理</a></li>
						<li class="ui-widget-content" ><a href="#" name="<%=path %>/sys/loadAllRolesAction.action">角色管理</a></li>
					</ol>	
				</div>
			</div>
		</div>
	</div>
	<div class = "ui-layout-center">
		<iframe src="<%=path %>/mywork.jsp" width="100%" height="100%"  frameborder="NO" scrolling="yes"></iframe>
	</div>
</body>
</html>
