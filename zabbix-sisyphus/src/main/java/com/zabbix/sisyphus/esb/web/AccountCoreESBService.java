package com.zabbix.sisyphus.esb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zabbix.sisyphus.esb.vo.ResultV;

/**
 * 总账模块
 * 
 * @author mc
 * 
 */
@Controller
@RequestMapping("esb/account")
public class AccountCoreESBService {
	/** T_个人总账 */
	public ResultV account(String customerId, String check, String accountId) {
		ResultV result = ResultV.getInstance();
		return result;
	}
}
