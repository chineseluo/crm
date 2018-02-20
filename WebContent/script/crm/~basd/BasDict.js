//数据字典 
function addDict(){
	$("form[name='basDictAddForm']").submit();
}

//数据字典查询
function search(formName){
	$("form[name='"+formName+"']").submit();
}

// 给查询条件赋值
function setConditionValue() {
	var queryDictType = $("input[name='basDictQueryDTO.dictType']").val();
	var queryDictItem = $("input[name='basDictQueryDTO.dictItem']").val();
	var queryDictValue = $("input[name='basDictQueryDTO.dictValue']").val();
	$("#queryDictType").val(queryDictType);
	$("#queryDictItem").val(queryDictItem);
	$("#queryDictValue").val(queryDictValue);

}

// 分页按钮的控制
function setPage(currentPage, formName) {
	setConditionValue();
	$("#queryCurrentPage").val(currentPage);
	$("form[name=" + formName + "]").submit();
}

// 设置自定义导航页数
function setNavigatePage(pageNum) {
	setConditionValue();
	$("#queryCurrentPage").val(pageNum);
	//$("form[name=" + formName + "]").submit();
}

//数据字典更新
function save(formName){
	$("form[name='"+formName+"']").submit();
}

//数据字典删除
function del(usrName, id){
	var flag = window.confirm("您确定要删除:" + usrName + "吗?");
	if(flag == true){
		window.location.href="/crm/basd/deleteBasDictAction.action?basDictDTO.id="+id;
	}	
}

$(document).ready(function(){
	$("#dictTypeTip").hide();
	var input=$("input[name='basDictDTO.dictType']").keyup(function(){
		$.ajax({
			type:"post",
			url:"/crm/basd/loadDictTypeByTipAction.action",
			data:"basDictQueryDTO.dictType="+$(this).val(),
			dataType:"json",
			success:function(list){
				$("#dictTypeTip ul").empty();
				$("#dictTypeTip").removeClass().addClass("hide");
				$("#dictTypeTip").hide();
				if(list==null || list.length<=0)
					return;
				for(var i=0;i<list.length;i++)
					$("#dictTypeTip ul").append("<li>"+list[i]+"</li>");
				$("#dictTypeTip li").click(function(){
					$("input[name='basDictDTO.dictType']").val($(this).text());
					$("#dictTypeTip").removeClass().addClass("hide");
					$("#dictTypeTip").hide();
				}).mouseover(function(){
					 $(this).removeClass().addClass("mouseover");
				}).mouseout(function(){
					$(this).removeClass().addClass("mouseout");
				});
				$("#dictTypeTip").removeClass().addClass("show");
				$("#dictTypeTip").show();
				$("#dictTyptTip").focus();
			}
		});
		
		
	});

	$("*:not(#dictTypeTip)").focus(function(){
		$("#dictTypeTip").removeClass().addClass("hide");
		$("#dictTypeTip").hide();
	});
	
	var offset = input.offset();
	var height=input.parent().height();
	$("#dictTypeTip").offset({ top: offset.top+height, left: offset.left }).width(input.width()+5);

});

