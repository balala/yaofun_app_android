package com.balala.yaofun.bean;

import java.util.List;

public class MailListBean {
    private List<MailListUserBean> user_list;
    private String zimu;
    public void setUser_list(List<MailListUserBean> user_list) {
        this.user_list = user_list;
    }
    public List<MailListUserBean> getUser_list() {
        return user_list;
    }

    public void setZimu(String zimu) {
        this.zimu = zimu;
    }
    public String getZimu() {
        return zimu;
    }
}
