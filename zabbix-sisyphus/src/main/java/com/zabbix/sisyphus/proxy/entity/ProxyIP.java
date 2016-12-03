package com.zabbix.sisyphus.proxy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sys_t_proxy_ip")
public class ProxyIP extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = 1397542459573787835L;
	private String ip;
	private Integer port;
	private String status;
	private String address;
	private String demo;
	private String demo1;
	private String demo2;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public String getDemo1() {
		return demo1;
	}

	public void setDemo1(String demo1) {
		this.demo1 = demo1;
	}

	public String getDemo2() {
		return demo2;
	}

	public void setDemo2(String demo2) {
		this.demo2 = demo2;
	}
}
