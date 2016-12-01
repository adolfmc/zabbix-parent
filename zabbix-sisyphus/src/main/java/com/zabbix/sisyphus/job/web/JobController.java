package com.zabbix.sisyphus.job.web;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;
import com.zabbix.sisyphus.job.entity.JobInfo;
import com.zabbix.sisyphus.job.service.JobService;

@Controller
@RequestMapping({ "/job" })
public class JobController {
	@SuppressWarnings("unused")
	private static final String PAGE_SIZE = "50";
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();

	@Autowired
	private JobService jobService;

	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = "50") int pageSize, @RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model, ServletRequest request,
			JobInfo jobinfo) throws UnsupportedEncodingException {
		return "/job/jobList";
	}

	@ResponseBody
	@RequestMapping("pages")
	public List<JobInfo> getPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber, @RequestParam(value = "page.size", defaultValue = "50") int pageSize, @RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model, ServletRequest request,
			JobInfo jobinfo) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Long userId = Long.valueOf(-4414312741959892991L);

		long s1 = System.currentTimeMillis();
		List<JobInfo> tasks = this.jobService.getJobs(userId, searchParams, pageNumber, pageSize, sortType, jobinfo);
		System.out.println(System.currentTimeMillis() - s1);

		return tasks;
	}

	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("titile", "职位");
		sortTypes.put("createDate", "日期");
		sortTypes.put("jobxz", "性质");
		sortTypes.put("salary", "薪水");
	}
}