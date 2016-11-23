<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<style>
    textarea{
        height:150px;
        width:300px;
    }
</style>
        <script type="text/javascript">

            function opImageDg(url){

                window.parent.opIndexImageDg(url)
            }
            $(function(){
                //初始化两个tabs
                $('#tt').tabs({
                    border:false,
                    onSelect:function(title){

                    }
                });
                $('#infoTabs').tabs({
                    border:false,
                    onSelect:function(title){

                    }
                });

                $.getJSON("${ctx}/rest/company/attachments/${info.id}", function(data){
                    $(data).each(function (index,att) {
                        $('<img width="102" height="69" onclick="opImageDg(\''+att.filePath+'\')" src="'+att.filePath+'">').appendTo('#'+att.type);
                    })
                });
            })


            KindEditor.ready(function(K) {
                window.editor = K.create('#operationStatus_editor',{
                    afterCreate : function() {
                        this.sync();
                    },
                    afterBlur:function(){
                        this.sync();
                    },
                    items : [
                        'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                        'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                        'insertunorderedlist']
                });
            });

            KindEditor.ready(function(K) {
                window.editor = K.create('#corporateInformation_editor',{
                    afterCreate : function() {
                        this.sync();
                    },
                    afterBlur:function(){
                        this.sync();
                    },
                    items : [
                        'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                        'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                        'insertunorderedlist']
                });
            });


            KindEditor.ready(function(K) {
                window.editor = K.create('#scale_editor',{
                    afterCreate : function() {
                        this.sync();
                    },
                    afterBlur:function(){
                        this.sync();
                    },
                    items : [
                        'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                        'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                        'insertunorderedlist']
                });
            });



        </script>
</head>
<body>



<div data-options="region:'east',split:true"  style="width:70%;border: 0px">
    <%--展示审核信息--%>
    <div id="tt"  style="width:100%;height:100%;">

        <div title="终审" style="padding:20px;display:none;">

            <form id="auditCompanyResultForm" method="POST">
                <input type="hidden" name="creditId" value="${credit.id}"/>
            <table border="1" cellspacing="0" width="100%">
                <tr>
                    <td>身份证审核</td>
                    <td>
                        <input type="radio" name="idcard" value="1" checked>通过
                        <input type="radio" name="idcard" value="0">不通过
                    </td>
                </tr>
                <tr>
                    <td>银行卡审核</td>
                    <td>

                        <input type="radio" name="bankId" value="1" checked>通过
                        <input type="radio" name="bankId" value="0">不通过

                    </td>
                </tr>
                <tr>
                    <td>信用报告审核</td>
                    <td>

                        <input type="radio" name="creditPort" value="1" checked>通过
                        <input type="radio" name="creditPort" value="0">不通过

                    </td>
                </tr>
                <tr>
                    <td>收入证明审核</td>
                    <td>

                        <input type="radio" name="income" value="1" checked>通过
                        <input type="radio" name="income" value="0">不通过

                    </td>
                </tr>
                <tr>
                    <td>工作证审核</td>
                    <td>
                        <input type="radio" name="workPermit" value="1" checked>通过
                        <input type="radio" name="workPermit" value="0">不通过
                    </td>
                </tr>


            </table>
                <br>
                <br>

                <table border="1" cellspacing="0" width="100%">

                    <tr>
                        <td>申请金额</td>
                        <td><span id="amount">${credit.amount}</span></td>
                        <td>审批金额</td>
                        <td><input type="text" class="easyui-numberbox" data-options="min:0,precision:0,prompt:'单位为元'" required="true" style="width:130px" name="auditAmount"/></td>
                    </tr>

                    <tr>
                        <td>申请期限</td>
                        <td>${credit.deadline}天</td>

                        <td>审批期限</td>
                        <td><input type="text" name="auditDeadline" class="easyui-numberbox" data-options="min:0,precision:0" required="true" style="width:130px" value=""/>天</td>
                    </tr>

                    <tr>
                        <td>申请费率</td>
                        <td>${credit.askFee}</td>
                        <td>审批费率</td>
                        <td><input type="text" name="auditFee" class="easyui-numberbox" data-options="min:0,precision:4,max:1,prompt:'请填写大于0小于1的数字'" style="width:130px" required="true" value=""/></td>
                    </tr>

                </table>

                <br>
                <br>

                <table border="1" cellspacing="0" width="100%">



                    <tr>
                        <td>风控结论</td>
                        <td>
                        <textarea  id="operationStatus_editor" name="operationStatus" ></textarea>
                        </td>
                    </tr>

                    <tr>
                        <td>贷后管理</td>
                        <td>

                        <textarea id="scale_editor" name="scale"></textarea>

                        </td>
                    </tr>

                    <tr>
                        <td>工作证审核</td>
                        <td>
                        <textarea id="corporateInformation_editor" name="corporateInformation"></textarea>
                        </td>
                    </tr>

                    <tr>
                        <td >终审结果</td>
                        <td >
                            <input type="radio" name="auditResult" value="03000008" checked>通过
                            <input type="radio" name="auditResult" value="03000009">不通过
                        </td>
                    </tr>


                </table>
            </form>
        </div>

    </div>
</div>
<div data-options="region:'west',split:true"  style="width:30%;border: 0px">

    <div id="infoTabs"  style="width:100%;height:100%;">
       <div title="基础信息">
           <table   border="1" cellspacing="0" width="100%" class="info">
               <tr>
                   <td width="100">企业名称</td>
                   <td>${info.name}</td>
               </tr>

               <tr>
                   <td>所属行业</td>
                   <td>${info.industry}</td>
               </tr>

               <tr>
                   <td>成立年限</td>
                   <td>${info.established}</td>
               </tr>
               
               <tr>
                   <td>注册资本</td>
                   <td>${info.registeredCapital}</td>
               </tr>

               <tr>
                   <td>所在地</td>
                   <td>${info.jobAdress}</td>
               </tr>

               <tr>
                   <td>盈利情况</td>
                   <td>${info.operationStatus}</td>
               </tr>

               <tr>
                   <td>企业规模</td>
                   <td>${info.scale}</td>
               </tr>
               
               <tr>
                   <td>法人信息</td>
                   <td>${info.corporateInformation}</td>
               </tr>

               <tr>
                   <td>资产负债情况</td>
                   <td>${info.liabilities}</td>
               </tr>

               <tr>
                   <td>上下游情况</td>
                   <td>${info.upsadown}</td>
               </tr>

               <tr>
                   <td>资产状况</td>
                   <td>${info.assetStatus}</td>
               </tr>

               <tr>
                   <td>年销售额</td>
                   <td>${info.annualSales}</td>
               </tr>
               <tr>
                   <td>借款用途</td>
                   <td>${info.moneyPurpose}</td>
               </tr>
               <tr>
                   <td>备注</td>
                   <td>${info.memo}</td>
               </tr>
           </table>

       </div>


        <div title="附件信息">

            <table >
                <tr>
                    <td>身份证</td>
                    <td id="00040001">

                    </td>
                </tr>

                <tr>
                    <td>信用报告</td>
                    <td id="00040003">


                    </td>
                </tr>

                <tr>
                    <td>收入证明</td>
                    <td id="00040004">

                    </td>
                </tr>

                <tr>
                    <td>工作证</td>
                    <td id="00040005">


                    </td>
                </tr>

                <tr>
                    <td>企业资质</td>
                    <td id="00040006">

                    </td>
                </tr>

                <tr>
                    <td>银行卡信息</td>
                    <td id="00040007">

                    </td>
                </tr>

            </table>
        </div>
    </div>



</div>
</body>
</html>
