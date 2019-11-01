package com.balala.yaofun.bean.result;

import com.balala.yaofun.bean.BaseBean;

import java.io.Serializable;
import java.util.List;

public class HomeBannerDean implements Serializable {

    public static class DataBean {
        private List<FirstBean> first;
        private List<SecondBean> second;

        public List<FirstBean> getFirst() {
            return first;
        }

        public void setFirst(List<FirstBean> first) {
            this.first = first;
        }

        public List<SecondBean> getSecond() {
            return second;
        }

        public void setSecond(List<SecondBean> second) {
            this.second = second;
        }

        public static class FirstBean {
            /**
             * _id : 5da6ef19769bd3da6591b1e0
             * cover : https://img.yaofun.vip/2019/10/16/f884261a-effd-11e9-8970-0242ac13000d.png
             * create_time : 2019-09-26 14:39
             * hot : 0
             * label : 活动
             * label_url : https://img.yaofun.vip/2019/06/12/c61b17a8-8ce6-11e9-ab42-acde48001122.png
             * location : top
             * object_id : 5da572ac2618c157116256fb
             * purpose : 跳活动
             * title :
             * url :
             */

            private String _id;
            private String cover;
            private String create_time;
            private int hot;
            private String label;
            private String label_url;
            private String location;
            private String object_id;
            private String purpose;
            private String title;
            private String url;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getLabel_url() {
                return label_url;
            }

            public void setLabel_url(String label_url) {
                this.label_url = label_url;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }

            public String getPurpose() {
                return purpose;
            }

            public void setPurpose(String purpose) {
                this.purpose = purpose;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class SecondBean {
            /**
             * _id : 5da6f167769bd3da6591b1fd
             * cover : https://img.yaofun.vip/2019/10/16/0b8bb6f4-f000-11e9-8970-0242ac13000d.jpg
             * create_time : 2019-09-26 14:39
             * hot : 0
             * label : 活动
             * label_url : https://img.yaofun.vip/2019/06/12/c61b17a8-8ce6-11e9-ab42-acde48001122.png
             * location : top
             * object_id : 5da542c42618c157116255d2
             * purpose : 跳活动
             * title :
             * url :
             */

            private String _id;
            private String cover;
            private String create_time;
            private int hot;
            private String label;
            private String label_url;
            private String location;
            private String object_id;
            private String purpose;
            private String title;
            private String url;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getLabel_url() {
                return label_url;
            }

            public void setLabel_url(String label_url) {
                this.label_url = label_url;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }

            public String getPurpose() {
                return purpose;
            }

            public void setPurpose(String purpose) {
                this.purpose = purpose;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
