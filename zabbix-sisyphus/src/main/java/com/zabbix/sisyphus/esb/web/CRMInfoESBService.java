package com.zabbix.sisyphus.esb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zabbix.sisyphus.esb.vo.MockData;
import com.zabbix.sisyphus.esb.vo.ResultV;

@Controller
@RequestMapping("esb/crm/")
@ResponseBody
public class CRMInfoESBService {
	/** C001_用户注册 */
	@RequestMapping("register")
	public ResultV register(String mobile, String loginPwd, Integer times) {
		try {
			System.out.println(Thread.currentThread().getId()+"|"+Thread.currentThread().getName()+">>>>>");
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MockData.register(mobile, loginPwd, times);
	}

	/** C002_用户登陆 */
	@RequestMapping("login")
	public ResultV login(String mobile, String loginPwd, Integer times) {
		return MockData.login(mobile, loginPwd, times);
	}

	/** C003_个人信息 */
	@RequestMapping("customerInfo")
	public ResultV customerInfo(String customerId, String check, String address, String company, String job, String mIncome) {
		return MockData.customerInfo(customerId, check, address, company, job, mIncome);
	}

	/** C004_身份认证 */
	@RequestMapping("cardAuthent")
	public ResultV cardAuthent(String customerId, String check, CommonsMultipartFile[] cards) {
		return MockData.cardAuthent(customerId, check, cards);
	}

	/** C005_手机认证 */
	@RequestMapping("mobileAuthent")
	public ResultV mobileAuthent(String customerId, String check, String mobile, String servicePwd, String sms) {
		return MockData.mobileAuthent(customerId, check, mobile, servicePwd);
	}

	/** C006_银行卡认证 */
	@RequestMapping("bankCardAuthent")
	public ResultV bankCardAuthent(String customerId, String check, String name, String cardId, String bankNo, String bankName, String bankMobile) {
		return MockData.bankCardAuthent(customerId, check, name, cardId, bankNo, bankName, bankMobile);
	}

	/** C007_微信认证 */
	@RequestMapping("weChatAuthent")
	public ResultV weChatAuthent(String customerId, String check, String weChat, String weChatPwd, String sms) {
		return MockData.weChatAuthent(customerId, check, weChat, weChatPwd, sms);
	}

	/** C008_支付宝认证 */
	@RequestMapping("alipayAuthent")
	public ResultV alipayAuthent(String customerId, String check, String alipay, String alipayPwd, String sms) {
		return MockData.alipayAuthent(customerId, check, alipay, alipayPwd, sms);
	}

	/** C009_金东认证 */
	@RequestMapping("jdAuthent")
	public ResultV jdAuthent(String customerId, String check, String jd, String jdPwd, String sms) {
		return MockData.JDAuthent(customerId, check, jd, jdPwd, sms);
	}

	/** C010_学信认证 */
	@RequestMapping("universityAuthent")
	public ResultV universityAuthent(String customerId, String check, String university, String universityPwd, String sms) {
		return MockData.universityAuthent(customerId, check, university, universityPwd, sms);
	}

	/** C011_QQ认证 */
	@RequestMapping("qqAuthent")
	public ResultV qqAuthent(String customerId, String check, String qq, String qqPwd, String sms) {
		return MockData.QQAuthent(customerId, check, qq, qqPwd, sms);
	}

	/** C012_微博认证 */
	@RequestMapping("weiboAuthent")
	public ResultV weiboAuthent(String customerId, String check, String weibo, String weiboPwd, String sms) {
		return MockData.weiboAuthent(customerId, check, weibo, weiboPwd, sms);
	}

	/** C013_认证信息 */
	@RequestMapping("authentInfo")
	public ResultV authentInfo(String customerId, String check) {
		return MockData.authentInfo(customerId, check);
	}

	/** C014_我要吐槽 */
	@RequestMapping("suggest")
	public ResultV suggest(String customerId, String suggestInfo) {
		return MockData.suggest(customerId, suggestInfo);
	}

	/** C015_身份证信息 */
	@RequestMapping("cardInfo")
	public ResultV cardInfo(String customerId, String check) {
		return MockData.cardInfo(customerId, check);
	}

	/** C016_修改登陆密码 */
	@RequestMapping("updateLoginPwd")
	public ResultV updateLoginPwd(String customerId, String check, String loginPwd) {
		return MockData.updateLoginPwd(customerId, check, loginPwd);
	}

	/** C017_退出登陆 */
	@RequestMapping("logout")
	public ResultV logout(String customerId) {
		return MockData.logout(customerId);
	}
}
