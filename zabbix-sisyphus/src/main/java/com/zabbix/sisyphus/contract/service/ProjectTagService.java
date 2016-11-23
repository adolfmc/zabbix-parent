package com.zabbix.sisyphus.contract.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zabbix.sisyphus.contract.entity.ProjectTag;
import com.zabbix.sisyphus.contract.repository.ProjectTagDao;

/**
 * 作者: zabbix 创建于 16/10/24.
 */
@Service
@Transactional
public class ProjectTagService {

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ProjectTagService.class);
    @Autowired
    ProjectTagDao projectTagDao;

    public List<ProjectTag> findAll(){
		return projectTagDao.findAll();
	}
}
