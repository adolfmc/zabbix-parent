package com.zabbix.sisyphus.contract.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 借贷产品
 *@author zabbix
 *2016年10月19日
 */
@Entity
@Table(name="con_t_credit_pro")
public class CreditPro extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal amount;

	@Temporal(TemporalType.DATE)
	@Column(name="end_time")
	private Date endTime;

	private BigDecimal fee;

	private BigDecimal interest;

	@Column(name="into_amount")
	private BigDecimal intoAmount;

	@Column(name="manger_free")
	private BigDecimal mangerFree;

	private String memo;

	private BigDecimal number;

	@Column(name="pay_way")
	private String payWay;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="repayment_amount")
	private BigDecimal repaymentAmount;

	@Column(name="service_charge")
	private BigDecimal serviceCharge;

	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	private Date startTime;

	private String status;

	@Column(name="total_cost")
	private BigDecimal totalCost;

	@Column(name="total_fee")
	private BigDecimal totalFee;

	public CreditPro() {
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getFee() {
		return this.fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public BigDecimal getInterest() {
		return this.interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getIntoAmount() {
		return this.intoAmount;
	}

	public void setIntoAmount(BigDecimal intoAmount) {
		this.intoAmount = intoAmount;
	}

	public BigDecimal getMangerFree() {
		return this.mangerFree;
	}

	public void setMangerFree(BigDecimal mangerFree) {
		this.mangerFree = mangerFree;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public BigDecimal getNumber() {
		return this.number;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public String getPayWay() {
		return this.payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getRepaymentAmount() {
		return this.repaymentAmount;
	}

	public void setRepaymentAmount(BigDecimal repaymentAmount) {
		this.repaymentAmount = repaymentAmount;
	}

	public BigDecimal getServiceCharge() {
		return this.serviceCharge;
	}

	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

}