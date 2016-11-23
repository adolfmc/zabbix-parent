package com.zabbix.sisyphus.uc.repository;

import java.util.List;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.uc.entity.Role;
import com.zabbix.sisyphus.uc.entity.StaffRole;

public interface StaffRoleDao extends BaseRepository<StaffRole> {

	List<StaffRole> findAllByRole(List<Role> role);

	List<StaffRole> findAllByRole(Role role);

}
