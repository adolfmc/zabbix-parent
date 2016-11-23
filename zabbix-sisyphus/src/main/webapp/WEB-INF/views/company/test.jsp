<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/static/kindeditor/themes/default/default.css"/>
    <script src="/static/kindeditor/kindeditor-min.js"></script>
    <script src="/static/kindeditor/lang/zh_CN.js"></script>
    <script type="text/javascript" src="/static/script/crm/upload.js"></script>
    <style>
        .uploadImgDiv{display: inline-block;width: 102px;height: 69px;margin:6px 10px ;  position: relative;}
        .delmore_img{ display: block; width: 20px; height: 20px; text-align: center; line-height: 20px; background-color: #0086ed;color: #ffffff ;border-radius: 50%; position: absolute; top: -12px; right:-10px; cursor: pointer;}
    </style>

    <script>
        function opImageDg(url) {

            $('#imageDg').dialog({
                title:'图片-浏览',
                fit:true,
                content:'<img  src="'+url+'">'
            });
            $('#imageDg').dialog('open');
        }


        $(function(){

            <c:if test="${id != null}">
                    //加载审核数据
                    $.getJSON("${ctx}/rest/company/attachments/${id}", function(data){
                            $(data).each(function (index,att) {
                                $('<div class="uploadImgDiv" ><span data-id="'+att.filePath+'" class="delmore_img">x</span><a href="'+att.filePath+'" target="_blank"><img  data-id="'+att.id+'"  width="102" height="69" src="' + att.filePath + '"></a></div>').insertBefore($("td[data-type="+att.type+"]").next().find('img.selectImage'));
                            })

                    });


            </c:if>

            $(document).on("click", ".delmore_img", function() {

                if($($(this).next()).attr('data-id')){
                $.getJSON("${ctx}/rest/company/attachments/delete/"+$($(this).next()).attr('data-id'), function(data){
                    //alert(data.code)
                    window.location.href=window.location.href;
                });
                }else{
                    $(this).parent().remove();
                }

            });
        })
        
        KindEditor.ready(function(K) {
    var editor = K.editor({
        filePostName:'file',
        dir:'image',
        uploadJson:'/file/upload',
        allowFileManager : true,
        imageUploadLimit : 2
    });
    K('.selectImage').click(function() {
        var currentClick = $(this)
        editor.loadPlugin('multiimage', function() {
            editor.plugin.multiImageDialog({
                clickFn : function(urlList) {
                    K.each(urlList, function(i, data) {

                        $('<div class="uploadImgDiv"><span data-id="'+data.url+'" class="delmore_img">x</span><a href="'+data.url+'" target="_blank"><img  width="102" height="69" src="' + data.url + '"></a></div>').insertBefore(currentClick);
                    });
                    editor.hideDialog();
                }
            });
        });
    });
});

    </script>
</head>
<body>
<div id="imageDg"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="10">
</tr>
    <tr>
        <td width="100" align="right" data-type="00040001">身份证</td>
        <td >
            <img src="/static/images/crm/uploadadd.png" class="selectImage" >
        </td>

    </tr>

    <tr>
        <td align="right" data-type="00040003">信用报告</td>
        <td>
            <img src="/static/images/crm/uploadadd.png" class="selectImage" >
        </td>
    </tr>

        <tr>
            <td align="right" data-type="00040004">收入证明</td>
            <td>
                <img src="/static/images/crm/uploadadd.png" class="selectImage" >
            </td>
        </tr>


        <tr>
            <td align="right" data-type="00040005">工作证</td>
            <td>
                <img src="/static/images/crm/uploadadd.png" class="selectImage" >
            </td>
        </tr>

        <tr>
            <td align="right" data-type="00040006">企业资质</td>
            <td>
                <img src="/static/images/crm/uploadadd.png" class="selectImage" >
            </td>
        </tr>

        <tr>
            <td align="right" data-type="00040007">银行卡信息</td>
            <td>
                <img src="/static/images/crm/uploadadd.png" class="selectImage" >
            </td>
        </tr>

</table>
</body>
</html>
