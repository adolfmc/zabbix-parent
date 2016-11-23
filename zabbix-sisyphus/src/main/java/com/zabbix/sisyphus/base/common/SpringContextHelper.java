package com.zabbix.sisyphus.base.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class SpringContextHelper implements ApplicationContextAware {

	private static ApplicationContext context;

	public static Object getBean(String name) throws BeansException {
		return context.getBean(name);
	}

	public static <T> T getBean(Class<T> t) throws BeansException{
		return context.getBean(t);
	}

	public static ApplicationContext getContext() {
		return context;
	}

	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringContextHelper.context = context;
	}

}