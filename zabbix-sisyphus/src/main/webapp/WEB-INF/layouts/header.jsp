<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header">
	<div id="title">
	    <h1><a href="${ctx}">Fortune V2.0 </a><small>--演示DEMO</small>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i>
					<span class="caret"></span>
				</a>
			</div>
		</h1>
	</div>
	<script>
	$(function() {	
		var days = ${passwordExpireDays};
		
		if (days <= 10 && days > 0) {
			$.messager.alert('温馨提示','距离您的密码过期还有'+days+'天，请尽快修改密码!','info');
		}
	});
	
	function loadCenter(title, url) {
		$(".combo-panel").parent(".panel").remove(); //清楚所有class为combo-panel的class为panel的父元素，解决combobox在页面缓存的问题
		var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;padding:0px;"></iframe>';
		$('body').layout('panel','center').panel({
			title: title,
			content: content
		});
		$('body').layout('panel','center').panel('refresh');
		return false;
	}
</script>
</div>