package com.zabbix.sisyphus.licaipro.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 作者: zabbix 创建于 16/10/25.
 */
@Entity
@Table(name = "t_licai_order_info")
public class LicaiOrderInfo extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = 2957967108978764494L;
	private String orderid; //订单号
    private Byte orderType; //订单类型
    private Byte payType; //支付方式:1=新浪支付
    private Date createTime; //创建时间
    private String createIp; //创建ip
    private Date finishTime; //支付完成时间
    private String thirdPartOrderid; //第三方单号
    private Date tradeCreateTime; //交易创建时间
    private Date tradePayTime; //交易支付时间
    private Date tradeCloseTime; //交易关闭时间
    private Integer pid; //产品id
    private String pname; //产品名称
    private Long uuid; //账号id
    private String mobile; //手机号
    private BigDecimal buyNum; //购买金额
    private BigDecimal buyActualNum; //实收金额
    private BigDecimal buyHongbaoNum; //红包参数值
    private String hongbaoId; //红包id
    private Byte hongbaoType; //1=理财金(虚拟本金只增加利息)，2=现金券（抵扣用户本金），3=加息券（只增加利息），type不同对应的buy_hongbao_num的含义不同，计算的refund_erest值不同
    private String memo; //备注信息
    private String extraInto; //订单额外信息
    private String refundOrderid; //退款订单号
    private Byte status; //订单状态:1=待付款,11=支付中,2=付款成功,3=付款失败,4=用户取消,5=超时关闭,6=申请退款,7=已退款,8-退款中,9-计息中,12= 结息中,10-已还款,13=已结息
    private Byte refundStatus; //退款状态:0 - 正常 1 - 自动退款
    private Date updTime; //最后更新时间
    private Date blockDate; //资金冻结日期
    private Date startEarnDate; //资金开始收益日期
    private Date refundDate; //回款日期
    private BigDecimal refundNum; //回款本金
    private BigDecimal refundInterest; //回款利息
    private Integer isSend; //是否发送过购买成功消息:0=未发送,1=已发送

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
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

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getThirdPartOrderid() {
        return thirdPartOrderid;
    }

    public void setThirdPartOrderid(String thirdPartOrderid) {
        this.thirdPartOrderid = thirdPartOrderid;
    }

    public Date getTradeCreateTime() {
        return tradeCreateTime;
    }

    public void setTradeCreateTime(Date tradeCreateTime) {
        this.tradeCreateTime = tradeCreateTime;
    }

    public Date getTradePayTime() {
        return tradePayTime;
    }

    public void setTradePayTime(Date tradePayTime) {
        this.tradePayTime = tradePayTime;
    }

    public Date getTradeCloseTime() {
        return tradeCloseTime;
    }

    public void setTradeCloseTime(Date tradeCloseTime) {
        this.tradeCloseTime = tradeCloseTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(BigDecimal buyNum) {
        this.buyNum = buyNum;
    }

    public BigDecimal getBuyActualNum() {
        return buyActualNum;
    }

    public void setBuyActualNum(BigDecimal buyActualNum) {
        this.buyActualNum = buyActualNum;
    }

    public BigDecimal getBuyHongbaoNum() {
        return buyHongbaoNum;
    }

    public void setBuyHongbaoNum(BigDecimal buyHongbaoNum) {
        this.buyHongbaoNum = buyHongbaoNum;
    }

    public String getHongbaoId() {
        return hongbaoId;
    }

    public void setHongbaoId(String hongbaoId) {
        this.hongbaoId = hongbaoId;
    }

    public Byte getHongbaoType() {
        return hongbaoType;
    }

    public void setHongbaoType(Byte hongbaoType) {
        this.hongbaoType = hongbaoType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getExtraInto() {
        return extraInto;
    }

    public void setExtraInto(String extraInto) {
        this.extraInto = extraInto;
    }

    public String getRefundOrderid() {
        return refundOrderid;
    }

    public void setRefundOrderid(String refundOrderid) {
        this.refundOrderid = refundOrderid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Byte refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Date getBlockDate() {
        return blockDate;
    }

    public void setBlockDate(Date blockDate) {
        this.blockDate = blockDate;
    }

    public Date getStartEarnDate() {
        return startEarnDate;
    }

    public void setStartEarnDate(Date startEarnDate) {
        this.startEarnDate = startEarnDate;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public BigDecimal getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(BigDecimal refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getRefundInterest() {
        return refundInterest;
    }

    public void setRefundInterest(BigDecimal refundInterest) {
        this.refundInterest = refundInterest;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }
}
