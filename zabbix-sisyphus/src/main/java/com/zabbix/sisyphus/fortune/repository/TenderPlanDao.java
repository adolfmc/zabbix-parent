package com.zabbix.sisyphus.fortune.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.fortune.entity.TenderPlan;

public interface TenderPlanDao extends BaseRepository<TenderPlan> {
	int countByFortuneProIdAndStatus(Long fortuneProId,String status);

    @Query(value ="SELECT tp.* FROM  ft_t_tender_plan tp WHERE now()>=tp.tender_start and now()<=tp.buy_end_time and old_licai_pro_id is null and tp.flow_id='13000002'",nativeQuery = true)
    List<TenderPlan> findReadyPlan();
    
    List<TenderPlan> findByTenderStartGreaterThanAndOldLicaiProIdIsNull(Date date);
    
    TenderPlan findByOldLicaiProId(Integer id);
    
    List<TenderPlan> findByRaiseEndTimeIsNull();
}
