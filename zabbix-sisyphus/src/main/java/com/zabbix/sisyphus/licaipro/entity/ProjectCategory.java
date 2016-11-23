package com.zabbix.sisyphus.licaipro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the t_project_category database table.
 * 
 */
@Entity
@Table(name="t_project_category")
public class ProjectCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte id;

	private String display;

	@Column(name="list_order")
	private byte listOrder;

	private String name;

	@Column(name="parent_id")
	private byte parentId;

	@Column(name="text_id")
	private int textId;
	
	//顶级分类为0  一级分类为1
	private int level;
	
	@Transient
	private String parentName;
	
	public ProjectCategory() {
	}
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public byte getListOrder() {
		return this.listOrder;
	}

	public void setListOrder(byte listOrder) {
		this.listOrder = listOrder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getParentId() {
		return this.parentId;
	}

	public void setParentId(byte parentId) {
		this.parentId = parentId;
	}

	public int getTextId() {
		return this.textId;
	}

	public void setTextId(int textId) {
		this.textId = textId;
	}

}