package com.zabbix.sisyphus.risk.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.zabbix.sisyphus.base.entity.IdEntity;
import com.zabbix.sisyphus.credit.entity.CreditInfo;
import com.zabbix.sisyphus.risk.enu.AuditInfoFlowId;
import com.zabbix.sisyphus.uc.entity.Staff;


/**
 * The persistent class for the cd_t_audit_info database table.
 * 
 */
@Entity
@Table(name="cd_t_audit_info")
public class AuditInfo extends IdEntity{
	private static final long serialVersionUID = 1L;
	
	private Long creditId;
	
	@Transient
	public Long getCreditId() {
		return creditId;
	}

	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}

	@Column(name="audit_amount")
	private BigDecimal auditAmount;

	@Column(name="audit_deadline")
	private int auditDeadline;

	@Column(name="audit_fee")
	private BigDecimal auditFee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_time")
	private Date auditTime;

	private BigDecimal balance;

	@Column(name="bank_id")
	private String bankId;

	@Column(name="corporate_information")
	private String corporateInformation;


	@Column(name="credit_port")
	private String creditPort;


	@Column(name="flow_id")
	private String flowId;

	private String idcard;

	private String income;

	private String memo;

	@Column(name="operation_status")
	private String operationStatus;

	private String scale;

	private String status;

	@Column(name="work_permit")
	private String workPermit;

	public AuditInfo() {
	}

	public BigDecimal getAuditAmount() {
		return this.auditAmount;
	}

	public void setAuditAmount(BigDecimal auditAmount) {
		this.auditAmount = auditAmount;
	}

	public int getAuditDeadline() {
		return this.auditDeadline;
	}

	public void setAuditDeadline(int auditDeadline) {
		this.auditDeadline = auditDeadline;
	}

	public BigDecimal getAuditFee() {
		return this.auditFee;
	}

	public void setAuditFee(BigDecimal auditFee) {
		this.auditFee = auditFee;
	}

	public Date getAuditTime() {
		return this.auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getCorporateInformation() {
		return this.corporateInformation;
	}

	public void setCorporateInformation(String corporateInformation) {
		this.corporateInformation = corporateInformation;
	}


	public String getCreditPort() {
		return this.creditPort;
	}

	public void setCreditPort(String creditPort) {
		this.creditPort = creditPort;
	}

	public String getFlowId() {
		return this.flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIncome() {
		return this.income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOperationStatus() {
		return this.operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkPermit() {
		return this.workPermit;
	}

	public void setWorkPermit(String workPermit) {
		this.workPermit = workPermit;
	}


	@Transient
	public String getFlowIdView(){
		for(AuditInfoFlowId flowId:AuditInfoFlowId.values()){
			if(flowId.code.equals(this.flowId)){
				return flowId.name();
			}
		}
		return "";
	}
	
	private CreditInfo creditInfo;

	@OneToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "credit_id", referencedColumnName = "id", unique = true)
	public CreditInfo getCreditInfo() {
		return creditInfo;
	}

	public void setCreditInfo(CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
	}
	
	private Staff createUser;

	@OneToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "create_user_id", referencedColumnName = "id", unique = true
	,insertable=false,updatable=false)
	public Staff getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Staff createUser) {
		this.createUser = createUser;
	}

	@Transient
	public BigDecimal getAskFee(){
		return creditInfo.getAskFee();
	}
	@Transient
	public BigDecimal getAmount(){
		return creditInfo.getAmount();
	}
	@Transient
	public Integer getDeadline(){
		return creditInfo.getDeadline();
	}

}