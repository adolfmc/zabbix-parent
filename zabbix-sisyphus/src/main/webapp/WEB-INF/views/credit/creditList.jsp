<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<style type="text/css">
.fitem {
	align: right;
	padding: 5px;
}

.fitem label {
	display: inline-block;
	width: 70px;
}

.fitem label.right {
	margin-left:25px;
}

.fitem input {
	display: inline-block;
}
</style>

<script>
$(function() {
	$('#imageDg').dialog({
        title: '图片',
        width: 1000,
        height: 700,
        closed: true,
        cache: false,
        modal: true
    });


    $('#auditDialog').dialog({
        title: '审核信息',
        width: 1300,
        height: 700,
        closed: true,
        cache: false,
        modal: true,

        buttons:[{
            text:'保存',
            handler:function(){

                submitAuditResultForm();


            }
        },{
            text:'关闭',
            handler:function(){
                $('#auditDialog').dialog('close')
            }
        }]
    });

})

function opIndexImageDg(url) {

            $('#imageDg').dialog({
                content:'<img  src="'+url+'">'
            });
            $('#imageDg').dialog('open');
        }
        
function submitAuditResultForm(){
    var formHtml =  $("#auditResultFrame").contents().find("#auditCompanyResultForm");
    var $formHtml = $(formHtml[0]);
    $formHtml.form('submit',{
        url:'/risk/rest/auditInfo/auditCompany',
        onSubmit: function(){
        	var amount = formHtml.find('#amount').text();
        	var auditAmount = formHtml.find('[name=auditAmount]').val();
        	var auditDeadline = formHtml.find('[name=auditDeadline]').val();
        	var auditFee = formHtml.find('[name=auditFee]').val();
        	var operationStatus = formHtml.find('[name=operationStatus]').val();
        	var scale = formHtml.find('[name=scale]').val();
        	var corporateInformation = formHtml.find('[name=corporateInformation]').val();
			if(!auditAmount || !auditDeadline || !auditFee || !operationStatus
					|| !scale || !corporateInformation){
				msg('提示','审批金额、审批期限、审批费率、风控结论，贷后管理，工作证审核必填','warning');
				return false;
			}
			if(parseInt(amount)<parseInt(auditAmount)){
				msg('提示','审批金额不能大于申请金额','warning');
				return false;
			}
        },
        success:function(data){
            var result = eval ("(" + data + ")");
            if(result.code){
                $('#auditDialog').dialog('close');
                window.parent.refreshCurr('风控管理','审核信息','risk/auditInfo');
            }
        }
    });

}


function audit(id) {
      $("#auditDialog").dialog({
          content: '<iframe id="auditResultFrame" src="/risk/auditInfo/audit/' + id + '" width="100%" height="100%" src="" frameborder="no" border="0"marginwidth="0" marginheight="0" allowtransparency="yes"></iframe>'
      });
      $("#auditDialog").dialog('open');
}


function formatOpt(val , row) {
	if(row.flowId=="02000000"){ //申请
		return '<a href="#" onclick="repeal('+row.id+')">撤销</a>&nbsp;'
		+ '|&nbsp;<a href="#" onclick="edit('+row.id+')">编辑</a>&nbsp;'
		+ '|&nbsp;<a href="#" onclick="audit('+row.id+')">审核</a>';
	}else if(row.flowId=="02000012"){ //撤销
		return '<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">撤销</a>&nbsp;'
		+ '|&nbsp;<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">编辑</a>&nbsp;'
		+ '|&nbsp;<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">审核</a>';
	}else{
		//审核通过|审核不通过
		if(row.subFlowId=='03000008' || row.subFlowId=='03000009'){
			return '<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">撤销</a>&nbsp;'
			+ '|&nbsp;<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">编辑</a>&nbsp;'
			+ '|&nbsp;<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">审核</a>';
		}
	}
}

function edit(id) {
	location.href='${ctx}/credit/update/' + id;
}
	
function repeal(id) {
	$.messager.confirm('确认', '确定撤销该条信息?', function(r) {
		if (r) {
			$.get('${ctx}/rest/credit/repeal/' + id, function(result) {
				if (result.code > 0) {
					$('#dg').datagrid('reload');
				} else {
					msg('错误', result.exception, 'error');
				}
			}, 'json');
		}
	});
}
</script>
</head>
<body>
<table class="easyui-datagrid" id="dg"
	data-options="
	url:'${ctx}/rest/credit/pages',
	rownumbers:true,
	pagination:true,
	fit:true,
	sortName:'auto',
	sortOrder:'DESC',
	pageSize:'20',
	singleSelect:false,
	checkOnSelect:true,
	selectOnCheck:true,
	method:'get',
	width:'100%',
	toolbar:'#toolbar'
">
	<thead>
		<tr>
			<th data-options="field:'creditNo',width:100,align:'center'">编号</th>
			<th data-options="field:'customerName',width:150,align:'center'">借款人</th>
			<th data-options="field:'payWayView',width:150,align:'center'">还款方式</th>
			<th data-options="field:'creditUse',width:150,align:'center'">借款用途</th>
			<th data-options="field:'deadline',width:100,align:'center'">申请期限(天)</th>
			<th data-options="field:'amount',width:100,align:'center'">申请金额(元)</th>
			<th data-options="field:'askFee',width:100,align:'center'">申请费率</th>
			<th data-options="field:'flowIdView',width:100,align:'center'">状态</th>
			<th data-options="field:'subFlowIdView',width:100,align:'center'">子状态</th>
			<th data-options="field:'createdDate',width:120,align:'center',formatter:function(value){return formattime(value,true)}">申请时间</th>
			<th data-options="field:'opt',width:200,align:'center',formatter:formatOpt">操作</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="audit()">审核</a>
</div>
	
<div id="auditDialog"></div>
<div id="imageDg"></div>
</body>
</html>
