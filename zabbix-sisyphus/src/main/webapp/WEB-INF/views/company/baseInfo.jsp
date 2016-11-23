<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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
            <td>

                <textarea id="editor_id" name="memo" style="width:700px;height:300px;">
    <c:if test="${id != null}">
            ${memo}
    </c:if>
                </textarea>
            </td>
        </tr>
    </table>
</form>

<script type="text/javascript">
    $(function(){
        KindEditor.ready(function(K) {
            window.editor = K.create('#editor_id',{
                afterCreate : function() {
                    this.sync();
                },
                afterBlur:function(){
                    this.sync();
                }
            });
        });
    })
    <c:if test="${id != null}">
    $(function(){
        $('#companyForm').form('load','/rest/company/'+${id});

    })
    </c:if>


</script>
