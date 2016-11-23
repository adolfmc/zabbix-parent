package com.zabbix.sisyphus.credit.enu;

public enum PayWay {
	一次到期付本还息("1"), 等额本息("2");
	public String code;

	private PayWay(String code) {
		this.code = code;
	}

}