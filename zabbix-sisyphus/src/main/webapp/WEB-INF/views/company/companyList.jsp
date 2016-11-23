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
	width: 100px;
}

.fitem input {
	display: inline-block;
	width: 220px;
}
</style>

<script>

	function formatOpt(val,row){
		return 	'<a href="#" onclick="openEditCompanyDialog(\'editCompanyInfo\','+row.id+')">修改</a>&nbsp;|&nbsp;'
		+ '<a href="#" onclick="applyCredit('+row.id+')">申请借款</a>';
	}
	
	
	function openCompanyDialog(option){
		window.parent.closeEditCompanyDialog()
		window.parent.openCompanyDialog(option);
	}

	function openEditCompanyDialog(option,id){
		window.parent.closeCreateCompanyDialog()
		window.parent.openEditCompanyDialog(option+'/'+id);
	}
	
	function applyCredit(id){
		var url = 'credit/create?customerType=1&customerId='+id;
		//客户管理为左侧导航title，申请借款为标签title
		window.parent.refreshCurr('客户管理','申请借款',url);
	}

	function destroyCompany(id) {
		$.messager.confirm('确认', '确定删除该条企业信息?', function(r) {
			if (r) {
				$.get('${ctx}/rest/company/delete/' + id, function(
						result) {
					if (result.code > 0) {
						$('#dg').datagrid('reload');
					} else {
						msg('错误', '服务器异常', 'error');
					}
				}, 'json');
			}
		});
	}
</script>
</head>
<body>
	<table class="easyui-datagrid" id="companyDg"
		data-options="
		url:'${ctx}/rest/company/pages',
		rownumbers:true,
		pagination:true,
		fit:true,
		sortName:'auto',
		sortOrder:'DESC',
		pageSize:'20',
		singleSelect:true,
		checkOnSelect:true,
		selectOnCheck:true,
		toolbar:'#tb',
		method:'get',
		width:'100%',
		toolbar:'#toolbar'
	">
		<thead>
			<tr>
				<th data-options="field:'customerCode',width:110,align:'center'">企业编号</th>
				<th data-options="field:'name',width:200,align:'center'">企业名</th>
				<th data-options="field:'industry',width:200,align:'center'">所属行业</th>
				<th data-options="field:'corporateInformation',width:200,align:'center'">法人信息</th>
				<th data-options="field:'createdDate',width:200,align:'center',formatter:function(value){return formattime(value,true)}">创建时间</th>
				<th data-options="field:'opt',width:200,align:'center',formatter:formatOpt">操作</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="openCompanyDialog('createCompanyInfo')">新建企业信息</a>
	</div>
</body>
</html>
