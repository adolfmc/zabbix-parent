package com.zabbix.sisyphus.base.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


@Component
public class SpringSecurityAuditorAware implements AuditorAware<Long> {

	private static Logger logger = LoggerFactory.getLogger(SpringSecurityAuditorAware.class);

	@Override
	public Long getCurrentAuditor() {
		logger.info("************************************");
		Long loginUserId = SecurityHelper.getLoginUserId();
		return loginUserId == null ? 0l : loginUserId;
	}

}
