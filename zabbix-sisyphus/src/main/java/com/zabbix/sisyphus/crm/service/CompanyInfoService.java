package com.zabbix.sisyphus.crm.service;

import java.util.ArrayList;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
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

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.crm.entity.Attachment;
import com.zabbix.sisyphus.crm.entity.CompanyInfo;
import com.zabbix.sisyphus.crm.repository.AttachmentDao;
import com.zabbix.sisyphus.crm.repository.CompanyInfoDao;

@Component
@Transactional
public class CompanyInfoService extends BaseService<CompanyInfo> {

	private static final String CUSTOME_CODE_PREFIX="H-C";
		
	@Autowired
	private CompanyInfoDao companyInfoDao;

	@Autowired
	private AttachmentDao attachmentDao;

	@Autowired
	public void setRepository(CompanyInfoDao repository) {
		super.setRepository(repository);
	}
	
	public String createCustomNo(){
		DateTime datetime = DateTime.now();
		DateTime today = datetime.dayOfMonth().roundFloorCopy();
		DateTime tomorrow = today.plusDays(1);
		CompanyInfo company = companyInfoDao.findTopByCreatedDateBetween(today.toDate(), tomorrow.toDate(),
				new Sort(Sort.Direction.DESC, "createdDate"));
		StringBuffer customeCode = new StringBuffer(CUSTOME_CODE_PREFIX);
		customeCode.append(today.toString("-yyyyMMdd-"));
		if(company==null){
			customeCode.append("0001");
		}else{
			String code = company.getCustomerCode().substring(company.getCustomerCode().lastIndexOf("-")+1);
			Integer intCode = Integer.parseInt(code)+1;
			customeCode.append(String.format("%04d", intCode));
		}
		return customeCode.toString();
	}
	
	public Page<CompanyInfo> page(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<CompanyInfo> spec = buildSpecification(searchParams);
		return companyInfoDao.findAll(spec, pageRequest);
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
	private Specification<CompanyInfo> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<CompanyInfo> spec = DynamicSpecifications.bySearchFilter(filters.values(), CompanyInfo.class);
		return spec;
	}


    public void createCompanyInfo(CompanyInfo companyInfo, ArrayList<String> images) {
		companyInfoDao.save(companyInfo);
		saveImages(companyInfo, images);
	}

	public void saveCompanyInfo(CompanyInfo companyInfo, ArrayList<String> images) {
		companyInfoDao.save(companyInfo);
		attachmentDao.deleteByCustomerId(companyInfo.getId().intValue());
		saveImages(companyInfo, images);
    }

	private void saveImages(CompanyInfo companyInfo, ArrayList<String> images) {
		ArrayListMultimap<String,String> map = ArrayListMultimap.create();
		for (String str :images){



			ArrayList<String> strings = Lists.newArrayList(StringUtils.split(str, "_"));
			if (strings!=null&&strings.size()==2){
				map.put(strings.get(0),strings.get(1));
			}
		}
		for(String key:map.keySet()){
			Attachment attachment = new Attachment();
			String type = StringUtils.substringBefore(key,":");
			for (String suffix:map.get(key)){
					if (StringUtils.startsWith(suffix,"01")){
						//缩略图
						attachment.setSubFilePath(String.format("%s_%s",StringUtils.substringAfter(key,":"),suffix));
					}else if (StringUtils.startsWith(suffix,"02")){
						//大图
						attachment.setFilePath(String.format("%s_%s",StringUtils.substringAfter(key,":"),suffix));
					}
			}
			attachment.setStatus("1");
			attachment.setAuditStatus("1");
			attachment.setCustomerId(companyInfo.getId().intValue());
			attachment.setType(type);

			attachmentDao.save(attachment);
		}


	}
}












