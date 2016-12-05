package com.zabbix.sisyphus.job.collection.lagou;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zabbix.sisyphus.job.JsoupBase;
import com.zabbix.sisyphus.job.entity.JobInfo;
import com.zabbix.sisyphus.job.repository.JobInfoDao;
import com.zabbix.sisyphus.proxy.service.ProxyIPService;

/**
 * 无视Https证书是否正确的Java Http Client
 * 
 * 
 * @author huangxuebin
 * 
 * @create 2012.8.17
 * @version 1.0
 */

@Lazy(false)
@Async
@Component
public class LaGouCollection extends JsoupBase{

	/**
	 * 忽视证书HostName
	 */
	private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
		public boolean verify(String s, SSLSession sslsession) {
			System.out.println("WARNING: Hostname is not matched for cert.");
			return true;
		}
	};

	/**
	 * Ignore Certification
	 */
	private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {

		private X509Certificate[] certificates;

		@Override
		public void checkClientTrusted(X509Certificate certificates[], String authType) throws CertificateException {
			if (this.certificates == null) {
				this.certificates = certificates;
				System.out.println("init at checkClientTrusted");
			}

		}

		@Override
		public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
			if (this.certificates == null) {
				this.certificates = ax509certificate;
				System.out.println("init at checkServerTrusted");
			}

			// for (int c = 0; c < certificates.length; c++) {
			// X509Certificate cert = certificates[c];
			// System.out.println(" Server certificate " + (c + 1) + ":");
			// System.out.println("  Subject DN: " + cert.getSubjectDN());
			// System.out.println("  Signature Algorithm: "
			// + cert.getSigAlgName());
			// System.out.println("  Valid from: " + cert.getNotBefore());
			// System.out.println("  Valid until: " + cert.getNotAfter());
			// System.out.println("  Issuer: " + cert.getIssuerDN());
			// }

		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}

	};

	public  String getMethod(String urlString) throws Exception {

		ByteArrayOutputStream buffer = new ByteArrayOutputStream(512);
			 String[] ip = proxyIPService.getIP();
			// System.getProperties().put("proxySet","true");
			// System.getProperties().put("proxyHost",proxyIP.getIp());
			// System.getProperties().put("proxyPort",proxyIP.getPort());

			// 创建代理服务器
			InetSocketAddress addr = new InetSocketAddress(ip[0],Integer.valueOf(ip[1]));
			Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理

			URL url = new URL(urlString);

			/*
			 * use ignore host name verifier
			 */
			HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection(proxy);

			// Prepare SSL Context
			TrustManager[] tm = { ignoreCertificationTrustManger };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());

			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			connection.setSSLSocketFactory(ssf);
			InputStream reader = connection.getInputStream();
			byte[] bytes = new byte[512];
			int length = reader.read(bytes);

			do {
				buffer.write(bytes, 0, length);
				length = reader.read(bytes);
			} while (length > 0);

			// result.setResponseData(bytes);
			System.out.println(buffer.toString());
			reader.close();

			connection.disconnect();
		String repString = new String(buffer.toByteArray());
		return repString;
	}

	public static void main(String[] args) {
	}

	@Autowired
	private JobInfoDao jobInfoDao;
	@Autowired
	private ProxyIPService proxyIPService;
	
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void excute() {
		for (int i = 0; i <= 100; i++) {
			String urlString = "https://www.lagou.com/jobs/positionAjax.json?px=new&needAddtionalResult=false&first=false&pn=" + i;
			boolean is = true;
			while (is) {
				try {
					String content = new String(getMethod(urlString));
					analyze(content);
					sleep(20000L);
					is = false;
				} catch (Exception e) {
					is = true;
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@SuppressWarnings({ "rawtypes","unchecked", "unused"})
	@Transactional
	public  void analyze(String content){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			LaGouVO lagou = objectMapper.readValue(content, LaGouVO.class);
			java.util.LinkedHashMap conten = (LinkedHashMap) lagou.getContent();
			java.util.LinkedHashMap positionResult = (LinkedHashMap) conten.get("positionResult");
			List<java.util.LinkedHashMap> results = (List<java.util.LinkedHashMap>) positionResult.get("result");
			for (java.util.LinkedHashMap result : results) {
				JobInfo entity = new JobInfo();
				String positionId = result.get("positionId")+"";
				String companyId = result.get("companyId")+"";
				String positionName = result.get("positionName")+"";
				String workYear = result.get("workYear")+"";
				String education =result.get("education") +"";
				String city = result.get("city")+"";
				String salary = result.get("salary")+"";
				String industryField = result.get("industryField")+"";
				String createTime = result.get("createTime")+"";
				String district = result.get("district")+"";
				String companyFullName = result.get("companyFullName")+"";
				
				entity.setTitile(positionName);
				entity.setCompany(companyFullName);
				entity.setArea(city+","+district);
				entity.setEdu(education);
				entity.setSalary(salary);
				entity.setWorkYears(workYear);
				entity.setUrl("https://www.lagou.com/jobs/"+positionId+".html");
				entity.setIndustry(industryField);
				entity.setType("lagou");
				jobInfoDao.save(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<JobInfo> analyze(Document result) {
		// TODO Auto-generated method stub
		return null;
	}
}