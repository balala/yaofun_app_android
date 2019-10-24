package com.balala.yaofun.bean;

public class VerificationBean extends AllBean {
    private String phone;
    private String purpose;
    private String key;
    private String code;
    private String sign2;

    public VerificationBean() {
        this.phone = phone;
        this.purpose = purpose;
        this.key = key;
        this.code = code;
        this.sign2 = sign2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSign2() {
        return sign2;
    }

    public void setSign2(String sign2) {
        this.sign2 = sign2;
    }

    @Override
    public String toString() {
        return "VerificationBean{" +
                "phone='" + phone + '\'' +
                ", purpose='" + purpose + '\'' +
                ", key='" + key + '\'' +
                ", code='" + code + '\'' +
                ", sign2='" + sign2 + '\'' +
                '}';
    }
}
