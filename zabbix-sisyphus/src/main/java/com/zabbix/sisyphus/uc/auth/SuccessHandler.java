package com.zabbix.sisyphus.uc.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.common.Constants;
import com.zabbix.sisyphus.base.common.SecurityHelper;
import com.zabbix.sisyphus.uc.entity.LoginLogger;
import com.zabbix.sisyphus.uc.service.LoginLoggerService;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private LoginLoggerService loginLoggerService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		super.onAuthenticationSuccess(request, response, authentication);
		String ip = request.getRemoteAddr();
		SecurityHelper.putAttr("ip",ip);
		
		LoginLogger loginLogger = new LoginLogger();
		loginLogger.setLoginAddr(ip);
		loginLogger.setStaffId(SecurityHelper.getLoginUserId());
		loginLogger.setLoginType(Constants.D00570004);
		loginLogger.setLoginTime(new Date());
		loginLoggerService.saveOrUpdate(loginLogger);
	}


	
	
}
