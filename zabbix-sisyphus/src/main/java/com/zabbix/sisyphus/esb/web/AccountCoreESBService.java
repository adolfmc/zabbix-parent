package com.zabbix.sisyphus.esb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zabbix.sisyphus.esb.vo.MockData;
import com.zabbix.sisyphus.esb.vo.ResultV;

/**
 * 总账模块
 * 
 * @author mc
 * 
 */
@Controller
@RequestMapping("esb/account/")
@ResponseBody
public class AccountCoreESBService {
	
	/** T_个人总账 */
	@RequestMapping("myAccount")
	public ResultV myAccount(String customerId, String check) {
		return MockData.account( customerId,  check);
	}
}
