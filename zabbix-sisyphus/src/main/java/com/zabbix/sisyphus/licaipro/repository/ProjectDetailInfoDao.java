package com.zabbix.sisyphus.licaipro.repository;

import com.zabbix.sisyphus.licaipro.entity.ProjectDetailInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 作者: zabbix 创建于 16/10/29.
 */
public interface ProjectDetailInfoDao extends JpaRepository<ProjectDetailInfo, Integer>, JpaSpecificationExecutor<ProjectDetailInfo> {
}
