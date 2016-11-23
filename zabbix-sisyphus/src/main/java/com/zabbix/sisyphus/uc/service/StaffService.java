package com.zabbix.sisyphus.uc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.common.Constants;
import com.zabbix.sisyphus.base.common.PasswordEncoder;
import com.zabbix.sisyphus.base.exception.BusinessException;
import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.Department;
import com.zabbix.sisyphus.uc.entity.LoginInfo;
import com.zabbix.sisyphus.uc.entity.Role;
import com.zabbix.sisyphus.uc.entity.Staff;
import com.zabbix.sisyphus.uc.entity.StaffRole;
import com.zabbix.sisyphus.uc.repository.DepartmentDao;
import com.zabbix.sisyphus.uc.repository.LoginInfoDao;
import com.zabbix.sisyphus.uc.repository.RoleDao;
import com.zabbix.sisyphus.uc.repository.StaffDao;
import com.zabbix.sisyphus.uc.repository.StaffRoleDao;

@Component
@Transactional
public class StaffService extends BaseService<Staff> {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private StaffRoleDao staffRoleDao;
	@Autowired
	private LoginInfoDao loginInfoDao;
	
	@Autowired
	private LoginInfoService loginInfoService;
	
	@Autowired
	public void setRepository(StaffDao staffDao) {
		super.setRepository(staffDao);
	}

	public void saveOrUpdate2(Staff staff, Long[] departmentIds, Long[] roleIds, String loginName) {
		if (departmentIds != null && departmentIds.length > 0) {
			List<Department> departments = departmentDao.findAllByIdIn(departmentIds);
			if (!departments.isEmpty())
				staff.setDepartment(departments.get(0));
		}
		List<StaffRole> roles = new ArrayList<StaffRole>();
		if (roleIds != null && roleIds.length > 0) {
			List<Role> roles2 = roleDao.findAllByIdIn(roleIds);
			for (Role role : roles2) {
				StaffRole staffRole = new StaffRole();
				staffRole.setRole(role);
				roles.add(staffRole);
			}
		}
		if (staff.getId() == null) {// 新员工
			saveOrUpdate(staff);
			for (StaffRole staffRole : roles) {
				staffRole.setStaff(staff);
				staffRoleDao.save(staffRole);
			}
			staff.setStaffRoles(roles);
			saveOrUpdate(staff);

			List<LoginInfo> loginInfos = loginInfoDao.findAllByUsername(loginName);			
			if(!loginInfos.isEmpty())throw new BusinessException("登录名重复！");
			/**
			 * 登入信息
			 */
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setUserId(staff.getId());
			loginInfo.setUserType(Constants.D00260001);// 用户类型
			loginInfo.setUsername(loginName);// 登录名
			loginInfo.setPassword1(PasswordEncoder.encoder(Constants.DEFAULTPASSWORD));// 123456
			loginInfo.setPw1Date(new Date()); // 密码1修改时间
//			loginInfo.setPassword2(Constants.DEFAULTPASSWORD);
//			loginInfo.setPw2Date(new Date());
			loginInfo.setStatus(Constants.D00210001);
			loginInfo.setMemo("");
			
			loginInfoService.saveOrUpdate(loginInfo);
		} else {// 员工修改
			Staff entity = load(staff.getId());
			entity.setAreaTel(staff.getAreaTel());
			entity.setTel(staff.getTel());
			entity.setCardId(staff.getCardId());
			entity.setEmail(staff.getEmail());
			entity.setGender(staff.getGender());
			entity.setMemo(staff.getMemo());
			entity.setMobile(staff.getMobile());
			entity.setName(staff.getName());
			entity.setStaffCode(staff.getStaffCode());
			entity.setDepartment(staff.getDepartment());
			List<StaffRole> roleDels = entity.getStaffRoles();
			List<Long> dels = new ArrayList<Long>();
			for (StaffRole staffRole : roleDels) {
				dels.add(staffRole.getId());
			}
			for (Long staffRoleId : dels) {				
				StaffRole staffRole = staffRoleDao.findOne(staffRoleId);
				if(staffRole!=null)staffRoleDao.delete(staffRole);
			}
			saveOrUpdate(entity);
			for (StaffRole staffRole : roles) {
				staffRole.setStaff(entity);
				staffRoleDao.save(staffRole);
			}
			entity.setStaffRoles(roles);
			saveOrUpdate(entity);
		}
	}

	public void deleteStaff(Long[] entityIds) {
		for (Long entityId : entityIds) {
			Staff entity = load(entityId);
			List<StaffRole> roleDels = entity.getStaffRoles();
			for (StaffRole staffRole : roleDels) {
				if(staffRole.getId()!=null)staffRoleDao.delete(staffRole.getId());
			}

			LoginInfo loginInfo = loginInfoDao.findByUserId(entity.getId());
			if (loginInfo != null)
				loginInfoDao.delete(loginInfo.getId());

			staffDao.delete(entityId);
		}
	}

	public List<StaffRole> findAllByRole(Role role) {
		return staffRoleDao.findAllByRole(role);
	}

	public LoginInfo getLoginInfoByCustomerId(Long entityId) {
		return loginInfoDao.findAllByUserIdAndUserType(entityId,Constants.D00260001).get(0);
	}
	public void resetPassword(Long customerId) {
		LoginInfo loginInfo = loginInfoDao.findAllByUserIdAndUserType(customerId,Constants.D00260001).get(0);
		// UC模块　CRM_T_CUSTOMER_INFO表
		loginInfo.setPassword1(PasswordEncoder.encoder(Constants.DEFAULTPASSWORD));// 123456
		loginInfo.setPw1Date(new Date()); // 密码1修改时间
//		loginInfo.setPassword2(Constants.DEFAULTPASSWORD);
//		loginInfo.setPw2Date(new Date());
		loginInfoService.saveOrUpdate(loginInfo);
	}
	
}
