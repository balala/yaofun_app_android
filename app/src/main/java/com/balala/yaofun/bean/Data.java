package com.balala.yaofun.bean;

public class Data {
    public static final int TYPE_ONE = 1;//类型1
    public static final int TYPE_TWO = 2;//类型2
    public static final int TYPE_TREE = 3;//类型2
    public static final int TYPE_FOUR = 4;//类型2
    public static final int TYPE_FORE = 5;//类型2
    public static final int TYPE_SIX = 6;//类型2
    public static final int TYPE_SEVEN = 7;//类型2
    public static final int TYPE_EIGHT = 8;//类型2

    public int type;//item内容 类型

    public int icon;
    public String username;
    public String message;

    public Data(int type, int icon, String username, String message) {
        this.type = type;
        this.icon = icon;
        this.username = username;
        this.message = message;
    }

    public static int getTypeOne() {
        return TYPE_ONE;
    }

    public static int getType_FOUR() {
        return TYPE_FOUR;
    }

    public static int getTypeFORE() {
        return TYPE_FORE;
    }

    public static int getTypeSIX() {
        return TYPE_SIX;
    }

    public static int getTypeSEVEN() {
        return TYPE_SEVEN;
    }

    public static int getTypeEIGHT() {
        return TYPE_EIGHT;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
