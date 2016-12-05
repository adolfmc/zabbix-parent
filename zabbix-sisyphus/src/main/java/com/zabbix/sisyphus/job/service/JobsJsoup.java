package com.zabbix.sisyphus.job.service;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zabbix.sisyphus.job.entity.JobInfo;
import com.zabbix.sisyphus.job.repository.JobInfoDao;
import com.zabbix.sisyphus.proxy.PXUserAgent;
import com.zabbix.sisyphus.proxy.service.ProxyIPService;
import com.zabbix.sisyphus.util.ProxyIP;

@Lazy(false)
@Async
@Component
public class JobsJsoup {
	public static Map<String, Object[]> vmap = new HashMap<String, Object[]>();
	public static Map<Object, Object> ipinfos = new HashMap<Object, Object>();

	@Autowired
	private JobInfoDao jobInfoDao;
	@Autowired
	private ProxyIPService proxyIPService;

	public void collect(String url) throws Exception {
		String[] ip = ProxyIP.getRandomProxyIP();

		Document doc = null;

		doc = connection(url, doc, ip);
		int ii = 0;
		while (doc == null) {
			ip = proxyIPService.getIP();
			doc = connection(url, doc, ip);
			System.out.println(new Date() + "yichang  " + (ii++));
		}

		Elements elements = doc.getElementsByClass("sojob-list");
		Iterator<?> localIterator1 = elements.iterator();
		while (localIterator1.hasNext()) {
			Element element = (Element) localIterator1.next();
			System.out.println(element);
			Elements eleLi = element.getElementsByTag("li");

			for (Iterator<?> localIterator2 = eleLi.iterator(); localIterator2.hasNext();) {
				Element info = (Element) localIterator2.next();
				String zwurl = null;
				Elements jobname = info.getElementsByClass("job-name");
				for (Iterator<?> localIterator3 = jobname.iterator(); localIterator3.hasNext();) {
					Element element2 = (Element) localIterator3.next();
					Elements elementsByTag = element2.getElementsByTag("a");
					zwurl = elementsByTag.attr("href");
				}

				String qiyxz = info.getElementsByTag("i").text();

				String jobinfo = info.getElementsByClass("job-info").text();
				String[] jobi = jobinfo.split(" ");

				for (int i = 0; i < jobi.length; ++i)
					;
				String companyinfo = info.getElementsByClass("company-info").text();
				String[] companyi = companyinfo.split(" ");

				for (int i = 0; i < companyi.length; ++i) {
					int times = 0;
					String infokey = jobi[0] + " " + jobi[1] + " " + jobi[2] + " " + jobi[3] + " " + jobi[4] + "|" + companyinfo;
					System.out.println("vmap.size() = " + vmap.size());
					if (vmap.containsKey(infokey)) {
						times = Integer.valueOf(((Object[]) vmap.get(infokey))[0].toString()).intValue() + 1;
						vmap.put(infokey, new Object[] { Integer.valueOf(times), jobinfo, companyinfo, jobi[5], qiyxz, zwurl, jobinfo, companyinfo, Boolean.valueOf(false) });
						break;
					}
					vmap.put(infokey, new Object[] { Integer.valueOf(times), jobinfo, companyinfo, jobi[5], qiyxz, zwurl, jobinfo, companyinfo, Boolean.valueOf(true) });
				}
			}
		}
	}

	private Document connection(String url, Document doc, String[] ip) {
		try {
			System.out.println(url + "  " + ip[0]);
			String uuid =UUID.randomUUID().toString().replaceAll(" ","");
			String tokenuuid =UUID.randomUUID().toString().replaceAll(" ","");
			doc = Jsoup.connect(url)
					.proxy(Proxy.Type.HTTP, ip[0], Integer.valueOf(ip[1]).intValue())
					.userAgent(PXUserAgent.getUserAgent())
					.cookie(uuid, "token="+System.currentTimeMillis()+tokenuuid)
					.timeout(12000)
					.post();
		} catch (Exception e) {
			doc = null;
		}
		return doc;
	}

	@Scheduled(cron = "0 0/30 * * * ? ")
//	 @Scheduled(cron = "0 0/5 * * * ? ")
	public void execute() throws Exception {
		System.out.println(new Date() + "--------------------------------------------");
		try {
			List<String> urllist = new ArrayList<String>();

			urllist.add("https://www.liepin.com/sh/zhaopin/?sfrom=click-pc_homepage-centre_searchbox-search_new&key=");
			for (int i = 1; i <= 500; ++i) {
				urllist.add("https://www.liepin.com/sh/zhaopin/?sfrom=click-pc_homepage-centre_searchbox-search_new&key=&curPage=" + i);
			}

			saveInfo(urllist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void saveInfo(List<String> urllist) throws Exception, InterruptedException {
		for (Iterator<String> localIterator1 = urllist.iterator(); localIterator1.hasNext();) {
			String string = (String) localIterator1.next();
			collect(string);

			// Set<String> infos = vmap.keySet();
			// Iterator<?> info = infos.iterator();
			// while (info.hasNext()) {
			// String jobcomp = (String) info.next();
			// int i = Integer.valueOf(((Object[])
			// vmap.get(jobcomp))[0].toString()).intValue();
			// }

			Set<String> infos2 = vmap.keySet();
			Iterator<?> info2 = infos2.iterator();
			while (info2.hasNext()) {
				String jobcomp = (String) info2.next();
				Object[] is = (Object[]) vmap.get(jobcomp);
				String companyinfo = (String) is[2];
				String jobinfo = (String) is[1];
				JobInfo jobii = new JobInfo();
				jobii.setCompany(companyinfo.split(" ")[0]);
				jobii.setJobxz(is[4] + "");
				jobii.setUrl(is[5] + "");
				jobii.setTitile(jobinfo.split(" ")[0]);
				jobii.setSalary(jobinfo.split(" ")[1]);
				jobii.setType("liepin");
				jobii.setJobtime(jobinfo.split(" ")[5]);
				jobii.setJobinfo(is[6] + "");
				jobii.setCompanyinfo(is[7] + "");
				jobii.setIsNew(is[8] + "");
				jobii.setIndustry(companyinfo.split(" ")[1]);
				jobii.setMemo1(jobii.getCompanyinfo() + jobii.getTitile() + jobii.getSalary() + jobii.getUrl());
				
				if(jobInfoDao.findByUrl(jobii.getUrl()).isEmpty() ){
					jobInfoDao.save(jobii);
				}
			}

			vmap = new HashMap<String, Object[]>();

			Thread.sleep(2000L);
		}
	}
}