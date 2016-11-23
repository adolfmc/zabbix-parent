package com.zabbix.sisyphus.fortune.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ft_t_tender_plan_credit database table.
 * 
 */
@Entity
@Table(name="ft_t_tender_plan_credit")
@NamedQuery(name="TenderPlanCredit.findAll", query="SELECT t FROM TenderPlanCredit t")
public class TenderPlanCredit extends com.zabbix.sisyphus.base.entity.IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String memo;

	private Long creditId;
	
	private Long tenderPlanId;

	public TenderPlanCredit() {
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getTenderPlanId() {
		return tenderPlanId;
	}

	public void setTenderPlanId(Long tenderPlanId) {
		this.tenderPlanId = tenderPlanId;
	}

	public Long getCreditId() {
		return creditId;
	}

	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}
}