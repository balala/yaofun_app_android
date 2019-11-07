package com.balala.yaofun.bean;

public class MailListUserBean {
    private String images;
    private String name;
    private String object_id;
    private String pinyin;
    private String type;
    private String zimu;
    public void setImages(String images) {
        this.images = images;
    }
    public String getImages() {
        return images;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }
    public String getObject_id() {
        return object_id;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    public String getPinyin() {
        return pinyin;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public String getZimu() {
        return zimu;
    }

    public void setZimu(String zimu) {
        this.zimu = zimu;
    }

    @Override
    public String toString() {
        return "MailListUserBean{" +
                "images='" + images + '\'' +
                ", name='" + name + '\'' +
                ", object_id='" + object_id + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", type='" + type + '\'' +
                ", zimu='" + zimu + '\'' +
                '}';
    }
}
