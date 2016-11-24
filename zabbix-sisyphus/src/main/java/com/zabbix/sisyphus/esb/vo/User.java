package com.zabbix.sisyphus.esb.vo;

public class User {
	private String mobile;
	private String loginPwd;
	private Integer logIntegerimes;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Integer getLogIntegerimes() {
		return logIntegerimes;
	}

	public void setLogIntegerimes(Integer logIntegerimes) {
		this.logIntegerimes = logIntegerimes;
	}

}
