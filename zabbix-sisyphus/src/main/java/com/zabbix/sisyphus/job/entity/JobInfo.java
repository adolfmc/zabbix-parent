package com.zabbix.sisyphus.job.entity;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "job_info")
public class JobInfo extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = -4915818834252874391L;
	private String titile;
	private String salary;
	private String company;
	private String type;
	private String url;
	private Long times;
	private String jobxz;
	private String jobtime;
	private String jobinfo;
	private String companyinfo;
	private String isNew;
	private String memo;
	private String memo1;
	private String memo2;
	private String starttime;
	private String endtime;
	private String industry;

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Transient
	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Transient
	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	@Column(length = 1000)
	public String getJobinfo() {
		return this.jobinfo;
	}

	public void setJobinfo(String jobinfo) {
		this.jobinfo = jobinfo;
	}

	@Column(length = 1000)
	public String getCompanyinfo() {
		return this.companyinfo;
	}

	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo;
	}

	public String getIsNew() {
		return this.isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMemo1() {
		return this.memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getMemo2() {
		return this.memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	public String getJobtime() {
		return this.jobtime;
	}

	public void setJobtime(String jobtime) {
		this.jobtime = jobtime;
	}


	public String getJobxz() {
		return this.jobxz;
	}

	public void setJobxz(String jobxz) {
		this.jobxz = jobxz;
	}

	public String getTitile() {
		return this.titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getTimes() {
		return this.times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}
}