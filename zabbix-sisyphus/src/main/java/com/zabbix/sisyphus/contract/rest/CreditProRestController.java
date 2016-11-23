package com.zabbix.sisyphus.contract.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zabbix.sisyphus.base.enu.Status;
import com.zabbix.sisyphus.contract.entity.CreditPro;
import com.zabbix.sisyphus.contract.service.CreditProService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * 借贷产品
 *@author zabbix
 *2016年10月19日
 */
@RestController
@RequestMapping(value = "/rest/creditPro")
public class CreditProRestController extends BaseController{

	@Autowired
	private CreditProService creditProService;
	
	@RequestMapping(value = "idName")
	public List<Map<String,Object>>idName() {
		Map<String,Object> searchParams = new HashMap<>();
		searchParams.put("EQ_status", Status.valid.code);
		Page<CreditPro> page = creditProService.page(searchParams, 1, Integer.MAX_VALUE, null);
		List<Map<String,Object>> list = Lists.newArrayList();
        if(page!=null && !CollectionUtils.isEmpty(page.getContent())){
        	for(CreditPro pro:page.getContent()){
        		Map<String,Object> map = Maps.newHashMap();
        		map.put("id", pro.getId());
        		map.put("name", pro.getProductName());
        		list.add(map);
        	}
        }
        return list;
	}
	
	@RequestMapping("find")
    public CreditPro find(Long id) {
        return creditProService.load(id);
    }

}
