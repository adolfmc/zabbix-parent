package com.zabbix.sisyphus.fortune.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zabbix.sisyphus.base.enu.Status;
import com.zabbix.sisyphus.contract.entity.ProjectTag;
import com.zabbix.sisyphus.fortune.enu.TenderPlanFlowId;


/**
 * The persistent class for the ft_t_tender_plan database table.
 * 
 */
@Entity
@Table(name="ft_t_tender_plan")
public class TenderPlan extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Byte type;

	private Byte subType;
	
	private String tags;
	
	private String subTypeName;
	
	private BigDecimal amount;

	private int deadline;

	private String flowId;

	private BigDecimal irr;

	private String memo;

	private Long fortuneProId; //关联的理财产品id
	
	private String produCode; //关联的理财产品code

	private String fortuneProName; //关联的理财产品名称
	
	private BigDecimal recommandIrr;

	private BigDecimal resAmount;
	
	private String status;

	private BigDecimal rewardIrr;

	private String tenderDesc;

	private String tenderName;
	
	private Integer oldLicaiProId;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date tenderStart;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date tenderEnd;

	public TenderPlan() {
	}

	@Transient
	private Long creditInfoId; //关联的借款信息id
	@Transient
	private List<ProjectTag> tagList;  //关联的tag
	
	@Transient
	public List<ProjectTag> getTagList() {
		return tagList;
	}
	public void setTagList(List<ProjectTag> tagList) {
		this.tagList = tagList;
	}
	public Long getCreditInfoId() {
		return creditInfoId;
	}
	public void setCreditInfoId(Long creditInfoId) {
		this.creditInfoId = creditInfoId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getDeadline() {
		return this.deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public String getFlowId() {
		return this.flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public BigDecimal getIrr() {
		return this.irr;
	}

	public void setIrr(BigDecimal irr) {
		this.irr = irr;
	}

	public String getMemo() {
		return this.memo;
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

	public String getFortuneProName() {
		return fortuneProName;
	}

	public void setFortuneProName(String fortuneProName) {
		this.fortuneProName = fortuneProName;
	}

	public BigDecimal getRecommandIrr() {
		return this.recommandIrr;
	}

	public void setRecommandIrr(BigDecimal recommandIrr) {
		this.recommandIrr = recommandIrr;
	}

	public BigDecimal getResAmount() {
		return this.resAmount;
	}

	public void setResAmount(BigDecimal resAmount) {
		this.resAmount = resAmount;
	}

	public BigDecimal getRewardIrr() {
		return this.rewardIrr;
	}

	public void setRewardIrr(BigDecimal rewardIrr) {
		this.rewardIrr = rewardIrr;
	}

	public String getTenderDesc() {
		return this.tenderDesc;
	}

	public void setTenderDesc(String tenderDesc) {
		this.tenderDesc = tenderDesc;
	}

	public String getTenderName() {
		return this.tenderName;
	}

	public void setTenderName(String tenderName) {
		this.tenderName = tenderName;
	}

	public Date getTenderStart() {
		return this.tenderStart;
	}

	public void setTenderStart(Date tenderStart) {
		this.tenderStart = tenderStart;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProduCode() {
		return produCode;
	}

	public void setProduCode(String produCode) {
		this.produCode = produCode;
	}

	public Date getTenderEnd() {
		return tenderEnd;
	}

	public void setTenderEnd(Date tenderEnd) {
		this.tenderEnd = tenderEnd;
	}

	public Integer getOldLicaiProId() {
		return oldLicaiProId;
	}

	public void setOldLicaiProId(Integer oldLicaiProId) {
		this.oldLicaiProId = oldLicaiProId;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte getSubType() {
		return subType;
	}

	public void setSubType(Byte subType) {
		this.subType = subType;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Transient
	public boolean isDeleted(){
		return Status.unvalid.code.equals(status);
	}
	
	@Transient
	public String getFlowIdView(){
		for(TenderPlanFlowId flowId:TenderPlanFlowId.values()){
			if(flowId.code.equals(this.flowId)){
				return flowId.name();
			}
		}
		return "";
	}
	
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date raiseEndTime;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date yureEndTime;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date buyEndTime;
	
	private String hongBaoType;

	public Date getRaiseEndTime() {
		return raiseEndTime;
	}
	public void setRaiseEndTime(Date raiseEndTime) {
		this.raiseEndTime = raiseEndTime;
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
	public String getHongBaoType() {
		return hongBaoType;
	}
	public void setHongBaoType(String hongBaoType) {
		this.hongBaoType = hongBaoType;
	}
	
	public Long contractId;

	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
}