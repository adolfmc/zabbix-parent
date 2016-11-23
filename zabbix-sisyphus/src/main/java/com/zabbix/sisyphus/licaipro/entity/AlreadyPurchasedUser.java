package com.zabbix.sisyphus.licaipro.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 作者: zabbix 创建于 16/7/13.
 */
public class AlreadyPurchasedUser {
    private  String mobile;
    private Date time;
    private BigDecimal buyNum;
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(BigDecimal buyNum) {
        this.buyNum = buyNum;
    }
}
