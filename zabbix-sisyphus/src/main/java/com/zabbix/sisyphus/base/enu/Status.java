package com.zabbix.sisyphus.base.enu;

public enum Status {
	valid("00050001"), unvalid("00050009");
	public String code;

	private Status(String code) {
		this.code = code;
	}

}