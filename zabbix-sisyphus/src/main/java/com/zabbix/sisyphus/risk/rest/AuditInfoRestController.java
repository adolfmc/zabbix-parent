package com.zabbix.sisyphus.risk.rest;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.web.Servlets;

import com.zabbix.sisyphus.base.common.PageVo;
import com.zabbix.sisyphus.base.common.ResultVo;
import com.zabbix.sisyphus.base.enu.Status;
import com.zabbix.sisyphus.credit.entity.CreditInfo;
import com.zabbix.sisyphus.credit.service.CreditInfoService;
import com.zabbix.sisyphus.risk.entity.AuditInfo;
import com.zabbix.sisyphus.risk.enu.AuditInfoFlowId;
import com.zabbix.sisyphus.risk.service.AuditInfoService;

/**
 * 作者: zabbix 创建于 16/10/20.
 */
@RestController
@RequestMapping("/risk/rest/auditInfo")
public class AuditInfoRestController {


    @Autowired
    AuditInfoService auditInfoService;

    @Autowired
    CreditInfoService creditInfoService;


    /**
     * 分页
     * @return
     */
    @RequestMapping(value = "pages", method = RequestMethod.GET)
    public PageVo<AuditInfo> pages(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                    @RequestParam(value = "rows", defaultValue = "20") int pageSize,
                                    @RequestParam(value = "sort", defaultValue = "auto") String sort, Model model, ServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        searchParams.put("EQ_status", Status.valid.code);
        Page<AuditInfo> companys = auditInfoService.page(searchParams, pageNumber, pageSize, sort);
        return new PageVo<>(companys);
    }


    @PostMapping("auditCompany")
    public ResultVo auditCompany(AuditInfo auditInfo,String auditResult){
        auditInfo.setVersion(1L);
        auditInfo.setFlowId(auditResult);
        auditInfo.setStatus(Status.valid.code);
        auditInfo.setAuditTime(new Date());
        auditInfo.setBalance(auditInfo.getAuditAmount());
        //更新申请表状态
        CreditInfo creditInfo = creditInfoService.load(auditInfo.getCreditId());

        if (StringUtils.equals(AuditInfoFlowId.终审通过.code,auditResult)){
            creditInfo.setSubFlowId(AuditInfoFlowId.终审通过.code);
            creditInfo.setFlowId("02000001");
        }else{
            creditInfo.setFlowId("02000009");
            creditInfo.setSubFlowId(AuditInfoFlowId.终审驳回.code);
        }
        creditInfoService.saveOrUpdate(creditInfo);
        auditInfo.setCreditInfo(creditInfo);
        auditInfoService.saveOrUpdate(auditInfo);
        return ResultVo.OK();
    }

}
