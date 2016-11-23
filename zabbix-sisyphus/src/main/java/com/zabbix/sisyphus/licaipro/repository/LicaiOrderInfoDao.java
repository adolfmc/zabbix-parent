package com.zabbix.sisyphus.licaipro.repository;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.licaipro.entity.LicaiOrderInfo;

import java.util.Collection;
import java.util.List;

/**
 * 作者: zabbix 创建于 16/10/25.
 */
public interface LicaiOrderInfoDao extends BaseRepository<LicaiOrderInfo> {
    List<LicaiOrderInfo> findByPidAndStatusInOrderByCreateTimeDesc(Integer pid, Collection<Byte> status);
}
