package com.zabbix.sisyphus.esb.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MockData {

	public static ResultV register(String mobile, String loginPwd, Integer times) {
		ResultV result = new ResultV();
		User info = new User();
		info.setMobile(mobile);
		info.setLoginPwd(loginPwd);
		info.setLogIntegerimes(times);
		result.setInfo(info);
		return result;
	}

	public static ResultV login(String mobile, String loginPwd, Integer times) {
		ResultV result = new ResultV();
		User info = new User();
		info.setMobile(mobile);
		info.setLoginPwd(loginPwd);
		info.setLogIntegerimes(times);
		result.setInfo(info);
		return result;
	}

	public static ResultV customerInfo(String customerId, String check, String address, String company, String job, String mIncome) {
		ResultV result = new ResultV();
		CustomerInfo info = new CustomerInfo();
		info.setAddress(address);
		info.setCompany(company);
		info.setCustomerId(customerId);
		info.setJob(job);
		info.setmIncome(mIncome);
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV cardAuthent(String customerId, String check, CommonsMultipartFile[] cards) {
		ResultV result = new ResultV();
		String[] cardsv = new String[] { "https://pan.baidu.com/s/1pL6huOz", "https://pan.baidu.com/s/1pL6huOz", "https://pan.baidu.com/s/1pL6huOz" };
		result.setInfo(cardsv);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV mobileAuthent(String customerId, String check, String mobile, String servicePwd) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("mobile", mobile);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV bankCardAuthent(String customerId, String check, String name, String cardId, String bankNo, String bankName, String bankMobile) {
		ResultV result = new ResultV();
		Bank info = new Bank();
		info.setBankMobile(bankMobile);
		info.setBankName(bankName);
		info.setBankNo(bankNo);
		info.setCardId(cardId);
		info.setName(bankName);
		result.setInfo(info);
		result.setCustomerId(customerId);

		return result;
	}

	public static ResultV weChatAuthent(String customerId, String check, String weChat, String weChatPwd, String sms) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("weChat", weChat);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV alipayAuthent(String customerId, String check, String alipay, String alipayPwd, String sms) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("alipay", alipay);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV JDAuthent(String customerId, String check, String jd, String jdPwd, String sms) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("jd", jd);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV universityAuthent(String customerId, String check, String university, String universityPwd, String sms) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("university", university);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV QQAuthent(String customerId, String check, String qq, String qqPwd, String sms) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("qq", qq);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV weiboAuthent(String customerId, String check, String weibo, String weiboPwd, String sms) {
		ResultV result = new ResultV();
		Map<String, String> info = new HashMap<String, String>();
		info.put("weibo", weibo);
		info.put("Authent", "SUCCESS");

		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV authentInfo(String customerId, String check) {
		ResultV result = new ResultV();
		AuthentInfo info = new AuthentInfo();
		info.setAlipayAuthent(true);
		info.setBankCardAuthent(true);
		info.setCustomerInfoAuthent(true);
		info.setQQAuthent(true);
		info.setWeiboAuthent(true);
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV suggest(String customerId, String suggestInfo) {
		ResultV result = new ResultV();
		result.setInfo(suggestInfo);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV cardInfo(String customerId, String check) {
		ResultV result = new ResultV();
		String[] cardsv = new String[] { "https://pan.baidu.com/s/1pL6huOz", "https://pan.baidu.com/s/1pL6huOz", "https://pan.baidu.com/s/1pL6huOz" };
		result.setInfo(cardsv);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV loanStatus(String customerId, String check, String creditId) {
		/*申请	02000000
		审核中	02000001
		放款中	02000002
		还款中	02000003
		催收中	02000004
		借款结束	02000009
		逾期	02000010
		撤销	02000012
		呆滞	02000013
		呆账	02000014*/
		ResultV result = new ResultV();
		CreditInfo info =new CreditInfo();
		info.setAmount("500.00");
		info.setApplyDate("2016-11-01");
		info.setDeadline(14);
		info.setFlowId("02000001");
		info.setMobile("15021008500");
		info.setName("胡汉三");
		info.setUsed("揭不开锅了,等米下锅。。");
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV applyLoan(String customerId, String check, String amount, String deadline,String used) {
		ResultV result = new ResultV();
		CreditInfo info =new CreditInfo();
		info.setAmount("500.00");
		info.setApplyDate("2016-11-01");
		info.setDeadline(14);
		info.setFlowId("02000000");
		info.setMobile("15021008500");
		info.setName("胡汉三");
		info.setUsed(used);
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV statement(String customerId, String check, String creditId) {
		ResultV result = new ResultV();
		Statement info=new Statement();
		info.setAmerce("10.00");
		info.setAmount("550.00");
		info.setApplyAmount("500.00");
		info.setApplyDate("2016-11-01");
		info.setDeadline(14);
		info.setFee("50.00");
		info.setReplaymentDate("2016-11-15");
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV loanHistory(String customerId, String check) {
		CreditInfo credit =new CreditInfo();
		credit.setAmount("500.00");
		credit.setApplyDate("2016-11-01");
		credit.setDeadline(14);
		credit.setFlowId("02000009");
		credit.setMobile("15021008500");
		credit.setName("胡汉三");
		credit.setUsed("揭不开锅了,等米下锅。。");
		
		
		ResultV result = new ResultV();
		List<CreditInfo> info = new ArrayList<CreditInfo>();
		info.add(credit);
		
		credit =new CreditInfo();
		credit.setAmount("500.00");
		credit.setApplyDate("2016-11-01");
		credit.setDeadline(14);
		credit.setFlowId("02000009");
		credit.setMobile("15000000000");
		credit.setName("巴菲特");
		credit.setUsed("资金周转。。");
		info.add(credit);
		
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV loanInfo(String customerId, String check, String creditId) {
		ResultV result = new ResultV();
		CreditInfo info =new CreditInfo();
		info.setAmount("500.00");
		info.setApplyDate("2016-11-01");
		info.setDeadline(14);
		info.setFlowId("02000000");
		info.setMobile("15021008500");
		info.setName("五月雪");
		info.setUsed("买手机...");
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV couponInfo(String customerId, String check, String couponType) {
		
		ResultV result = new ResultV();
		List<ActivityInfo> info =new ArrayList<ActivityInfo>();
		ActivityInfo activity =new ActivityInfo();
		activity.setName("借款优惠劵");
		activity.setEndDate("2016-12-31");
		activity.setType("0002");
		activity.setDesc("10元优惠劵");
		info.add(activity);
		
		activity =new ActivityInfo();
		activity.setName("借款优惠劵");
		activity.setEndDate("2016-12-31");
		activity.setType("0002");
		activity.setDesc("5元优惠劵");
		info.add(activity);
		
		
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV activityInfo(String customerId, String check, String activityType) {
		
		ResultV result = new ResultV();
		List<ActivityInfo> info =new ArrayList<ActivityInfo>();
		ActivityInfo activity =new ActivityInfo();
		activity.setName("提前还款送大礼");
		activity.setStartDate("2016-10-01");
		activity.setEndDate("2016-12-31");
		activity.setType("0001");
		activity.setDesc("提前还款可获得抵扣劵");
		info.add(activity);
		
		activity =new ActivityInfo();
		activity.setName("注册当天申请送优惠");
		activity.setStartDate("2016-10-01");
		activity.setEndDate("2016-12-31");
		activity.setType("0001");
		activity.setDesc("注册当天可获得10元抵扣劵");
		info.add(activity);
		
		
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV repayment(String customerId, String check, String statementDetailId, String amount) {
		ResultV result = new ResultV();
		Statement info=new Statement();
		info.setAmerce("10.00");
		info.setAmount("550.00");
		info.setApplyAmount("500.00");
		info.setApplyDate("2016-11-01");
		info.setDeadline(14);
		info.setFee("50.00");
		info.setReplaymentDate("2016-11-15");
		info.setReplayAmount(amount);
		
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV account(String customerId, String check) {
		ResultV result = new ResultV();
		GeneralLedger info=new GeneralLedger();
		info.setAvlBal("5.00");
		info.setFrzBal("0.00");
		info.setName("五月雪");
		info.setSysglNo("S00010000001");
		
		result.setInfo(info);
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV logout(String customerId) {
		ResultV result = new ResultV();
		result.setMessage("退出成功");
		result.setCustomerId(customerId);
		return result;
	}

	public static ResultV updateLoginPwd(String customerId, String check, String loginPwd) {
		ResultV result = new ResultV();
		result.setMessage("密码更新成功");
		result.setCustomerId(customerId);
		return result;
	}
}
