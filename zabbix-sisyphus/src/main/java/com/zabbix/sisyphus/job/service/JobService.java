package com.zabbix.sisyphus.job.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.zabbix.sisyphus.job.entity.JobInfo;

@Component
@Transactional
public class JobService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JobInfo> getJobs(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType, JobInfo jobinfo) {
		Object starttime = (jobinfo.getStarttime() == null) ? "2016-12-01 07:00:00" : jobinfo.getStarttime();
		Object endtime = (jobinfo.getEndtime() == null) ? "2016-12-01 22:00:00" : jobinfo.getEndtime();
		String titile = (jobinfo.getTitile() == null) ? "产品" : jobinfo.getTitile();
		searchParams.put("starttime", starttime);
		searchParams.put("endtime", endtime);
		searchParams.put("titile", titile);

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT  distinct ji.company ,DATE_FORMAT( ji.create_date,'%Y-%c-%d') memo,ji.titile,ji.jobxz,ji.salary ,ji.url ");
		sb.append("from   jobs.job_info ji ");
		sb.append("WHERE  ji.CREATE_DATE >= ? AND ji.CREATE_DATE <= ? AND ji.titile like ? ");
		sb.append("AND ji.jobxz =? ");
		sb.append("AND ji.memo1 NOT IN (SELECT DISTINCT  i.memo1 FROM  jobs.job_info i WHERE i.CREATE_DATE <= ? ) ");

		Object[] args = { starttime, endtime, "%" + titile + "%",jobinfo.getJobxz() ,starttime};

		return jdbcTemplate.query(sb.toString(), args, new ResultSetExtractor() {
			public List<JobInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				long s1 = System.currentTimeMillis();
				List<JobInfo> result = new ArrayList<JobInfo>();
				while (rs.next()) {
					JobInfo job = new JobInfo();
					job.setCompany(rs.getObject("company") + "");
					job.setTitile(rs.getObject("titile") + "");
					job.setJobxz(rs.getObject("jobxz") + "");
					job.setSalary(rs.getObject("salary") + "");
					job.setMemo(rs.getObject("memo") + "");
					job.setUrl(rs.getObject("url") + "");
					result.add(job);
				}
				System.out.println(">>" + (System.currentTimeMillis() - s1));
				return result;
			}
		});

	}

	@SuppressWarnings("unused")
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType))
			sort = new Sort(Sort.Direction.DESC, new String[] { "id" });
		else if ("titile".equals(sortType))
			sort = new Sort(Sort.Direction.DESC, new String[] { "titile" });
		else if ("createDate".equals(sortType))
			sort = new Sort(Sort.Direction.DESC, new String[] { "createDate" });
		else if ("jobxz".equals(sortType))
			sort = new Sort(Sort.Direction.DESC, new String[] { "jobxz" });
		else if ("salary".equals(sortType)) {
			sort = new Sort(Sort.Direction.DESC, new String[] { "salary" });
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private Specification<JobInfo> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", SearchFilter.Operator.EQ, userId));
		Specification spec = DynamicSpecifications.bySearchFilter(filters.values(), JobInfo.class);
		return spec;
	}
}