package com.zabbix.sisyphus.credit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zabbix.sisyphus.base.common.FlowIdConstants;
import com.zabbix.sisyphus.credit.enu.CreditFlowId;
import com.zabbix.sisyphus.credit.enu.PayWay;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;


/**
 * 借款信息
 */
@Entity
@Table(name="cd_t_credit_info")
public class CreditInfo extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String creditNo;
	private Long creProId;
	private String creProName;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creditEndTime;

	private String creditUse;

	private Long customerId;
	
	private String customerName;
	
	private String customerPhone;
	
	private String customerType;
	private BigDecimal askFee;
	private BigDecimal amount;
	private Integer deadline;

	private String flowId;

	private String memo;

	private String mobile;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date payTime;

	private String payWay;

	private String status;

	private String subFlowId;
	
	public CreditInfo() {
	}
	
	private CompanyInfo companyInfo;
	
	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "id"
	,insertable=false,updatable=false)
	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	@Transient
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public BigDecimal getAskFee() {
		return askFee;
	}

	public void setAskFee(BigDecimal askFee) {
		this.askFee = askFee;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getCreProId() {
		return creProId;
	}

	public void setCreProId(Long creProId) {
		this.creProId = creProId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCreditEndTime() {
		return this.creditEndTime;
	}

	public void setCreditEndTime(Date creditEndTime) {
		this.creditEndTime = creditEndTime;
	}

	public String getCreditUse() {
		return this.creditUse;
	}

	public void setCreditUse(String creditUse) {
		this.creditUse = creditUse;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getDeadline() {
		return deadline;
	}

	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getSubFlowId() {
		return subFlowId;
	}

	public void setSubFlowId(String subFlowId) {
		this.subFlowId = subFlowId;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPayWay() {
		return this.payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCreProName() {
		return creProName;
	}

	public void setCreProName(String creProName) {
		this.creProName = creProName;
	}
	
	public String getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

	@Transient
	public String getPayWayView(){
		for(PayWay way:PayWay.values()){
			if(way.code.equals(payWay)){
				return way.name();
			}
		}
		return "";
	}
	
	@Transient
	public String getFlowIdView(){
		for(CreditFlowId flowId:CreditFlowId.values()){
			if(flowId.code.equals(this.flowId)){
				return flowId.name();
			}
		}
		return "";
	}
	
	@Transient
	public String getSubFlowIdView(){
		return FlowIdConstants.flowIdView(subFlowId);
	}
	
	private String creditInfo;
	public String getCreditInfo() {
		return creditInfo;
	}
	public void setCreditInfo(String creditInfo) {
		this.creditInfo = creditInfo;
	}
	
}