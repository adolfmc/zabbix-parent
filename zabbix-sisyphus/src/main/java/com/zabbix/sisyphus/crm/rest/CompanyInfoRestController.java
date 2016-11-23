package com.zabbix.sisyphus.crm.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
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
import com.zabbix.sisyphus.crm.entity.Attachment;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;
import com.zabbix.sisyphus.crm.service.AttachmentService;
import com.zabbix.sisyphus.crm.service.CompanyInfoService;
import com.zabbix.sisyphus.uc.web.BaseController;

/**
 * rest风格的企业信息控制器
 *
 * @author zabbix 2016年10月14日
 */
@RestController
@RequestMapping(value = "/rest/company")
public class CompanyInfoRestController extends BaseController {

    @Autowired
    private CompanyInfoService companyInfoService;

    /**
     * 创建企业信息
     *
     * @param companyInfo
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultVo create(@Valid CompanyInfo companyInfo, @RequestParam("images") ArrayList<String> images) {
        if (companyInfo.getId() == null) {
            companyInfo.setCustomerCode(companyInfoService.createCustomNo());
            companyInfo.setStatus(Status.valid.code);
        }
        companyInfoService.createCompanyInfo(companyInfo, images);
        return ResultVo.OK();
    }

    /**
     * 更新企业信息
     *
     * @param companyInfo
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultVo update(@Valid @ModelAttribute("companyInfo") CompanyInfo companyInfo,@RequestParam("images") ArrayList<String> images) {

        companyInfoService.saveCompanyInfo(companyInfo,images);

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
        companyInfoService.delete(id);
        return ResultVo.OK();
    }

    /**
     * 分页 搜索字段格式：search_${opertor}_${field},如search_LIKE_title，search_EQ_id
     * opertor枚举：org.springside.modules.persistence.SearchFilter.Operator
     *
     * @return
     */
    @RequestMapping(value = "pages", method = RequestMethod.GET)
    public PageVo<CompanyInfo> pages(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
                                     @RequestParam(value = "rows", defaultValue = "20") int pageSize,
                                     @RequestParam(value = "sort", defaultValue = "auto") String sort, Model model, ServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        Page<CompanyInfo> companys = companyInfoService.page(searchParams, pageNumber, pageSize, sort);
        return new PageVo<>(companys);
    }

    /**
     * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2
     * Preparable二次部分绑定的效果,先根据form的id从数据库查出company对象,再把Form提交的内容绑定到该对象上。
     * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
     */
    @ModelAttribute
    public void getCompanyInfo(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
        if (id != -1) {
            //要与update方法的@ModelAttribute("companyInfo")对应
            model.addAttribute("companyInfo", companyInfoService.load(id));
        }
    }

    /**
     * 根据ID获取企业信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public CompanyInfo companyInfo(@PathVariable("id") Long id) {
        return companyInfoService.load(id);
    }


    @Autowired
    AttachmentService attachmentService;

    @RequestMapping("attachments/{id}")
    public List<Attachment> attachments(@PathVariable("id")Integer id){

        return  attachmentService.find(id);
    }

    @RequestMapping("attachments/delete/{id}")
    public ResultVo deleteAttachments(@PathVariable("id")Long id){
        attachmentService.delete(id);
        return  ResultVo.OK();
    }
}


























