package com.zabbix.sisyphus.licaipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zabbix.sisyphus.licaipro.entity.ProjectCategory;

/**
 *@author zabbix
 *2016年10月25日
 */
public interface ProjectCategoryDao extends JpaRepository<ProjectCategory, Byte>, JpaSpecificationExecutor<ProjectCategory>{
	public List<ProjectCategory> findByLevel(int level);
	
}
