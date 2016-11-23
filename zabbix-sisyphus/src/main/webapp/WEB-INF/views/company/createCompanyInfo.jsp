<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>

    function saveCompanyInfo() {

    	if(!$('#companyForm').form('validate')){
    		return;
    	}

        var formValues = $("#companyForm").serialize();

        //获取frame中的元素
        var images = $("#autditLogIframe").contents().find(".selectImage");
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

        var values =  formValues +'&images='+ urlArray.join(",");

        $.post("${ctx}/rest/company/create?"+values, function(result){
				if (result.code > 0) {
	                //保存完成关闭当前tab
	                window.parent.closeCreateCompanyDialog();
					window.parent.refreshTab('客户管理','企业信息','company');
				} else {
					msg('错误', '服务器异常', 'error');
				}

        });
    }
</script>
<div class="easyui-tabs" style="height: 700px">

    <div title="基本信息" style="padding:10px;">
        <form id="companyForm" method="post">
        <table width="100%">
            <tr>
                <td>企业名称:</td>
                <td><input name="name"
                           class="easyui-validatebox"
                           required="true"></td>
                <td>所属行业</td>
                <td><input name="industry"
                           class="easyui-validatebox"
                           required="true"></td>
            </tr>

            <tr>
                <td>成立年限</td>
                <td><input name="established"
                           class="easyui-validatebox"
                           required="true"></td>
                <td>注册资本</td>
                <td><input name="registeredCapital"
                           class="easyui-validatebox"
                           required="true"></td>
            </tr>

            <tr>
                <td>所在地</td>
                <td><input name="jobAdress"
                           class="easyui-validatebox"
                           required="true"></td>
                <td>盈利情况</td>
                <td><input name="operationStatus"
                           class="easyui-validatebox"
                           required="true"></td>
            </tr>

            <tr>
                <td>企业规模</td>
                <td><input name="scale" class="easyui-textbox"></td>
                </td>
                <td>法人信息</td>
                <td><input name="corporateInformation"
                           class="easyui-validatebox"
                           required="true"></td>
            </tr>


            <tr>
                <td>资产负债情况</td>
                <td><input name="liabilities"
                           class="easyui-validatebox"
                           required="true"></td>
                <td>上下游情况</td>
                <td><input name="upsadown" class="easyui-textbox"></td>
            </tr>

            <tr>
                <td>资产状况</td>
                <td><input name="assetStatus"
                           class="easyui-textbox"></td>

                <td>年销售额</td>
                <td><input name="annualSales"
                           class="easyui-textbox"></td>
            </tr>
            <tr>
                <td>借款用途</td>
                <td><input name="moneyPurpose"
                           class="easyui-validatebox"
                           required="true"></td>
                <td>备注</td>
                <td><input name="memo" class="easyui-textbox" multiline="true" style="height: 100px; width: 160px"></td>
            </tr>
        </table>
</form>

    </div>
    <div title="附件" style="padding:10px;">
        <iframe id="autditLogIframe" src="/company/test" width="100%" height="100%" src="" frameborder="no" border="0"
                marginwidth="0" marginheight="0" allowtransparency="yes"></iframe>
    </div>


</div>
<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="saveCompanyInfo()">保存企业信息</a>
