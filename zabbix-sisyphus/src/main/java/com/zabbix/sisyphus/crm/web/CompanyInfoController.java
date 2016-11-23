package com.zabbix.sisyphus.crm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zabbix.sisyphus.crm.entity.CompanyInfo;
import com.zabbix.sisyphus.crm.service.CompanyInfoService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * 企业信息控制器
 *@author zabbix
 *2016年10月14日
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyInfoController extends BaseController{

	@Autowired
	private CompanyInfoService companyInfoService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "/company/companyList";
	}


	/**
	 * 创建表单页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("company", new CompanyInfo());
		model.addAttribute("action", "create");
		return "task/create";
	}

	/**
	 * 更新表单页
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("company", companyInfoService.load(id));
		model.addAttribute("action", "update");
		return "task/taskForm";
	}

	@GetMapping("createCompanyInfo")
	public String createCompanyInfo(){
		return "/company/createCompanyInfo";
	}
	@GetMapping("editCompanyInfo/{id}")
	public String editCompanyInfo(@PathVariable("id")Long id,Model model){
		model.addAttribute("id",id);
		return "/company/editCompanyInfo";
	}


	@GetMapping("baseInfo")
	public String baseInfo(Long id,Model model){
		model.addAttribute("id",id);
		CompanyInfo companyInfo = companyInfoService.load(id);
		model.addAttribute("memo",companyInfo.getMemo());
		return "/company/baseInfo";
	}

	@GetMapping("test")
	public String test(Integer id,Model model){
		model.addAttribute("id",id);
		return "/company/test";
	}

}








