<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <style type="text/css">
        .fitem {
	display: inline-block;
	width: 270px;
	padding: 10px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	display: inline-block;
}

.right {
	float: right;
}
    </style>

    <script>



        $(function () {
			
			$('#ndg').datagrid({
				url:'${ctx}/risk/rest/auditInfo/pages',
				rownumbers:true,
				pagination:true,
				fit:true,
				sortName:'auto',
				sortOrder:'DESC',
				pageSize:'20',
				singleSelect:true,
				checkOnSelect:true,
				selectOnCheck:true,
				method:'get',
				width:'100%',
				toolbar:'#toolbar',
				columns:[[
					{field:'id',title:'审核id',width:100,align:'center'},
					{field:'creditNo',title:'借款编号',width:100,align:'center',formatter:function(value,row){return row.creditInfo.creditNo}},
					{field:'customerName',title:'企业名',width:100,align:'center',formatter:function(value,row){return row.creditInfo.companyInfo.name}},
					{field:'customerCorporate',title:'法人',width:100,align:'center',formatter:function(value,row){return row.creditInfo.companyInfo.corporateInformation}},
					{field:'customerIndustry',title:'所属行业',width:100,align:'center',formatter:function(value,row){return row.creditInfo.companyInfo.industry}},
					{field:'deadline',title:'申请期限(天)',width:100,align:'center'},
					{field:'amount',title:'申请金额(元)',width:100,align:'center'},
					{field:'askFee',title:'申请费率',width:100,align:'center'},
					{field:'auditAmount',title:'审核金额',width:100,align:'center'},
					{field:'balance',title:'剩余金额',width:100,align:'center'},
					{field:'auditDeadline',title:'审核期限',width:100,align:'center'},
					{field:'auditFee',title:'审核费率',width:100,align:'center'},
					{field:'flowIdView',title:'状态',width:100,align:'center'},
					{field:'createUser',title:'审核人',width:100,align:'center',formatter:function(value,row){return row.createUser.name}},
					{field:'opt',title:'操作',width:100,align:'center',formatter:function(value,row){
						if(row.creditInfo.flowId=='02000001' && row.creditInfo.subFlowId=='03000008'){  //审核中  审核通过
							return "<a href='#' onclick=newTenderPlan(" + row.creditInfo.id + ")>发标</a>";
						}else{
							return '<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">发标</a>';
						}
					}}
				]]
			});
        })

        function saveTenderPlan() {
        	
        	$('#fm').form('submit', {
        		url : '${ctx}/rest/tenderPlan/create',
        		onSubmit : function() {
        			var qx = $("input.tag_checkbox:checked").map(function () {
        	               return $(this).val();
        	           }).get().join(',');
        			if(!qx){
        				msg('提示','投标标记必选','warning');
        				return false;
        			}
        			var start = new Date($('[name=tenderStart]').val());
        			var end = new Date($('[name=tenderEnd]').val());
        			if(start>end){
        				msg('提示','投标开始时间不能大于结束时间','warning');
        				return false;
        			}
        			$('[name=tags]').val(qx);
        			if($(this).form('validate')){
     					$('#saveBtn').linkbutton('disable');
     					return true;
     				}else{
     					return false;
     				}
        		},
        		success : function(result) {
        			var data = JSON.parse(result);
        			if (data.code > 0) {
        				window.parent.refreshCurr('投资管理','标的管理','tenderPlan');
        			} else {
        				$('#saveBtn').linkbutton('enable');
        				msg('错误', data.exception, 'error');
        			}
        		}
        	});
        }
        
        function newTenderPlan(id) {
        	$('#dlg').dialog('open').dialog('setTitle', '发标');
        	$('#fm').form('clear');
        	$('[name=creditInfoId]').val(id);
        	$('#saveBtn').linkbutton('enable');
        }
    </script>
</head>
<body>

<table id="ndg"></table>
<div id="dlg" class="easyui-dialog"
		style="width: 700px; max-height: 600px; padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<input name="creditInfoId" type="hidden">
			<div>
				<div class="fitem">
					<label>投标分类:</label> <input name="subType"
						class="easyui-combobox" required="true" 
						data-options="url:'${ctx}/rest/tenderPlan/getProjectType',
							method: 'get',
							valueField:'id',
							textField:'name',
							groupField:'parentName'
							">
				</div>
				<div class="fitem">
					<label>投标标记:</label> 
					<c:forEach items="${tags}" var="tag">
						<input type="checkbox" class="tag_checkbox" value="${tag.id}" checked="checked">${tag.tag}
					</c:forEach>
					<input type="hidden" name="tags" class="easyui-textbox"/>
				</div>
			</div>
			<div>
				<div class="fitem">
					<label>投标名称:</label> <input name="tenderName"
						class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>融资总额:</label> <input name="amount" class="easyui-numberbox" prompt="单位为元"
						data-options="min:0,precision:2" required="true">
				</div>
			</div>
			<div>
				<div class="fitem">
					<label>投标开始时间:</label> <input name="tenderStart"
						class="easyui-datetimebox" required="true">
				</div>
				<div class="fitem">
					<label>购买结束时间:</label> <input name="buyEndTime"
						class="easyui-datetimebox" required="true">
				</div>
			</div>
			<div>
				<div class="fitem">
					<label>预热结束时间:</label> <input name="yureEndTime"
						class="easyui-datetimebox" required="true">
				</div>
				<div class="fitem">
					<label>投标期限:</label> <input name="deadline"
						class="easyui-numberbox" data-options="min:0,precision:0,prompt: '单位是天'"
						required="true">
				</div>
			</div>
			<div>
				<div class="fitem">
					<label>年利率:</label> <input name="irr" class="easyui-numberbox" prompt="请填写小于1大于0的数字"
						data-options="min:0,precision:4,max:1" required="true">
				</div>
				<div class="fitem">
					<label>投标介绍:</label> <input name="tenderDesc" class="easyui-textbox"
						multiline="true" style="height: 80px; width: 160px">
				</div>
			</div>
			<div>
				<div class="fitem">
					<label>红包类型:</label> <input name="hongBaoType" class="easyui-textbox" multiline="true" style="height: 40px; width: 160px">
				</div>
				<div class="fitem">
				</div>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" id="saveBtn" onclick="saveTenderPlan()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>
</body>
</html>
