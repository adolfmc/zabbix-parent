package com.zabbix.sisyphus.esb.vo;


public class Statement {
	private String amount;
	private String applyAmount;
	private String applyDate;
	private Integer deadline;
	private String replaymentDate;
	private String fee;
	private String amerce;
	private String replayAmount;

	public String getReplayAmount() {
		return replayAmount;
	}
	public void setReplayAmount(String replayAmount) {
		this.replayAmount = replayAmount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getApplyAmount() {
		return applyAmount;
	}
	public void setApplyAmount(String applyAmount) {
		this.applyAmount = applyAmount;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getDeadline() {
		return deadline;
	}
	public void setDeadline(Integer deadline) {
		this.deadline = deadline;
	}
	public String getReplaymentDate() {
		return replaymentDate;
	}
	public void setReplaymentDate(String replaymentDate) {
		this.replaymentDate = replaymentDate;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getAmerce() {
		return amerce;
	}
	public void setAmerce(String amerce) {
		this.amerce = amerce;
	}
}
