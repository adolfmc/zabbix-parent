package com.zabbix.sisyphus.uc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.common.Constants;
import com.zabbix.sisyphus.base.common.ResultVo;
import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.Function;
import com.zabbix.sisyphus.uc.entity.LoginInfo;
import com.zabbix.sisyphus.uc.entity.Staff;
import com.zabbix.sisyphus.uc.repository.FunctionDao;
import com.zabbix.sisyphus.uc.repository.LoginInfoDao;
import com.zabbix.sisyphus.uc.repository.StaffDao;
@Component
@Transactional
public class LoginInfoService extends BaseService<LoginInfo> {

	private LoginInfoDao loginInfoDao;
	@Autowired
	private FunctionDao functionDao;
	@Autowired
	private StaffDao staffDao;
	
	
	
	@Autowired
	public void setRepository(LoginInfoDao loginInfoDao) {
		super.setRepository(loginInfoDao);
		this.loginInfoDao = loginInfoDao;
	}

//	public void save(LoginInfo info) {
//		info.setPassword1(PasswordEncoder.encoder(info.getPassword1()));
////		info.setPassword2(PasswordEncoder.encoder(info.getPassword2()));
//		loginInfoDao.save(info);
//	}
//	public void saveForApp(LoginInfo info) {
//		info.setPassword1(info.getPassword1());
//		info.setPassword2(info.getPassword2());
//		loginInfoDao.save(info);
//	}
	
	public List<LoginInfo> findByUsername(String mobile){
		return loginInfoDao.findAllByUsername(mobile);
	}
	
	public List<LoginInfo> findByCustomerId(Long customerId){
		return loginInfoDao.findAllByUserId(customerId);
	}
	
	public LoginInfo findByUserId(Long userId){
		return loginInfoDao.findByUserId(userId);
	}
	
	public ResultVo login(String mobile,String password){
		List<LoginInfo> loginInfos = loginInfoDao.findAllByUsername(mobile);
		if(loginInfos == null || loginInfos.size() < 1){
			return new ResultVo(-1,"不存在该登录名");
		}
		if(Constants.D00210009.equals(loginInfos.get(0).getStatus())){
			return new ResultVo(-1,"无效的登陆名");
		}
		LoginInfo loger = loginInfos.get(0);
		String psw = loger.getPassword1();
		if(password.equals(psw)){
			
			return new ResultVo(0,loger.getUserId());
		}
		return new ResultVo(-1,"密码错误");
	}

	public LoginInfo findAllByUserIdAndUserType(Long id) {
		return loginInfoDao.findAllByUserIdAndUserType(id, Constants.D00260001).get(0);
	}

	public Function findRootFunction() {
		return functionDao.root();
	}
	
	public Staff findStaff(Long id) {
		return staffDao.findOne(id);
	}
}
