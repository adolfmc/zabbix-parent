<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>合同管理</title>
    <%@ include file="/static/script/common/meta.jsp" %>
    <%@ include file="/static/script/common/jscsslibs/easyui.jsp" %>
    <%@ include file="/static/script/common/jscsslibs/easyuicommon.jsp" %>
    <style>
        .fitem {
            margin-bottom: 5px;
        }

        .fitem label {
            display: inline-block;
            width: 80px;
        }

        .fitem input {
            width: 160px;
        }
    </style>
    <script type="text/javascript">

        var url = "";
        function saveFortune() {
            $('#fortuneForm').form('submit', {
                url: url,
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {

                    $('#fortuneDialog').dialog('close');
                    $('#fortuneDg').datagrid('reload');
                }
            });
        }

        function removeFortunePro() {
            var row = $('#fortuneDg').datagrid('getSelected');

            if (row) {
                $.getJSON("/contract/delete",{id:row.id}, function(data){
                    if(data.code != 1){
                        $.messager.alert('提示','系统异常请稍后重试!','error');
                    }else{
                        $('#fortuneDg').datagrid('reload');
                    }
                });
            }

        }



        function showEditForm() {
            url = "/contract/update";
            var row = $('#fortuneDg').datagrid('getSelected');

            if(row){
                $('#fortuneForm').form('load','/contract/find?id='+row.id);
                $('#fortuneDialog').dialog('open');
            }

        }



        $(function () {

            /*初始化日期框*/
            $('#startTime').datebox({
                required: true
            });

            $('#endTime').datebox({
                required: true
            });

//        初始化提交框
            $('#fortuneDialog').dialog({
                title: '添加产品',
                width: 400,
                height: 450,
                closed: true,
                cache: false,
                modal: true,
                buttons: [{
                    text: '保存',

                    handler: function () {
                        saveFortune();
                    }
                }, {
                    text: '取消',
                    handler: function () {
                        $('#fortuneDialog').dialog('close');
                    }
                }]
            });


            $('#fortuneDg').datagrid({
                url: '/contract/findFortunePro',
                rownumbers:true,
                pagination:true,
                singleSelect:true,
                toolbar: [{
                    text:"新增",
                    iconCls: 'icon-add',
                    handler: function () {
                        $('#fortuneForm').form('clear');
                        url = "/contract/saveFortune";
                        $('#fortuneDialog').dialog("open");

                    }
                }, '-', {
                    text:"修改",
                    iconCls: 'icon-edit',
                    handler: function () {


                        showEditForm();
                    }
                },'-', {
                    text:"删除",
                    iconCls: 'icon-remove',
                    handler: function () {

                        removeFortunePro()

                    }
                }],
                columns: [[
                    {field: 'productName', title: '产品名称', fit: true, align: 'right'},
                    {field: 'productCode', title: '产品编号', fit: true, align: 'right'},
                    {field: 'number', title: '募集期数', fit: true, align: 'right'},
                    {field: 'amount', title: '募集金额', fit: true, align: 'right'},
                    {field: 'hasAmount', title: '已募集金额', fit: true, align: 'right'},
                    {field: 'freezwAmount', title: '锁定金额', fit: true, align: 'right'},
                    {field: 'fee', title: '手续费', fit: true, align: 'right'},
                    {field: 'serviceCharge', title: '服务费', fit: true, align: 'right'},
                    {field: 'mangerFree', title: '管理费', fit: true, align: 'right'},
                    {field: 'interest', title: '利息', fit: true, align: 'right'},
                    {field: 'totalCost', title: '总费用', fit: true, align: 'right'},
                    {field: 'totalFee', title: '总费率', fit: true, align: 'right'},
                    {field: 'startTime', title: '开始时间', fit: true, align: 'right'},
                    {field: 'endTime', title: '结束时间', fit: true, align: 'right'},
                    {field: 'oldMemo1', title: '兼容字段', fit: true, align: 'right'},
                    {field: 'status', title: '数据状态', fit: true, align: 'right'},
                    {field: 'version', title: '版本', fit: true, align: 'right'},
                    {field: 'memo', title: '备注', fit: true, align: 'right'},
                    {field: 'memo2', title: '备注2', fit: true, align: 'right'},
                    {field: 'memo3', title: '备注3', fit: true, align: 'right'},
                    {field: 'createDate', title: '创建时间', fit: true, align: 'right'}
                ]]
            });
        })
    </script>

</head>

<body>


<div id="fortuneDialog">
    <form id="fortuneForm" method="post">
        <input name="id" type="hidden">
        <input name="createDate" type="hidden">
        <input name="createUserId" type="hidden">
        <div class="fitem"><label>产品名称:</label><input name="productName" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>产品编号:</label><input name="productCode" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>募集期数:</label><input name="number" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>募集金额:</label><input name="amount" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>已募集金额:</label><input name="hasAmount" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>锁定金额:</label><input name="freezwAmount" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>手续费:</label><input name="fee" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>服务费:</label><input name="serviceCharge" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>管理费:</label><input name="mangerFree" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>利息:</label><input name="interest" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>总费用:</label><input name="totalCost" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>总费率:</label><input name="totalFee" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>开始时间:</label>
            <input id="startTime" name="startTime" type="text">
        </div>

        <div class="fitem"><label>结束时间:</label>
            <input id="endTime" name="endTime" type="text">
        </div>
        <div class="fitem"><label>兼容字段:</label><input name="oldMemo1" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>备注:</label><input name="memo" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>备注2:</label><input name="memo2" class="easyui-textbox" required="true"></div>
        <div class="fitem"><label>备注3:</label><input name="memo3" class="easyui-textbox" required="true"></div>

    </form>
</div>

<table id="fortuneDg" style="height:auto">

</table>

</body>
</html>
