package com.zabbix.sisyphus.licaipro.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 作者: zabbix 创建于 16/10/25.
 */
@Entity
@Table(name = "t_user_info")
public class UserInfo {
    private  String email;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long uuid;
    
    private String password;
    
    private String source;
    
    private Date createTime = new Date();
    
    private String createIp;

    private String mobile;

    private String trueName;

    private String userHeadUrl;
    
    private String idcard;

    private Byte isBindCard;

    private Byte isPayPasswd;

    private Byte isBindEmail;

    private Byte secureLevel;

    private BigDecimal keyongMoney;

    private BigDecimal dongjieMoney;

    private BigDecimal daishouMoney;

    private BigDecimal totalChargeMoney;

    private BigDecimal totalQuxianMoney;

    private BigDecimal totalYield;
    
    private Date trueNameTime;
    
    private Date mobileVerifyTime;
    




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Byte getIsBindCard() {
        return isBindCard;
    }

    public void setIsBindCard(Byte isBindCard) {
        this.isBindCard = isBindCard;
    }

    public Byte getIsPayPasswd() {
        return isPayPasswd;
    }

    public void setIsPayPasswd(Byte isPayPasswd) {
        this.isPayPasswd = isPayPasswd;
    }

    public Byte getIsBindEmail() {
        return isBindEmail;
    }

    public void setIsBindEmail(Byte isBindEmail) {
        this.isBindEmail = isBindEmail;
    }

    public Byte getSecureLevel() {
        return secureLevel;
    }

    public void setSecureLevel(Byte secureLevel) {
        this.secureLevel = secureLevel;
    }

    public BigDecimal getKeyongMoney() {
        return keyongMoney;
    }

    public void setKeyongMoney(BigDecimal keyongMoney) {
        this.keyongMoney = keyongMoney;
    }

    public BigDecimal getDongjieMoney() {
        return dongjieMoney;
    }

    public void setDongjieMoney(BigDecimal dongjieMoney) {
        this.dongjieMoney = dongjieMoney;
    }

    public BigDecimal getDaishouMoney() {
        return daishouMoney;
    }

    public void setDaishouMoney(BigDecimal daishouMoney) {
        this.daishouMoney = daishouMoney;
    }

    public BigDecimal getTotalChargeMoney() {
        return totalChargeMoney;
    }

    public void setTotalChargeMoney(BigDecimal totalChargeMoney) {
        this.totalChargeMoney = totalChargeMoney;
    }

    public BigDecimal getTotalQuxianMoney() {
        return totalQuxianMoney;
    }

    public void setTotalQuxianMoney(BigDecimal totalQuxianMoney) {
        this.totalQuxianMoney = totalQuxianMoney;
    }

    public BigDecimal getTotalYield() {
        return totalYield;
    }

    public void setTotalYield(BigDecimal totalYield) {
        this.totalYield = totalYield;
    }

    public Date getTrueNameTime() {
        return trueNameTime;
    }

    public void setTrueNameTime(Date trueNameTime) {
        this.trueNameTime = trueNameTime;
    }

    public Date getMobileVerifyTime() {
        return mobileVerifyTime;
    }

    public void setMobileVerifyTime(Date mobileVerifyTime) {
        this.mobileVerifyTime = mobileVerifyTime;
    }

}
