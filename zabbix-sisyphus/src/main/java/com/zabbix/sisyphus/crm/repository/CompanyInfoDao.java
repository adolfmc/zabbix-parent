package com.zabbix.sisyphus.crm.repository;

import java.util.Date;

import org.springframework.data.domain.Sort;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;

public interface CompanyInfoDao extends BaseRepository<CompanyInfo> {
	CompanyInfo findTopByCreatedDateBetween(Date preDate,Date postDate,Sort sort);
}
