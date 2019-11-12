package com.balala.yaofun.bean.result;

import java.util.List;

public class HomedetailsBean  {


    /**
     * data : {"UM_wxFriends_url":"https://m.yaofun.vip/activityinfo?id=5db81532a77870fcf9d9d610","_id":"5db81532a77870fcf9d9d610","auditing_count":0,"content_array":["摁着我在真转我","https://img.yaofun.vip/2019/09/12/724829b2-d549-11e9-a450-0242ac130002.png","https://img.yaofun.vip/2019/09/12/74217bda-d549-11e9-a450-0242ac130002.png"],"cost":0,"cover":"https://img.yaofun.vip/2019/08/30/db23dec6-cafa-11e9-8483-acde48001122.png","cover_height":600,"cover_width":600,"door_number":"","earliest5img":[],"el_id":"","errollment_ios":"报名中","errollment_ios_detail":"立即报名","errollment_number":25,"errollment_status":"normal","errollment_wx_detail":"立即报名","errollment_wx_list":"报名中","errollment_wx_list_my":"报名中","good_id":"5db81532a77870fcf9d9d611","group_count":0,"group_id":"","has_join_number":0,"has_join_user_group":false,"is_delete":false,"last24hours":false,"less24hours":false,"limit_number":6,"location_name":"新丝界","my_status":8,"need_audit":false,"place_text":{"address":"大屯路慧忠北里309号楼D座1层附近","location":{"latitude":"40.002931","longitude":"116.405224"},"name":"新丝界"},"post_card_url":"https://img.yaofun.vip/2019/10/29/68579466-fa37-11e9-8724-0242ac13000c.png","product_id":"5db81532a77870fcf9d9d610","qq_url":"","qr_code_state":"","qr_code_url":"","rich_introduce":"<p>摁着我在真转我<\/p><img src='https://img.yaofun.vip/2019/09/12/724829b2-d549-11e9-a450-0242ac130002.png'><\/img><img src='https://img.yaofun.vip/2019/09/12/74217bda-d549-11e9-a450-0242ac130002.png'><\/img>","rule_time":"10-30 19:00","show_picture":false,"signup_status":"未报名","start_end_time":"10/31 本周四 19:00 - 22:00","start_month_day":"10/31","start_year":2019,"temporary_user_group_id":"5db81547a77870fcf9d9d61f","title":"黄小明同学测试一下","type_array":["文本","图片","图片"],"update_count":0,"user_autograph":[],"user_id":"5cde140a71ab1051bdada8b7","user_identity":"未报名用户","user_images":"https://img.yaofun.vip/2019/10/11/fa9ec260-ec02-11e9-abc2-0242ac13000c.png","user_label":["我就是我","职业秃头","专业写BUG"],"user_nick_name":"黄小明666","user_phone":"10000000000","wx_share_image":"https://img.yaofun.vip/2019/10/29/66643966-fa37-11e9-8724-0242ac13000c.jpg","wx_share_url":"/pages/login/login?share_query=true&type=activity&id=5db81532a77870fcf9d9d610"}
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
         * UM_wxFriends_url : https://m.yaofun.vip/activityinfo?id=5db81532a77870fcf9d9d610
         * _id : 5db81532a77870fcf9d9d610
         * auditing_count : 0
         * content_array : ["摁着我在真转我","https://img.yaofun.vip/2019/09/12/724829b2-d549-11e9-a450-0242ac130002.png","https://img.yaofun.vip/2019/09/12/74217bda-d549-11e9-a450-0242ac130002.png"]
         * cost : 0
         * cover : https://img.yaofun.vip/2019/08/30/db23dec6-cafa-11e9-8483-acde48001122.png
         * cover_height : 600
         * cover_width : 600
         * door_number :
         * earliest5img : []
         * el_id :
         * errollment_ios : 报名中
         * errollment_ios_detail : 立即报名
         * errollment_number : 25
         * errollment_status : normal
         * errollment_wx_detail : 立即报名
         * errollment_wx_list : 报名中
         * errollment_wx_list_my : 报名中
         * good_id : 5db81532a77870fcf9d9d611
         * group_count : 0
         * group_id :
         * has_join_number : 0
         * has_join_user_group : false
         * is_delete : false
         * last24hours : false
         * less24hours : false
         * limit_number : 6
         * location_name : 新丝界
         * my_status : 8
         * need_audit : false
         * place_text : {"address":"大屯路慧忠北里309号楼D座1层附近","location":{"latitude":"40.002931","longitude":"116.405224"},"name":"新丝界"}
         * post_card_url : https://img.yaofun.vip/2019/10/29/68579466-fa37-11e9-8724-0242ac13000c.png
         * product_id : 5db81532a77870fcf9d9d610
         * qq_url :
         * qr_code_state :
         * qr_code_url :
         * rich_introduce : <p>摁着我在真转我</p><img src='https://img.yaofun.vip/2019/09/12/724829b2-d549-11e9-a450-0242ac130002.png'></img><img src='https://img.yaofun.vip/2019/09/12/74217bda-d549-11e9-a450-0242ac130002.png'></img>
         * rule_time : 10-30 19:00
         * show_picture : false
         * signup_status : 未报名
         * start_end_time : 10/31 本周四 19:00 - 22:00
         * start_month_day : 10/31
         * start_year : 2019
         * temporary_user_group_id : 5db81547a77870fcf9d9d61f
         * title : 黄小明同学测试一下
         * type_array : ["文本","图片","图片"]
         * update_count : 0
         * user_autograph : []
         * user_id : 5cde140a71ab1051bdada8b7
         * user_identity : 未报名用户
         * user_images : https://img.yaofun.vip/2019/10/11/fa9ec260-ec02-11e9-abc2-0242ac13000c.png
         * user_label : ["我就是我","职业秃头","专业写BUG"]
         * user_nick_name : 黄小明666
         * user_phone : 10000000000
         * wx_share_image : https://img.yaofun.vip/2019/10/29/66643966-fa37-11e9-8724-0242ac13000c.jpg
         * wx_share_url : /pages/login/login?share_query=true&type=activity&id=5db81532a77870fcf9d9d610
         */

        private String UM_wxFriends_url;
        private String _id;
        private int auditing_count;
        private String cost;
        private String cover;
        private int cover_height;
        private int cover_width;
        private String door_number;
        private String el_id;
        private String errollment_ios;
        private String errollment_ios_detail;
        private String errollment_number;
        private String errollment_status;
        private String errollment_wx_detail;
        private String errollment_wx_list;
        private String errollment_wx_list_my;
        private String good_id;
        private String group_count;
        private String group_id;
        private int has_join_number;
        private boolean has_join_user_group;
        private boolean is_delete;
        private boolean last24hours;
        private boolean less24hours;
        private String limit_number;
        private String location_name;
        private String my_status;
        private boolean need_audit;
        private PlaceTextBean place_text;
        private String post_card_url;
        private String product_id;
        private String qq_url;
        private String qr_code_state;
        private String qr_code_url;
        private String rich_introduce;
        private String rule_time;
        private boolean show_picture;
        private String signup_status;
        private String start_end_time;
        private String start_month_day;
        private int start_year;
        private String temporary_user_group_id;
        private String title;
        private int update_count;
        private String user_id;
        private String user_identity;
        private String user_images;
        private String user_nick_name;
        private String user_phone;
        private String wx_share_image;
        private String wx_share_url;
        private List<String> content_array;
        private List<?> earliest5img;
        private List<String> type_array;
        private List<?> user_autograph;
        private List<String> user_label;

        public String getUM_wxFriends_url() {
            return UM_wxFriends_url;
        }

        public void setUM_wxFriends_url(String UM_wxFriends_url) {
            this.UM_wxFriends_url = UM_wxFriends_url;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getAuditing_count() {
            return auditing_count;
        }

        public void setAuditing_count(int auditing_count) {
            this.auditing_count = auditing_count;
        }

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getCover_height() {
            return cover_height;
        }

        public void setCover_height(int cover_height) {
            this.cover_height = cover_height;
        }

        public int getCover_width() {
            return cover_width;
        }

        public void setCover_width(int cover_width) {
            this.cover_width = cover_width;
        }

        public String getDoor_number() {
            return door_number;
        }

        public void setDoor_number(String door_number) {
            this.door_number = door_number;
        }

        public String getEl_id() {
            return el_id;
        }

        public void setEl_id(String el_id) {
            this.el_id = el_id;
        }

        public String getErrollment_ios() {
            return errollment_ios;
        }

        public void setErrollment_ios(String errollment_ios) {
            this.errollment_ios = errollment_ios;
        }

        public String getErrollment_ios_detail() {
            return errollment_ios_detail;
        }

        public void setErrollment_ios_detail(String errollment_ios_detail) {
            this.errollment_ios_detail = errollment_ios_detail;
        }

        public String getErrollment_number() {
            return errollment_number;
        }

        public void setErrollment_number(String errollment_number) {
            this.errollment_number = errollment_number;
        }

        public String getErrollment_status() {
            return errollment_status;
        }

        public void setErrollment_status(String errollment_status) {
            this.errollment_status = errollment_status;
        }

        public String getErrollment_wx_detail() {
            return errollment_wx_detail;
        }

        public void setErrollment_wx_detail(String errollment_wx_detail) {
            this.errollment_wx_detail = errollment_wx_detail;
        }

        public String getErrollment_wx_list() {
            return errollment_wx_list;
        }

        public void setErrollment_wx_list(String errollment_wx_list) {
            this.errollment_wx_list = errollment_wx_list;
        }

        public String getErrollment_wx_list_my() {
            return errollment_wx_list_my;
        }

        public void setErrollment_wx_list_my(String errollment_wx_list_my) {
            this.errollment_wx_list_my = errollment_wx_list_my;
        }

        public String getGood_id() {
            return good_id;
        }

        public void setGood_id(String good_id) {
            this.good_id = good_id;
        }

        public String getGroup_count() {
            return group_count;
        }

        public void setGroup_count(String group_count) {
            this.group_count = group_count;
        }

        public String getGroup_id() {
            return group_id;
        }

        public void setGroup_id(String group_id) {
            this.group_id = group_id;
        }

        public int getHas_join_number() {
            return has_join_number;
        }

        public void setHas_join_number(int has_join_number) {
            this.has_join_number = has_join_number;
        }

        public boolean isHas_join_user_group() {
            return has_join_user_group;
        }

        public void setHas_join_user_group(boolean has_join_user_group) {
            this.has_join_user_group = has_join_user_group;
        }

        public boolean isIs_delete() {
            return is_delete;
        }

        public void setIs_delete(boolean is_delete) {
            this.is_delete = is_delete;
        }

        public boolean isLast24hours() {
            return last24hours;
        }

        public void setLast24hours(boolean last24hours) {
            this.last24hours = last24hours;
        }

        public boolean isLess24hours() {
            return less24hours;
        }

        public void setLess24hours(boolean less24hours) {
            this.less24hours = less24hours;
        }

        public String getLimit_number() {
            return limit_number;
        }

        public void setLimit_number(String limit_number) {
            this.limit_number = limit_number;
        }

        public String getLocation_name() {
            return location_name;
        }

        public void setLocation_name(String location_name) {
            this.location_name = location_name;
        }

        public String getMy_status() {
            return my_status;
        }

        public void setMy_status(String my_status) {
            this.my_status = my_status;
        }

        public boolean isNeed_audit() {
            return need_audit;
        }

        public void setNeed_audit(boolean need_audit) {
            this.need_audit = need_audit;
        }

        public PlaceTextBean getPlace_text() {
            return place_text;
        }

        public void setPlace_text(PlaceTextBean place_text) {
            this.place_text = place_text;
        }

        public String getPost_card_url() {
            return post_card_url;
        }

        public void setPost_card_url(String post_card_url) {
            this.post_card_url = post_card_url;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getQq_url() {
            return qq_url;
        }

        public void setQq_url(String qq_url) {
            this.qq_url = qq_url;
        }

        public String getQr_code_state() {
            return qr_code_state;
        }

        public void setQr_code_state(String qr_code_state) {
            this.qr_code_state = qr_code_state;
        }

        public String getQr_code_url() {
            return qr_code_url;
        }

        public void setQr_code_url(String qr_code_url) {
            this.qr_code_url = qr_code_url;
        }

        public String getRich_introduce() {
            return rich_introduce;
        }

        public void setRich_introduce(String rich_introduce) {
            this.rich_introduce = rich_introduce;
        }

        public String getRule_time() {
            return rule_time;
        }

        public void setRule_time(String rule_time) {
            this.rule_time = rule_time;
        }

        public boolean isShow_picture() {
            return show_picture;
        }

        public void setShow_picture(boolean show_picture) {
            this.show_picture = show_picture;
        }

        public String getSignup_status() {
            return signup_status;
        }

        public void setSignup_status(String signup_status) {
            this.signup_status = signup_status;
        }

        public String getStart_end_time() {
            return start_end_time;
        }

        public void setStart_end_time(String start_end_time) {
            this.start_end_time = start_end_time;
        }

        public String getStart_month_day() {
            return start_month_day;
        }

        public void setStart_month_day(String start_month_day) {
            this.start_month_day = start_month_day;
        }

        public int getStart_year() {
            return start_year;
        }

        public void setStart_year(int start_year) {
            this.start_year = start_year;
        }

        public String getTemporary_user_group_id() {
            return temporary_user_group_id;
        }

        public void setTemporary_user_group_id(String temporary_user_group_id) {
            this.temporary_user_group_id = temporary_user_group_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUpdate_count() {
            return update_count;
        }

        public void setUpdate_count(int update_count) {
            this.update_count = update_count;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_identity() {
            return user_identity;
        }

        public void setUser_identity(String user_identity) {
            this.user_identity = user_identity;
        }

        public String getUser_images() {
            return user_images;
        }

        public void setUser_images(String user_images) {
            this.user_images = user_images;
        }

        public String getUser_nick_name() {
            return user_nick_name;
        }

        public void setUser_nick_name(String user_nick_name) {
            this.user_nick_name = user_nick_name;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getWx_share_image() {
            return wx_share_image;
        }

        public void setWx_share_image(String wx_share_image) {
            this.wx_share_image = wx_share_image;
        }

        public String getWx_share_url() {
            return wx_share_url;
        }

        public void setWx_share_url(String wx_share_url) {
            this.wx_share_url = wx_share_url;
        }

        public List<String> getContent_array() {
            return content_array;
        }

        public void setContent_array(List<String> content_array) {
            this.content_array = content_array;
        }

        public List<?> getEarliest5img() {
            return earliest5img;
        }

        public void setEarliest5img(List<?> earliest5img) {
            this.earliest5img = earliest5img;
        }

        public List<String> getType_array() {
            return type_array;
        }

        public void setType_array(List<String> type_array) {
            this.type_array = type_array;
        }

        public List<?> getUser_autograph() {
            return user_autograph;
        }

        public void setUser_autograph(List<?> user_autograph) {
            this.user_autograph = user_autograph;
        }

        public List<String> getUser_label() {
            return user_label;
        }

        public void setUser_label(List<String> user_label) {
            this.user_label = user_label;
        }

        public static class PlaceTextBean {
            /**
             * address : 大屯路慧忠北里309号楼D座1层附近
             * location : {"latitude":"40.002931","longitude":"116.405224"}
             * name : 新丝界
             */

            private String address;
            private LocationBean location;
            private String name;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class LocationBean {
                /**
                 * latitude : 40.002931
                 * longitude : 116.405224
                 */

                private String latitude;
                private String longitude;

                public LocationBean(double longitude, double latitude, String trim, String s) {

                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            }
        }
    }
}
