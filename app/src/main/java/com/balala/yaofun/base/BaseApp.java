package com.balala.yaofun.base;

import android.app.Application;
import android.content.Context;

import com.balala.yaofun.util.DeviceUuidFactory;

import java.util.UUID;

public class BaseApp extends Application {
    public static BaseApp sBaseApp;
    public static int mWidthPixels;
    public static int mHeightPixels;
    public UUID mUuid;
    public static String session="";
    public static String mToken="";
    public static String uSerId="";
    public static String mPhone="";
    public boolean mImIsLogin=false;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp=this;
        DeviceUuidFactory instance = DeviceUuidFactory.getInstance(getApplicationContext());
        mUuid = instance.getDeviceUuid();

    }

    @Override
    public Context getApplicationContext() {
        return sBaseApp.getApplicationContext();
    }

}
