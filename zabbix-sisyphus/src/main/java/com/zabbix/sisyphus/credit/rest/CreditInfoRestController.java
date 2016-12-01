package com.zabbix.sisyphus.credit.rest;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
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
import com.zabbix.sisyphus.credit.entity.CreditInfo;
import com.zabbix.sisyphus.credit.service.CreditInfoService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * rest风格的借款信息控制器
 *@author zabbix
 *2016年10月18日
 */
@RestController
@RequestMapping(value = "/rest/credit")
public class CreditInfoRestController extends BaseController {

	@Autowired
	private CreditInfoService creditInfoService;

	/**
	 * 创建/更新借款信息
	 */
	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	public ResultVo saveOrUpdate(@Valid @ModelAttribute CreditInfo creditInfo) {
		creditInfoService.saveOrUpdate(creditInfo);
		return ResultVo.OK();
	}
	
	/**
	 * 撤销
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "repeal/{id}", method = RequestMethod.GET)
	public ResultVo repeal(@PathVariable("id") Long id) {
		try {
			creditInfoService.repeal(id);
		} catch (BusinessException e) {
			return ResultVo.error(e.getMessage());
		}
		return ResultVo.OK();
	}

	/**
	 * 分页
	 * @return
	 */
	@RequestMapping(value = "pages", method = RequestMethod.GET)
	public PageVo<CreditInfo> pages(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "rows", defaultValue = "20") int pageSize,
			@RequestParam(value = "sort", defaultValue = "auto") String sort, Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		searchParams.put("EQ_status", Status.valid.code);
		Page<CreditInfo> companys = creditInfoService.page(searchParams, pageNumber, pageSize, sort);
		return new PageVo<>(companys);
	}

	@ModelAttribute
	public void getcreditInfo(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			//要与update方法的@ModelAttribute("creditInfo")对应
			model.addAttribute("creditInfo", creditInfoService.load(id));
		}
	}
}
