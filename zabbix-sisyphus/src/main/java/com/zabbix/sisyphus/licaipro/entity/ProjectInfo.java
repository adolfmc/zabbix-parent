package com.zabbix.sisyphus.licaipro.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_licai_project_info")
public class ProjectInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="buy_end_time")
	private Date buyEndTime;

	@Column(name="buy_min_num")
	private BigDecimal buyMinNum;

	@Column(name="company_id")
	private int companyId;

	@Column(name="create_ip")
	private String createIp;

	@Column(name="create_mobile")
	private String createMobile;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	private String display;

	@Column(name="hongbao_types")
	private String hongbaoTypes;

	@Column(name="invest_limit_pre_user")
	private BigDecimal investLimitPreUser;

	@Column(name="invest_period")
	private int investPeriod;

	@Column(name="is_new_project")
	private byte isNewProject;

	@Column(name="penalty_days")
	private int penaltyDays;

	@Column(name="project_name")
	private String projectName;

	@Column(name="project_order")
	private int projectOrder;

	@Column(name="project_status")
	private byte projectStatus;

	@Column(name="project_sub_type")
	private byte projectSubType;

	@Column(name="project_type")
	private byte projectType;

	@Temporal(TemporalType.DATE)
	@Column(name="refund_date")
	private Date refundDate;

	@Column(name="remain_num")
	private BigDecimal remainNum;

	private byte repayment;

	private String tags;

	@Column(name="total_buy_num")
	private BigDecimal totalBuyNum;

	@Column(name="total_num")
	private BigDecimal totalNum;

	@Column(name="year_rate")
	private BigDecimal yearRate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="yure_end_time")
	private Date yureEndTime;

	public ProjectInfo() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getBuyEndTime() {
		return this.buyEndTime;
	}

	public void setBuyEndTime(Date buyEndTime) {
		this.buyEndTime = buyEndTime;
	}

	public BigDecimal getBuyMinNum() {
		return this.buyMinNum;
	}

	public void setBuyMinNum(BigDecimal buyMinNum) {
		this.buyMinNum = buyMinNum;
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCreateIp() {
		return this.createIp;
	}

	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}

	public String getCreateMobile() {
		return this.createMobile;
	}

	public void setCreateMobile(String createMobile) {
		this.createMobile = createMobile;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getHongbaoTypes() {
		return this.hongbaoTypes;
	}

	public void setHongbaoTypes(String hongbaoTypes) {
		this.hongbaoTypes = hongbaoTypes;
	}

	public BigDecimal getInvestLimitPreUser() {
		return this.investLimitPreUser;
	}

	public void setInvestLimitPreUser(BigDecimal investLimitPreUser) {
		this.investLimitPreUser = investLimitPreUser;
	}

	public int getInvestPeriod() {
		return this.investPeriod;
	}

	public void setInvestPeriod(int investPeriod) {
		this.investPeriod = investPeriod;
	}

	public byte getIsNewProject() {
		return this.isNewProject;
	}

	public void setIsNewProject(byte isNewProject) {
		this.isNewProject = isNewProject;
	}

	public int getPenaltyDays() {
		return this.penaltyDays;
	}

	public void setPenaltyDays(int penaltyDays) {
		this.penaltyDays = penaltyDays;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectOrder() {
		return this.projectOrder;
	}

	public void setProjectOrder(int projectOrder) {
		this.projectOrder = projectOrder;
	}

	public byte getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(byte projectStatus) {
		this.projectStatus = projectStatus;
	}

	public byte getProjectSubType() {
		return this.projectSubType;
	}

	public void setProjectSubType(byte projectSubType) {
		this.projectSubType = projectSubType;
	}

	public byte getProjectType() {
		return this.projectType;
	}

	public void setProjectType(byte projectType) {
		this.projectType = projectType;
	}

	public Date getRefundDate() {
		return this.refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public BigDecimal getRemainNum() {
		return this.remainNum;
	}

	public void setRemainNum(BigDecimal remainNum) {
		this.remainNum = remainNum;
	}

	public byte getRepayment() {
		return this.repayment;
	}

	public void setRepayment(byte repayment) {
		this.repayment = repayment;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public BigDecimal getTotalBuyNum() {
		return this.totalBuyNum;
	}

	public void setTotalBuyNum(BigDecimal totalBuyNum) {
		this.totalBuyNum = totalBuyNum;
	}

	public BigDecimal getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(BigDecimal totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getYearRate() {
		return this.yearRate;
	}

	public void setYearRate(BigDecimal yearRate) {
		this.yearRate = yearRate;
	}

	public Date getYureEndTime() {
		return this.yureEndTime;
	}

	public void setYureEndTime(Date yureEndTime) {
		this.yureEndTime = yureEndTime;
	}

}