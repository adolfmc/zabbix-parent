package com.zabbix.sisyphus.contract.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the con_t_fortune_pro database table.
 */
@Entity
@Table(name = "con_t_fortune_pro")
public class FortunePro extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    private String productName;

    private String productCode;

    private BigDecimal number;

    private BigDecimal amount;

    private BigDecimal hasAmount;


    private BigDecimal freezwAmount;

    private BigDecimal fee;

    private BigDecimal serviceCharge;

    private BigDecimal mangerFree;

    private BigDecimal interest;

    private BigDecimal totalCost;

    private BigDecimal totalFee;
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    private String oldMemo1;

    private String status;



    private String memo;

    private String memo2;

    private String memo3;


    public FortunePro() {
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getHasAmount() {
        return hasAmount;
    }

    public void setHasAmount(BigDecimal hasAmount) {
        this.hasAmount = hasAmount;
    }

    public BigDecimal getFreezwAmount() {
        return freezwAmount;
    }

    public void setFreezwAmount(BigDecimal freezwAmount) {
        this.freezwAmount = freezwAmount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public BigDecimal getMangerFree() {
        return mangerFree;
    }

    public void setMangerFree(BigDecimal mangerFree) {
        this.mangerFree = mangerFree;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOldMemo1() {
        return oldMemo1;
    }

    public void setOldMemo1(String oldMemo1) {
        this.oldMemo1 = oldMemo1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }
}