package com.zabbix.sisyphus.contract.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.google.common.collect.Maps;
import com.zabbix.sisyphus.contract.entity.FortunePro;
import com.zabbix.sisyphus.contract.repository.FortuneProDao;

/**
 * 作者: zabbix 创建于 16/10/14.
 */
@Service
@Transactional
public class FortuneProService{

    @Autowired
    FortuneProDao fortuneProDao;

    public Page<FortunePro> findAll(PageRequest pageRequest) {
        Map<String, SearchFilter> filters = Maps.newHashMap();
        filters.put("status", new SearchFilter("status", SearchFilter.Operator.EQ, "1"));
        Specification<FortunePro> spec = DynamicSpecifications.bySearchFilter(filters.values(), FortunePro.class);
        return fortuneProDao.findAll(spec,pageRequest);
    }

    public void save(FortunePro fortunePro) {
        fortuneProDao.save(fortunePro);
    }

    public FortunePro find(Long id) {
         return fortuneProDao.findOne(id);
    }

    public void update(FortunePro fortunePro) {
        fortuneProDao.save(fortunePro);
    }
}
