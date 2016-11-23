package com.zabbix.sisyphus.licaipro.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zabbix.sisyphus.licaipro.entity.ProjectInfo;
import com.zabbix.sisyphus.licaipro.repository.ProjectInfoDao;

@Component
@Transactional
public class ProjectInfoService {
	@Autowired
	private ProjectInfoDao projectInfoDao;
	
	public boolean isExistInvestByPid(Integer pid){
		ProjectInfo proInfo = projectInfoDao.findByPid(pid);
		return proInfo==null?false:proInfo.getTotalBuyNum()==null?false:proInfo.getTotalBuyNum().compareTo(new BigDecimal(0))==1?true:false;
	}

	public void saveProjectInfo(ProjectInfo projectInfo) {
		projectInfoDao.save(projectInfo);
	}
	
	/**
	 * 是否存在未满标的新手宝
	 * @return
	 */
	public boolean existNew(){
		List<ProjectInfo> list = projectInfoDao.findByIsNewProject((byte)1);
		for(ProjectInfo info:list){
			if(info.getProjectStatus()<15 && info.getProjectStatus()!=-1){
				return true;
			}
		}
		return false;
	}
}
