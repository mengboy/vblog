<#include "../_inc/_layout.html"/> 
<#macro script>

    var data={
        url:'',
        alt:''
    };

    function initTinymce(){
        tinymce.init({
            selector: '#textarea',
            height: 365,
            language: 'zh_CN',
            menubar: false,
            automatic_uploads: true,
            paste_data_images: true,
            convert_urls: false,
            relative_urls : false,
            imagetools_toolbar: "rotateleft rotateright | flipv fliph | editimage imageoptions",
            imagetools_proxy: '/admin/tinymce/image/proxy',
            images_upload_url: '/admin/tinymce/image/upload',
            wordcount_countregex: /[\u4e00-\u9fa5_a-zA-Z0-9]/g,
            file_picker_callback: function(callback, value, meta) {
                layer.open({
                    type: 2,
                    title: '选择图片',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['92%', '90%'],
                    content: '/admin/attachment/choose_layer',
                    end:function(){
                        if(''!=data.url && null != data.url){
                            callback(data.url, {alt: data.alt});
                        }
                    }
                });
            },
            plugins: [
                "advlist autolink autosave link image media imagetools lists charmap print preview hr anchor pagebreak spellchecker",
                "searchreplace wordcount visualblocks visualchars code codesample fullscreen insertdatetime media nonbreaking",
                "table contextmenu directionality emoticons template textcolor paste fullpage textcolor colorpicker textpattern"
            ],
            toolbar1: '  bold italic underline strikethrough removeformat | blockquote hr table image media codesample | anchor link   unlink | alignleft aligncenter alignright alignjustify | bullist numlist     ',
            toolbar2: '  formatselect | outdent indent | forecolor backcolor  |  undo redo | code  fullscreen',
        });
    }

    var simplemde ;
    function initMarkdownEditor(){
        simplemde = new SimpleMDE({ element: $("#textarea")[0] });
    }

    if("tinymce" == "${editor}"){
        initTinymce();
    }else{
        initMarkdownEditor();
    }

    function save(){

        $('#content_slug').attr('value',$("#slug_text").text());

        if("tinymce" == "${editor}"){
            tinymce.activeEditor.uploadImages(function(success) {
                tinymce.triggerSave();
                doSubmit();
            });
        }else{
            $("#textarea").text(simplemde.markdown(simplemde.value()));
            doSubmit();
        }
        return false;
    }

    function saveAsDraft(){
        $("#content_status").attr("value","draft");
        save();
    }

    function doSubmit(){
        $("#form").ajaxSubmit({
            type : "post",
            dataType : "json",
            success : function(data) {
                if(data.status == 0){
                    $("#content_id").attr("value",data.body);
                    toastr.success('保存成功！','操作成功');
                }else{
                    toastr.error(data.message,'操作失败');
                }
            },
            error : function() {
                alert("信息提交错误");
            }
        });
    }

    function doSelectThumbnail(){
        layer.open({
            type: 2,
            title: '选择图片',
            shadeClose: true,
            shade: 0.8,
            area: ['92%', '90%'],
            content: '/admin/attachment/choose_layer',
            end:function(){
                if(''!=data.url && null != data.url){
                    $("#thumbnail").attr("src",data.url);
                    $("#content_thumbnail").attr("value",data.url);
                }
            }
        });
    }

    function doRemoveThumbnail(){
        $("#thumbnail").attr("src","/static/jpress/admin/image/nothumbnail.jpg");
        $("#content_thumbnail").val("");
    }


    function doAjax(url){
        $.get(url, function(result){
            if(result.errorCode > 0){
                toastr.error(result.message,'操作失败');
            }else{
                location.reload();
            }
        });
    }

    $('#_category').tagEditor();
    <#--$('#_feature').tagEditor();-->
    $('#_tag').tagEditor();


    $("#title").keyup(function(){
        if($('#content_slug').val() == ""){
            $("#slug_text").text(this.value);
            $('#slug_text').editable('setValue',this.value);
        }
    });

    $(document).ready(function(){

        $.fn.editable.defaults.mode = 'inline';
        $('#slug_text').editable();

        var url = window.location.protocol  +"//"+ window.location.host+"/c/" ;
        $("#url_preffix").text(url);
        $('#slug_text').editable('setValue'," 标题");

        $('#titleurl').on('save', function(e, params) {
            $('#content_slug').attr('value',params.newValue);
        });
    });


<#--$("#title").keyup(function(){-->
	<#--if($('#content_slug').val() == ""){-->
	   <#--$("#slug_text").text(this.value);-->
       <#--$('#slug_text').editable('setValue',this.value);-->
	<#--}-->
<#--});-->

<#--$(document).ready(function(){-->
	<#---->
	 <#--$.fn.editable.defaults.mode = 'inline';-->
	 <#--$('#slug_text').editable();-->
	 <#---->
	 <#--var url = window.location.protocol  +"//"+ window.location.host+"${CPATH}${urlPreffix!}" ;-->
     <#--$("#url_preffix").text(url);-->
     <#--$('#slug_text').editable('setValue'," ${(content.slug)!'标题'}");-->
     <#---->
     <#--$('#titleurl').on('save', function(e, params) {-->
    	 <#--$('#content_slug').attr('value',params.newValue);-->
	 <#--});-->
<#--});-->
</#macro> 
<#macro script_import>
<script src="${CPATH}/static/tinymce/tinymce.min.js"></script>
<script src="${CPATH}/static/plugins/tag/jquery.caret.min.js"></script>
<script src="${CPATH}/static/plugins/tag/jquery.tag-editor.min.js"></script>
<script src="${CPATH}/static/plugins/editable/bootstrap-editable.min.js"></script>
<script src="${CPATH}/static/simplemde/simplemde.min.js"></script>
</#macro>
<#macro css_import>
<link rel="stylesheet" href="${CPATH}/static/plugins/tag/jquery.tag-editor.css">
<link rel="stylesheet" href="${CPATH}/static/plugins/editable/bootstrap-editable.css">
<link rel="stylesheet" href="${CPATH}/static/simplemde/simplemde.min.css">
</#macro>
<#macro css>
.editable-input {
	width: 100%;
}
.form-inline .form-control {
    display: inline-block;
    width: 100%;
    vertical-align: middle;
}
.nav-tabs-custom {
    margin-bottom: 0px; 
    background: #fff;
    box-shadow: 0 1px 1px rgba(0, 0, 0, 0);
    border-radius: 3px;
}
</#macro>
<@layout active_id=p child_active_id=c>
<#include include/>
</@layout>