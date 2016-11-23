<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>zabbix金融服务平台</title>
<%@ include file="/static/script/common/indexjs.jsp"%>

<script type="text/javascript">

	$(function () {
		//class="easyui-tabs" fit="true" border="false"
		$('#tabs').tabs({
			height:$("#tabs").parent().height()
		});
	})

	if (top != window) {
		top.location.href = window.location.href;
	}
	
	
	function changePassword() {
		$('#Password_dlg').dialog('open').dialog('setTitle', '修改密码');
	}

	function savePassword() {
		$('#Password_fm').form('submit', {
			url : '${ctx}/rest/loginfo/savePassword',
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var data = eval('(' + data + ')');
				if (data.code == 1) {
					$.messager.show({
						title : '成功',
						msg : '修改密码成功！'
					});
					$('#Password_dlg').dialog('close');
				} else {
					$.messager.show({
						title : '失败',
						msg : data.exception
					});
				}
			}
		})
	}
	
	
	
	
	
	
	function openCompanyDialog(option){
		$('#tabs').tabs('close','新增企业信息');
		$('#tabs').tabs('add',{
			title:'新增企业信息',
			href:'${ctx}/company/'+option,
			closable:true
		});
	}
	function openEditCompanyDialog(option){
		$('#tabs').tabs('close','修改企业信息');
		$('#tabs').tabs('add',{
			title:'修改企业信息',
			href:'${ctx}/company/'+option,
			closable:true
		});
	}
	function closeCreateCompanyDialog(){
		$('#tabs').tabs('close','新增企业信息');

	}
	function closeEditCompanyDialog(){
		$('#tabs').tabs('close','修改企业信息');
	}
	
	//刷新当前tab  navTitle：导航title  tabTitle:标签页title url:相对应用的相对地址
	function refreshCurr(navTitle,tabTitle,url){
		$(".easyui-accordion1").accordion('select',navTitle);
		var tab = $('#tabs').tabs('getSelected');
		$('#tabs').tabs('update', {
			tab: tab,
			options: {
				title:tabTitle,
				//用iframe渲染新页面，如果用href属性，会导致easyui样式丢失
				content : '<iframe scrolling="auto" frameborder="0"  src="${ctx}/'+url+'" style="width:100%;height:100%;"></iframe>'
			}
		});
		//一定要加上这句话，不然无法加载到页面
		tab.panel('refresh');
	}
	
	//刷新指定tab
	function refreshTab(navTitle,tabTitle,url){
		$(".easyui-accordion1").accordion('select',navTitle);
		$('#tabs').tabs('select',tabTitle);
		refreshCurr(navTitle, tabTitle, url);
	}
</script>

</head>

<body class="easyui-layout" style="overflow-y: hidden" scroll="no">


	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 65px; background: url(./static/images/logo1.jpg) #7f99be; background-repeat: no-repeat; line-height: 20px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
		<span style="float: right; padding-right: 20px;" class="head">欢迎
			${staff.name} (${role.name}) <a href="javascript:changePassword();">密码修改</a>
			<a href="${ctx }/logout">安全退出</a>
		</span>
		<div>
			<div style="width:80px;height:80px; float: left;" onclick="window.location.reload();">
			</div>
			<div style="padding-left: 90px; padding-top: 25px">
				<!-- Damocles Sysetem V1.0 -->
			</div>
		</div>
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2;">
		<div class="footer">Sisyphus Sysetem 版权@Sisyphus</div>
	</div>

	<div region="west" split="true" title="导航菜单" style="width: 180px;"
		id="west">
		<div class="easyui-accordion1" fit="true" border="false">
			<!--  导航内容 -->
		</div>
	</div>

	<div id="mainPanle" region="center" style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">
				<h1>Welcome to the Sisyphus system (v1.0.0-beta)!</h1>
			</div>
		</div>
		<div id="tabs" style=""></div>
	</div>

	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>

	<!-- 修改密码 -->
	<div id="Password_dlg" class="easyui-dialog" iconCls="icon-edit"
		style="width: 400px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#Password_dlg-buttons">
		<form id="Password_fm" method="post">
			<table class="m_table" style="width: 100%;">
				<tr>
					<td><label>账号</label></td>
					<td><input type="hidden" name="staffid" value="${staff.id}">${staff.name}
					</td>
				</tr>
				<tr>
					<td><label>登录名</label></td>
					<td><input type="hidden" name="loginInfoid"
						value="${loginInfo.id}">${loginInfo.username}</td>
				</tr>
				<tr>
					<td><label class="bitian">原密码</label></td>
					<td><input class="easyui-validatebox" type="password"
						name="password" id="password" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<td><label class="bitian">新密码</label></td>
					<td><input class="easyui-validatebox" type="password"
						name="newPassword" id="newPassword" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<td><label class="bitian">重复新密码</label></td>
					<td><input class="easyui-validatebox" type="password"
						name="newPassword2" id="newPassword2" data-options="required:true"
						validType="passwordEqual" /></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 修改密码保存取消 -->
	<div id="Password_dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="savePassword()">保存</a> <a href="#" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#Password_dlg').dialog('close')">取消</a>
	</div>
</body>
</html>
