package com.zabbix.sisyphus.uc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "UC_T_ROLE")
public class Role extends IdEntity {
	private static final long serialVersionUID = -4494023232468676201L;
	private String name;
	private String memo;

	// private List<Function> functions = Lists.newArrayList();

	private List<RoleFun> roleFuns = Lists.newArrayList();

	private List<StaffRole> staffRoles = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	@JsonIgnore
	public List<RoleFun> getRoleFuns() {
		return roleFuns;
	}

	public void setRoleFuns(List<RoleFun> roleFuns) {
		this.roleFuns = roleFuns;
	}

	@OneToMany(mappedBy = "role")
	@JsonIgnore
	public List<StaffRole> getStaffRoles() {
		return staffRoles;
	}

	public void setStaffRoles(List<StaffRole> staffRoles) {
		this.staffRoles = staffRoles;
	}

	@Transient
	public List<Function> getFunctions() {
		List<Function> list = new ArrayList<Function>();
		for (RoleFun roleFun : roleFuns) {
			list.add(roleFun.getFunction());
		}
		return list;
	}
	//
	// public void setFunctions(List<Function> functions) {
	// this.functions = functions;
	// }
}
