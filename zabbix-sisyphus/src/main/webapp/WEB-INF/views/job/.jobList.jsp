<html><head>
	<title>任务管理</title>
</head><body>
<table class="easyui-datagrid" id="dg" data-options="
	url:'${ctx}/job',
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
			<th data-options="field:'jobxz',width:100,align:'center'">编号</th>
			<th data-options="field:'salary',width:150,align:'center'">借款人</th>
			<th data-options="field:'memo',width:150,align:'center'">还款方式</th>
			<th data-options="field:'company',width:150,align:'center'">借款用途</th>
			<th data-options="field:'titile',width:100,align:'center'">申请期限(天)</th>
			<th data-options="field:'url',width:100,align:'center'">申请金额(元)</th>
			<th data-options="field:'opt',width:200,align:'center',formatter:formatOpt">操作</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onclick="audit()">审核</a>
</div>
	
<div id="auditDialog"></div>
<div id="imageDg"></div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       </body></html>