package com.zabbix.sisyphus.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabbix.sisyphus.job.entity.JobInfo;

public abstract interface JobInfoDao extends JpaRepository<JobInfo, Long> {
}