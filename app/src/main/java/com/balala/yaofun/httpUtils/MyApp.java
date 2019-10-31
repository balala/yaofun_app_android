package com.balala.yaofun.httpUtils;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApp extends Application {
    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5d3fbba33fc19519fb000296"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        //微信平台
        PlatformConfig.setWeixin("wx24009bcc9adc6318", "aa1643259ceb30e64ccef3a4ce63459b");
        myApp=this;
    }

    public static MyApp getInstance() {
        return myApp;
    }
}
