package com.zabbix.sisyphus.uc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.Log;
import com.zabbix.sisyphus.uc.repository.LogDao;

@Component
public class LogService extends BaseService<Log> {
	
	@Autowired
	public void setRepository(LogDao repository) {
		super.setRepository(repository);
	}

}
