<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<style type="text/css">
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
th{font-weight:bold;background:#ccc;}
</style>

<script>
	$.parser.auto = false;
</script>


</head>
<body>
	<div>
        <h2>企业信息</h2>
        <table>
            <tr>
                <th>企业名称:</th>
                <td>${companyInfo.name}</td>
                <th>所属行业:</th>
                <td>${companyInfo.industry}</td>
            </tr>
            <tr>
                <th>成立年限:</th>
                <td>${companyInfo.established}</td>
                <th>注册资本:</th>
                <td>${companyInfo.registeredCapital}</td>
            </tr>
            <tr>
                <th>盈利状况:</th>
                <td>${companyInfo.operationStatus}</td>
                <th>企业规模:</th>
                <td>${companyInfo.scale}</td>
            </tr>
            <tr>
                <th>法人信息:</th>
                <td>${companyInfo.corporateInformation}</td>
                <th>资产负债情况:</th>
                <td>${companyInfo.liabilities}</td>
            </tr>
            <tr>
                <th>上下游情况:</th>
                <td>${companyInfo.upsadown}</td>
                <th>资产情况:</th>
                <td>${companyInfo.assetStatus}</td>
            </tr>
        </table>




        <h2>借款信息</h2>
        <table>
            <tr>
                <th>借款编号:</th>
                <td>${creditInfo.creditNo}</td>
                <th>借款金额:</th>
                <td><fmt:formatNumber value="${creditInfo.amount}"
                        type="number" /></td>
            </tr>
            <tr>
                <th>借款期数:</th>
                <td>${creditInfo.deadline}</td>
                <th>申请费率:</th>
                <td><fmt:formatNumber value="${creditInfo.askFee}"
                        type="number" /></td>
            </tr>
            <tr>
                <th>还款方式:</th>
                <td>${creditInfo.payWayView}</td>
            </tr>
        </table>

        <h2>审核信息</h2>
        <table>
            <tr>
                <th>身份证审核:</th>
                <td><c:choose>
                        <c:when test="${auditInfo.idcard=='1'}">通过</c:when>
                        <c:otherwise>不通过</c:otherwise>
                    </c:choose></td>
                <th>银行卡审核:</th>
                <td><c:choose>
                        <c:when test="${auditInfo.bankId=='1'}">通过</c:when>
                        <c:otherwise>不通过</c:otherwise>
                    </c:choose></td>
            </tr>
            <tr>
                <th>信用报告审核:</th>
                <td><c:choose>
                        <c:when test="${auditInfo.creditPort=='1'}">通过</c:when>
                        <c:otherwise>不通过</c:otherwise>
                    </c:choose></td>
                <th>收入证明审核:</th>
                <td><c:choose>
                    <c:when test="${auditInfo.income==1}">通过</c:when>
                    <c:otherwise>不通过</c:otherwise>
                </c:choose></td>
            </tr>
            <tr>
                <th>工作证明审核:</th>
                <td><c:choose>
                    <c:when test="${auditInfo.workPermit==1}">通过</c:when>
                    <c:otherwise>不通过</c:otherwise>
                </c:choose></td>
            </tr>
            <tr>
                <th>审批金额:</th>
                <td><fmt:formatNumber value="${auditInfo.auditAmount}"
                        type="number"></fmt:formatNumber></td>
                <th>审批期限:</th>
                <td>${auditInfo.auditDeadline}</td>
            </tr>
            <tr>
                <th>审批费率:</th>
                <td><fmt:formatNumber value="${auditInfo.auditFee}"
                        type="number" /></td>
                <th>剩余金额:</th>
                <td><fmt:formatNumber value="${auditInfo.balance}"
                        type="number"></fmt:formatNumber></td>
            </tr>

            <tr>
                <th>风控结论:</th>
                <td>${auditInfo.operationStatus}</td>
                <th>贷后管理:</th>
                <td>${auditInfo.scale}</td>
            </tr>
            <tr>
                <th>工作证审核:</th>
                <td>${auditInfo.corporateInformation}</td>
                <th>审批时间:</th>
                <td><fmt:formatDate value="${auditInfo.createdDate}"
                        pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
        </table>


        <h2>标的信息</h2>
        <table>
            <tr>
                <th>投标名称:</th>
                <td>${tenderPlan.tenderName}</td>
                <th>投标开始时间:</th>
                <td><fmt:formatDate value="${tenderPlan.tenderStart}"
                        pattern="yyyy-MM-dd HH:mm:ss" /></td>
            </tr>
            <tr>
                <th>投标结束时间:</th>
                <td><fmt:formatDate value="${tenderPlan.tenderEnd}"
                        pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <th>标的标记:</th>
                <td>${tenderPlan.tags}</td>
            </tr>
            <tr>
                <th>投标期限:</th>
                <td><fmt:formatNumber value="${tenderPlan.amount}"
                        type="number" /></td>
                <th>融资总额:</th>
                <td><fmt:formatNumber value="${tenderPlan.amount}"
                        type="number" /></td>
            </tr>
            <tr>
                <th>年利率:</th>
                <td><fmt:formatNumber value="${tenderPlan.irr}" type="number" /></td>
                <th>红包类型:</th>
                <td>${tenderPlan.hongBaoType}</td>
            </tr>
        </table>
        
        <h2>附件信息</h2>
        <table id="attachTable">
            <tr>
                <th>身份证:</th></tr><tr>
                <td colspan="3" >
                <c:if test="${attachmentMap['00040001']!=null}">
	                <c:forEach items="${attachmentMap['00040001']}" var="att">
	                	<img alt="" src="${att.filePath}">
	                </c:forEach>
                </c:if>
                </td>
            </tr>
            <tr>
                <th>信用报告:</th></tr><tr>
                <td colspan="3" >
                	<c:if test="${attachmentMap['00040003']!=null}">
	                <c:forEach items="${attachmentMap['00040003']}" var="att">
	                	<img alt="" src="${att.filePath}">
	                </c:forEach>
                </c:if>
                </td>
            </tr>
            <tr>
                <th>收入证明:</th></tr><tr>
                <td colspan="3" >
                	<c:if test="${attachmentMap['00040004']!=null}">
		                <c:forEach items="${attachmentMap['00040003']}" var="att">
		                	<img alt="" src="${att.filePath}">
		                </c:forEach>
	                </c:if>
                </td>
            </tr>
            <tr>
                <th>工作证:</th></tr><tr>
                <td colspan="3" >
                	<c:if test="${attachmentMap['00040005']!=null}">
		                <c:forEach items="${attachmentMap['00040005']}" var="att">
		                	<img alt="" src="${att.filePath}">
		                </c:forEach>
	                </c:if>
                </td>
            </tr>
            <tr>
                <th>企业资质:</th> </tr><tr>
                <td colspan="3" >
                	<c:if test="${attachmentMap['00040006']!=null}">
		                <c:forEach items="${attachmentMap['00040006']}" var="att">
		                	<img alt="" src="${att.filePath}">
		                </c:forEach>
	                </c:if>
                </td>
            </tr>
            <tr> <th>银行卡信息:</th></tr><tr>
                <td colspan="3" >
                	<c:if test="${attachmentMap['00040007']!=null}">
		                <c:forEach items="${attachmentMap['00040007']}" var="att">
		                	<img alt="" src="${att.filePath}">
		                </c:forEach>
	                </c:if>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>
