package com.zabbix.sisyphus.uc.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.zabbix.sisyphus.uc.entity.User;

public class BaseController {

	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return(authentication == null ? null :  (User) authentication.getPrincipal());
	}
}
