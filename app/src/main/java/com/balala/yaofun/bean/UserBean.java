package com.balala.yaofun.bean;

import java.io.Serializable;
import java.util.List;

public  class UserBean implements Serializable {
    //登录之后的key
    private String key;
    private String _id;
    //真实姓名
    private String real_name;
    //昵称
    private String nick_name;
    private String sortLetters;//显示数据拼音的首字母
    //手机号
    private String phone;
    //密码
    private String password;
    //出生年月日
    private int birthday_year;
    private String birthday_month;
    private String birthday_day;
    //出生年月日,样式： year-month-day
    private String birthday;
    //头像
    private String images;
    //个人签名列表
    private String autograph_str;
    //性别
    private String sex;
    //微信UnionidID
    private String wx_unionid;
    // 公众号openid（订阅号）
    private String openid_public;
    //公众号openid（服务号）
    private String openid_service;
    //（和上面的wx_unionid一样）uid能否实现Android与iOS平台打通，目前QQ只能实现同APPID下用户ID匹配
    private String uid;
    //网页上用的openid
    private String openid_web;
    //openid :小程序使用
    private String openid;
    //ios使用, Android也可以用的,主要为微信和QQ使用
    private String opendid_ios;
    //我关注别人的数量
    private String follow_count;
    //别人关注我的数量
    private String fans_count;
    //好友：相关关注
    private List<String> friend;
    //邮件
    private String email;
    //是否已经删除，默认为none
    private String is_delete;
    //创建时间
    private String create_time;
    //身份:{'root','manager','群众'},default='群众')
    private String rule;
    //用户所在国家
    private String country;
    //用户所在省份
    private String province;
    //用户所所选的城市
    private String city;
    //自动定位的城市
    private String city_location;
    //是否实名
    private Boolean real_name_authentication;
    //身份证
    private String identity_card;
    //实名方式:身份证、护照
    private String real_from;
    //可以创建群组的数量,默认为5个
    private String max_group;
    //签名照片
    private String autograph_img;
    //融云token
    private String rc_token;
    //是否完成融云信息同步，默认保存第几次同步
    private String rc_refresh_number;
    //兴趣标签
    private List<String> interest;
    //个性标签
    private List<String> user_label;
    //ios里面个人设备背景图片
    private String back_image;
    // 注册平台
    private String come_form;
    //用户余额
    private Double current_balance;
    // deviceToken是【友盟+】消息推送生成的用于标识设备的id，长度为44位，不能定制和修改。
    // 同一台设备上不同应用对应的deviceToken不一样。获取deviceToken的值后，可进行消息推送测试！
    //友盟推送用的设备编号
    private String umeng_device_token;
    //友盟设备
    private String umeng_device;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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

    public int getBirthday_year() {
        return birthday_year;
    }

    public void setBirthday_year(int birthday_year) {
        this.birthday_year = birthday_year;
    }

    public String getBirthday_month() {
        return birthday_month;
    }

    public void setBirthday_month(String birthday_month) {
        this.birthday_month = birthday_month;
    }

    public String getBirthday_day() {
        return birthday_day;
    }

    public void setBirthday_day(String birthday_day) {
        this.birthday_day = birthday_day;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWx_unionid() {
        return wx_unionid;
    }

    public void setWx_unionid(String wx_unionid) {
        this.wx_unionid = wx_unionid;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOpenid_web() {
        return openid_web;
    }

    public void setOpenid_web(String openid_web) {
        this.openid_web = openid_web;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpendid_ios() {
        return opendid_ios;
    }

    public void setOpendid_ios(String opendid_ios) {
        this.opendid_ios = opendid_ios;
    }

    public String getFollow_count() {
        return follow_count;
    }

    public void setFollow_count(String follow_count) {
        this.follow_count = follow_count;
    }

    public String getFans_count() {
        return fans_count;
    }

    public void setFans_count(String fans_count) {
        this.fans_count = fans_count;
    }

    public List<String> getFriend() {
        return friend;
    }

    public void setFriend(List<String> friend) {
        this.friend = friend;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_location() {
        return city_location;
    }

    public void setCity_location(String city_location) {
        this.city_location = city_location;
    }

    public Boolean getReal_name_authentication() {
        return real_name_authentication;
    }

    public void setReal_name_authentication(Boolean real_name_authentication) {
        this.real_name_authentication = real_name_authentication;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getReal_from() {
        return real_from;
    }

    public void setReal_from(String real_from) {
        this.real_from = real_from;
    }

    public String getMax_group() {
        return max_group;
    }

    public void setMax_group(String max_group) {
        this.max_group = max_group;
    }

    public String getAutograph_img() {
        return autograph_img;
    }

    public void setAutograph_img(String autograph_img) {
        this.autograph_img = autograph_img;
    }

    public String getRc_token() {
        return rc_token;
    }

    public void setRc_token(String rc_token) {
        this.rc_token = rc_token;
    }

    public String getRc_refresh_number() {
        return rc_refresh_number;
    }

    public void setRc_refresh_number(String rc_refresh_number) {
        this.rc_refresh_number = rc_refresh_number;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public List<String> getUser_label() {
        return user_label;
    }

    public void setUser_label(List<String> user_label) {
        this.user_label = user_label;
    }

    public String getBack_image() {
        return back_image;
    }

    public void setBack_image(String back_image) {
        this.back_image = back_image;
    }

    public String getCome_form() {
        return come_form;
    }

    public void setCome_form(String come_form) {
        this.come_form = come_form;
    }

    public Double getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(Double current_balance) {
        this.current_balance = current_balance;
    }

    public String getUmeng_device_token() {
        return umeng_device_token;
    }

    public void setUmeng_device_token(String umeng_device_token) {
        this.umeng_device_token = umeng_device_token;
    }

    public String getUmeng_device() {
        return umeng_device;
    }

    public void setUmeng_device(String umeng_device) {
        this.umeng_device = umeng_device;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    public String getAutograph_str() {
        return autograph_str;
    }

    public void setAutograph_str(String autograph_str) {
        this.autograph_str = autograph_str;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "key='" + key + '\'' +
                ", _id='" + _id + '\'' +
                ", real_name='" + real_name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", sortLetters='" + sortLetters + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", birthday_year=" + birthday_year +
                ", birthday_month='" + birthday_month + '\'' +
                ", birthday_day='" + birthday_day + '\'' +
                ", birthday='" + birthday + '\'' +
                ", images='" + images + '\'' +
                ", autograph_str='" + autograph_str + '\'' +
                ", sex='" + sex + '\'' +
                ", wx_unionid='" + wx_unionid + '\'' +
                ", openid_public='" + openid_public + '\'' +
                ", openid_service='" + openid_service + '\'' +
                ", uid='" + uid + '\'' +
                ", openid_web='" + openid_web + '\'' +
                ", openid='" + openid + '\'' +
                ", opendid_ios='" + opendid_ios + '\'' +
                ", follow_count='" + follow_count + '\'' +
                ", fans_count='" + fans_count + '\'' +
                ", friend=" + friend +
                ", email='" + email + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", create_time='" + create_time + '\'' +
                ", rule='" + rule + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", city_location='" + city_location + '\'' +
                ", real_name_authentication=" + real_name_authentication +
                ", identity_card='" + identity_card + '\'' +
                ", real_from='" + real_from + '\'' +
                ", max_group='" + max_group + '\'' +
                ", autograph_img='" + autograph_img + '\'' +
                ", rc_token='" + rc_token + '\'' +
                ", rc_refresh_number='" + rc_refresh_number + '\'' +
                ", interest=" + interest +
                ", user_label=" + user_label +
                ", back_image='" + back_image + '\'' +
                ", come_form='" + come_form + '\'' +
                ", current_balance=" + current_balance +
                ", umeng_device_token='" + umeng_device_token + '\'' +
                ", umeng_device='" + umeng_device + '\'' +
                '}';
    }
}
