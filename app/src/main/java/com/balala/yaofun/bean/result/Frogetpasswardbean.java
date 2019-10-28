package com.balala.yaofun.bean.result;

public class Frogetpasswardbean {

    /**
     * data :
     * msg : 缺少必填参数
     * page : 0
     * pageSize : 0
     * success : false
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
