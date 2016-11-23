package com.zabbix.sisyphus.uc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.entity.IdEntity;

@Entity
@Table(name = "UC_T_FUNCTION")
public class Function extends IdEntity {
	private static final long serialVersionUID = -8112563598865844029L;
	private String name;
	private String functionSum;
	private String type;
	private String functionCode;
	private String systemId;

	private Function parent;
	private int ord;

	private String url;
	private String memo;

	private String fullPath;

	private List<Function> children = Lists.newArrayList();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "FUNCTION_SUM")
	public String getFunctionSum() {
		return functionSum;
	}

	public void setFunctionSum(String functionSum) {
		this.functionSum = functionSum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "FUNCTION_CODE")
	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT_FUNCTION_ID")
	@JsonIgnore
	public Function getParent() {
		return parent;
	}

	public void setParent(Function parent) {
		this.parent = parent;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "FULL_PATH")
	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	@OneToMany(mappedBy = "parent")
	@Where(clause = "ID != PARENT_FUNCTION_ID")
	@OrderBy("ord desc")
	public List<Function> getChildren() {
		return children;
	}

	public void setChildren(List<Function> children) {
		this.children = children;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

}
