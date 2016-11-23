package com.zabbix.sisyphus.licaipro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


/**
 * The persistent class for the t_licai_project_detail_info database table.
 * 
 */
@Entity
@Table(name="t_licai_project_detail_info")
public class ProjectDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int pid;

	@Column(name="baozhang_type")
	private String baozhangType;

	@Column(name="car_pic_url")
	private String carPicUrl;

	@Lob
	@Column(name="danbao_info")
	private String danbaoInfo;

	@Column(name="danbaohan_url")
	private String danbaohanUrl;

	@Lob
	@Column(name="disclaimer_info")
	private String disclaimerInfo;

	@Lob
	@Column(name="fengkong_info")
	private String fengkongInfo;

	@Lob
	@Column(name="fengxian_info")
	private String fengxianInfo;

	@Lob
	@Column(name="fengxianshu_info")
	private String fengxianshuInfo;

	@Column(name="project_desc")
	private String projectDesc;

	@Lob
	@Column(name="project_detail")
	private String projectDetail;

	@Lob
	@Column(name="special_info")
	private String specialInfo;

	@Column(name="xieyi_url")
	private String xieyiUrl;

	public ProjectDetailInfo() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getBaozhangType() {
		return this.baozhangType;
	}

	public void setBaozhangType(String baozhangType) {
		this.baozhangType = baozhangType;
	}

	public String getCarPicUrl() {
		return this.carPicUrl;
	}

	public void setCarPicUrl(String carPicUrl) {
		this.carPicUrl = carPicUrl;
	}

	public String getDanbaoInfo() {
		return this.danbaoInfo;
	}

	public void setDanbaoInfo(String danbaoInfo) {
		this.danbaoInfo = danbaoInfo;
	}

	public String getDanbaohanUrl() {
		return this.danbaohanUrl;
	}

	public void setDanbaohanUrl(String danbaohanUrl) {
		this.danbaohanUrl = danbaohanUrl;
	}

	public String getDisclaimerInfo() {
		return this.disclaimerInfo;
	}

	public void setDisclaimerInfo(String disclaimerInfo) {
		this.disclaimerInfo = disclaimerInfo;
	}

	public String getFengkongInfo() {
		return this.fengkongInfo;
	}

	public void setFengkongInfo(String fengkongInfo) {
		this.fengkongInfo = fengkongInfo;
	}

	public String getFengxianInfo() {
		return this.fengxianInfo;
	}

	public void setFengxianInfo(String fengxianInfo) {
		this.fengxianInfo = fengxianInfo;
	}

	public String getFengxianshuInfo() {
		return this.fengxianshuInfo;
	}

	public void setFengxianshuInfo(String fengxianshuInfo) {
		this.fengxianshuInfo = fengxianshuInfo;
	}

	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getProjectDetail() {
		return this.projectDetail;
	}

	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}

	public String getSpecialInfo() {
		return this.specialInfo;
	}

	public void setSpecialInfo(String specialInfo) {
		this.specialInfo = specialInfo;
	}

	public String getXieyiUrl() {
		return this.xieyiUrl;
	}

	public void setXieyiUrl(String xieyiUrl) {
		this.xieyiUrl = xieyiUrl;
	}

}