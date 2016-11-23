package com.zabbix.sisyphus.contract.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zabbix.sisyphus.contract.entity.FortunePro;

/**
 * 作者: zabbix 创建于 16/10/14.
 */
public interface FortuneProDao extends PagingAndSortingRepository<FortunePro, Long>, JpaSpecificationExecutor<FortunePro> {

}
