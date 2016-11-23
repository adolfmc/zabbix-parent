package com.zabbix.sisyphus.uc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.LoginLogger;
import com.zabbix.sisyphus.uc.repository.LoginLoggerDao;

@Component
@Transactional
public class LoginLoggerService extends BaseService<LoginLogger> {
	@Autowired
	private LoginLoggerDao loginLoggerDao;

	@Autowired
	public void setRepository(LoginLoggerDao repository) {
		super.setRepository(repository);
	}
	
	public void saveLoginLoger(LoginLogger log){
		loginLoggerDao.save(log);
	}
	
}
