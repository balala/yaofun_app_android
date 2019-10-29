package com.balala.yaofun.bean.result;

import java.util.List;

public class RegisterBean {

    /**
     * data : {"_id":"5db7b8a5a77870fcf9d9cf5c","autograph":["不秃头的小白说没有签名会变胖！"],"back_image":"","both_follow":false,"city":"","come_form":"安卓","country":"","create_time":"2019-10-29 11:57","current_balance":0,"email":"","fans_count":0,"first_in_ios":true,"follow_count":0,"friend":[],"has_follow":false,"identity_card":"","images":"https://img.yaofun.vip/2019/10/11/97e47172-ebd2-11e9-b241-0242ac130002.png","interest":[],"is_delete":false,"is_top":false,"key":"5db7b8a5a77870fcf9d9cf5d","language":"","max_group":5,"medal":[],"nick_name":"Fun粒80073","openid":"","openid_ios":"","openid_public":"","openid_service":"","openid_web":"","operator_tags":{},"phone":"15843423826","province":"","rc_refresh_number":"","rc_token":"t69f0LfutwGzS/VWNflgbCHjRiDzVQTbLdmfTrRS4toH0o8UXU715WxNDt4pDZptxEMggchGpfZdMj0aAy2K52vSvE/Lq6aSSd9fBtgC3/UuVP63KwNm9A==","real_name":"","real_name_authentication":false,"rule":"群众","selected_city":"北京","self_create_group_count":0,"setting_nick_name":false,"sex":"","tags_aggr":{},"user_label":[],"user_tags":{},"wx_unionid":""}
     * msg : 注册成功
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
         * _id : 5db7b8a5a77870fcf9d9cf5c
         * autograph : ["不秃头的小白说没有签名会变胖！"]
         * back_image :
         * both_follow : false
         * city :
         * come_form : 安卓
         * country :
         * create_time : 2019-10-29 11:57
         * current_balance : 0
         * email :
         * fans_count : 0
         * first_in_ios : true
         * follow_count : 0
         * friend : []
         * has_follow : false
         * identity_card :
         * images : https://img.yaofun.vip/2019/10/11/97e47172-ebd2-11e9-b241-0242ac130002.png
         * interest : []
         * is_delete : false
         * is_top : false
         * key : 5db7b8a5a77870fcf9d9cf5d
         * language :
         * max_group : 5
         * medal : []
         * nick_name : Fun粒80073
         * openid :
         * openid_ios :
         * openid_public :
         * openid_service :
         * openid_web :
         * operator_tags : {}
         * phone : 15843423826
         * province :
         * rc_refresh_number :
         * rc_token : t69f0LfutwGzS/VWNflgbCHjRiDzVQTbLdmfTrRS4toH0o8UXU715WxNDt4pDZptxEMggchGpfZdMj0aAy2K52vSvE/Lq6aSSd9fBtgC3/UuVP63KwNm9A==
         * real_name :
         * real_name_authentication : false
         * rule : 群众
         * selected_city : 北京
         * self_create_group_count : 0
         * setting_nick_name : false
         * sex :
         * tags_aggr : {}
         * user_label : []
         * user_tags : {}
         * wx_unionid :
         */

        private String _id;
        private String back_image;
        private boolean both_follow;
        private String city;
        private String come_form;
        private String country;
        private String create_time;
        private int current_balance;
        private String email;
        private int fans_count;
        private boolean first_in_ios;
        private int follow_count;
        private boolean has_follow;
        private String identity_card;
        private String images;
        private boolean is_delete;
        private boolean is_top;
        private String key;
        private String language;
        private int max_group;
        private String nick_name;
        private String openid;
        private String openid_ios;
        private String openid_public;
        private String openid_service;
        private String openid_web;
        private OperatorTagsBean operator_tags;
        private String phone;
        private String province;
        private String rc_refresh_number;
        private String rc_token;
        private String real_name;
        private boolean real_name_authentication;
        private String rule;
        private String selected_city;
        private int self_create_group_count;
        private boolean setting_nick_name;
        private String sex;
        private TagsAggrBean tags_aggr;
        private UserTagsBean user_tags;
        private String wx_unionid;
        private List<String> autograph;
        private List<?> friend;
        private List<?> interest;
        private List<?> medal;
        private List<?> user_label;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getBack_image() {
            return back_image;
        }

        public void setBack_image(String back_image) {
            this.back_image = back_image;
        }

        public boolean isBoth_follow() {
            return both_follow;
        }

        public void setBoth_follow(boolean both_follow) {
            this.both_follow = both_follow;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCome_form() {
            return come_form;
        }

        public void setCome_form(String come_form) {
            this.come_form = come_form;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getCurrent_balance() {
            return current_balance;
        }

        public void setCurrent_balance(int current_balance) {
            this.current_balance = current_balance;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getFans_count() {
            return fans_count;
        }

        public void setFans_count(int fans_count) {
            this.fans_count = fans_count;
        }

        public boolean isFirst_in_ios() {
            return first_in_ios;
        }

        public void setFirst_in_ios(boolean first_in_ios) {
            this.first_in_ios = first_in_ios;
        }

        public int getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(int follow_count) {
            this.follow_count = follow_count;
        }

        public boolean isHas_follow() {
            return has_follow;
        }

        public void setHas_follow(boolean has_follow) {
            this.has_follow = has_follow;
        }

        public String getIdentity_card() {
            return identity_card;
        }

        public void setIdentity_card(String identity_card) {
            this.identity_card = identity_card;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public boolean isIs_delete() {
            return is_delete;
        }

        public void setIs_delete(boolean is_delete) {
            this.is_delete = is_delete;
        }

        public boolean isIs_top() {
            return is_top;
        }

        public void setIs_top(boolean is_top) {
            this.is_top = is_top;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getMax_group() {
            return max_group;
        }

        public void setMax_group(int max_group) {
            this.max_group = max_group;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getOpenid_ios() {
            return openid_ios;
        }

        public void setOpenid_ios(String openid_ios) {
            this.openid_ios = openid_ios;
        }

        public String getOpenid_public() {
            return openid_public;
        }

        public void setOpenid_public(String openid_public) {
            this.openid_public = openid_public;
        }

        public String getOpenid_service() {
            return openid_service;
        }

        public void setOpenid_service(String openid_service) {
            this.openid_service = openid_service;
        }

        public String getOpenid_web() {
            return openid_web;
        }

        public void setOpenid_web(String openid_web) {
            this.openid_web = openid_web;
        }

        public OperatorTagsBean getOperator_tags() {
            return operator_tags;
        }

        public void setOperator_tags(OperatorTagsBean operator_tags) {
            this.operator_tags = operator_tags;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRc_refresh_number() {
            return rc_refresh_number;
        }

        public void setRc_refresh_number(String rc_refresh_number) {
            this.rc_refresh_number = rc_refresh_number;
        }

        public String getRc_token() {
            return rc_token;
        }

        public void setRc_token(String rc_token) {
            this.rc_token = rc_token;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public boolean isReal_name_authentication() {
            return real_name_authentication;
        }

        public void setReal_name_authentication(boolean real_name_authentication) {
            this.real_name_authentication = real_name_authentication;
        }

        public String getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }

        public String getSelected_city() {
            return selected_city;
        }

        public void setSelected_city(String selected_city) {
            this.selected_city = selected_city;
        }

        public int getSelf_create_group_count() {
            return self_create_group_count;
        }

        public void setSelf_create_group_count(int self_create_group_count) {
            this.self_create_group_count = self_create_group_count;
        }

        public boolean isSetting_nick_name() {
            return setting_nick_name;
        }

        public void setSetting_nick_name(boolean setting_nick_name) {
            this.setting_nick_name = setting_nick_name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public TagsAggrBean getTags_aggr() {
            return tags_aggr;
        }

        public void setTags_aggr(TagsAggrBean tags_aggr) {
            this.tags_aggr = tags_aggr;
        }

        public UserTagsBean getUser_tags() {
            return user_tags;
        }

        public void setUser_tags(UserTagsBean user_tags) {
            this.user_tags = user_tags;
        }

        public String getWx_unionid() {
            return wx_unionid;
        }

        public void setWx_unionid(String wx_unionid) {
            this.wx_unionid = wx_unionid;
        }

        public List<String> getAutograph() {
            return autograph;
        }

        public void setAutograph(List<String> autograph) {
            this.autograph = autograph;
        }

        public List<?> getFriend() {
            return friend;
        }

        public void setFriend(List<?> friend) {
            this.friend = friend;
        }

        public List<?> getInterest() {
            return interest;
        }

        public void setInterest(List<?> interest) {
            this.interest = interest;
        }

        public List<?> getMedal() {
            return medal;
        }

        public void setMedal(List<?> medal) {
            this.medal = medal;
        }

        public List<?> getUser_label() {
            return user_label;
        }

        public void setUser_label(List<?> user_label) {
            this.user_label = user_label;
        }

        public static class OperatorTagsBean {
        }

        public static class TagsAggrBean {
        }

        public static class UserTagsBean {
        }
    }
}
