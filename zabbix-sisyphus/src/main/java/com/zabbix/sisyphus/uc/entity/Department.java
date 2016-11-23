package com.zabbix.sisyphus.uc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "UC_T_DEPARTMENT")
public class Department extends IdEntity {
	private static final long serialVersionUID = 7329232352087255937L;
	private String name;// 部门名称
	private String enName;// 英文名称
	private String depCode; // 部门编号
	private String depSum; // 部门简介

	private Department parent;// 上级机构ID
	private String fullPath;// 全路径代码
	private String memo;// 备注

	private List<Department> children = Lists.newArrayList();

	@Transient
	public String getText() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EN_NAME")
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "DEP_CODE")
	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	@Column(name = "DEP_SUM")
	public String getDepSum() {
		return depSum;
	}

	public void setDepSum(String depSum) {
		this.depSum = depSum;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT_DEP_ID")
	@JsonIgnore
	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@OneToMany(mappedBy = "parent")
	@Where(clause = "ID != PARENT_DEP_ID")
	@OrderBy("create_date asc")
	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}

}
