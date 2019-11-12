package com.balala.yaofun.base;

public class BaseClickEvent implements BaseClickEventInterface{
    private BaseClickEventInterface clickEventInterface;
    public BaseClickEvent(BaseClickEventInterface clickEventInterface) {

    }

    @Override
    public void go() {

    }
}

interface BaseClickEventInterface{
    void go();

}


