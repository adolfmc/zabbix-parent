package com.zabbix.sisyphus.proxy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabbix.sisyphus.proxy.entity.ProxyIP;

public abstract interface ProxyIPDao extends JpaRepository<ProxyIP, Long> {
	List<ProxyIP> findByStatus(String status);

	List<ProxyIP> findByIp(String ip);
}
