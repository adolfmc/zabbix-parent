package com.zabbix.sisyphus.fortune.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.ArrayListMultimap;
import com.zabbix.sisyphus.contract.service.ProjectTagService;
import com.zabbix.sisyphus.crm.entity.Attachment;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;
import com.zabbix.sisyphus.crm.service.AttachmentService;
import com.zabbix.sisyphus.fortune.entity.TenderPlan;
import com.zabbix.sisyphus.fortune.service.TenderPlanService;
import com.zabbix.sisyphus.risk.entity.AuditInfo;
import com.zabbix.sisyphus.risk.service.AuditInfoService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * 投标计划
 *@author zabbix
 *2016年10月19日
 */
@Controller
@RequestMapping(value = "/tenderPlan")
public class TenderPlanController extends BaseController{

	@Autowired
	private TenderPlanService tenderPlanService;
	@Autowired
	private ProjectTagService projectTagService;
	@Autowired
	private AuditInfoService auditInfoService;
	@Autowired
	private AttachmentService attachmentService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("tags",projectTagService.findAll());
		return "/tenderPlan/tenderPlanList";
	}
	
	@GetMapping("preview/{id}")
	public String preview(@PathVariable Long id,Model model) {
		TenderPlan tenderPlan = tenderPlanService.load(id);
		AuditInfo auditInfo = auditInfoService.findByCreditId(tenderPlan.getCreditInfoId());
		CompanyInfo companyInfo = auditInfo.getCreditInfo().getCompanyInfo();
		model.addAttribute("tenderPlan", tenderPlan);
		model.addAttribute("auditInfo", auditInfo);
		model.addAttribute("creditInfo", auditInfo.getCreditInfo());
		model.addAttribute("companyInfo", companyInfo);
		ArrayListMultimap<String, Attachment> map = ArrayListMultimap.create();
		List<Attachment> attachments = attachmentService.find(companyInfo.getId().intValue());
		if(attachments!=null){
			for(Attachment att:attachments){
				map.put(att.getType(), att);
			}
		}
		model.addAttribute("attachmentMap", map.asMap());
		return "/tenderPlan/preview";
	}

}
