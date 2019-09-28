package com.balala.yaofun.bean.result;

import java.util.List;

public class LandingBean {

    /**
     * data : {"_id":"5cd2755c64f7c507f6e8dfe3","autograph":"","autograph_img":"https://img.yaofun.vip/2019/09/10/2ca4931a-d3a9-11e9-954c-acde48001122.png","back_image":"","birthday":"请选择生日","both_follow":false,"city":"","come_form":"微信小程序","country":"冰岛","create_time":"2019-05-08 14:21","current_balance":0,"email":"","fans_count":1,"first_in_ios":false,"follow_count":10,"has_follow":false,"identity_card":"","images":"https://img.yaofun.vip/2019/09/16/66ce5f1a-d856-11e9-824d-acde48001122.png","interest":["宠物","运动"],"is_delete":false,"is_top":false,"key":"5d8c5da1fa09e5f3dd82c9d0","language":"zh_CN","max_group":5,"medal":[],"nick_name":"Mark333","openid":"oy3_c4reXKy3YA-2yMFfJQwY_cVI","openid_ios":"","openid_public":"","openid_service":"","openid_web":"","operator_tags":{},"phone":"19965772170","province":"","rc_refresh_number":"","rc_status":"1","rc_time":"2019-07-01 14:49:08","rc_token":"/v5VkOsK3Wm31z2VUudSUotDThrZbuv4tvKiHu/pQzXLtr1UMVUjnjwyqLwzYmMCHki+js1vA5DPmjDW+CElkJ1HjsJzlHXglN5j9zAZhXAp9CZQH8upYw==","real_name":"","real_name_authentication":true,"rule":"群众","selected_city":"北京","self_create_group_count":3,"setting_nick_name":true,"sex":"男","tags_aggr":{"宠物":10,"运动":10},"umeng_device":"ios","umeng_device_token":"c084d4ce7fba24608359f09e9d710b2962e90db91aabacfa139810693b7c6a55","user_tags":{},"wx_unionid":"or7ly1ooRfr230FVr9c9DUD4YytA"}
     * msg : 请求成功
     * page : 0
     * pageSize : 0
     * success : true
     * total : 1
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
         * _id : 5cd2755c64f7c507f6e8dfe3
         * autograph :
         * autograph_img : https://img.yaofun.vip/2019/09/10/2ca4931a-d3a9-11e9-954c-acde48001122.png
         * back_image :
         * birthday : 请选择生日
         * both_follow : false
         * city :
         * come_form : 微信小程序
         * country : 冰岛
         * create_time : 2019-05-08 14:21
         * current_balance : 0
         * email :
         * fans_count : 1
         * first_in_ios : false
         * follow_count : 10
         * has_follow : false
         * identity_card :
         * images : https://img.yaofun.vip/2019/09/16/66ce5f1a-d856-11e9-824d-acde48001122.png
         * interest : ["宠物","运动"]
         * is_delete : false
         * is_top : false
         * key : 5d8c5da1fa09e5f3dd82c9d0
         * language : zh_CN
         * max_group : 5
         * medal : []
         * nick_name : Mark333
         * openid : oy3_c4reXKy3YA-2yMFfJQwY_cVI
         * openid_ios :
         * openid_public :
         * openid_service :
         * openid_web :
         * operator_tags : {}
         * phone : 19965772170
         * province :
         * rc_refresh_number :
         * rc_status : 1
         * rc_time : 2019-07-01 14:49:08
         * rc_token : /v5VkOsK3Wm31z2VUudSUotDThrZbuv4tvKiHu/pQzXLtr1UMVUjnjwyqLwzYmMCHki+js1vA5DPmjDW+CElkJ1HjsJzlHXglN5j9zAZhXAp9CZQH8upYw==
         * real_name :
         * real_name_authentication : true
         * rule : 群众
         * selected_city : 北京
         * self_create_group_count : 3
         * setting_nick_name : true
         * sex : 男
         * tags_aggr : {"宠物":10,"运动":10}
         * umeng_device : ios
         * umeng_device_token : c084d4ce7fba24608359f09e9d710b2962e90db91aabacfa139810693b7c6a55
         * user_tags : {}
         * wx_unionid : or7ly1ooRfr230FVr9c9DUD4YytA
         */

        private String _id;
        private String autograph;
        private String autograph_img;
        private String back_image;
        private String birthday;
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
        private String rc_status;
        private String rc_time;
        private String rc_token;
        private String real_name;
        private boolean real_name_authentication;
        private String rule;
        private String selected_city;
        private int self_create_group_count;
        private boolean setting_nick_name;
        private String sex;
        private TagsAggrBean tags_aggr;
        private String umeng_device;
        private String umeng_device_token;
        private UserTagsBean user_tags;
        private String wx_unionid;
        private List<String> interest;
        private List<?> medal;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getAutograph() {
            return autograph;
        }

        public void setAutograph(String autograph) {
            this.autograph = autograph;
        }

        public String getAutograph_img() {
            return autograph_img;
        }

        public void setAutograph_img(String autograph_img) {
            this.autograph_img = autograph_img;
        }

        public String getBack_image() {
            return back_image;
        }

        public void setBack_image(String back_image) {
            this.back_image = back_image;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
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

        public String getRc_status() {
            return rc_status;
        }

        public void setRc_status(String rc_status) {
            this.rc_status = rc_status;
        }

        public String getRc_time() {
            return rc_time;
        }

        public void setRc_time(String rc_time) {
            this.rc_time = rc_time;
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

        public String getUmeng_device() {
            return umeng_device;
        }

        public void setUmeng_device(String umeng_device) {
            this.umeng_device = umeng_device;
        }

        public String getUmeng_device_token() {
            return umeng_device_token;
        }

        public void setUmeng_device_token(String umeng_device_token) {
            this.umeng_device_token = umeng_device_token;
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

        public List<String> getInterest() {
            return interest;
        }

        public void setInterest(List<String> interest) {
            this.interest = interest;
        }

        public List<?> getMedal() {
            return medal;
        }

        public void setMedal(List<?> medal) {
            this.medal = medal;
        }

        public static class OperatorTagsBean {
        }

        public static class TagsAggrBean {
        }

        public static class UserTagsBean {
        }
    }
}
