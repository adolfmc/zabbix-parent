package com.zabbix.sisyphus.base.common;

public class Constants {

	public static final String operation = "yizhenmoney";

	public static final String CUSTOMER_ATTACHMETN_DIR = "upload/attachment";// 用户上传附件目录

	public static final String CountryCode = "000000";// 中国

	public static final String AddrSplit = "--addr--";// 中国

	public static final String TelSplit = "--tel--";// 中国

	public static final String CREDITLEVEL = "D";// 默认信用等级

	public static final Long CREDITNUMBER = 1000L;// 默认信用积分

	public static final Long CREDITNUM = 0L;// 默认借款次数

	public static final String CREDITMONEY = "5000";// 默认信用额度

	public static final String DEFAULTPASSWORD = "123456";// 默认用户密码

	public static final String SendPort = "123456";// 短信默认端口

	public static final long VC_OVERTIME = 30;// 验证码超时分钟

	public static final long VC_CLEANTIME = 60;// 验证码清除分钟

	public static final String DEFAULT_ROLENAMES = "初审人员, 终审人员";// 审核人默认角色名称
	public static final String DEFAULT_ROLENAMEF = "初审人员";// 审核人默认角色名称
	public static final String DEFAULT_ROLENAMEE = "终审人员";// 审核人默认角色名称

	public static final long DEFAULT_CUSTOMER_ID = 2000L;// 默认垫资人id

	public static final String PRODUCT_CODE = "C00010001";// 产品代码

	public static final String ADMIN_EMAIL = "hezc@yizhenmoney.com";// 产品代码

	public static final int MONEY_ACCURACY = 8;// 数据库保存数据的精度

	// 认证状态
	public static final int AUTH_BEING = 0;
	public static final int AUTH_SUCCESS = 1;
	public static final int AUTH_FAIL = 9;
	
	/**************************** 字典数据类型 *****************************************/
	/**
	 * 还款方式
	 */
	public static final String D0001 = "0001";
	public static final String D00010001 = "00010001";// 一次性还本付息
	public static final String D00010002 = "00010002";// 按月等额本息
	public static final String D00010003 = "00010003";// 按月付息,到期还本

	/**
	 * 渠道
	 */
	public static final String D0002 = "0002";
	public static final String D00020001 = "00020001";// 移动端
	public static final String D00020002 = "00020002";// 线上
	public static final String D00020003 = "00020003";// 线下
	public static final String D00020004 = "00020004";// 外部

	/**
	 * 抵扣类别
	 */
	public static final String D0003 = "0003";
	/**
	 * 创建方式
	 */
	public static final String D0004 = "0004";
	public static final String D00040001 = "00040001"; // 系统创建
	public static final String D00040002 = "00040002"; // 手工创建
	public static final String D00040003 = "00040003"; // 移动端回执
	public static final String D00040004 = "00040004"; //实时划扣

	/**
	 * 信用级别
	 */
	public static final String D0005 = "0005";
	/**
	 * 客户等级
	 */
	public static final String D0006 = "0006";
	/**
	 * 证件类型
	 */
	public static final String D0007 = "0007";

	/**
	 * 身份证
	 */
	public static final String D00070001 = "00070001";

	/**
	 * 学历
	 */
	public static final String D0008 = "0008";
	/**
	 * 职业
	 */
	public static final String D0009 = "0009";
	public static final String D00090001 = "00090001";// 私营业主
	public static final String D00090002 = "00090002";// 公司职员
	public static final String D00090003 = "00090003";// 公务员
	public static final String D00090004 = "00090004";// 离/退休人员
	public static final String D00090005 = "00090005";// 自由职业者
	public static final String D00090006 = "00090006";// 学生
	public static final String D00090007 = "00090007";// 工薪组
	public static final String D00090008 = "00090008";// 其他

	/**
	 * 关系
	 */
	public static final String D0010 = "0010";
	/**
	 * 婚姻状况
	 */
	public static final String D0011 = "0011";
	/**
	 * 公司规模
	 */
	public static final String D0012 = "0012";
	/**
	 * 职务
	 */
	public static final String D0013 = "0013";
	/**
	 * 性别
	 */
	public static final String D0014 = "0014";
	public static final String D00140001 = "00140001"; // 男
	public static final String D00140002 = "00140002"; // 女
	public static final String D00140003 = "00140003"; // 保密

	/**
	 * 客户附件类型
	 */
	public static final String D0015 = "0015";
	public static final String D00150001 = "00150001";// 身份证信息正面
	public static final String D00150002 = "00150002";// 身份证信息反面
	public static final String D00150003 = "00150003";// 手持身份证信息
	public static final String D00150004 = "00150004";// 信用报告
	public static final String D00150005 = "00150005";// 工作证明
	public static final String D00150006 = "00150006";// 收入证明
	public static final String D00150007 = "00150007";// 房产资料
	public static final String D00150008 = "00150008";// 车辆资料
	public static final String D00150009 = "00150009";// 手机详单
	public static final String D00150010 = "00150010";// 网购截屏
	public static final String D00150011 = "00150011";// 学历证明
	public static final String D00150012 = "00150012";// 婚姻情况证明
	public static final String D00150013 = "00150013";// 其他资料

	/**
	 * 贷款产品
	 */
	public static final String D0016 = "0016";
	/**
	 * 借贷类别
	 */
	public static final String D0017 = "0017";
	public static final String D00170001 = "00170001";// 信贷
	public static final String D00170002 = "00170002";// 理财

	/**
	 * 资金用途
	 */
	public static final String D0018 = "0018";
	public static final String D00180001 = "00180001";// 个人消费
	public static final String D00180002 = "00180002";// 资金周转

	/**
	 * 二元选择
	 */
	public static final String D0019 = "0019";

	/**
	 * 是
	 */
	public static final String D00190001 = "00190001";
	/**
	 * 否
	 */
	public static final String D00190002 = "00190002";

	/**
	 * 住房情况
	 */
	public static final String D0020 = "0020";
	public static final String D00200001 = "00200001"; // 商住
	public static final String D00200002 = "00200002"; // 与父母共住
	public static final String D00200003 = "00200003"; // 集体宿舍
	public static final String D00200004 = "00200004"; // 自置有按揭
	public static final String D00200005 = "00200005"; // 租用
	public static final String D00200006 = "00200006"; // 自置无按揭

	/**
	 * 数据状态
	 */
	public static final String D0021 = "0021";
	public static final String D00210001 = "00210001";// 有效
	public static final String D00210009 = "00210009";// 无效

	/**
	 * 短信类型
	 */
	public static final String D0022 = "0022";
	public static final String D00220001 = "00220001"; // 注册验证码
	public static final String D00220002 = "00220002"; // 注册成功提示
	public static final String D00220003 = "00220003"; // 借款未通过通知
	public static final String D00220004 = "00220004"; // 放款通知
	public static final String D00220005 = "00220005"; // 上传图片不合格通知
	public static final String D00220006 = "00220006"; // 还款提醒通知
	public static final String D00220007 = "00220007"; // 催收通知
	public static final String D00220008 = "00220008"; // 还款流水确认
	public static final String D00220009 = "00220009"; // 还款流水拒绝通知

	public static final String D00220010 = "00220010"; // 居间人投资账户告警
	public static final String D00220011 = "00220011"; // 手续费投资账户告警
	public static final String D00220012 = "00220012"; // 公司优惠金账户告警

	public static final String D00220013 = "00220013"; // 本期账单(还清)
	public static final String D00220014 = "00220014"; // 本期账单(未还清)
	public static final String D00220015 = "00220015"; // 骗子
	public static final String D00220016 = "00220016"; // 挂账金额还款
	public static final String D00220017 = "00220017"; // 自动划扣
	public static final String D00220018 = "00220018"; // 还款提醒（当天）
	/**
	 * 通讯状态
	 */
	public static final String D0023 = "0023";
	public static final String D00230001 = "00230001"; // 未发送
	public static final String D00230002 = "00230002"; // 通讯异常
	public static final String D00230003 = "00230003"; // 已发送
	public static final String D00230004 = "00230004"; // 已接收
	public static final String D00230005 = "00230005"; // 系统内部异常

	/**
	 * 货币
	 */
	public static final String D0024 = "0024";
	public static final String D00240001 = "00240001";// 人民币
	/**
	 * 支付类型
	 */
	public static final String D0025 = "0025";
	/**
	 * 登录类型
	 */
	public static final String D0026 = "0026";
	public static final String D00260001 = "00260001"; // 员工
	public static final String D00260002 = "00260002"; // 客户

	/**
	 * 催收等级
	 */
	public static final String D0027 = "0027";
	/**
	 * 结息周期
	 */
	public static final String D0028 = "0028";
	public static final String D00280001 = "00280001";// 按天结算
	public static final String D00280002 = "00280002";// 按月结算
	/**
	 * 利率类型
	 */
	public static final String D0029 = "0029";
	public static final String D00290001 = "00290001";// 分期还款利率
	public static final String D00290002 = "00290002";// 一次性还款利率
	/**
	 * 所属系统
	 */
	public static final String D0030 = "0030";
	public static final String D00300001 = "00300001";// 信贷
	public static final String D00300002 = "00300002";// 理财

	/**
	 * 业务类别
	 */
	public static final String D0031 = "0031";
	public static final String D00310001 = "00300001";// 信贷
	public static final String D00310002 = "00300002";// 理财
	/**
	 * 支付方式
	 */
	public static final String D0032 = "0032";
	/**
	 * 划扣
	 */
	public static final String D00320001 = "00320001";// 易联支付
	/**
	 * 银行转账
	 */
	public static final String D00320002 = "00320002";
	/**
	 * 支付宝
	 */
	public static final String D00320003 = "00320003";// 支付宝
	/**
	 * 财付通
	 */
	public static final String D00320004 = "00320004";// 财付通
	/**
	 * 易联支付
	 */
//	public static final String D00320005 = "00320001";// 易联支付

	/**
	 * 凭证种类
	 */
	public static final String D0033 = "0033";
	public static final String D00330001 = "00330001";// 原始凭证
	public static final String D00330002 = "00330002";// 收款凭证
	public static final String D00330003 = "00330003";// 付款凭证
	public static final String D00330004 = "00330004";// 转账凭证
	public static final String D00330005 = "00330005";// 记账凭证

	/**
	 * 交易类别
	 */
	public static final String D0034 = "0034";
	public static final String D00340001 = "00340001";// 现货交易
	public static final String D00340002 = "00340002";// 合同交易

	/**
	 * 交易处理类别
	 */
	public static final String D0035 = "0035";
	public static final String D00350001 = "00350001";// 即时交易
	public static final String D00350002 = "00350002";// 延时交易
	/**
	 * 执行状态
	 */
	public static final String D0036 = "0036";
	public static final String D00360001 = "00360001";// 未执行
	public static final String D00360002 = "00360002";// 已执行

	/**
	 * 帐户状态
	 */
	public static final String D0037 = "0037";
	public static final String D00370001 = "00370001";// 开户
	public static final String D00370002 = "00370002";// 正常
	public static final String D00370003 = "00370003";// 逾期
	public static final String D00370004 = "00370004";// 呆滞
	public static final String D00370005 = "00370005";// 呆账
	public static final String D00370006 = "00370006";// 核销
	public static final String D00370007 = "00370007";// 部分逾期
	public static final String D00370008 = "00370008";// 销户
	/**
	 * 还款标示
	 */
	public static final String D0038 = "0038";
	/**
	 * 账单状态
	 */
	public static final String D0039 = "0039";
	/**
	 * 操作来源
	 */
	public static final String D0040 = "0040";
	public static final String D00400001 = "0040001";// 用户
	public static final String D00400002 = "0040002";// 后台人员
	/**
	 * 核查类别
	 */
	public static final String D0041 = "0041";
	/**
	 * 核查状态
	 */
	public static final String D0042 = "0042";
	/**
	 * 卡用途
	 */
	public static final String D0043 = "0043";

	public static final String D00430001 = "00430001";// 取款
	public static final String D00430002 = "00430002";// 还款
	public static final String D00430003 = "00430003";// 无效

	/**
	 * 入住年数
	 */
	public static final String D0044 = "0044";
	/**
	 * 单位性质
	 */
	public static final String D0045 = "0045";
	/**
	 * 行业类别
	 */
	public static final String D0046 = "0046";
	/**
	 * 工作年限
	 */
	public static final String D0047 = "0047";

	/**
	 * 风控附件
	 */
	public static final String D0048 = "0048";
	public static final String D00480012 = "00480012"; // 其他
	/**
	 * 电话核查
	 */
	public static final String D0049 = "0049";

	/**
	 * 是否生效
	 */
	public static final String D0050 = "0050";
	/**
	 * 账单已出
	 */
	public static final String D00500001 = "00500001";
	/**
	 * 账单未出
	 */
	public static final String D00500002 = "00500002";
	/**
	 * 优惠劵状态
	 */
	public static final String D0051 = "0051";
	/**
	 * 未使用
	 */
	public static final String D00510001 = "00510001";
	/**
	 * 已使用
	 */
	public static final String D00510002 = "00510002";
	/**
	 * 冻结中
	 */
	public static final String D00510003 = "00510003";
	/**
	 * 抵用类型
	 */
	public static final String D0052 = "0052";
	/**
	 * 现金
	 */
	public static final String D00520001 = "00520001";
	/**
	 * 管理费
	 */
	public static final String D00520002 = "00520002";
	/**
	 * 银行卡卡种
	 */
	public static final String D0053 = "0053";
	/**
	 * 借记卡
	 */
	public static final String D00530001 = "00530001";
	/**
	 * 贷记卡
	 */
	public static final String D00530002 = "00530002";
	/**
	 * 预付费卡
	 */
	public static final String D00530003 = "00530003";
	/**
	 * 准贷记卡
	 */
	public static final String D00530004 = "00530004";

	/**
	 * 优惠规则
	 */
	public static final String D0054 = "0054";
	/**
	 * 注册优惠
	 */
	public static final String D00540001 = "00540001";
	/**
	 * 分享到新浪微博优惠
	 */
	public static final String D00540002 = "00540002";
	/**
	 * 分享到QQ空间优惠
	 */
	public static final String D00540003 = "00540003";
	/**
	 * 分享到微信优惠
	 */
	public static final String D00540004 = "00540004";

	/**
	 * 菜单类型
	 */
	public static final String D0056 = "0056";
	/**
	 * 页面
	 */
	public static final String D00560001 = "00560001";
	/**
	 * 按钮
	 */
	public static final String D00560002 = "00560002";
	/**
	 * 菜单
	 */
	public static final String D00560003 = "00560003";
	/**
	 * 栏目
	 */
	public static final String D00560004 = "00560004";

	public static final String D0057 = "0057"; // 登陆平台
	public static final String D00570001 = "00570001";// Android平台
	public static final String D00570002 = "00570002";// IOS平台
	public static final String D00570003 = "00570003";// WEB平台
	public static final String D00570004 = "00570004";// 管理平台

	public static final String D00570101 = "00570101";// Android注册
	public static final String D00570102 = "00570102";// ios注册

	public static final String D0058 = "0058"; // 日子类型
	public static final String D00580001 = "00580001";// 操作日志
	public static final String D00580002 = "00580002";// 系统日志

	public static final String D0059 = "0059"; // 意见类型
	public static final String D00590001 = "00590001";// 信贷
	public static final String D00590002 = "00590002";// 理财

	/**
	 * 消息推送状态
	 */
	public static final String D0061 = "0061";
	public static final String D00610001 = "00610001";// 未推送
	public static final String D00610009 = "00610009";// 已推送

	/**
	 * 第三方返回状态
	 */
	public static final String D0062 = "0062";
	/**
	 * 成功
	 */
	public static final String D00620000 = "00620000";
	/**
	 * 失败
	 */
	public static final String D00621111 = "00621111";
	/**
	 * 处理中
	 */
	public static final String D00629999 = "00629999";

	/**
	 * 请求响应
	 */
	public static final String D0063 = "0063";
	/**
	 * 请求
	 */
	public static final String D00630001 = "00630001";
	/**
	 * 响应
	 */
	public static final String D00630002 = "00630002";
	
	
	/**************************** 流程定义 *****************************************/
	/**************************** 流程定义 *****************************************/
	/**************************** 流程定义 *****************************************/
	
	public static final String F0100 = "0100";// 信贷客户
	/**
	 * 开户
	 */
	public static final String F01000000 = "01000000";
	/**
	 * 正常
	 */
	public static final String F01000001 = "01000001";
	/**
	 * 逾期
	 */
	public static final String F01000002 = "01000002";
	/**
	 * 呆滞
	 */
	public static final String F01000003 = "01000003";
	/**
	 * 呆账
	 */
	public static final String F01000004 = "01000004";
	/**
	 * 核销
	 */
	public static final String F01000005 = "01000005";
	/**
	 * 部分预期
	 */
	public static final String F01000006 = "01000006";
	/**
	 * 销户
	 */
	public static final String F01000007 = "01000007";

	public static final String F0200 = "0200";// 借款信息（总信息）
	/**
	 * 申请
	 */
	public static final String F02000000 = "02000000";
	/**
	 * 审核中
	 */
	public static final String F02000001 = "02000001";
	/**
	 * 放款中
	 */
	public static final String F02000002 = "02000002";
	/**
	 * 还款中
	 */
	public static final String F02000003 = "02000003";
	/**
	 * 催收中
	 */
	public static final String F02000004 = "02000004";
	/**
	 * 借款结束
	 */
	public static final String F02000009 = "02000009";
	/**
	 * 逾期
	 */
	public static final String F02000010 = "02000010";
	/**
	 * 撤销
	 */
	public static final String F02000012 = "02000012";
	/**
	 * 呆滞
	 */
	public static final String F02000013 = "02000013";
	/**
	 * 呆账
	 */
	public static final String F02000014 = "02000014";

	public static final String F0300 = "0300";// 审批单
	/**
	 * 初审待分配
	 */
	public static final String F03000001 = "03000001";
	/**
	 * 待初审
	 */
	public static final String F03000011 = "03000011";
	/**
	 * 初审
	 */
	public static final String F03000002 = "03000002";
	/**
	 * 初审通过
	 */
	public static final String F03000003 = "03000003";
	/**
	 * 补件
	 */
	public static final String F03000004 = "03000004";
	/**
	 * 初审驳回
	 */
	public static final String F03000005 = "03000005";
	/**
	 * 终审待分配
	 */
	public static final String F03000006 = "03000006";
	/**
	 * 终审
	 */
	public static final String F03000007 = "03000007";
	/**
	 * 终审通过
	 */
	public static final String F03000008 = "03000008";
	/**
	 * 终审驳回
	 */
	public static final String F03000009 = "03000009";
	/**
	 * 退回初审
	 */
	public static final String F03000010 = "03000010";

	public static final String F0400 = "0400";// 放款单
	/**
	 * 放款审核
	 */
	public static final String F04000001 = "04000001";
	/**
	 * 放款通过
	 */
	public static final String F04000002 = "04000002";
	/**
	 * 放款拒绝
	 */
	public static final String F04000003 = "04000003";

	public static final String F0500 = "0500";// 账单
	/**
	 * 正常
	 */
	public static final String F05000001 = "05000001";
	/**
	 * 逾期
	 */
	public static final String F05000002 = "05000002";
	/**
	 * 呆滞
	 */
	public static final String F05000003 = "05000003";

	public static final String F0600 = "0600";// 催收单
	/**
	 * 催收待分配
	 */
	public static final String F06000001 = "06000001";
	/**
	 * 部门催收中
	 */
	public static final String F06000002 = "06000002";
	/**
	 * 催收作业中
	 */
	public static final String F06000003 = "06000003";
	/**
	 * 全部收回
	 */
	public static final String F06000004 = "06000004";
	/**
	 * 部分收回
	 */
	public static final String F06000005 = "06000005";

	public static final String F0700 = "0700";// 补件
	/**
	 * 补件中
	 */
	public static final String F07000001 = "07000001";
	/**
	 * 已上传
	 */
	public static final String F07000002 = "07000002";
	/**
	 * 补件完成
	 */
	public static final String F07000003 = "07000003";
	/**
	 * 还款状态
	 */
	public static final String F0800 = "0800";
	/**
	 * 待还款
	 */
	public static final String F08000001 = "08000001";
	/**
	 * 已结清
	 */
	public static final String F08000002 = "08000002";
	/**
	 * 罚息结清
	 */
	public static final String F08000003 = "08000003";
	/**
	 * 利息结清
	 */
	public static final String F08000004 = "08000004";
	/**
	 * 部分本金
	 */
	public static final String F08000005 = "08000005";
	/**
	 * 部分利息
	 */
	public static final String F08000006 = "08000006";
	/**
	 * 部分罚息
	 */
	public static final String F08000007 = "08000007";

	/**
	 * 凭证无效
	 */
	public static final String F08000008 = "08000008";
	/**
	 * 凭证通过
	 */
	public static final String F08000009 = "08000009";
	/**
	 * 凭证待确认
	 */
	public static final String F08000010 = "08000010";

	/**
	 * 优惠劵
	 */
	public static final String F0900 = "0900";
	/**
	 * 已使用
	 */
	public static final String F09000001 = "09000001";
	/**
	 * 正常
	 */
	public static final String F09000002 = "09000002";
	/**
	 * 过期
	 */
	public static final String F09000003 = "09000003";

	/**
	 * 审核分配状态列表 初审待分配、终审待分配 、初审、终审
	 */
	public static final String[] AssignFlow = new String[] { F03000001,
			F03000002, F03000006, F03000007, F03000011 };

	/**
	 * 审核状态列表 初审、终审
	 */
	public static final String[] CreditVerifyFlow = new String[] { F03000002,
			F03000007, F03000011 };

	/**
	 * 账单状态列表 还款中、催收中、逾期、呆滞
	 */
	public static final String[] StatementFlow = new String[] { F02000003,
			F02000004, F02000010, F02000013 };

}
