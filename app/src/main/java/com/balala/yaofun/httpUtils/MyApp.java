package com.balala.yaofun.httpUtils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.event.LoginSuccessEvent;
import com.balala.yaofun.event.SignOutSuccessEvent;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ACache;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.util.Utils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

import static com.amap.api.maps.model.BitmapDescriptorFactory.getContext;
import static com.balala.yaofun.util.Utils.getNowDate;

public class MyApp extends Application {
    private static MyApp myApp;
    public static UserBean user=null;
    //手机唯一辨别码
    private static String unique_identifier;
    //用户自定义手机名称，暂时用来保存手机的各种信息
    private static String user_defined_name;
    //手机型号
    private static String phone_model;
    //手机版本
    private static String phone_version;
    private static SharedPreferences preferences1;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        //mark备注：为了方便测试登录注册模块，默认直接退出登录
//        signOut();

        RongIM.init(this,"25wehl3u2ggfw",true);

        UMConfigure.init(this,"5d3fbba33fc19519fb000296"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        //微信平台
        PlatformConfig.setWeixin("wx24009bcc9adc6318", "aa1643259ceb30e64ccef3a4ce63459b");

        //读取缓存登陆信息
        ACache aCache=ACache.get(this);
        user= (UserBean) aCache.getAsObject("user");
        if(user!=null){
            goLogin(user);
        }else{
            signOut();
        }
        ForLog.e("本地读取数据"+user);
        getPhoneInformation();


    }

    public static MyApp getInstance() {
        return myApp;
    }

    public static Map<String, Object> getBaseMap(Map<String,? extends Object> maps){
        Map<String, Object> map=new HashMap<>();
//        preferences1 = getContext().getSharedPreferences("users", Context.MODE_PRIVATE);
//        String id = preferences1.getString("id", "");
        map.put("version", '1');
        map.put("current_device", "android");
        map.put("unique_identifier", unique_identifier);
        map.put("user_defined_name", user_defined_name);
        //下载渠道
        map.put("download_channel", "未知");
        map.put("phone_version", phone_version);
        map.put("phone_model", phone_model);
        //请求时间
        map.put("request_start_time",getNowDate());
        if(maps!=null){
            for(Map.Entry<String,? extends Object> entry:maps.entrySet()){
                map.put(entry.getKey(),entry.getValue());
            }
        }
        if(hasLogin()){
            map.put("user_id", user.get_id());
            //sign=md5(request_start_time+用户id+key_ios+每次登陆返回的key)
            map.put("sign", Utils.md5(map.get("request_start_time")+user.get_id()+Utils.Signs+user.getKey()));
        }else{
            map.put("user_id", -1);
            map.put("sign", "");
        }
        ForLog.e("before api"+map);
        return map;
    }

    public static boolean hasLogin(){
        if(user!=null && user.get_id().length()>5){
            return true;
        }else{
            return false;
        }
    }

    //退出登录
    public static void signOut(){
        //登陆成功通用处理
        ACache aCache=ACache.get(myApp);
        aCache.remove("user");
        user=null;
        EventBus.getDefault().post(new SignOutSuccessEvent());
    }

    public static void goLogin(UserBean bean){
        //登陆成功通用处理
        ACache aCache=ACache.get(myApp);
        aCache.put("user",bean);
        user=bean;
        EventBus.getDefault().post(new LoginSuccessEvent());
        connectRongIM(user.getRc_token());
    }

    public static void connectRongIM(String token){
        ForLog.e("RongIM---token:"+token);
        token="pfvUiiCvjroEqa0usyOe2otDThrZbuv4tvKiHu/pQzVsegLaQ6JF2BwaRlEoj2Zaa/AQa+Gf9Tvejgc1rGk+pJ/HYc+h8E/j70dew6njt0bNJpgEfnLcZA==";
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                ForLog.e("RongIM---Token 错误");
//                ApiModel.getRCToken(null, new ResultCallBack<BaseBean<String>>() {
//                    @Override
//                    public void onSuccess(BaseBean<String> bean) {
//                        ForLog.e("请求成功" + bean);
//                        connectRongIM(bean.getData());
//                    }
//
//                    @Override
//                    public void onFail(String msg) {
//                        ForLog.e("RongIM---请求获取token失败:"+msg);
//                    }
//                });
            }
            @Override
            public void onSuccess(String userid) {
                ForLog.e("RongIM---onSuccess:"+userid);

            }
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                ForLog.e("RongIM---onError:"+errorCode);
            }
        });
    }

    @Override

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static void getPhoneInformation(){
        // Android获得屏幕分辨率补充，
        // 使用上面的方法在大多数情况下都是有效的，但是 在存在虚拟导航栏的手机上
        // 获取的分辨率却不对，例如1280*720的分辨率，获取出来并不是这么多，因为导航栏占据了一部分高度，这个时候使用
        // windowMgr.getDefaultDisplay().getRealMetrics(dm);     即可

        DisplayMetrics dm=new DisplayMetrics();
        WindowManager windowMgr= (WindowManager) myApp.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowMgr.getDefaultDisplay().getRealMetrics(dm);
        float width=dm.widthPixels*dm.density;
        float height=dm.heightPixels*dm.density;
        String information="[当前分辨率->"+width*height+"<-]";
        ActivityManager am= (ActivityManager) myApp.getSystemService(Context.ACTIVITY_SERVICE);
        int memoryClass=am.getMemoryClass();
        int largeMemoryClass=am.getLargeMemoryClass();
        information+="[内存大小->"+memoryClass+"<-]";
        information+="[最大内存->"+largeMemoryClass+"<-]";
        information+="[手机厂商->"+android.os.Build.MANUFACTURER+"<-]";
        //获取手机型号：
        phone_model=android.os.Build.MODEL;
        //获取版本号<--->当前sdk版本号
        phone_version=android.os.Build.VERSION.RELEASE+"<--->"+ Build.VERSION.SDK_INT ;
        user_defined_name=information;
        unique_identifier="35"+Build.BOARD.length() % 10 +
                Build.BRAND.length() % 10 +
                Build.CPU_ABI.length()  % 10 +
                Build.DEVICE.length()  % 10 +
                Build.DISPLAY.length()  % 10 +
                Build.HOST.length()  % 10 +
                Build.ID.length()  % 10 +
                Build.MANUFACTURER.length()  % 10 +
                Build.MODEL.length()  % 10 +
                Build.PRODUCT.length()  % 10 +
                Build.TAGS.length()  % 10 +
                Build.TYPE.length()  % 10 +
                Build.USER.length()  % 10;
        ForLog.e("获取到底unique_identifier"+unique_identifier);
    }
}
