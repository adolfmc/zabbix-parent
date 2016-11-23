package com.zabbix.sisyphus.credit.enu;

public enum CustomerType {
	company("1"), individual("2");
	public String code;

	private CustomerType(String code) {
		this.code = code;
	}

}