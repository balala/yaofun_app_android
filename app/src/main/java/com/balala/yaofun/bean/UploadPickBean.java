package com.balala.yaofun.bean;

import java.io.Serializable;

public class UploadPickBean implements Serializable {

    /**
     * data : https://img.yaofun.vip/2019/10/31/da9cc5a2-fbb6-11e9-9d70-0242ac130013.png
     * msg : 上传成功
     * page : 0
     * pageSize : 0
     * success : true
     * total : 0
     */

    private String data;
    private String msg;
    private String page;
    private int pageSize;
    private boolean success;
    private int total;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
