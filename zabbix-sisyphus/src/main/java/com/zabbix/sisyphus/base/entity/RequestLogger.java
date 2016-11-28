package com.zabbix.sisyphus.base.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_t_request_logger")
public class RequestLogger extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = -927645585917104374L;
	private String request;
	private Long times;
	private Long time;
	private String requestUri;
	private String thread;

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}
}
