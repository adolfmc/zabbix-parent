<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<style type="text/css">
.fitem {
	display:inline-block;
	width: 270px;
	padding: 10px;
}

.fitem label {
	display: inline-block;
	width: 75px;
}

.fitem input {
	display: inline-block;
}

.right{
	float:right;
}
</style>

<script>
	
	$(function() {
		$('#payWay').combobox('select','${creditInfo.payWay}');
		KindEditor.ready(function(K) {
            var editor = K.create('#creditInfo',{
                width : '400px',
                minWidth:'100px',
                height:'150px',
                resizeType:0,
                items : [
 						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
 						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
 						'insertunorderedlist']
            });
            
            editor.html($('#creditInfoTxt').text());
            
        });
		
	})
	
	var url = "${ctx}/rest/credit/saveOrUpdate";
	function save() {
		$('#fm').form('submit', {
			url : url,
			onSubmit : function() {
				KindEditor.sync('#creditInfo');
				return $(this).form('validate');
			},
			success : function(data) {
				var result = JSON.parse(data);
				if (result.code > 0) {
					window.parent.refreshCurr('授信管理','借款管理','credit');
				} else {
					msg('错误', result.exception, 'error');
				}
			}
		});
	}
</script>
</head>
<body>
	<div style="padding: 20px;">
		<div class="easyui-panel" style="width:600px;">
		<form id="fm" method="post">
			<input type="hidden" name="id" value="${creditInfo.id}">
			<div>
				<div class="fitem">
					<label>借款人:</label><span> ${creditInfo.customerName}</span>
					<input name="customerType" type="hidden" value="${creditInfo.customerType}">
					<input name="customerId" type="hidden" value="${creditInfo.customerId}">
					<input name="customerName" type="hidden" value="${creditInfo.customerName}">
					<input name="customerPhone" type="hidden" value="${creditInfo.customerPhone}">
				</div>
				<div class="fitem">
					<label>还款方式:</label> <select id="payWay" name="payWay" required="true"
						class="easyui-combobox" style="width: 160px;">
						<option value="1"  >一次到期付本还息</option>
					<option value="2" >等额本息</option>
					</select>
				</div>
			</div>
			<div>
				<div class="fitem">
					<label>申请金额:</label> <input name="amount" class="easyui-numberbox" prompt="单位为元"
						data-options="min:0,precision:0" required="true" value="${creditInfo.amount}">
				</div>
				<div class="fitem">
					  <label>申请费率:</label> <input
						id="totalFee" class="easyui-numberbox" name="askFee" prompt="请填写小于1大于0的数字"
						data-options="min:0,precision:4,max:1" required="true" value="${creditInfo.askFee}">
				</div>
			</div>
			<div>
				<div class="fitem">
					<label class="">借款用途:</label> <input value="${creditInfo.creditUse}"
						name="creditUse" class="easyui-textbox" multiline="true" style="height:60px;width:156px">
				</div>
				<div class="fitem">
					<label>申请期限:</label> <input
						id="totalFee" class="easyui-numberbox" name="deadline" prompt="单位为天"
						data-options="min:0,precision:0" required="true" value="${creditInfo.deadline}">
				</div>
			</div>
			
			<div>
				<div class="fitem">
					<label class="">项目描述:</label>
					<input id="creditInfo" name="creditInfo">
					<span id="creditInfoTxt" style="display:none">${creditInfo.creditInfo}</span>
				</div>
			</div>
			
			<div style="margin-right:10px;margin-bottom:10px;text-align:right">
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()" style="width:80px">提交</a>
			</div>
		</form>
		</div>
	</div>
</body>
</html>
