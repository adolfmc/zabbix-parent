package com.zabbix.sisyphus.risk.enu;

public enum AuditInfoFlowId {
	初审待分配("03000001"),
	初审("03000002"),
	初审通过("03000003"),
	补件("03000004"),
	初审驳回("03000005"),
	终审待分配("03000006"),
	终审("03000007"),
	终审通过("03000008"),
	终审驳回("03000009"),
	退回初审("03000010"),
	待初审("03000011"),
	黑名单待审("03000012"),
	黑名单拒绝("03000013"),
	已入队列("03000014");
	public String code;

	private AuditInfoFlowId(String code) {
		this.code = code;
	}

}