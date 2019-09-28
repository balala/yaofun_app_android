package com.balala.yaofun.bean;

public class VerificationResult {


    /**
     * data : {"code":56345,"key":"82d6566a-df34-11e9-9054-0242ac130011","phone":"18600747953","purpose":"注册","time":{"$date":1569404023000}}
     * msg : 发送成功
     * page : 0
     * pageSize : 0
     * success : true
     * total : 0
     */

    private DataBean data;
    private String msg;
    private String page;
    private int pageSize;
    private boolean success;
    private int total;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * code : 56345
         * key : 82d6566a-df34-11e9-9054-0242ac130011
         * phone : 18600747953
         * purpose : 注册
         * time : {"$date":1569404023000}
         */

        private int code;
        private String key;
        private String phone;
        private String purpose;
        private TimeBean time;

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

        public TimeBean getTime() {
            return time;
        }

        public void setTime(TimeBean time) {
            this.time = time;
        }

        public static class TimeBean {
            /**
             * $date : 1569404023000
             */

            private long $date;

            public long get$date() {
                return $date;
            }

            public void set$date(long $date) {
                this.$date = $date;
            }
        }
    }
}
