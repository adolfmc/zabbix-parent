package com.zabbix.sisyphus.util;
public class SmsRequest {

    String account = "dh73271";
    String password = "7f926654d7913c7d541862cc87e04e37";//9zIJjJv0;
    String phones;
    String content;
    String sign = "【zabbix金融】";
    String subcode = "73271";

    public SmsRequest(String phones, String content) {
        this.phones = phones;
        this.content = content;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    @Override
    public String toString() {
        return String.format("account=%s&password=%s&phones=%s&content=%s&sign=%s&subcode=%s",account,password,phones,content,sign,subcode);
    }
}