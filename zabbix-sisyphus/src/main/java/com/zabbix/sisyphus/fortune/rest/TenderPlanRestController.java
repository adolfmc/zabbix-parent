package com.zabbix.sisyphus.fortune.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.web.Servlets;

import com.zabbix.sisyphus.base.common.PageVo;
import com.zabbix.sisyphus.base.common.ResultVo;
import com.zabbix.sisyphus.base.enu.Status;
import com.zabbix.sisyphus.base.exception.BusinessException;
import com.zabbix.sisyphus.fortune.entity.TenderPlan;
import com.zabbix.sisyphus.fortune.service.TenderPlanService;
import com.zabbix.sisyphus.licaipro.entity.ProjectCategory;
import com.zabbix.sisyphus.licaipro.service.ProjectCategoryService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * rest风格控制器
 *@author zabbix
 *2016年10月19日
 */
@RestController
@RequestMapping(value = "/rest/tenderPlan")
public class TenderPlanRestController extends BaseController {

	@Autowired
	private TenderPlanService tenderPlanService;
	@Autowired
	private ProjectCategoryService projectCategoryService;

	@GetMapping("getProjectType")
	public List<ProjectCategory> getProjectType() {
		List<ProjectCategory> list = projectCategoryService.findByLevel(1);
		Map<Byte,String> map = new HashMap<>();
		for(ProjectCategory ca:list){
			map.put(ca.getId(), ca.getName());
		}
		
		List<ProjectCategory> list2 = projectCategoryService.findByLevel(2);
		if(!CollectionUtils.isEmpty(list2)){
			for(ProjectCategory ca:list2){
				ca.setParentName(map.get(ca.getParentId()));
			}
		}
		return list2;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResultVo create(@Valid TenderPlan tenderPlan) {
		try {
			tenderPlanService.create(tenderPlan);
		} catch (BusinessException e) {
			return ResultVo.error(e.getMessage());
		}
		return ResultVo.OK();
	}

	/**
	 * 更新企业信息
	 * 
	 * @param tenderPlan
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ResultVo update(@Valid @ModelAttribute("tenderPlan") TenderPlan tenderPlan) {
		try {
			tenderPlanService.update(tenderPlan);
		} catch (BusinessException e) {
			return ResultVo.error(e.getMessage());
		}
		return ResultVo.OK();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ResultVo delete(@PathVariable("id") Long id) {
		TenderPlan tenderPlan = new TenderPlan();
		tenderPlan.setStatus(Status.unvalid.code);
		tenderPlan.setId(id);
		tenderPlanService.update(tenderPlan);
		return ResultVo.OK();
	}
	
	/**
	 * 标的上线
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "release/{id}", method = RequestMethod.GET)
	public ResultVo release(@PathVariable("id") Long id) {
		try {
			tenderPlanService.release(id);
		} catch (BusinessException e) {
			return ResultVo.error(e.getMessage());
		}
		return ResultVo.OK();
	}
	
	/**
	 * 撤销上线
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "repeal/{id}", method = RequestMethod.GET)
	public ResultVo repeal(@PathVariable("id") Long id) {
		try {
			tenderPlanService.repeal(id);
		} catch (BusinessException e) {
			return ResultVo.error(e.getMessage());
		}
		return ResultVo.OK();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TenderPlan get(@PathVariable("id") Long id) {
		return tenderPlanService.load(id);
	}
	
	@RequestMapping(value = "switchProDisplay/{id}", method = RequestMethod.GET)
	public ResultVo switchProDisplay(@PathVariable("id") Integer pid) {
		tenderPlanService.switchProDisplay(pid);
		return ResultVo.OK();
	}

	/**
	 * 分页 搜索字段格式：search_${opertor}_${field},如search_LIKE_title，search_EQ_id
	 * opertor枚举：org.springside.modules.persistence.SearchFilter.Operator
	 */
	@RequestMapping(value = "pages", method = RequestMethod.GET)
	public PageVo<TenderPlan> pages(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "rows", defaultValue = "20") int pageSize,
			@RequestParam(value = "sort", defaultValue = "auto") String sort, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Page<TenderPlan> page = tenderPlanService.page(searchParams, pageNumber, pageSize, sort);
		return new PageVo<>(page);
	}

	@ModelAttribute
	public void gettenderPlan(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			//要与update方法的@ModelAttribute("tenderPlan")对应
			model.addAttribute("tenderPlan", tenderPlanService.load(id));
		}
	}

}
