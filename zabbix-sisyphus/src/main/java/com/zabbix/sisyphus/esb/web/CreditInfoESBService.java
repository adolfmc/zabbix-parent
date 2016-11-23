package com.zabbix.sisyphus.esb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zabbix.sisyphus.esb.vo.ResultV;

/***
 * 信贷模块
 */
@Controller
@RequestMapping("esb/credit")
public class CreditInfoESBService {
	/** L001_借款状态 */
	public ResultV loanStatus(String customerId, String check, String creditId) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L002_借款申请 */
	public ResultV applyLoan(String customerId, String check, String amount, String deadline) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L003_账单信息 */
	public ResultV statement(String customerId, String check, String creditId) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L004_借款历史 */
	public ResultV loanHistory(String customerId, String check) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L005_借款明细 */
	public ResultV loanInfo(String customerId, String check, String creditId) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L006_优惠劵 */
	public ResultV couponInfo(String customerId, String check, String couponType) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L007_活动中心 */
	public ResultV activityInfo(String customerId, String check, String activityType) {
		ResultV result = ResultV.getInstance();
		return result;
	}

	/** L008_还款接口 */
	public ResultV repayment(String customerId, String check, String statementDetailId, String amount) {
		ResultV result = ResultV.getInstance();
		return result;
	}
}
