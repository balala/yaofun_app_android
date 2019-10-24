package com.balala.yaofun.bean;

public class AccountBean extends AllBean {
    private String phone;
    private String password;

    public AccountBean() {
        this.phone = phone;
        this.password = password;
    }

    public AccountBean(String user_id, String version, String current_device, int unique_identifier, String user_defined_name, String download_channel, String phone_version, int phone_model, String wx_unionid, String request_start_time, String phone, String password) {
        super(user_id, version, current_device, unique_identifier, user_defined_name, download_channel, phone_version, phone_model, wx_unionid, request_start_time);
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountBean{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
