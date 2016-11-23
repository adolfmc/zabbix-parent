package com.zabbix.sisyphus.contract.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zabbix.sisyphus.base.common.ResultVo;
import com.zabbix.sisyphus.contract.entity.FortunePro;
import com.zabbix.sisyphus.contract.entity.vo.DataGridVo;
import com.zabbix.sisyphus.contract.service.FortuneProService;

/**
 * 合同管理
 * 作者: zabbix 创建于 16/10/14.
 */
@Controller
@RequestMapping("contract")
public class ContractController {


    @Autowired
    FortuneProService fortuneProService;

    @GetMapping("list")
    public String list() {

        return "/contract/contractList";
    }


    @RequestMapping("update")
    @ResponseBody
    public ResultVo update(FortunePro fortunePro) {

        fortuneProService.update(fortunePro);
        return ResultVo.OK();
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultVo delete(Long id){
        FortunePro fortunePro = fortuneProService.find(id);
        fortunePro.setStatus("9");
        fortuneProService.update(fortunePro);
        return  ResultVo.OK();
    }


    @RequestMapping("find")
    @ResponseBody
    public FortunePro find(Long id) {
        FortunePro fortunePro = fortuneProService.find(id);
        return fortunePro;
    }


    @RequestMapping("findFortunePro")
    @ResponseBody
    public DataGridVo<FortunePro> findFortunePro(Integer page, Integer rows) {
        PageRequest pageRequest = new PageRequest(page - 1, rows, Sort.Direction.DESC,"id");
        Page<FortunePro> proPage = fortuneProService.findAll(pageRequest);
        DataGridVo<FortunePro> dataGridVo = new DataGridVo<FortunePro>();
        dataGridVo.setRows(proPage.getContent());
        dataGridVo.setTotal(proPage.getTotalElements());
        return dataGridVo;
    }
    
    @RequestMapping("fortunePro/idName")
    @ResponseBody
    public List<Map<String,Object>> idName() {
        PageRequest pageRequest = new PageRequest(0, Integer.MAX_VALUE, Sort.Direction.DESC,"id");
        Page<FortunePro> proPage = fortuneProService.findAll(pageRequest);
        List<Map<String,Object>> list = Lists.newArrayList();
        if(proPage!=null && !CollectionUtils.isEmpty(proPage.getContent())){
        	for(FortunePro pro:proPage.getContent()){
        		Map<String,Object> map = Maps.newHashMap();
        		map.put("id", pro.getId());
        		map.put("name", pro.getProductName());
        		list.add(map);
        	}
        }
        return list;
    }


    @RequestMapping("saveFortune")
    @ResponseBody
    public ResultVo saveFortune(FortunePro fortunePro) {
        fortunePro.setStatus("1");//有效状态

        fortuneProService.save(fortunePro);
        return ResultVo.OK();
    }
}

