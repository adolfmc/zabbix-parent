package com.zabbix.sisyphus.crm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.zabbix.sisyphus.base.entity.IdEntity;


/**
 * The persistent class for the crm_t_company_info database table.
 * 
 */
@Entity
@Table(name="crm_t_company_info")
public class CompanyInfo extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String annualSales;

	private String assetStatus;

	private String corporateInformation;

	private String customerCode;

	private String established;

	private String flowId;

	private String industry;

	private String jobAdress;

	private String liabilities;

	private String memo;

	private String moneyPurpose;

	private String name;

	private String operationStatus;

	private String registeredCapital;

	private String scale;

	private String status;

	private String upsadown;
	
	private String phoneNum;

	public CompanyInfo() {
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAnnualSales() {
		return this.annualSales;
	}

	public void setAnnualSales(String annualSales) {
		this.annualSales = annualSales;
	}

	public String getAssetStatus() {
		return this.assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getCorporateInformation() {
		return this.corporateInformation;
	}

	public void setCorporateInformation(String corporateInformation) {
		this.corporateInformation = corporateInformation;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getEstablished() {
		return this.established;
	}

	public void setEstablished(String established) {
		this.established = established;
	}

	public String getFlowId() {
		return this.flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getJobAdress() {
		return this.jobAdress;
	}

	public void setJobAdress(String jobAdress) {
		this.jobAdress = jobAdress;
	}

	public String getLiabilities() {
		return this.liabilities;
	}

	public void setLiabilities(String liabilities) {
		this.liabilities = liabilities;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMoneyPurpose() {
		return this.moneyPurpose;
	}

	public void setMoneyPurpose(String moneyPurpose) {
		this.moneyPurpose = moneyPurpose;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperationStatus() {
		return this.operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	public String getRegisteredCapital() {
		return this.registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
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

	public String getUpsadown() {
		return this.upsadown;
	}

	public void setUpsadown(String upsadown) {
		this.upsadown = upsadown;
	}

	public static void main(String[] args) {
		DateTime datetime = DateTime.now();
		System.out.println(datetime.dayOfMonth().roundFloorCopy());
		System.out.println(String.format("%04d", 1));
	}
}