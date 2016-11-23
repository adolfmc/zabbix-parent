package com.zabbix.sisyphus.uc.repository;

import java.util.List;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.uc.entity.Role;

public interface RoleDao extends BaseRepository<Role> {

	List<Role> findAllByIdIn(Long[] roleIds);

	List<Role> findAllByName(String name);

	List<Role> findAllByNameIn(String[] name);

}
