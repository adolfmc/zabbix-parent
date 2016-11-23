package com.zabbix.sisyphus.esb.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zabbix.sisyphus.contract.entity.ProjectTag;
import com.zabbix.sisyphus.credit.entity.CreditDetail;
import com.zabbix.sisyphus.crm.entity.Attachment;
import com.zabbix.sisyphus.licaipro.entity.AlreadyPurchasedUser;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 作者: zabbix 创建于 16/10/24.
 */
public class TenderPlanVO {


    private Date auditTime;

    private String xieyiUrl;


    private BigDecimal amount;

    private int deadline;

    @JsonIgnore
    private String flowId;

    private BigDecimal irr;

    private String memo;

    private Long fortuneProId;

    private String produCode;

    private String fortuneProName;

    private BigDecimal recommandIrr;

    private BigDecimal resAmount;

    private String status;

    private BigDecimal rewardIrr;

    private String tenderDesc;

    private String tenderName;

    private Integer oldLicaiProId;

    private Date tenderStart;

    private Date tenderEnd;

    private  Long contractId;

    private CreditDetail creditDetail;

    //附件信息
    List<Attachment> attachments;

    //老工程字段
    private BigDecimal remainAmount; //剩余金额
    private List<ProjectTag> tags; // 标签

    //项目详情
    private String operationStatus;// '风控结论',
    private String scale;//'贷后管理'
    private String corporateInformation; //'风险提示',

    //投资记录
    List<AlreadyPurchasedUser> purchasedUser;

    private Integer buyMinNum; //最小购买金额

    private BigDecimal totalBuyNum; //购买数量

    private Integer projectStatus; //项目状态

    private Integer repayment; //支付方式

    private Date createTime;
    private Date yureEndTime;
    private Date buyEndTime;

    //创建时间

    private  String  idcard;
    private  String bankId;
    private  String  creditPort;
    private  String income;
    private  String workPermit;


    public String getIdcard() {
        return idcard;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getXieyiUrl() {
        return xieyiUrl;
    }

    public void setXieyiUrl(String xieyiUrl) {
        this.xieyiUrl = xieyiUrl;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getCreditPort() {
        return creditPort;
    }

    public void setCreditPort(String creditPort) {
        this.creditPort = creditPort;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getWorkPermit() {
        return workPermit;
    }

    public void setWorkPermit(String workPermit) {
        this.workPermit = workPermit;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public CreditDetail getCreditDetail() {
        return creditDetail;
    }

    public void setCreditDetail(CreditDetail creditDetail) {
        this.creditDetail = creditDetail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getYureEndTime() {
        return yureEndTime;
    }

    public void setYureEndTime(Date yureEndTime) {
        this.yureEndTime = yureEndTime;
    }

    public Date getBuyEndTime() {
        return buyEndTime;
    }

    public void setBuyEndTime(Date buyEndTime) {
        this.buyEndTime = buyEndTime;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public Integer getRepayment() {
        return repayment;
    }

    public void setRepayment(Integer repayment) {
        this.repayment = repayment;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public BigDecimal getTotalBuyNum() {
        return totalBuyNum;
    }

    public void setTotalBuyNum(BigDecimal totalBuyNum) {
        this.totalBuyNum = totalBuyNum;
    }

    public Integer getBuyMinNum() {
        return buyMinNum;
    }

    public void setBuyMinNum(Integer buyMinNum) {
        this.buyMinNum = buyMinNum;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<AlreadyPurchasedUser> getPurchasedUser() {
        return purchasedUser;
    }

    public void setPurchasedUser(List<AlreadyPurchasedUser> purchasedUser) {
        this.purchasedUser = purchasedUser;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
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

    public BigDecimal getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(BigDecimal remainAmount) {
        this.remainAmount = remainAmount;
    }

    public List<ProjectTag> getTags() {
        return tags;
    }

    public void setTags(List<ProjectTag> tags) {
        this.tags = tags;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public BigDecimal getIrr() {
        return irr;
    }

    public void setIrr(BigDecimal irr) {
        this.irr = irr;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getFortuneProId() {
        return fortuneProId;
    }

    public void setFortuneProId(Long fortuneProId) {
        this.fortuneProId = fortuneProId;
    }

    public String getProduCode() {
        return produCode;
    }

    public void setProduCode(String produCode) {
        this.produCode = produCode;
    }

    public String getFortuneProName() {
        return fortuneProName;
    }

    public void setFortuneProName(String fortuneProName) {
        this.fortuneProName = fortuneProName;
    }

    public BigDecimal getRecommandIrr() {
        return recommandIrr;
    }

    public void setRecommandIrr(BigDecimal recommandIrr) {
        this.recommandIrr = recommandIrr;
    }

    public BigDecimal getResAmount() {
        return resAmount;
    }

    public void setResAmount(BigDecimal resAmount) {
        this.resAmount = resAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getRewardIrr() {
        return rewardIrr;
    }

    public void setRewardIrr(BigDecimal rewardIrr) {
        this.rewardIrr = rewardIrr;
    }

    public String getTenderDesc() {
        return tenderDesc;
    }

    public void setTenderDesc(String tenderDesc) {
        this.tenderDesc = tenderDesc;
    }

    public String getTenderName() {
        return tenderName;
    }

    public void setTenderName(String tenderName) {
        this.tenderName = tenderName;
    }

    public Integer getOldLicaiProId() {
        return oldLicaiProId;
    }

    public void setOldLicaiProId(Integer oldLicaiProId) {
        this.oldLicaiProId = oldLicaiProId;
    }

    public Date getTenderStart() {
        return tenderStart;
    }

    public void setTenderStart(Date tenderStart) {
        this.tenderStart = tenderStart;
    }

    public Date getTenderEnd() {
        return tenderEnd;
    }

    public void setTenderEnd(Date tenderEnd) {
        this.tenderEnd = tenderEnd;
    }
}
