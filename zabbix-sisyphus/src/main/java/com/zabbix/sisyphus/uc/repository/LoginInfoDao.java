package com.zabbix.sisyphus.uc.repository;

import java.util.List;

import com.zabbix.sisyphus.base.repository.BaseRepository;
import com.zabbix.sisyphus.uc.entity.LoginInfo;

public interface LoginInfoDao extends BaseRepository<LoginInfo> {

	public LoginInfo findByUsernameAndStatus(String username, String status);

	public LoginInfo findByUserId(Long id);

	public List<LoginInfo> findAllByUsername(String mobile);

	public List<LoginInfo> findAllByUserIdAndUserType(Long entityId, String d00260001);

	public List<LoginInfo> findAllByUserId(Long customerId);


}
