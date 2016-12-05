package com.zabbix.sisyphus.job;

import java.net.Proxy;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.zabbix.sisyphus.job.entity.JobInfo;
import com.zabbix.sisyphus.proxy.PXUserAgent;

public abstract class JsoupBase {
	public String url;
	public Document doc;
	public String[] ip;
	
	public   Document connection(String url, String[] ip) {
		Document doc;
		try {
			System.out.println(url + "  " + ip[0]);
			String cookieId = UUID.randomUUID().toString().replaceAll("-", "");
			String token = "token=" + UUID.randomUUID().toString().replaceAll("-", "") + System.nanoTime();
			doc = Jsoup.connect(url).proxy(Proxy.Type.HTTP, ip[0], Integer.valueOf(ip[1]))
					.userAgent(PXUserAgent.getUserAgent())
					.header("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7")
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language", "zh-cn,zh;q=0.5")
					.header("Connection", "keep-alive")
					.header("refer", "http://www.baidu.com/s?tn=monline_5_dg&bs=httpclient4+MultiThreadedHttpConnectionManager")
					.cookie(cookieId, token)
					.timeout(15000).get();

		} catch (Exception e) {
			e.printStackTrace();
			doc = null;
		}

		return doc;
	}

	public abstract List<JobInfo> analyze(Document result);
	
	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}

	public  int getRandom(int min, int max) {
		Random random = new Random();
		return (random.nextInt(max) % (max - min + 1) + min);
	}
}
