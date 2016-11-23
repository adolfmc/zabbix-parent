<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
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
	$(function() {
		
	})

	function formatOpt(val,row) {
		if(row.flowId=='13000001'){
			return '<a href="#" onclick=\"release('+row.id+')\">发布</a>&nbsp;|&nbsp;'
							+'<a href="#" onclick=\"edit('+row.id+')\">修改</a>&nbsp;|&nbsp;'
							+'<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">撤销</a>&nbsp;|&nbsp;'
							+'<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">预览</a>';
		}else if(row.flowId=='13000002'){
			return '<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">发布</a>&nbsp;|&nbsp;'
			+'<a onclick="msg(\'提示\',\'不可操作\',\'warning\')">修改</a>&nbsp;|&nbsp;'
			+'<a href="#" onclick=\"repeal('+row.id+')\">撤销</a>&nbsp;|&nbsp;'
			+'<a href="${ctx}/tenderPlan/preview/'+row.id+'"target="_blank">预览</a>';
		}
	}
	
	function edit(id) {
		$('#dlg').dialog('open').dialog('setTitle', '编辑');
		$('.tag_checkbox').prop("checked",false);
		$('#fm').form({
			onLoadSuccess:function(data){
				$('.tag_checkbox').each(function(){
					if(data.tags.indexOf($(this).val())!=-1){
						$(this).prop('checked',true);
					}else{
						if($(this).is(':checked')){
							$(this).prop("checked",false);
						}
					}
				})
			}
		});
		$('#fm').form('load', '${ctx}/rest/tenderPlan/'+id);
		url='${ctx}/rest/tenderPlan/update?id=' + id;
		$('#saveBtn').linkbutton('enable');
	}

	function save() {
		
		$('#fm').form('submit', {
			url : url,
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
			success : function(data) {
				var result = JSON.parse(data);
				if (result.code > 0) {
					$('#dlg').dialog('close');
					$('#dg').datagrid('reload');
				} else {
					$('#saveBtn').linkbutton('enable');
					msg('错误', result.exception, 'error');
				}
			}
		});
	}

	function release(id) {
		$.messager.confirm('确认', '确定发布?', function(r) {
			if (r) {
				$.get('${ctx}/rest/tenderPlan/release/' + id,function(result) {
					if (result.code > 0) {
						$.messager.show({
							title : '成功',
							msg : "已成功发布"
						});
						$('#dg').datagrid('reload');
					} else {
						msg('错误', result.exception, 'error');
					}
				}, 'json');
			}
		});
	}
	
	function repeal(id) {
		$.messager.confirm('确认', '确定撤销?', function(r) {
			if (r) {
				$.get('${ctx}/rest/tenderPlan/repeal/' + id,function(result) {
					if (result.code > 0) {
						$.messager.show({
							title : '成功',
							msg : "已成功撤销"
						});
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

	<div id="dlg" class="easyui-dialog"
		style="width: 650px; max-height: 600px; padding: 10px 20px"
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
					<div><c:forEach items="${tags}" var="tag">
						<input type="checkbox" class="tag_checkbox" value="${tag.id}">${tag.tag} 
					</c:forEach></div>
					<input type="hidden" id="tags" class="easyui-textbox" name="tags"/>
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
						multiline="true" style="height: 100px; width: 160px">
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
			iconCls="icon-ok" id="saveBtn" onclick="save()" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>
	
	<table class="easyui-datagrid" id="dg"
		data-options="
		url:'${ctx}/rest/tenderPlan/pages',
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
				<th data-options="field:'tenderName',width:100,align:'center'">投标名</th>
				<th data-options="field:'subTypeName',width:100,align:'center'">分类</th>
				<th data-options="field:'tenderStart',width:130,align:'center'">投标开始时间</th>
				<th data-options="field:'buyEndTime',width:130,align:'center'">购买结束时间</th>
				<th data-options="field:'yureEndTime',width:130,align:'center'">预热结束时间</th>
				<th data-options="field:'deadline',width:100,align:'center'">投标期限</th>
				<th data-options="field:'amount',width:100,align:'center'">融资总额</th>
				<th data-options="field:'irr',width:100,align:'center'">年利率</th>
				<th data-options="field:'createdDate',width:140,align:'center'">创建时间</th>
				<th data-options="field:'flowIdView',width:200,align:'center'">状态</th>
				<th data-options="field:'opt',formatter:formatOpt,width:200,align:'center'">操作</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>
