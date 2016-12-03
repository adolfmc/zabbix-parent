package com.zabbix.sisyphus.proxy;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CheckProxyIP {
	public static List<String[]> iplist = new ArrayList<String[]>();
	static {
		iplist.add(new String[] { "117.90.2.206", "9000" });
		iplist.add(new String[] { "114.103.107.246", "808" });
		iplist.add(new String[] { "27.18.202.87", "808" });
		iplist.add(new String[] { "117.90.6.71", "9000" });
		iplist.add(new String[] { "59.37.176.145", "9000" });
		iplist.add(new String[] { "182.89.6.240", "8123" });
		iplist.add(new String[] { "218.14.121.229	", "9000" });
		iplist.add(new String[] { "125.104.208.151	", "8998" });
		iplist.add(new String[] { "119.85.31.34	", "8998" });
		iplist.add(new String[] { "117.65.93.155	", "8998" });
//		iplist.add(new String[] { "171.97.31.40", "8888" });
//		iplist.add(new String[] { "144.52.65.84", "8998" });
//		iplist.add(new String[] { "106.81.160.230", "8998" });
//		iplist.add(new String[] { "27.19.116.160", "8998" });
//		iplist.add(new String[] { "177.136.85.122", "8080" });
//		iplist.add(new String[] { "171.211.93.187", "8998" });
//		iplist.add(new String[] { "124.248.190.215", "8080" });
//		iplist.add(new String[] { "110.191.141.88", "8998" });
//		iplist.add(new String[] { "61.130.212.163", "8998" });
//		iplist.add(new String[] { "116.52.86.2", "8998" });
//		iplist.add(new String[] { "144.52.79.91", "8998" });
//		iplist.add(new String[] { "171.211.46.154", "8998" });
//		iplist.add(new String[] { "106.81.210.24", "8998" });
//		iplist.add(new String[] { "101.66.251.216", "20739" });
//		iplist.add(new String[] { "42.88.31.132", "8998" });
//		iplist.add(new String[] { "183.164.142.79", "8998" });
//		iplist.add(new String[] { "180.241.44.176", "3128" });
//		iplist.add(new String[] { "180.136.242.247", "8998" });
//		iplist.add(new String[] { "116.237.99.238", "9999" });
//		iplist.add(new String[] { "220.137.40.6", "8080" });
//		iplist.add(new String[] { "218.91.165.15", "8998" });
//		iplist.add(new String[] { "181.60.253.71", "8080" });
//		iplist.add(new String[] { "183.164.149.132", "8998" });
//		iplist.add(new String[] { "171.97.93.22", "8888" });
//		iplist.add(new String[] { "200.167.191.227", "9090" });
//		iplist.add(new String[] { "183.141.105.41", "3128" });
//		iplist.add(new String[] { "27.18.116.231", "8998" });
//		iplist.add(new String[] { "182.40.56.61", "8998" });
//		iplist.add(new String[] { "115.211.220.225", "8998" });
//		iplist.add(new String[] { "125.109.117.225", "8998" });
//		iplist.add(new String[] { "142.147.117.1", "8080" });
//		iplist.add(new String[] { "221.199.203.106", "3128" });
//		iplist.add(new String[] { "89.40.115.244", "3128" });
//		iplist.add(new String[] { "118.113.222.135", "8998" });
//		iplist.add(new String[] { "171.125.113.173", "8998" });
//		iplist.add(new String[] { "118.113.220.235", "8998" });
//		iplist.add(new String[] { "106.81.169.244", "8998" });
//		iplist.add(new String[] { "59.58.206.230", "8998" });
//		iplist.add(new String[] { "222.45.80.203", "8998" });
//		iplist.add(new String[] { "27.10.14.14", "8998" });
//		iplist.add(new String[] { "171.97.206.253", "8888" });
//		iplist.add(new String[] { "180.97.224.115", "8998" });
//		iplist.add(new String[] { "219.156.1.70", "8118" });
//		iplist.add(new String[] { "61.130.94.32", "8998" });
//		iplist.add(new String[] { "180.136.88.194", "8998" });
//		iplist.add(new String[] { "222.82.128.174", "8998" });
//		iplist.add(new String[] { "27.18.143.7", "8998" });
//		iplist.add(new String[] { "121.224.113.139", "8998" });
//		iplist.add(new String[] { "117.45.177.186", "8998" });
//		iplist.add(new String[] { "14.108.177.159", "8998" });
//		iplist.add(new String[] { "183.161.57.52", "8998" });
//		iplist.add(new String[] { "182.244.182.61", "8998" });
//		iplist.add(new String[] { "125.109.64.218", "8998" });
//		iplist.add(new String[] { "106.81.182.150", "8998" });
//		iplist.add(new String[] { "171.211.9.215", "8998" });
//		iplist.add(new String[] { "177.8.216.106", "8080" });
//		iplist.add(new String[] { "180.136.86.207", "8998" });
//		iplist.add(new String[] { "112.244.73.90", "8118" });
//		iplist.add(new String[] { "180.136.149.215", "8998" });
//		iplist.add(new String[] { "27.211.11.129", "8118" });
//		iplist.add(new String[] { "27.22.59.102", "3128" });
//		iplist.add(new String[] { "14.110.124.47", "8998" });
//		iplist.add(new String[] { "60.0.126.222", "8118" });
//		iplist.add(new String[] { "106.81.42.52", "8998" });
//		iplist.add(new String[] { "106.81.114.187", "8998" });
//		iplist.add(new String[] { "117.35.242.246", "8998" });
//		iplist.add(new String[] { "27.18.183.57", "8998" });
//		iplist.add(new String[] { "114.97.217.118", "8998" });
//		iplist.add(new String[] { "118.113.220.90", "8998" });
//		iplist.add(new String[] { "43.243.142.130", "8080" });
//		iplist.add(new String[] { "60.185.201.108", "8998" });
//		iplist.add(new String[] { "163.53.187.98", "8080" });
//		iplist.add(new String[] { "111.79.2.245", "8998" });
//		iplist.add(new String[] { "124.206.254.216", "3128" });
//		iplist.add(new String[] { "171.211.69.244", "8998" });
//		iplist.add(new String[] { "61.228.46.244", "8080" });
//		iplist.add(new String[] { "60.169.78.218", "808" });
//		iplist.add(new String[] { "202.29.214.90", "8080" });
//		iplist.add(new String[] { "37.72.185.17", "1080" });
//		iplist.add(new String[] { "180.136.89.187", "8998" });
//		iplist.add(new String[] { "59.127.110.38", "3128" });
//		iplist.add(new String[] { "125.109.195.14", "8998" });
//		iplist.add(new String[] { "37.72.184.215", "1080" });
//		iplist.add(new String[] { "218.76.84.206", "3128" });
//		iplist.add(new String[] { "118.113.254.180", "8998" });
//		iplist.add(new String[] { "61.130.93.47", "8998" });
//		iplist.add(new String[] { "58.249.55.222", "9797" });
//		iplist.add(new String[] { "123.154.177.251", "8998" });
//		iplist.add(new String[] { "220.143.186.8", "3128" });
//		iplist.add(new String[] { "61.136.79.240", "9000" });
//		iplist.add(new String[] { "140.237.143.233", "8998" });
//		iplist.add(new String[] { "171.91.130.110", "8118" });
//		iplist.add(new String[] { "171.211.54.74", "8998" });
//		iplist.add(new String[] { "112.193.252.36", "8998" });
//		iplist.add(new String[] { "183.144.58.53", "8998" });
//		iplist.add(new String[] { "171.97.52.67", "8888" });
//		iplist.add(new String[] { "27.18.96.37", "8998" });
//		iplist.add(new String[] { "122.233.124.192", "8998" });
//		iplist.add(new String[] { "42.88.158.168", "8998" });
//		iplist.add(new String[] { "183.129.151.130", "80" });
	}

	/**
	 * <br>
	 * * 批量代理IP有效检测<br>
	 * *<br>
	 * * @param IP<br>
	 * * @param post<br>
	 */
	public synchronized static Document connection(String url, String[] ip) {
		Document doc;
		try {
			System.out.println(url + "  " + ip[0]);
			String cookieId = UUID.randomUUID().toString().replaceAll("-", "");
			String token = "token=" + UUID.randomUUID().toString().replaceAll("-", "") + System.nanoTime();
			doc = Jsoup.connect(url)
					.proxy(Proxy.Type.HTTP, ip[0], Integer.valueOf(ip[1]))
					.userAgent(PXUserAgent.getUserAgent())
					.header("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
					.header("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7")
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language", "zh-cn,zh;q=0.5")
					.header("Connection", "keep-alive")
					.header("refer", "http://www.baidu.com/s?tn=monline_5_dg&bs=httpclient4+MultiThreadedHttpConnectionManager")
					.cookie(cookieId, token)
					.timeout(15000)
					.get();

		} catch (Exception e) {
			e.printStackTrace();
			doc = null;
		}

		return doc;
	}

	public static void main(String[] args) {
		for (String[] ip : iplist) {
			Document result = null;
			try {
				result = connection("http://www.xicidaili.com/nn", ip);
			} catch (Exception e) {

			}

			if (result == null) {
				System.out.println(new Date() + "  " + "ip " + ip[0] + " is not aviable");// 异常IP
			} else {
				System.out.println(result.text());
				System.out.println(new Date() + "  " + ip[0] + ":" + ip[1] + " is ok");
			}
		}
	}
}
