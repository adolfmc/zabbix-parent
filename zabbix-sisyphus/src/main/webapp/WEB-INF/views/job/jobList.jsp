<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>任务管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span offset">
			<form class="form-search" action="#">
				<label>职位：</label> <input type="text" name="titile" class="input-medium" value="${titile==null?"产品":(titile)}">
				<label>开始时间：</label> <input type="text" name="starttime" class="input-medium" value="${starttime==null?"2016-09-15 10:00:00":(starttime)}" > 
				<label>结束时间：</label> <input type="text" name="endtime" class="input-medium" value="${endtime==null?"2016-09-15 22:00:00":(endtime)}">  
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
		<tr>
			<th width="30px">序号</th>
			<th>公司</th>
			<th>职位</th>
			<th>类型</th
			<th></th>
			<th>薪水</th>
			<th width="80px">时间</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${tasks}" var="task" begin="1" step="1" varStatus="status">
			<tr>
				<td><c:out value="${status.index}"/>
				<td>
				<c:choose>
					<c:when test="${task.url=='null'}">
						${task.company}
					</c:when>
					<c:otherwise>
						<a href="${task.url=="null"?"https://www.liepin.com":(task.url)}" target="_blank">${task.company}</a>
					</c:otherwise>
				</c:choose>
				</td>
				
				<td>
				<c:choose>
					<c:when test="${task.url=='null'}">
					${task.titile}
					</c:when>
					<c:otherwise>
						<a href="${task.url=="null"?"https://www.liepin.com":(task.url)}" target="_blank">${task.titile}</a>
					</c:otherwise>
				</c:choose>
				</td>
				<td>${task.jobxz}</a></td>
				<td>${task.salary}</a></td>
				<td>${task.memo}</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
