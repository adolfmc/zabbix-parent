package com.zabbix.sisyphus.fortune.repository;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.fortune.entity.TenderPlanCredit;

public interface TenderPlanCreditDao extends BaseRepository<TenderPlanCredit> {
    TenderPlanCredit findByTenderPlanId(Long id);
}
