package com.zabbix.sisyphus.contract.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.contract.entity.CreditPro;
import com.zabbix.sisyphus.contract.repository.CreditProDao;

/**
 *@author zabbix
 *2016年10月19日
 */
@Service
@Transactional
public class CreditProService extends BaseService<CreditPro>{

    @Autowired
    CreditProDao creditProDao;
    
    @Autowired
	public void setRepository(CreditProDao repository) {
		super.setRepository(repository);
	}
    
    public Page<CreditPro> page(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<CreditPro> spec = buildSpecification(searchParams);
		return creditProDao.findAll(spec, pageRequest);
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "lastModifiedDate");
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<CreditPro> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<CreditPro> spec = DynamicSpecifications.bySearchFilter(filters.values(), CreditPro.class);
		return spec;
	}
}
