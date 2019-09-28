package com.balala.yaofun.bean.result;


/**
 *
 * 验证码验证返回的实体类
 */
public class VerificationCode {


    /**
     * data :
     * msg : 请求成功
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

    @Override
    public String toString() {
        return "VerificationCode{" +
                "data='" + data + '\'' +
                ", msg='" + msg + '\'' +
                ", page='" + page + '\'' +
                ", pageSize=" + pageSize +
                ", success=" + success +
                ", total=" + total +
                '}';
    }
}
