package com.zabbix.sisyphus.base.common;

/**
 * 异常错误
 * 
 * 
 */
public class ExceptionVo extends ResultVo {
	private String exception;

	public ExceptionVo(String exception) {
		super(-1, exception);
		this.exception = exception;
	}

	public ExceptionVo(Exception e) {
		this(-1, e);
	}

	public ExceptionVo(int code, Exception e) {
		super(code, e);
		exception = e.getClass().getName();
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}
