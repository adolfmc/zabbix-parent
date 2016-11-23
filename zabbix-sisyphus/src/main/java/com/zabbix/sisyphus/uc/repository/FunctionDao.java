package com.zabbix.sisyphus.uc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.uc.entity.Function;

public interface FunctionDao extends BaseRepository<Function> {

	@Query("from Function func where func.id = func.parent.id")
	public Function root();

	public Function findOneByName(String name);

	public List<Function> findAllByParentAndIdNotOrderByOrdAsc(Function sysfucntion, Long id);
	
	

}
