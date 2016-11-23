package com.zabbix.sisyphus.credit.enu;

public enum CreditFlowId {
	申请("02000000"),
	审核中("02000001"),
	放款中("02000002"),
	还款中("02000003"),
	催收中("02000004"),
	借款结束("02000009"),
	逾期("02000010"),
	撤销("02000012"),
	呆滞("02000013"),
	呆账("02000014"),
	借款中("02000015");
	public String code;

	private CreditFlowId(String code) {
		this.code = code;
	}

}