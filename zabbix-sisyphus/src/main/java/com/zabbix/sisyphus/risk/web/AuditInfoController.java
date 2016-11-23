package com.zabbix.sisyphus.risk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zabbix.sisyphus.contract.service.ProjectTagService;
import com.zabbix.sisyphus.credit.entity.CreditInfo;
import com.zabbix.sisyphus.credit.service.CreditInfoService;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;
import com.zabbix.sisyphus.crm.service.CompanyInfoService;

/**
 * 作者: zabbix 创建于 16/10/20.
 */

@Controller
@RequestMapping("risk/auditInfo")
public class AuditInfoController {


    @Autowired
    CompanyInfoService companyInfoService;
    @Autowired
    CreditInfoService creditInfoService;
    @Autowired
    ProjectTagService projectTagService;

    @GetMapping("audit/{id}")
    public String auditList(@PathVariable Long id, Model model){
        CreditInfo creditInfo = creditInfoService.load(id);
        CompanyInfo companyInfo = companyInfoService.load(creditInfo.getCustomerId()    );
        model.addAttribute("info",companyInfo);
        model.addAttribute("credit",creditInfo);
        return "/risk/auditInfo";
    }
    
    @RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
        model.addAttribute("tags",projectTagService.findAll());
		return "/risk/auditList";
	}

}
