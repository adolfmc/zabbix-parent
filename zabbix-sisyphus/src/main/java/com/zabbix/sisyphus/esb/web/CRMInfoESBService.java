package com.zabbix.sisyphus.esb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.zabbix.sisyphus.esb.vo.AuthentInfo;
import com.zabbix.sisyphus.esb.vo.Bank;
import com.zabbix.sisyphus.esb.vo.CustomerInfo;
import com.zabbix.sisyphus.esb.vo.ResultV;

@Controller
@RequestMapping("esb/crm")
public class CRMInfoESBService {
	/** C001_用户注册 */
	public ResultV register(String mobile, String loginPwd, int times) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C002_用户登陆 */
	public ResultV login(String mobile, String loginPwd, int times) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C003_个人信息 */
	public ResultV customerInfo(String customerId, String check, String address, String company, String job, String mIncome) {
		ResultV result = ResultV.getInstance();
		CustomerInfo info = new CustomerInfo();
		result.setInfo(info);
		return result;
	}

	/** C004_身份认证 */
	public ResultV cardAuthent(String customerId, String check, CommonsMultipartFile[] cards) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C005_手机认证 */
	public ResultV mobileAuthent(String customerId, String check, String mobile, String servicePwd) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C006_银行卡认证 */
	public ResultV bankCardAuthent(String customerId, String check, String name, String cardId, String bankNo, String bankName, String bankMobile) {
		ResultV result = ResultV.getInstance();
		Bank info = new Bank();
		result.setInfo(info);
		return result;
	}

	/** C007_微信认证 */
	public ResultV weChatAuthent(String customerId, String check, String weChat, String weChatPwd, String sms) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C008_支付宝认证 */
	public ResultV alipayAuthent(String customerId, String check, String alipay, String alipayPwd, String sms) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C009_金东认证 */
	public ResultV JDAuthent(String customerId, String check, String jd, String jdPwd, String sms) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C010_学信认证 */
	public ResultV universityAuthent(String customerId, String check, String university, String universityPwd, String sms) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C011_QQ认证 */
	public ResultV QQAuthent(String customerId, String check, String qq, String qqPwd, String sms) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C012_微博认证 */
	public ResultV weiboAuthent(String customerId, String check, String weibo, String weiboPwd, String sms) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C013_认证信息 */
	public ResultV authentInfo(String customerId, String check) {
		ResultV result = ResultV.getInstance();
		AuthentInfo info = new AuthentInfo();
		result.setInfo(info);
		return result;
	}

	/** C014_我要吐槽 */
	public ResultV suggest(String customerId, String suggestInfo) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C015_认证信息 */
	public ResultV cardInfo(String customerId, String check) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C016_修改登陆密码 */
	public ResultV updateLoginPwd(String customerId, String check, String loginPwd) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** C017_退出登陆 */
	public ResultV logout(String customerId) {
		ResultV result = ResultV.getInstance();
		return result;
	}
}
