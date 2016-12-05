package com.zabbix.sisyphus.job.collection.lagou;

import java.util.List;

public class LaGouVO {
	private String success;
	private String requestId;
	private String msg;
	private String resubmitToken;
	private String code;
	private Object content;
	private List<Result> results;
	private Result result;
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getResubmitToken() {
		return resubmitToken;
	}

	public void setResubmitToken(String resubmitToken) {
		this.resubmitToken = resubmitToken;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	class positionResult {
		private String totalCount;
		private List<Result> result;

		public String getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(String totalCount) {
			this.totalCount = totalCount;
		}

		public List<Result> getResult() {
			return result;
		}

		public void setResult(List<Result> result) {
			this.result = result;
		}
	}


class Result {
	private String explain;
	private String plus;
	private String pcShow;
	private String appShow;
	private String deliver;
	private String gradeDescription;
	private String promotionScoreExplain;
	private String firstType;
	private String secondType;
	List<String> positionLables;
	private String imState;
	private String businessZones;
	private String lastLogin;
	private String publisherId;
	private String companyId;
	private String positionName;
	private String workYear;
	private String education;
	private String jobNature;
	private String positionId;
	private String companyShortName;
	private String createTime;
	private String score;
	private String cit;
	private String salary;
	private String approve;
	private String positionAdvantage;
	private String companyLogo;
	private String industryField;
	private String financeStage;
	List<String> companyLabelList;
	private String district;
	private String companySize;
	private String formatCreateTime;
	private String adWord;
	private String companyFullName;

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getPlus() {
		return plus;
	}

	public void setPlus(String plus) {
		this.plus = plus;
	}

	public String getPcShow() {
		return pcShow;
	}

	public void setPcShow(String pcShow) {
		this.pcShow = pcShow;
	}

	public String getAppShow() {
		return appShow;
	}

	public void setAppShow(String appShow) {
		this.appShow = appShow;
	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public String getGradeDescription() {
		return gradeDescription;
	}

	public void setGradeDescription(String gradeDescription) {
		this.gradeDescription = gradeDescription;
	}

	public String getPromotionScoreExplain() {
		return promotionScoreExplain;
	}

	public void setPromotionScoreExplain(String promotionScoreExplain) {
		this.promotionScoreExplain = promotionScoreExplain;
	}

	public String getFirstType() {
		return firstType;
	}

	public void setFirstType(String firstType) {
		this.firstType = firstType;
	}

	public String getSecondType() {
		return secondType;
	}

	public void setSecondType(String secondType) {
		this.secondType = secondType;
	}

	public List<String> getPositionLables() {
		return positionLables;
	}

	public void setPositionLables(List<String> positionLables) {
		this.positionLables = positionLables;
	}

	public String getImState() {
		return imState;
	}

	public void setImState(String imState) {
		this.imState = imState;
	}

	public String getBusinessZones() {
		return businessZones;
	}

	public void setBusinessZones(String businessZones) {
		this.businessZones = businessZones;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJobNature() {
		return jobNature;
	}

	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getCompanyShortName() {
		return companyShortName;
	}

	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getCit() {
		return cit;
	}

	public void setCit(String cit) {
		this.cit = cit;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getPositionAdvantage() {
		return positionAdvantage;
	}

	public void setPositionAdvantage(String positionAdvantage) {
		this.positionAdvantage = positionAdvantage;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getIndustryField() {
		return industryField;
	}

	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}

	public String getFinanceStage() {
		return financeStage;
	}

	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}

	public List<String> getCompanyLabelList() {
		return companyLabelList;
	}

	public void setCompanyLabelList(List<String> companyLabelList) {
		this.companyLabelList = companyLabelList;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public String getFormatCreateTime() {
		return formatCreateTime;
	}

	public void setFormatCreateTime(String formatCreateTime) {
		this.formatCreateTime = formatCreateTime;
	}

	public String getAdWord() {
		return adWord;
	}

	public void setAdWord(String adWord) {
		this.adWord = adWord;
	}

	public String getCompanyFullName() {
		return companyFullName;
	}

	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}
}
}
