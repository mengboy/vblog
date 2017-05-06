<#include "../_inc/_layout.html"/>

<#macro script>
function trash(id){
	$.get("${CPATH}/admin/content/trash?id="+id, function(result){
		if(result.status > 0){
			alert(result.message);
		}else{
			location.reload();
		}
	});
}
function batchAction(){
	var action = "${s!}";
	if("delete"==action){
		$("#form").attr("action","${CPATH}/admin/content/batchDelete");
	}else{
		$("#form").attr("action","${CPATH}/admin/content/batchTrash");
	}

 	$("#form").ajaxSubmit({
			type : "post", 
			dataType : "json",
			success : function(result) { 
				if(result.errorCode > 0){
					toastr.error(result.message,'操作失败');
				}else{
					location.reload();
				}
			},
			error : function() {
				alert("信息提交错误");
			}
	});
 }

function restore(id){
	$.get("${CPATH}/admin/content/restore?ucode=${ucode}&id="+id, function(result){
		if(result.errorCode > 0){
			toastr.error(result.message,'操作失败');
		}else{
			location.reload();
		}
	});
}

function draft(id){
	$.get("${CPATH}/admin/content/draft?id="+id, function(result){
		if(result.status > 0){
			toastr.error(result.message,'操作失败');
		}else{
			location.reload();
		}
	});
}

function del(id){
	$.get("${CPATH}/admin/content/delete?id="+id, function(result){
		if(result.status > 0){
			toastr.error(result.message,'操作失败');
		}else{
			location.reload();
		}
	});
}


$(document).ready(function(){
  $(".jp-selected").change(function(){
  		var tids = "";
  		$(".jp-selected").each(function(){
  			if("" != $(this).val()){
  				tids += $(this).val()+",";
  			}
  		});
  		
  		$(".tids").val(tids);
  });
});
</#macro> 
<@layout active_id=p child_active_id=c>
<#include include/>
</@layout>



