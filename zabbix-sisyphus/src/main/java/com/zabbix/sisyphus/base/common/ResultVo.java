package com.zabbix.sisyphus.base.common;

public class ResultVo {

	private int code;
	private Object attachment;

	public ResultVo(int code, Object attachment) {
		this.code = code;
		this.attachment = attachment;
	}
	public ResultVo(){
		
	}

	public static ResultVo getInstance(int code, Object attachment){
		return new ResultVo();
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getAttachment() {
		return attachment;
	}

	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}

	public static class OK extends ResultVo {

		public OK() {
			super(1, null);
		}

		private OK(Object attachment) {
			super(1, attachment);
		}

	}

	public static class ExceptionVo extends ResultVo {

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


	public static OK OK() {
		return new OK();
	}

	public static OK OK(Object attachment) {
		return new OK(attachment);
	}

	public static ExceptionVo error(String exception) {
		return new ExceptionVo(exception);
	}

	public static ExceptionVo error(Exception e) {
		return new ExceptionVo(e);
	}

	public static ExceptionVo error(int code, Exception e) {
		return new ExceptionVo(code, e);
	}

}
