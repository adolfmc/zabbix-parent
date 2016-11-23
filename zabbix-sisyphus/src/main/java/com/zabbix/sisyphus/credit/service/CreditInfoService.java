package com.zabbix.sisyphus.credit.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.zabbix.sisyphus.base.enu.Status;
import com.zabbix.sisyphus.base.exception.BusinessException;
import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.credit.entity.CreditInfo;
import com.zabbix.sisyphus.credit.enu.CreditFlowId;
import com.zabbix.sisyphus.credit.repository.CreditInfoDao;
import com.zabbix.sisyphus.risk.enu.AuditInfoFlowId;

@Component
public class CreditInfoService extends BaseService<CreditInfo> {
	private static final String CUSTOME_CODE_PREFIX="HC";
	@Autowired
	private CreditInfoDao creditInfoDao;

	@Autowired
	public void setRepository(CreditInfoDao repository) {
		super.setRepository(repository);
	}
	
	@Transactional
	public void saveOrUpdate(CreditInfo creditInfo){
		if(creditInfo.getId()!=null){
			creditInfoDao.save(creditInfo);
		}else{
			creditInfo.setStatus(Status.valid.code);
			creditInfo.setCreditNo(createNo());
			creditInfo.setFlowId(CreditFlowId.申请.code); //借款申请
			creditInfo.setSubFlowId(AuditInfoFlowId.初审待分配.code); //初审待分配
			creditInfoDao.save(creditInfo);
		}
	}
	
	@Transactional
	public void repeal(Long id){
		CreditInfo creditInfo = load(id);
		if(CreditFlowId.审核中.code.equals(creditInfo.getFlowId())){
			throw new BusinessException("当前借款信息在审核中，不能撤销！");
		}
		creditInfo.setFlowId(CreditFlowId.撤销.code);
		creditInfoDao.save(creditInfo);
	}
	
	public String createNo(){
		DateTime datetime = DateTime.now();
		DateTime today = datetime.dayOfMonth().roundFloorCopy();
		DateTime tomorrow = today.plusDays(1);
		CreditInfo creditInfo = creditInfoDao.findTopByCreatedDateBetweenOrderByCreatedDateDesc(today.toDate(), tomorrow.toDate());
		StringBuffer customeCode = new StringBuffer(CUSTOME_CODE_PREFIX);
		customeCode.append(today.toString("yyyyMMdd"));
		if(creditInfo==null){
			customeCode.append("0001");
		}else{
			String code = creditInfo.getCreditNo().substring(creditInfo.getCreditNo().length()-3);
			Integer intCode = Integer.parseInt(code)+1;
			customeCode.append(String.format("%04d", intCode));
		}
		return customeCode.toString();
	}
	
	public Page<CreditInfo> page(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<CreditInfo> spec = buildSpecification(searchParams);
		return creditInfoDao.findAll(spec, pageRequest);
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
	private Specification<CreditInfo> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<CreditInfo> spec = DynamicSpecifications.bySearchFilter(filters.values(), CreditInfo.class);
		return spec;
	}
	
	
}
