//添加销售机会
function addSalChance(){
	$("form[name='salChanceAddForm']").submit();
}

//销售机会查询
function search(){
	$("form[name='loadSalChanceByCondictionForm']").submit();
}
//已指派机会查询

function searchDispatchSalChance(){
	$("form[name='loadAllDispatcheSalChanceForm']").submit();
}

// 给查询条件赋值
function setConditionValue() {
	var queryChcCustName = $("input[name='salChanceQueryDto.chcCustName']").val();
	var queryChcTitle = $("input[name='salChanceQueryDto.chcTitle']").val();
	var queryChcLinkMan = $("input[name='salChanceQueryDto.chcLinkMan']").val();
	$("#chcCustName").val(queryChcCustName);
	$("#chcTitle").val(queryChcTitle);
	$("#chcLinkMan").val(queryChcLinkMan);
}

// 分页按钮的控制
function setPage(currentPage) {
	setConditionValue();
	$("#queryCurrentPage").val(currentPage);
	$("form[name='loadSalChanceByPageForm']").submit();
}

// 设置自定义导航页数
function setNavigatePage(pageNum) {
	setConditionValue();
	$("#queryCurrentPage").val(pageNum);
}

//销售机会更新
function edit(){
	$("form[name='editSalChanceForm']").submit();
}

//销售机会删除
function del(chcCustName, id){
		var flag = window.confirm("您确定要删除对:" + chcCustName + "这个客户的销售机会吗?");
		if(flag == true){
			window.location.href="/crm/sale/deleteSalChanceAction.action?salChanceQueryDto.id="+id;
		}
}

//保存已指派的销售机会
function saveDispatchSalChance(){
	$("form[name='saveDispatchSalChanceForm']").submit();
	
}

//保存计划
function savePlan(){
	$("form[name='savePlanForm']").submit();
}


//更新销售计划
function updateSalPlan(id,index,salChancId){
	var todo = $("#toDo"+index).val();
	window.location.href="crm/sale/updateSalPlanAction.action?salPlanQueryDto.id="+id+"&salChanceQueryDto.id="+salChancId+"&salPlanQueryDto.plaToDo="+todo;
}
//删除计划
function deleteSalPlan(id,salChancId){
	window.confirm("确定要删除该计划？");
	window.location.href="crm/sale/deleteSalPlanAction.action?salPlanQueryDto.id="+id+"&salChanceQueryDto.id="+salChancId;
}
//执行计划
function executeSalPlan(id){
	window.location.href="crm/sale/executeSalPlanAction.action?salChanceQueryDto.id="+id;
}
//保存执行计划的结果
function saveExecutePlan(id,index,salChancId){
	var plaResult = $("#result"+index).val();
    window.location.href="crm/sale/saveExecutePlanAction.action?salPlanQueryDto.id="+id+"&salPlanQueryDto.plaResult="+plaResult+"&salChanceQueryDto.id="+salChancId;
}


//终止计划
function stopSalPlan(id){
	window.location.href="crm/sale/stopSalPlanAction.action?salChanceQueryDto.id="+id;
}



