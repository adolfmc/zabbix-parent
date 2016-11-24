package com.zabbix.sisyphus.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zabbix.sisyphus.base.entity.RequestLogger;
import com.zabbix.sisyphus.base.repository.RequestLoggerDao;

@Service
@Transactional
public class RequestLoggerService extends BaseService<RequestLogger> {
	@Autowired
	RequestLoggerDao requestLoggerDao;

	public void save(RequestLogger requestLogger) {
		requestLoggerDao.save(requestLogger);
	}
}
