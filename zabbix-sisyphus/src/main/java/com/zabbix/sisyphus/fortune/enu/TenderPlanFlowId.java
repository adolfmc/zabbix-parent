package com.zabbix.sisyphus.fortune.enu;

public enum TenderPlanFlowId {
	待审核("13000001"),
	审核通过("13000002"),
	审核拒绝("13000003"),
	未开始("13000004"),
	进行中("13000005"),
	满标("13000006"),
	流标("13000007");
	public String code;

	private TenderPlanFlowId(String code) {
		this.code = code;
	}

}