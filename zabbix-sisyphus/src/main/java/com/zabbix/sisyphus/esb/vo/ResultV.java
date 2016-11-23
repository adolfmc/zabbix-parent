package com.zabbix.sisyphus.esb.vo;

public class ResultV {

	private String code = "11111111";
	private String message="操作成功";
	private Object info;

	public static ResultV getInstance(String code, String message, Object info) {
		ResultV v = new ResultV();
		v.code = code;
		v.message = message;
		v.info = info;
		return v;
	}

	public static ResultV getInstance(String code, String message) {
		ResultV v = new ResultV();
		v.code = code;
		v.message = message;
		return v;
	}

	public static ResultV getInstance(String message, Object info) {
		ResultV v = new ResultV();
		v.message = message;
		v.info = info;
		return v;
	}

	public static ResultV getInstance() {
		ResultV v = new ResultV();
		return v;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}
}
