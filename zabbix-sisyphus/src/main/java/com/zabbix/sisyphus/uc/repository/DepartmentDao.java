package com.zabbix.sisyphus.uc.repository;

import java.util.List;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.uc.entity.Department;

public interface DepartmentDao extends BaseRepository<Department> {

	Department findOneByName(String name);

	List<Department> findAllByParentAndIdNot(Department sysfucntion, Long id);

	List<Department> findAllByIdIn(Long[] departmentIds);

}
