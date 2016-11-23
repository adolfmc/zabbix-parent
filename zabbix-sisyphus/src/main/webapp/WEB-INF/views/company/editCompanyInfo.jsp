<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>

    function saveCompanyInfo() {


//    	if(!$( $("#baseInfoframe").contents().find("#companyForm")[0]).form('validate')){
//    		return;
//    	}

        var formValues =$( $("#baseInfoframe").contents().find("#companyForm")[0]).serialize();
        //获取frame中的元素
        var images = $("#autditLogIframe").contents().find(".selectImage");
        var memoText = $("#baseInfoframe").contents().find("#editor_id").text();

        var urlArray = [];
        images.each(function (index, domEle) {

            $(domEle).parent().prevAll().each(function (i, d) {
                var next = $(d).next();
                next.find("img").each(function (i, img) {
                    var img_src = $(img).attr("src");
                    if(img_src.lastIndexOf('/static/images/crm/uploadadd.png')!=0) {
                        urlArray.push($(d).data('type') + ':' + img_src)
                    }
                })
            })

        })

        var values =  formValues +'&images='+ urlArray.join(",") + '&memo'+memoText;
        $.post("${ctx}/rest/company/update?id=${id}&"+values, function(result){
            if (result.code > 0) {
	            //保存完成关闭当前tab
	            window.parent.closeEditCompanyDialog();
				window.parent.refreshTab('客户管理','企业信息','company');
			} else {
				msg('错误', '服务器异常', 'error');
			}
        });
    }
</script>
<div class="easyui-tabs" style="height: 700px">

    <div title="基本信息" style="padding:10px;">

        <iframe id="baseInfoframe" src="/company/baseInfo?id=${id}" width="100%" height="100%" src="" frameborder="no" border="0"
                marginwidth="0" marginheight="0" allowtransparency="yes" ></iframe>



    </div>
    <div title="附件" style="padding:10px;">
        <iframe id="autditLogIframe" src="/company/test?id=${id}" width="100%" height="100%" src="" frameborder="no" border="0"
                marginwidth="0" marginheight="0" allowtransparency="yes" ></iframe>
    </div>


</div>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="saveCompanyInfo()">保存企业信息</a>

</script>