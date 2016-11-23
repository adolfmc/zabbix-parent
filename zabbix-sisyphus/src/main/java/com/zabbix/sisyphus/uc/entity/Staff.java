package com.zabbix.sisyphus.uc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "UC_T_STAFF")
public class Staff extends IdEntity {
	private static final long serialVersionUID = -4495860377965145154L;
	private String name;
	private String gender; // 性别
	private String staffCode; // 员工编号

	private Department department;

	private String cardId; // 身份证
	private String mobile; // 移动电话
	private String areaTel; // 座机区号
	private String tel; // 电话
	private String email;

	private String memo;

	private List<StaffRole> staffRoles = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "STAFF_CODE")
	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "CARD_ID")
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "AREA_TEL")
	public String getAreaTel() {
		return areaTel;
	}

	public void setAreaTel(String areaTel) {
		this.areaTel = areaTel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "E_MAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	public List<StaffRole> getStaffRoles() {
		return staffRoles;
	}

	public void setStaffRoles(List<StaffRole> staffRoles) {
		this.staffRoles = staffRoles;
	}

	@Transient
	@JsonIgnore
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<Role>();
		for (StaffRole staffRole : staffRoles) {
			list.add(staffRole.getRole());
		}
		return list;
	}

	@Transient
	@JsonIgnore
	public List<Function> getFunctions() {
		List<Function> list = new ArrayList<Function>();
		for (StaffRole staffRole : staffRoles) {
			list.addAll(staffRole.getRole().getFunctions());
		}
		return list;
	}

	// @ManyToMany(fetch = FetchType.EAGER)
	// @JoinTable(name = "UC_T_STAFF_ROLE", joinColumns = { @JoinColumn(name =
	// "STAFF_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	// @Fetch(FetchMode.SUBSELECT)
	// public List<Role> getRoles() {
	// return roles;
	// }
	//
	// public void setRoles(List<Role> roles) {
	// this.roles = roles;
	// }
	//
	// @Transient
	// @JsonIgnore
	// public Set<Function> getFunctions() {
	// Set<Function> set = new HashSet<Function>();
	// for (Role role : roles) {
	// set.addAll(role.getFunctions());
	// }
	// return set;
	// }

}
