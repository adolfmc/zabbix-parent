package com.zabbix.sisyphus.uc.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabbix.sisyphus.base.common.PasswordEncoder;
import com.zabbix.sisyphus.base.common.ResultVo;
import com.zabbix.sisyphus.uc.entity.LoginInfo;
import com.zabbix.sisyphus.uc.service.LoginInfoService;

/**
 *@author zabbix
 *2016年10月24日
 */
@RestController
@RequestMapping("/rest/loginfo")
public class LoginfoRestController {
    @Autowired
    private LoginInfoService loginInfoService;

    @PostMapping(value = "savePassword")
    public ResultVo savePassword(Long loginInfoid,String password,String newPassword) {
    	LoginInfo loginfo = loginInfoService.load(loginInfoid);
    	if(loginfo==null || !PasswordEncoder.encoder(password)
    			.equals(loginfo.getPassword1())){
    		return ResultVo.error("密码不正确！");
    	}
    	loginfo.setPassword1(PasswordEncoder.encoder(newPassword));
    	loginfo.setPw1Date(new Date());
    	loginInfoService.saveOrUpdate(loginfo);
        return ResultVo.OK();
    }

    @GetMapping(value = "{id}")
    public LoginInfo getLoginfo(@PathVariable Long id) {
    	return loginInfoService.load(id);
    }
    
}
