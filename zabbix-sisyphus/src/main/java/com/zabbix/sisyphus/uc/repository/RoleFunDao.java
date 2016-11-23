package com.zabbix.sisyphus.uc.repository;

import java.util.List;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.uc.entity.Role;
import com.zabbix.sisyphus.uc.entity.RoleFun;

public interface RoleFunDao extends BaseRepository<RoleFun> {

	List<RoleFun> findAllByRole(Role role);

}
