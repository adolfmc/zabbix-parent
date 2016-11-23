<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link type="image/x-icon" href="${ctx}/static/images/favicon.ico" rel="shortcut icon">

<link href="${ctx}/static/jquery-validation/1.11.1/validate.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-easyui-1.5/themes/default/easyui.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-easyui-1.5/themes/color.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery-easyui-1.5/themes/icon.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css">

<script src="${ctx}/static/script/common/common.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-validation/1.11.1/messages_bs_zh.js" type="text/javascript"></script>
<script src="${ctx}/static/jquery-easyui-1.5/jquery.easyui.min.js" type="text/javascript"></script>
<!-- easyui-lang-zh_CN.js一定要放在jquery.easyui.min.js之后，不然不起作用 -->
<script src="${ctx}/static/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" type="text/javascript" ></script>
<script src="${ctx}/static/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="/static/kindeditor/themes/default/default.css"/>
	<script src="/static/kindeditor/kindeditor-min.js"></script>
	<script src="/static/kindeditor/lang/zh_CN.js"></script>
	<script type="text/javascript" src="/static/script/crm/upload.js"></script>
<sitemesh:head/>
</head>

<body class="easyui-layout">
	<sitemesh:body/>
</body>
</html>