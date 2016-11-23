package com.zabbix.sisyphus.uc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.Function;
import com.zabbix.sisyphus.uc.entity.Role;
import com.zabbix.sisyphus.uc.entity.RoleFun;
import com.zabbix.sisyphus.uc.repository.FunctionDao;
import com.zabbix.sisyphus.uc.repository.RoleDao;
import com.zabbix.sisyphus.uc.repository.RoleFunDao;

@Component
@Transactional
public class RoleService extends BaseService<Role> {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleFunDao roleFunctionDao;
	@Autowired
	private FunctionDao founctionDao;

	@Autowired
	public void setRepository(RoleDao repository) {
		super.setRepository(repository);
	}

	public void deleteRoles(Long[] entityIds) {
		for (Long entityId : entityIds) {
			Role role = load(entityId);
			List<RoleFun> roleFunctions = roleFunctionDao.findAllByRole(role);
			for (RoleFun roleFunction : roleFunctions) {
				roleFunctionDao.delete(roleFunction.getId());
			}
			roleDao.delete(entityId);
		}
	}

	public void tieFunction(Long roleId, Long[] entityIds) {
		Role role = roleDao.findOne(roleId);
		List<RoleFun> roleFunctions = roleFunctionDao.findAllByRole(role);
		for (RoleFun roleFunction : roleFunctions) {
			roleFunctionDao.delete(roleFunction.getId());
		}

		List<RoleFun> roleFunctionsList = new ArrayList<RoleFun>();
		for (Long entityId : entityIds) {
			Function function = founctionDao.findOne(entityId);
			RoleFun roleFunction = new RoleFun();
			roleFunction.setRole(role);
			roleFunction.setFunction(function);
			roleFunctionDao.save(roleFunction);
			roleFunctionsList.add(roleFunction);
		}
		role.setRoleFuns(roleFunctionsList);
		roleDao.save(role);
	}

	public List<Role> findAllByName(String name) {
		return roleDao.findAllByName(name);
	}

	public List<Role> findAllByNameIn(String[] name) {
		return roleDao.findAllByNameIn(name);
	}

}
