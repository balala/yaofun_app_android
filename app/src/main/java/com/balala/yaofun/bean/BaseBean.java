package com.balala.yaofun.bean;

public class BaseBean<T>{
    private T data;
    private String msg;
    private int page;
    private int pageSize;
    private boolean success;
    private int total;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
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
        return "BaseBean{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", success=" + success +
                ", total=" + total +
                '}';
    }
}
