package com.zabbix.sisyphus.base.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zabbix.sisyphus.base.entity.RequestLogger;
import com.zabbix.sisyphus.base.service.RequestLoggerService;

public class HandlerInterceptorAdapter implements HandlerInterceptor {

	private RequestLoggerService requestLoggerService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("_starttime_request_logger", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
		 String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
	        String requestUri = request.getRequestURI();//得到请求的资源
	        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
	        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
	        String remoteHost = request.getRemoteHost();
	        int remotePort = request.getRemotePort();
	        String remoteUser = request.getRemoteUser();
	        String method = request.getMethod();//得到请求URL地址时使用的方法
	        String pathInfo = request.getPathInfo();
	        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
	        String localName = request.getLocalName();//获取WEB服务器的主机名
	        Enumeration<String> headerNames = request.getHeaderNames();
	        StringBuilder sbuilder=new StringBuilder();
	        while(headerNames.hasMoreElements()){
	        	String element = headerNames.nextElement();
	            sbuilder.append(request.getHeader(element)).append("["+element+"]|");
	        }
	        
	        long currentTimeMillis = System.currentTimeMillis();
	        currentTimeMillis  = currentTimeMillis - Long.valueOf(request.getAttribute("_starttime_request_logger")+"");
	        
	        sbuilder.append(requestUrl).append("[requestUrl]|");
	        sbuilder.append(requestUri).append("[requestUri]|");
	        sbuilder.append(queryString).append("[queryString]|");
	        sbuilder.append(remoteAddr).append("[remoteAddr]|");
	        sbuilder.append(remoteHost).append("[remoteHost]|");
	        sbuilder.append(remotePort).append("[remotePort]|");
	        sbuilder.append(remoteUser).append("[remoteUser]|");
	        sbuilder.append(method).append("[method]|");
	        sbuilder.append(pathInfo).append("[pathInfo]|");
	        sbuilder.append(localAddr).append("[localAddr]|");
	        sbuilder.append(localName).append("[localName]|");
	        sbuilder.append(currentTimeMillis).append("[currentTimeMillis]|");
	        
	        RequestLogger requestLogger = new RequestLogger();
			requestLogger.setRequest(sbuilder.toString());
			requestLogger.setTime(currentTimeMillis);
			requestLogger.setRequestUri(requestUri);
			requestLogger.setThread(Thread.currentThread().getId()+"|"+Thread.currentThread().getName());
			requestLoggerService.save(requestLogger);
	}

	public RequestLoggerService getRequestLoggerService() {
		return requestLoggerService;
	}

	public void setRequestLoggerService(RequestLoggerService requestLoggerService) {
		this.requestLoggerService = requestLoggerService;
	}
}