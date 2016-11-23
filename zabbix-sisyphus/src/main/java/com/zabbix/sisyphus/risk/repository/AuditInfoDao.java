package com.zabbix.sisyphus.risk.repository;

import org.springframework.data.jpa.repository.Query;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.risk.entity.AuditInfo;

public interface AuditInfoDao extends BaseRepository<AuditInfo>  {

@Query("select p from AuditInfo p where p.creditInfo.id = ?1")
	AuditInfo findByCreditId(Long creditId);
			}
