package com.zabbix.sisyphus.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabbix.sisyphus.job.entity.JobInfo;

public abstract interface JobInfoDao extends JpaRepository<JobInfo, Long> {

	List<JobInfo> findByUrl(String url);
}