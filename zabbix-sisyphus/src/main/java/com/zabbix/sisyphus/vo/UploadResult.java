package com.zabbix.sisyphus.vo;



/**
 * 作者: zabbix 创建于 16/10/19.
 */
public class UploadResult {
    private Integer id=0;
    private  Integer error=0;
    private  String url;

    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
