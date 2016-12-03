package com.zabbix.sisyphus.base.common;

import java.net.Proxy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class JsoupBase {
	public String url;
	public Document doc;
	public String[] ip;
	
	public static Document connection(String url, Document doc, String[] ip) {
		try {
			System.out.println(url + "  " + ip[0]);
			doc = Jsoup.connect(url).proxy(Proxy.Type.HTTP, ip[0], Integer.valueOf(ip[1]).intValue()).userAgent("Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)").cookie("sd65fjl", "token=sfs;;7vvv").timeout(12000).post();
		} catch (Exception e) {
			doc = null;
		}
		return doc;
	}
}
