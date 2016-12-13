package com.zabbix.sisyphus.proxy.service;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zabbix.sisyphus.proxy.PXUserAgent;
import com.zabbix.sisyphus.proxy.entity.ProxyIP;
import com.zabbix.sisyphus.proxy.repository.ProxyIPDao;

@Lazy(false)
@Component
public class ProxyIPService {
	public static Vector<String[]> ipList = new Vector<String[]>();
	public static Vector<String> urlList = new Vector<String>();
	public static String checkUrl ="http://www.baidu.com";
	public static Logger logger =LoggerFactory.getLogger(ProxyIPService.class);
	
	static{
		urlList.add("http://www.xicidaili.com/nn");
		urlList.add("http://www.xicidaili.com/nn/1");
		urlList.add("http://www.xicidaili.com/nt");
		urlList.add("http://www.xicidaili.com/nt/1");
		urlList.add("http://www.xicidaili.com/wn");
		urlList.add("http://www.xicidaili.com/wn/1");
		urlList.add("http://www.xicidaili.com/wt");
		urlList.add("http://www.xicidaili.com/wt/1");
	}
	
	


	@Scheduled(cron = "0 0 0/4 * * ? ")
	public void excute() {
		for (String url : urlList) {
			List<ProxyIP> analyzeProxyIps = new ArrayList<ProxyIP>();
			Document result = null;
			try {
				result = connection(url, getIP());
			} catch (Exception e) {
			}
			
			if (result == null) {
			} else {
				analyzeProxyIps = analyze(result);
			}
			
			checkIP(analyzeProxyIps);
			sleep(10000);
		}
	}

	
	public  String[] getIP() {
		if (ipList.isEmpty()) {
			List<ProxyIP> lists = proxyIPDao.findByStatus("00000000");
			for (ProxyIP proxyIP : lists) {
				ipList.add(new String[]{proxyIP.getIp(),String.valueOf(proxyIP.getPort())});
			}
		}
		return ipList.get(getRandom(0, (ipList.size() - 1)));
	}

	public static int getRandom(int min, int max) {
		Random random = new Random();
		return (random.nextInt(max) % (max - min + 1) + min);
	}
	
	
	/**
	 * <br>
	 * * 批量代理IP有效检测<br>
	 * *<br>
	 * * @param IP<br>
	 * * @param post<br>
	 */
	public synchronized  Document connection(String url, String[] ip) {
		Document doc;
		try {
			logger.debug(url + "  " + ip[0]);
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

	private List<ProxyIP> analyze(Document result){
		List<ProxyIP> proxyIPs =new ArrayList<ProxyIP>();
		try {
			Elements tr = result.select("tr");
			Iterator<Element> iterator = tr.iterator();
			while(iterator.hasNext()){
				String textTr = iterator.next().text();
				String[] trs = textTr.split(" ");
				ProxyIP proxyIP =new ProxyIP();
				proxyIP.setAddress(textTr);
				proxyIP.setIp(trs[0]);
				proxyIP.setStatus("00000000");
				try {
					proxyIP.setPort(Integer.valueOf(trs[1]));
					proxyIPs.add(proxyIP);
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return proxyIPs;
	}
	
	@Transactional
	public List<ProxyIP> checkIP(List<ProxyIP> proxyIPs){
		List<ProxyIP> checkedProxyIps =new ArrayList<ProxyIP>();
		for (ProxyIP proxyIP : proxyIPs) {
			Document result = null;
			String[] ip = new String[] { proxyIP.getIp(), String.valueOf(proxyIP.getPort()) };
			try {
				result = connection(checkUrl, ip);
			} catch (Exception e) {

			}

			if (result == null) {
				logger.debug("  " + "ip " + ip[0] + " is not aviable");
			} else {
				logger.debug(result.text());
				logger.debug("  " + ip[0] + ":" + ip[1] + " is ok");
				checkedProxyIps.add(proxyIP);
				
				List<ProxyIP> ips = proxyIPDao.findByIp(proxyIP.getIp());
				if(ips.isEmpty()){
					proxyIPDao.saveAndFlush(proxyIP);
				}
			}
			
			sleep(5000);
		}
		
		return checkedProxyIps;
	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
//	public static void main(String[] args) {
//		ProxyIPService p = new ProxyIPService();
//			Document result = null;
//			String[] ip = new String[] { "117.93.91.236", "8118" };
//			try {
//				result = p.connection("http://www.xicidaili.com/nn", ip);
//			} catch (Exception e) {
//
//			}
//
//			if (result == null) {
//				System.out.println(new Date() + "  " + "ip " + ip[0] + " is not aviable");// 异常IP
//			} else {
//				System.out.println(result.text());
//				System.out.println(new Date() + "  " + ip[0] + ":" + ip[1] + " is ok");
//			}
//			
//			p.analyze(result);
//	}

	@Autowired
	private ProxyIPDao proxyIPDao;

}
