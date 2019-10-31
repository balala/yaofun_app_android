package com.balala.yaofun.util;

import android.app.Application;

import com.balala.yaofun.bean.UserBean;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by $lzj on 2019/3/25.
 */
public class MyApp extends Application {

    private static MyApp myApp;
    public static UserBean user=null;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;

        //读取缓存登陆信息
        ACache aCache=ACache.get(this);
        UserBean user= (UserBean) aCache.getAsObject("user");
        ForLog.e("本地读取数据"+user);
        MyApp.user=user;
    }

    public static MyApp getMyApp() {
        return myApp;
    }

    public static Map<String, Object> getBaseMap(Map<String,? extends Object> maps){
        Map<String, Object> map=new HashMap<>();
        map.put("user_id", -1);
        map.put("version", '1');
        map.put("current_device", "Android");
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("key", "");

        for(Map.Entry<String,? extends Object> entry:maps.entrySet()){
            map.put(entry.getKey(),entry.getValue());
        }

        return map;
    }

    public static boolean hasLogin(){
        if(user!=null && user.get_id().length()>5){
            return true;
        }else{
            return false;
        }
    }
}
