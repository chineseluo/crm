function search(searchForm){
	$("form[name='"+searchForm+"']").submit();
}

// 给查询条件赋值
function setConditionValue() {
	$("#querySvrCustName").val($("input[name='cstServiceQueryDTO.svrCustName']:first").val());
	$("#querySvrTitle").val($("input[name='cstServiceQueryDTO.svrTitle']:first").val());
	$("#querySvrTypeId").val($("input[name='cstServiceQueryDTO.svrTypeId']:first").val());
	$("#querySvrCreateDateFrom").val($("input[name='cstServiceQueryDTO.svrCreateDateFrom']:first").val());
	$("#svrCreateDateTo").val($("input[name='cstServiceQueryDTO.svrCreateDateTo']:first").val());
	$("#querySvrStatus").val($("input[name='cstServiceQueryDTO.svrStatus']:first").val());
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
}


function dispatchForm(submitbutton){
	var c_form=$(submitbutton).parents("form:first");
//	if($(c_form).find("select[name='svrDueDTO.id']").val().length<=0 )
//	{
//		alert("分配客户经理不能为空");
//		return false;
//	}    
	$(c_form).submit();
	
}

function formCheck(editForm){
	var c_form=$("form[name='"+editForm+"']");
//	var flag=true;
//	var note="";
//	$(c_form).find("select").each(function(){
//		if($(this).val().length<=0){
//			flag=false;
//			note=$(this).parent().prev().text();
//			return false;
//		}
//	});
//	$(c_form).find("input[name]").each(function(){
//		if($(this).val().length<=0){
//			flag=false;
//			note=$(this).parent().prev().text();
//			return false;
//		}
//	});
//	$(c_form).find("textarea[name]").each(function(){
//		if($(this).val().length<=0){
//			flag=false;
//			note=$(this).parent().prev().text();
//			return false;
//		}
//	});
//	if(flag)
		$(c_form).submit();
//	else
//		alert(note+"不能为空");
	
}


function del(name, url){
	var flag = window.confirm("您确定要删除:" + name + "吗?");
	if(flag == true){
		window.location.href=url;
	}
	
}

