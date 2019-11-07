package com.balala.yaofun.bean;

import java.io.Serializable;

public class CodeBean implements Serializable {
    private String code;
    private String key;
    private String purpose;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "CodeBean{" +
                "code=" + code +
                ", key='" + key + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
