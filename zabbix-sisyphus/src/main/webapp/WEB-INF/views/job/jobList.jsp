<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>任务管理</title>

<script type="text/javascript">  
  
$(document).ready(function () { 
	QueryData();   
}); 

function QueryData(){  
 	var titile = $("#titile").val();  
 	var jobxz = $("#jobxz").combobox('getValue');
 	var starttime = $("#starttime").val();
 	var endtime = $("#endtime").val();  
 	$.ajax({
	 	url: "/job/pages"
	 	,data: jQuery.param({ "titile": titile,"jobxz":jobxz,"starttime":starttime,"endtime":endtime})
		,success: function(data) {
		    $("#dt").datagrid('loadData', data);
		}
	});  
};  

function formatOpt(val,row){
	if(row.url!=null && row.rul!='' && row.rul!='defined'){
		return '<a href='+row.url+' target="_blank">'+row.company+'</a>';
	}else{
		return 'row.company';
	}
}  
</script>

</head>

<body>
<div id="tb" style="padding:2px;height:auto">  
   职位:<input id="titile" class="easyui-validatebox" style="width:200px" value="产品"/>   
   性质:
	<select id="jobxz" class="easyui-combobox" name="dept" style="width:50px;">
		<option value=""></option>
		<option value="企">企</option>
		<option value="猎">猎</option>
	</select>
   开始:<input id="starttime" class="easyui-validatebox" style="width:130px" value="2016-12-01 07:00:00"/>
   结束:<input id="endtime" class="easyui-validatebox" style="width:130px" value="2016-12-01 22:00:00" />
   <a id="btnQuery" href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="QueryData()">查询</a>    
</div>  

 <table id="dt" class="easyui-datagrid"  data-options="title:'猎聘职位查询',rownumbers:true,toolbar:'#tb',fit:true,fitColumns:true,pagination:false,singleSelect:true">    
    <thead>    
        <tr>    
            <th data-options="field:'id',hidden:true">编号</th>    
            <th data-options="field:'titile'">职位</th>  
            <th data-options="field:'company',formatter:formatOpt">公司</th>
            <th data-options="field:'salary'">薪水</th>  
            <th data-options="field:'jobxz'">性质</th>
            <th data-options="field:'memo'">日期</th>    
        </tr>    
    </thead>    
</table>  

</body>
</html>
