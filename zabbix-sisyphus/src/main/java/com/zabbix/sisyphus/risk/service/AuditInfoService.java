package com.zabbix.sisyphus.risk.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.risk.entity.AuditInfo;
import com.zabbix.sisyphus.risk.repository.AuditInfoDao;

@Component
public class AuditInfoService extends BaseService<AuditInfo> {

	@Autowired
	private AuditInfoDao auditInfoDao;
	
	
	@Autowired
	public void setRepository(AuditInfoDao repository) {
		super.setRepository(repository);
	}
	
	public AuditInfo findByCreditId(Long creditId){
		return auditInfoDao.findByCreditId(creditId);
	}

    public Page<AuditInfo> page(Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<AuditInfo> spec = buildSpecification(searchParams);
		return auditInfoDao.findAll(spec, pageRequest);
    }

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "createdDate");
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<AuditInfo> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<AuditInfo> spec = DynamicSpecifications.bySearchFilter(filters.values(), AuditInfo.class);
		return spec;
	}

}
