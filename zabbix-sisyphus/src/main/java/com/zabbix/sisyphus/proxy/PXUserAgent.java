package com.zabbix.sisyphus.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PXUserAgent {

	public static List<String> list = new ArrayList<String>();

	static {
		list.add("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 ");
		list.add("Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50");
		list.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;");
		list.add("Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)");
		list.add("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
		list.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
		list.add("Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
		list.add("Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11");
		list.add("Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11");
		list.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 ");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; The World)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Avant Browser)");
		list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
		list.add("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
		list.add("Mozilla/5.0 (iPod; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
		list.add("Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
		list.add("Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
		list.add("MQQBrowser/26 Mozilla/5.0 (Linux; U; Android 2.3.7; zh-cn; MB200 Build/GRJ22; CyanogenMod-7) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
		list.add("Opera/9.80 (Android 2.3.4; Linux; Opera Mobi/build-1107180945; U; en-GB) Presto/2.8.149 Version/11.10");
		list.add("Mozilla/5.0 (Linux; U; Android 3.0; en-us; Xoom Build/HRI39) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13");
		list.add("Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; en) AppleWebKit/534.1+ (KHTML, like Gecko) Version/6.0.0.337 Mobile Safari/534.1+");
		list.add("Mozilla/5.0 (hp-tablet; Linux; hpwOS/3.0.0; U; en-US) AppleWebKit/534.6 (KHTML, like Gecko) wOSBrowser/233.70 Safari/534.6 TouchPad/1.0");
		list.add("UserMozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; HTC; Titan)");
		list.add("UCWEB7.0.2.37/28/999");
		list.add("NOKIA5700/ UCWEB7.0.2.37/28/999");
		list.add("Openwave/ UCWEB7.0.2.37/28/999");
		list.add("Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/999");
	}

	public static String getUserAgent() {
		return (list.get(getRandom(0, 31)));
	}

	public static int getRandom(int min, int max) {
		Random random = new Random();
		return (random.nextInt(max) % (max - min + 1) + min);
	}
	
	public static void main(String[] args) {
		System.out.println(getUserAgent());
	}
	
}
