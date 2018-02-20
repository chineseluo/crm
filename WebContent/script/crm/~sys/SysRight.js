var userAgent = window.navigator.userAgent.toLowerCase();
$.browser.msie8 = $.browser.msie && /msie 8\.0/i.test(userAgent);
$.browser.msie7 = $.browser.msie && /msie 7\.0/i.test(userAgent);
$.browser.msie6 = !$.browser.msie8 && !$.browser.msie7 && $.browser.msie
		&& /msie 6\.0/i.test(userAgent);
function load() {
	var roleId = $("#roleId").val();
	var sendUrl = "/crm/sys/loadRightsByRoleAction.action";
	if(null != roleId && "" != roleId){
		sendUrl += "?sysRightQueryDTO.roleId=" + roleId;
	}
	
	var o = {
		url : sendUrl
	};
	$("#tree").treeview(o);
}
if ($.browser.msie6) {
	load();
} else {
	$(document).ready(load);
}