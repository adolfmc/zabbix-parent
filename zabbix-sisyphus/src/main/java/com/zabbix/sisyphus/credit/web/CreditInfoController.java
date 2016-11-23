package com.zabbix.sisyphus.credit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zabbix.sisyphus.credit.entity.CreditInfo;
import com.zabbix.sisyphus.credit.enu.CustomerType;
import com.zabbix.sisyphus.credit.service.CreditInfoService;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;
import com.zabbix.sisyphus.crm.service.CompanyInfoService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * 借款信息控制器
 *@author zabbix
 *2016年10月18日
 */
@Controller
@RequestMapping(value = "/credit")
public class CreditInfoController extends BaseController{

	@Autowired
	private CreditInfoService creditInfoService;
	@Autowired
	private CompanyInfoService companyInfoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "/credit/creditList";
	}

	/**
	 * 创建表单页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(@RequestParam(required=true) Long customerId,
			@RequestParam(required=true) String customerType,Model model) {
		CreditInfo creditInfo = new CreditInfo();
		creditInfo.setCustomerType(customerType);
		if(customerType.equals(CustomerType.company.code)){
			CompanyInfo customer = companyInfoService.load(customerId);
			creditInfo.setCustomerId(customer.getId());
			creditInfo.setCustomerName(customer.getName());
			creditInfo.setCustomerPhone(customer.getPhoneNum());
		}
		model.addAttribute("creditInfo", creditInfo);
		return "/credit/update";
	}
	
	/**
	 * 更新表单页
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		CreditInfo creditInfo = creditInfoService.load(id);
		model.addAttribute("creditInfo", creditInfo);
		return "/credit/update";
	}

}
