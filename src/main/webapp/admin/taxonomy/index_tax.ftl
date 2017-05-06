<#include "../_inc/_layout.html"/>
<#macro script>
	function doSubmit(){
        if($("#tag-name").val() == ""){
            alert("名称不能为空！");
            return;
        }
        if($("#taxonomy_slug").val() == ""){
            alert("别名不能为空！");
            return;
        }

        $("#form").ajaxSubmit({
            type : "post",
            dataType : "json",
            success : function(data) {
                if(data.status == 0){
                    window.location.href="${CPATH}/admin/taxonomy/${taxonomy.taxType}?id=arctile";
                }else{
                    toastr.error(data.message,'操作失败');
                }
            },
            error : function() {
                alert("信息提交错误");
            }
        });
    }

    function del(id){
        $.get("${CPATH}/admin/taxonomy/delete?id="+id, function(result){
            if(result.status > 0){
                alert(result.message);
            }else{
                location.reload();
            }
        });
    }

    var reload = false;
    function openSetLayer(id,title){
        reload = false;
        layer.open({
            type: 2,
            title: '【'+title + '】设置',
            shadeClose: true,
            shade: 0.8,
            area: ['50%', '80%'],
            content: '${CPATH}/admin/taxonomy/setting?m=article&t=category&id='+id,
            end:function(){
                if(reload){
                    location.reload();
                }
            }
        });

    }

</#macro>
<@layout active_id=p child_active_id=c>
<#include include/>
</@layout>



