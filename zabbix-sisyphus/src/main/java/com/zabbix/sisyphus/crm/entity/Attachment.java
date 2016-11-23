package com.zabbix.sisyphus.crm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zabbix.sisyphus.base.entity.IdEntity;

import java.io.Serializable;

/**
 * 作者: zabbix 创建于 16/10/18.
 */
@Entity
@Table(name = "crm_t_attachment")
public class Attachment extends IdEntity implements Serializable {
	private static final long serialVersionUID = 498289716084683133L;
	private Integer customerId;
    private String execSource;
    private Integer authenticate;
    private String type;
    private String filePath;
    private String auditStatus;
    private String status;
    private String subFilePath;
    private String status2;
    private String memo;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getExecSource() {
        return execSource;
    }

    public void setExecSource(String execSource) {
        this.execSource = execSource;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubFilePath() {
        return subFilePath;
    }

    public void setSubFilePath(String subFilePath) {
        this.subFilePath = subFilePath;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
