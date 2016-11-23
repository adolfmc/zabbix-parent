package com.zabbix.sisyphus.fortune.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.zabbix.sisyphus.base.enu.Status;
import com.zabbix.sisyphus.base.exception.BusinessException;
import com.zabbix.sisyphus.base.service.BaseService;
import com.zabbix.sisyphus.contract.entity.ProjectTag;
import com.zabbix.sisyphus.contract.repository.ProjectTagDao;
import com.zabbix.sisyphus.credit.entity.CreditDetail;
import com.zabbix.sisyphus.credit.repository.CreditInfoDao;
import com.zabbix.sisyphus.crm.entity.Attachment;
import com.zabbix.sisyphus.crm.repository.AttachmentDao;
import com.zabbix.sisyphus.esb.vo.TenderPlanVO;
import com.zabbix.sisyphus.fortune.entity.TenderPlan;
import com.zabbix.sisyphus.fortune.entity.TenderPlanCredit;
import com.zabbix.sisyphus.fortune.enu.TenderPlanFlowId;
import com.zabbix.sisyphus.fortune.repository.TenderPlanCreditDao;
import com.zabbix.sisyphus.fortune.repository.TenderPlanDao;
import com.zabbix.sisyphus.licaipro.entity.AlreadyPurchasedUser;
import com.zabbix.sisyphus.licaipro.entity.LicaiOrderInfo;
import com.zabbix.sisyphus.licaipro.entity.ProjectCategory;
import com.zabbix.sisyphus.licaipro.entity.ProjectInfo;
import com.zabbix.sisyphus.licaipro.entity.UserInfo;
import com.zabbix.sisyphus.licaipro.repository.LicaiOrderInfoDao;
import com.zabbix.sisyphus.licaipro.repository.ProjectDetailInfoDao;
import com.zabbix.sisyphus.licaipro.repository.ProjectInfoDao;
import com.zabbix.sisyphus.licaipro.repository.UserInfoDao;
import com.zabbix.sisyphus.licaipro.service.ProjectCategoryService;
import com.zabbix.sisyphus.licaipro.service.ProjectInfoService;
import com.zabbix.sisyphus.risk.entity.AuditInfo;
import com.zabbix.sisyphus.risk.repository.AuditInfoDao;

@Component
public class TenderPlanService extends BaseService<TenderPlan> {

	@Autowired
	private TenderPlanDao tenderPlanDao;
	@Autowired
	private ProjectInfoService projectInfoService;
	@Autowired
	private ProjectCategoryService projectCategoryService;
	@Autowired
	private ProjectDetailInfoDao projectDetailInfoDao;

	
	@Autowired
	public void setRepository(TenderPlanDao repository) {
		super.setRepository(repository);
	}

	public void switchProDisplay(Integer pid){
		ProjectInfo info = projectInfoDao.findByPid(pid);
		if(info!=null){
			if("0".equals(info.getDisplay())){
				info.setDisplay("1");
			}else{
				info.setDisplay("0");
			}
			projectInfoDao.save(info);
		}
	}
	
	@Transactional
	public void update(TenderPlan tenderPlan){
		AuditInfo auditInfo = auditInfoDao.findByCreditId(tenderPlan.getCreditInfoId());
		if(auditInfo.getBalance().compareTo(tenderPlan.getAmount())<0){
			throw new BusinessException("发标金额不能大于剩余金额！");
		}
		if(TenderPlanFlowId.审核通过.code.equals(tenderPlan.getFlowId())){
			throw new BusinessException("已上线，不能更新标的信息！");
		}
		ProjectCategory type = projectCategoryService.findById(tenderPlan.getSubType());
		if(type==null){
			throw new BusinessException("未找到发标类型！"+tenderPlan.getSubType());
		}
		if("新手宝".equals(type.getName()) && projectInfoService.existNew()){
			throw new BusinessException("当前存在新手宝，不能再发布新手宝！");
		}
		//现在设置这两个字段为系统值
		tenderPlan.setTenderEnd(tenderPlan.getBuyEndTime());
		tenderPlan.setType(type.getParentId());
		tenderPlan.setSubTypeName(type.getName());
		tenderPlanDao.save(tenderPlan);
	}
	
	@Transactional
	public void create(TenderPlan tenderPlan){
		AuditInfo auditInfo = auditInfoDao.findByCreditId(tenderPlan.getCreditInfoId());
		if(auditInfo==null || auditInfo.getBalance()==null){
			throw new BusinessException("审计信息为空！");
		}
		if(auditInfo.getBalance().compareTo(tenderPlan.getAmount())<0){
			throw new BusinessException("发标金额不能大于剩余金额！");
		}
		ProjectCategory type = projectCategoryService.findById(tenderPlan.getSubType());
		if(type==null){
			throw new BusinessException("未找到发标分类！"+tenderPlan.getSubType());
		}
		if("新手宝".equals(type.getName()) && projectInfoService.existNew()){
			throw new BusinessException("当前存在新手宝，不能再发布新手宝！");
		}
		tenderPlan.setTenderEnd(tenderPlan.getBuyEndTime());
		tenderPlan.setType(type.getParentId());
		tenderPlan.setSubTypeName(type.getName());
		tenderPlan.setStatus(Status.valid.code);
		tenderPlan.setFlowId(TenderPlanFlowId.待审核.code);
		tenderPlanDao.save(tenderPlan);
		
		//添加中间表，此表暂时用不到，等借款信息和发标信息是多对多的关系时则会用到
		TenderPlanCredit tenderPlanCredit = new TenderPlanCredit();
		tenderPlanCredit.setCreditId(tenderPlan.getCreditInfoId());
		tenderPlanCredit.setTenderPlanId(tenderPlan.getId());
		tenderPlanCreditDao.save(tenderPlanCredit);
	}
	
	@Transactional
	public void delete(Long id) {
		TenderPlan tenderPlan = tenderPlanDao.findOne(id);
		tenderPlan.setStatus(Status.unvalid.code);
		tenderPlan.setId(id);
		tenderPlanDao.save(tenderPlan);
	}
	
	/**
	 * 上线标的
	 * @param id
	 */
	@Transactional
	public void release(Long id){
		TenderPlan tenderPlan = tenderPlanDao.findOne(id);
		AuditInfo auditInfo = auditInfoDao.findByCreditId(tenderPlan.getCreditInfoId());
		if(auditInfo.getBalance().compareTo(tenderPlan.getAmount())<0){
			throw new BusinessException("发标金额不能大于剩余金额！");
		}
		//余额扣除
		auditInfo.setBalance(auditInfo.getBalance().subtract(tenderPlan.getAmount()));
		auditInfoDao.save(auditInfo);
		//状态变更
		tenderPlan.setFlowId(TenderPlanFlowId.审核通过.code);
		tenderPlanDao.save(tenderPlan);
	}
	
	/**
	 * 撤销上线
	 * @param id
	 */
	public void repeal(Long id){
		TenderPlan tenderPlan = tenderPlanDao.findOne(id);
		AuditInfo auditInfo = auditInfoDao.findByCreditId(tenderPlan.getCreditInfoId());
		//判断标的是否有投资
		if(tenderPlan.getOldLicaiProId()!=null){
			if(projectInfoService.isExistInvestByPid(tenderPlan.getOldLicaiProId())){
				throw new BusinessException("已有投资记录，不能撤销！");
			}
			projectInfoDao.delete(tenderPlan.getOldLicaiProId());
			projectDetailInfoDao.delete(tenderPlan.getOldLicaiProId());
		}
		//金额回滚
		auditInfo.setBalance(auditInfo.getBalance().add(tenderPlan.getAmount()));
		auditInfoDao.save(auditInfo);
		//状态回滚
		tenderPlan.setOldLicaiProId(null);
		tenderPlan.setFlowId(TenderPlanFlowId.待审核.code);
		tenderPlanDao.save(tenderPlan);
	}
	
	
	public Page<TenderPlan> page(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TenderPlan> spec = buildSpecification(searchParams);
		return tenderPlanDao.findAll(spec, pageRequest);
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
	private Specification<TenderPlan> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<TenderPlan> spec = DynamicSpecifications.bySearchFilter(filters.values(), TenderPlan.class);
		return spec;
	}


	@Autowired
	ProjectTagDao projectTagDao;
	@Autowired
	ProjectInfoDao projectInfoDao;

	@Autowired
	CreditInfoDao creditInfoDao;

	@Autowired
	TenderPlanCreditDao tenderPlanCreditDao;
	@Autowired
	AuditInfoDao auditInfoDao;
	@Autowired
	LicaiOrderInfoDao licaiOrderInfoDao;

	@Autowired
	UserInfoDao userInfoDao;
	@Autowired
	AttachmentDao attachmentDao;

	@Autowired
	JdbcTemplate jdbcTemplate;


	String sql = "SELECT ctc.amount,ctc.deadline,fttp.irr,ctci.job_adress,ctci.industry,ctci.scale,ctci.corporate_information\n" +
			"  ,ctci.liabilities,ctci.upsadown,ctci.asset_status,ctci.annual_sales,ctc.credit_use,ctc.pay_way,fttp.tender_end\n" +
			"FROM cd_t_credit_info ctc,crm_t_company_info ctci,ft_t_tender_plan fttp\n" +
			"WHERE  ctc.customer_id = ctci.id and ctc.id = fttp.credit_info_id and fttp.old_licai_pro_id = %d";
    public TenderPlanVO findByOldPid(Integer id) {

		CreditDetail creditDetail = jdbcTemplate.queryForObject(String.format(sql,id), new BeanPropertyRowMapper<CreditDetail>(CreditDetail.class));
		String xieyiUrl = jdbcTemplate.queryForObject(String.format("select xieyi_url from t_licai_project_detail_info WHERE pid = %d",id),String.class);
		TenderPlanVO vo = new TenderPlanVO();
		vo.setXieyiUrl(xieyiUrl);
		vo.setCreditDetail(creditDetail);
		//最小购买金额为100
		vo.setBuyMinNum(100);
		TenderPlan tenderPlan = tenderPlanDao.findByOldLicaiProId(id);
		ProjectInfo projectInfo = projectInfoDao.findOne(id.intValue());
		List<Attachment> attachments = attachmentDao.findAttachmentByPid(id,"00040006");
		vo.setAttachments(attachments);

		//设置剩余金额
		vo.setRemainAmount(projectInfo.getRemainNum());
		vo.setTotalBuyNum(projectInfo.getTotalBuyNum());
		vo.setProjectStatus(Integer.valueOf(projectInfo.getProjectStatus()));
		vo.setRepayment(1);
		vo.setCreateTime(projectInfo.getCreateTime());
		vo.setYureEndTime(projectInfo.getYureEndTime());
		vo.setBuyEndTime(projectInfo.getBuyEndTime());


		//设置投资记录
		List<LicaiOrderInfo> purchasedUsers = licaiOrderInfoDao.findByPidAndStatusInOrderByCreateTimeDesc(id, Lists.newArrayList((byte)2,(byte)9,(byte)12,(byte)10,(byte)13));
		List<AlreadyPurchasedUser> users = Lists.newArrayListWithCapacity(purchasedUsers.size());
		for (LicaiOrderInfo orderInfo :purchasedUsers){
			AlreadyPurchasedUser u = new AlreadyPurchasedUser();
			UserInfo userInfo = userInfoDao.findOne(orderInfo.getUuid());
			u.setMobile(StringUtils.overlay(userInfo.getMobile(), "*******", 2, 9));
			u.setTime(orderInfo.getCreateTime());
			u.setBuyNum(orderInfo.getBuyNum());
			users.add(u);
		}
		vo.setPurchasedUser(users);
		//设置详情信息
		TenderPlanCredit tenderPlanCredit = tenderPlanCreditDao.findByTenderPlanId(tenderPlan.getId());
		AuditInfo auditInfo = auditInfoDao.findByCreditId(tenderPlanCredit.getCreditId());
		vo.setOperationStatus(auditInfo.getOperationStatus());
		vo.setScale(auditInfo.getScale());
		vo.setCorporateInformation(auditInfo.getCorporateInformation());

		//审核时间
		vo.setAuditTime(auditInfo.getAuditTime());

		vo.setIdcard(auditInfo.getIdcard());
		vo.setBankId(auditInfo.getBankId());
		vo.setCreditPort(auditInfo.getCreditPort());
		vo.setIncome(auditInfo.getIncome());
		vo.setWorkPermit(auditInfo.getWorkPermit());

		List<Long> ids = Lists.newArrayList();

		if (StringUtils.isNotBlank(projectInfo.getTags())) {
			for (String idstr : Splitter.on(",").split(projectInfo.getTags())) {
				ids.add(Long.valueOf(idstr));
			}
		}
		List<ProjectTag> tags = projectTagDao.findAll(ids);

		BeanUtils.copyProperties(tenderPlan,vo);
		vo.setTags(tags);
		return vo;
	}
}

















