package com.zabbix.sisyphus.uc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.uc.entity.Function;
import com.zabbix.sisyphus.uc.repository.FunctionDao;

@Component
@Transactional
public class FunctionService extends BaseService<Function> {

	private FunctionDao functionDao;

	@Autowired
	public void setRepository(FunctionDao functionDao) {
		super.setRepository(functionDao);
		this.functionDao = functionDao;
	}

	public Function root() {
		return functionDao.root();
	}

	public void deleteFunctions(Long[] entityIds) {
		for (Long entityId : entityIds) {
			subDelete(entityId);
			functionDao.delete(entityId);
		}
	}

	private void subDelete(Long entityId) {
		Function entity = functionDao.findOne(entityId);
		List<Function> entitys = entity.getChildren();
		for (Function function : entitys) {
			subDelete(function.getId());
			functionDao.delete(function.getId());
		}
	}

	public Function findOneByName(String name) {
		return functionDao.findOneByName(name);
	}

	public List<Function> findAllByParent(Function sysfucntion) {
		return functionDao.findAllByParentAndIdNotOrderByOrdAsc(sysfucntion, sysfucntion.getId());
	}
}
