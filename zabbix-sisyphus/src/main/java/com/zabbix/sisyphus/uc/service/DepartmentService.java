package com.zabbix.sisyphus.uc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.Department;
import com.zabbix.sisyphus.uc.repository.DepartmentDao;

@Component
@Transactional
public class DepartmentService extends BaseService<Department> {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	public void setRepository(DepartmentDao repository) {
		super.setRepository(repository);
	}

	public Department findOneByName(String name) {
		return departmentDao.findOneByName(name);
	}

	public List<Department> findAllByParent(Department sysfucntion) {
		return departmentDao.findAllByParentAndIdNot(sysfucntion, sysfucntion.getId());
	}

	public void deleteDepartments(Long[] entityIds) {
		for (Long entityId : entityIds) {
			subDelete(entityId);
			departmentDao.delete(entityId);
		}
	}

	private void subDelete(Long entityId) {
		Department entity = load(entityId);
		List<Department> entitys = entity.getChildren();
		for (Department function : entitys) {
			subDelete(function.getId());
			departmentDao.delete(function.getId());
		}
	}

}
