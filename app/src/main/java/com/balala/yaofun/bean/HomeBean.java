package com.balala.yaofun.bean;

public class HomeBean extends AllBean{

    private String x;
    private String y;
    private String sign;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "max_distance='"  + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
