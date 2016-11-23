package com.zabbix.sisyphus.uc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "UC_T_LOGIN_INFO")
public class LoginInfo extends IdEntity {
	private static final long serialVersionUID = 4944239188987054382L;
	private Long userId; // 用户的id
	private String userType;// 用户类型
	private String username;// 登录名
	private String password1;
	private Date pw1Date; // 密码1修改时间

	private String password2;
	private Date pw2Date;
	private String memo;

	private String status;

	@Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_TYPE")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PW1_DATE")
	public Date getPw1Date() {
		return pw1Date;
	}

	public void setPw1Date(Date pw1Date) {
		this.pw1Date = pw1Date;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PW2_DATE")
	public Date getPw2Date() {
		return pw2Date;
	}

	public void setPw2Date(Date pw2Date) {
		this.pw2Date = pw2Date;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
