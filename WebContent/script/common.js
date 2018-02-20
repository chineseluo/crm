function reload() {
	window.location.reload();
}
function help(msg) {
	alert('欢迎使用' + msg);
}

function to(url) {
	window.location.href = url;
}
function back() {
	history.go(-1);
}
function save(url) {
	alert('保存成功！');
	to(url);
}
function add(formName) {
	document.getElementsByName(formName)[0].submit();
	//alert("新建成功!");
}
function setCurTime(oid) {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth()+1;
	var day = now.getDate();
	var hours = now.getHours();
	var minutes = now.getMinutes();
	var seconds = now.getSeconds();
	var timeString = year + "-" + month + "-" + day + " " + hours + ":"
			+ minutes + ":" + seconds;
	var oCtl = document.getElementById(oid);
	oCtl.value = timeString;
}


//$(function(){
//	var now = new Date();
//	var weekday=now.getDay();
//	if(weekday==6){
//		var endDate=new Date();
//		endDate.setHours(2, 0, 0, 0);//周六凌晨2点
//		window.interval("autoRunDaemon()",endDate.UTC()-now.UTC());
//		
//	} 
//});
//
//function autoRunDaemon(){
//	console.info(11);
//}

