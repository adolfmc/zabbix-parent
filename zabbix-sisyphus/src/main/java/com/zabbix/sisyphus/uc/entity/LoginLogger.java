package com.zabbix.sisyphus.uc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "SYS_T_LOGIN_LOGGER")
public class LoginLogger extends IdEntity{
	private static final long serialVersionUID = 5692080943791492167L;
	private Long staffId;
	private Date loginTime;

	private String loginType;
	private String loginInfo;

	private String loginAddr;
	
	private String mobile;
	private String area;
	private String memo;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getLoginInfo() {
		if(loginInfo != null && loginInfo.length() > 100){
			return loginInfo.substring(0, 100)+"......";
		}
		return loginInfo;
	}

	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}

	public String getLoginAddr() {
		return loginAddr;
	}

	public void setLoginAddr(String loginAddr) {
		this.loginAddr = loginAddr;
	}
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


}
