package com.zabbix.sisyphus.esb.vo;

public class GeneralLedger {
	private String name;
	private String sysglNo;
	private String avlBal;
	private String frzBal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSysglNo() {
		return sysglNo;
	}

	public void setSysglNo(String sysglNo) {
		this.sysglNo = sysglNo;
	}

	public String getAvlBal() {
		return avlBal;
	}

	public void setAvlBal(String avlBal) {
		this.avlBal = avlBal;
	}

	public String getFrzBal() {
		return frzBal;
	}

	public void setFrzBal(String frzBal) {
		this.frzBal = frzBal;
	}
}
