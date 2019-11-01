package com.balala.yaofun.bean;

import java.io.Serializable;

public class CodeBean implements Serializable {
    private int code;
    private String key;
    private String purpose;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
