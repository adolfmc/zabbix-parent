package com.zabbix.sisyphus.esb.web;

import com.zabbix.sisyphus.contract.service.ProjectTagService;
import com.zabbix.sisyphus.credit.service.CreditInfoService;
import com.zabbix.sisyphus.esb.vo.HttpResult;
import com.zabbix.sisyphus.esb.vo.TenderPlanVO;
import com.zabbix.sisyphus.fortune.service.TenderPlanService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 合同模块
 */
@Controller
@RequestMapping("esb/contract")
public class ContractInfoESBService {

    @Autowired
    CreditInfoService creditInfoService;


    @Autowired
    ProjectTagService projectTagService;

    @Autowired
    TenderPlanService tenderPlanService;


    /**
     * 获取理财产品数据
     * @param id
     * @return
     */
    @RequestMapping("tenderPlan/{id}")
    @ResponseBody
    public HttpResult credit(@PathVariable("id") String id) {
        HttpResult httpResult = HttpResult.success();
        if (StringUtils.isNumeric(id)) {
            TenderPlanVO tenderPlanVO = tenderPlanService.findByOldPid(Integer.valueOf(id));
            httpResult.setData(tenderPlanVO);
        }
        return httpResult;
    }
}
