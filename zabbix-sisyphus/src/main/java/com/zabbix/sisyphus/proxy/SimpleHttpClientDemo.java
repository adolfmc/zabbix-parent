package com.zabbix.sisyphus.proxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 简单httpclient实例
 * 
 * @author arron
 * @date 2015年11月11日 下午6:36:49
 * @version 1.0
 */
public class SimpleHttpClientDemo {

	/**
	 * 模拟请求
	 * 
	 * @param url
	 *            资源地址
	 * @param map
	 *            参数列表
	 * @param encoding
	 *            编码
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String send(String url, Map<String, String> map, String encoding) throws ParseException, IOException {
		String body = "";

		// 创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建post方式请求对象
		HttpGet httpPost = new HttpGet(url);

		// 装填参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		// 设置参数到请求对象中
		//httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

		System.out.println("请求地址：" + url);
		System.out.println("请求参数：" + nvps.toString());

		// 设置header信息
		// 指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpPost.setHeader("Accept-Encoding","gzip, deflate, sdch");
		httpPost.setHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
		httpPost.setHeader("Cache-Control","max-age=0");
		httpPost.setHeader("Upgrade-Insecure-Requests","1");
		httpPost.setHeader("Host","www.xicidaili.com");
		httpPost.setHeader("Connection","keep-alive");
		httpPost.setHeader("Referer","http://www.xicidaili.com/");
		httpPost.setHeader("User-Agent",PXUserAgent.getUserAgent());
		httpPost.setHeader("Cookie","_free_proxy_session=BAh7B0kiD3Nlc3Npb25faWQGOgZFVEkiJWYwNzc3NTMzYmE0MGM2NGJmZjI4M2M0MGVkOGQyZWE1BjsAVEkiEF9jc3JmX3Rva2VuBjsARkkiMXRCT1k4akhncFdIOWV1YlRiTHZBbG8xUEE4NjExWDRuNHltQ3A1Q2xucDg9BjsARg%3D%3D--78b7cae27be1c2d5ec650cbe6eaa02b29012cc2d; CNZZDATA1256960793=1771440537-1480581802-http%253A%252F%252Fwww.cnblogs.com%252F%7C1480686120");
		
		// 执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		// 获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			// 按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, encoding);
		}
		
		System.out.println("========================================="+response.getStatusLine().getStatusCode());
		
		EntityUtils.consume(entity);
		// 释放链接
		response.close();
		return body;
	}

	public static void main2(String[] args) throws ParseException, IOException {
		String url = "http://php.weather.sina.com.cn/iframe/index/w_cl.php";
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "js");
		map.put("day", "0");
		map.put("city", "上海");
		map.put("dfc", "1");
		map.put("charset", "utf-8");
		String body = send(url, map, "utf-8");
		System.out.println("交易响应结果：");
		System.out.println(body);

		System.out.println("-----------------------------------");

		map.put("city", "北京");
		body = send(url, map, "utf-8");
		System.out.println("交易响应结果：");
		System.out.println(body);
	}
	
	public static void main(String[] args) throws ParseException, IOException {
		String url = "http://www.xicidaili.com/nn";
		Map<String, String> map = new HashMap<String, String>();
		map.put("charset", "utf-8");
		String body = send(url, map, "utf-8");
		System.out.println("交易响应结果：");
		System.out.println(body);

		System.out.println("-----------------------------------");

		map.put("city", "北京");
		body = send(url, map, "utf-8");
		System.out.println("交易响应结果：");
		System.out.println(body);
	}
}