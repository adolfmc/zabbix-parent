package com.zabbix.sisyphus.uc.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "UC_T_STAFF_ROLE")
public class StaffRole extends IdEntity {
	private static final long serialVersionUID = -1706371308614079811L;
	private Staff staff;
	private Role role;

	private String memo;

	@ManyToOne
	@JoinColumn(name = "STAFF_ID")
	@JsonIgnore
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
