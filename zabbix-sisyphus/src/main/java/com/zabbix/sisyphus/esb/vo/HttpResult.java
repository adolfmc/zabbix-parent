package com.zabbix.sisyphus.esb.vo;

/**
 * 作者:  zabbix on 2016/3/9.
 */
public class HttpResult {
    public static final String SUCCESS_MSG = "OK";
    public static final int SUCCESS_STATUS = 0;

    private Object data; // 接口数据
    private int status; // 接口返回状态 0-成功
    private String msg; // 错误信息，状态为0是返回空串
    private  Long serverTime = System.currentTimeMillis();

    public static String getSuccessMsg() {
        return SUCCESS_MSG;
    }

    public static int getSuccessStatus() {
        return SUCCESS_STATUS;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public static HttpResult success() {
        return HttpResult.success(null);
    }

    public static HttpResult success(Object data) {
        HttpResult result = new HttpResult();
        result.setData(data);
        result.setStatus(SUCCESS_STATUS);
        result.setMsg(SUCCESS_MSG);
        return result;
    }

    public static HttpResult fail(int status, String msg) {
        HttpResult result = new HttpResult();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult fail(String msg) {
        HttpResult result = new HttpResult();
        result.setStatus(-1);
        result.setMsg(msg);
        return result;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
