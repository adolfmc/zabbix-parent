package com.zabbix.sisyphus.licaipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.zabbix.sisyphus.licaipro.entity.ProjectInfo;

public interface ProjectInfoDao extends JpaRepository<ProjectInfo, Integer>, JpaSpecificationExecutor<ProjectInfo> {
	
	@Query("select p from ProjectInfo p where p.pid = ?1")
	ProjectInfo findByPid(Integer pid);

	List<ProjectInfo> findByIsNewProject(byte isNewProject);
	
	
	List<ProjectInfo> findByProjectStatusEquals(byte projectStatus);

}
