package com.zabbix.sisyphus.credit.repository;

import java.util.Date;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.credit.entity.CreditInfo;

public interface CreditInfoDao extends BaseRepository<CreditInfo> {
	CreditInfo findTopByCreatedDateBetweenOrderByCreatedDateDesc(Date preDate,Date postDate);

}
