package com.zabbix.sisyphus.licaipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.licaipro.entity.ProjectCategory;
import com.zabbix.sisyphus.licaipro.repository.ProjectCategoryDao;

@Component
public class ProjectCategoryService {
	@Autowired
	private ProjectCategoryDao projectCategoryDao;
	
	public List<ProjectCategory> findByLevel(int level) {
		return projectCategoryDao.findByLevel(level);
	}
	
	public ProjectCategory findById(Byte id) {
		return projectCategoryDao.findOne(id);
	}
}
