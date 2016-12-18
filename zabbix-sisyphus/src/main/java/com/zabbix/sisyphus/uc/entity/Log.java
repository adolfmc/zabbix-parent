package com.zabbix.sisyphus.uc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zabbix.sisyphus.base.common.Constants;
import com.zabbix.sisyphus.base.entity.IdEntity;

/**
 * Log entity. @author Hezc
 */
@Entity
@Table(name = "SYS_T_LOG")
public class Log extends IdEntity {
	private static final long serialVersionUID = -4722720987775161168L;
	private Staff staffId;
	private Date logDate;
	private String ip;
	private String operatorId;
	private String operatorDesc;
	private String logType;
	
	
	@ManyToOne
	@JoinColumn(name = "STAFF_ID")
	public Staff getStaffId() {
		return staffId;
	}

	public void setStaffId(Staff staffId) {
		this.staffId = staffId;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
	@Column(length=1000)
	public String getOperatorDesc() {
		/*if(operatorDesc != null && operatorDesc.length() > 100){
			return operatorDesc.substring(0, 100)+"......";
		}*/
		return operatorDesc;
	}
	@Transient
	public String getOperatorDescCom(){
		return operatorDesc;
	}

	public void setOperatorDesc(String operatorDesc) {
		this.operatorDesc = operatorDesc;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}
	@Transient
	public String getLogTypeText(){
		if(Constants.D00580001.equals(logType)){
			return "操作日志";
		}
		if(Constants.D00580002.equals(logType)){
			return "系统日志";
		}
		return "";
	}

}