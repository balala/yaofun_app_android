package com.balala.yaofun.httpUtils;

import android.widget.Toast;

import com.balala.yaofun.MyApp;


/**
 * Created by asus on 2019/3/5.
 */

public class ToastUtil {
    public static void showShort(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(MyApp.getInstance(),msg, Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        //避免内存泄漏的一个方法,用到上下文的地方,能用application的就application
        Toast.makeText(MyApp.getInstance(),msg, Toast.LENGTH_LONG).show();
    }
}
