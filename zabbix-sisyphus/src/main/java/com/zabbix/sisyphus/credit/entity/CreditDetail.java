package com.zabbix.sisyphus.credit.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者: zabbix 创建于 16/10/26.
 */
public class CreditDetail {

    private BigDecimal amount;
    private Integer deadline;
    private BigDecimal  irr;
    private String jobAdress;
    private String industry;
    private String scale;
    private String corporateInformation;
    private String liabilities;
    private String upsadown;
    private String assetStatus;
    private String annualSales;
    private String creditUse;
    private String payWay;
    private Date tenderEnd;

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public BigDecimal getIrr() {
        return irr;
    }

    public void setIrr(BigDecimal irr) {
        this.irr = irr;
    }

    public String getJobAdress() {
        return jobAdress;
    }

    public void setJobAdress(String jobAdress) {
        this.jobAdress = jobAdress;
    }


    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getCorporateInformation() {
        return corporateInformation;
    }

    public void setCorporateInformation(String corporateInformation) {
        this.corporateInformation = corporateInformation;
    }

    public String getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(String liabilities) {
        this.liabilities = liabilities;
    }

    public String getUpsadown() {
        return upsadown;
    }

    public void setUpsadown(String upsadown) {
        this.upsadown = upsadown;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(String annualSales) {
        this.annualSales = annualSales;
    }

    public String getCreditUse() {
        return creditUse;
    }

    public void setCreditUse(String creditUse) {
        this.creditUse = creditUse;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Date getTenderEnd() {
        return tenderEnd;
    }

    public void setTenderEnd(Date tenderEnd) {
        this.tenderEnd = tenderEnd;
    }
}
