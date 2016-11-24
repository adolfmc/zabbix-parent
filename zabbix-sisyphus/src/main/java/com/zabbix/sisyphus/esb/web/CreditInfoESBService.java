package com.zabbix.sisyphus.esb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zabbix.sisyphus.esb.vo.MockData;
import com.zabbix.sisyphus.esb.vo.ResultV;

/***
 * 信贷模块
 */
@Controller
@RequestMapping("esb/credit/")
@ResponseBody
public class CreditInfoESBService {

	/** L001_借款状态 */
	@RequestMapping("loanStatus")
	public ResultV loanStatus(String customerId, String check, String creditId) {
		return MockData.loanStatus(customerId, check, creditId);
	}

	/** L002_借款申请 */
	@RequestMapping("applyLoan")
	public ResultV applyLoan(String customerId, String check, String amount, String deadline, String used) {
		return MockData.applyLoan(customerId, check, amount, deadline, used);
	}

	/** L003_账单信息 */
	@RequestMapping("statement")
	public ResultV statement(String customerId, String check, String creditId) {
		return MockData.statement(customerId, check, creditId);
	}

	/** L004_借款历史 */
	@RequestMapping("loanHistory")
	public ResultV loanHistory(String customerId, String check) {
		return MockData.loanHistory(customerId, check);
	}

	/** L005_借款明细 */
	@RequestMapping("loanInfo")
	public ResultV loanInfo(String customerId, String check, String creditId) {
		return MockData.loanInfo(customerId, check, creditId);
	}

	/** L006_优惠劵 */
	@RequestMapping("couponInfo")
	public ResultV couponInfo(String customerId, String check, String couponType) {
		return MockData.couponInfo(customerId, check, couponType);
	}

	/** L007_活动中心 */
	@RequestMapping("activityInfo")
	public ResultV activityInfo(String customerId, String check, String activityType) {
		return MockData.activityInfo(customerId, check, activityType);
	}

	/** L008_还款接口 */
	@RequestMapping("repayment")
	public ResultV repayment(String customerId, String check, String statementDetailId, String amount) {
		return MockData.repayment(customerId, check, statementDetailId, amount);
	}
}
