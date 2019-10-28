package com.balala.yaofun.model;

import android.util.Log;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.httpUtils.BaseObserver;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.util.MyServer;
import com.balala.yaofun.util.Utils;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel extends BaseModel {
    private static final String TAG = "xuzhiqi";
//    private HomeBean homeBean;

    // 传过来用户的id和sign的值
    private String sign = "1";
    // 用户登陆的Id
    private String userId = "1";

    // 顶部每日一句
    public void HomeDayData(ResultCallBack<DayBeans> resultCallBack) {
        // 顶部每日一句的解析
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        final HashMap<String, Object> map = new HashMap<>();
        // map.put("key",key); key
        map.put("user_id", "-1");
        map.put("version", "-1");
        map.put("current_device", "安卓");
        map.put("unique_identifier", "");
        map.put("download_channel", "");
        map.put("user_defined_name", "");
        map.put("phone_version", "");
        map.put("wx_unionid", "");
        map.put("phone_model", "");
        apiserver.getDayData(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<DayBeans>() {

                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(DayBeans dayBean) {
                        if (dayBean != null) {
                            Log.i(TAG, "onNext: " + dayBean.toString());
                            try {
                                resultCallBack.onSuccess(dayBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    // 首页解析
    public void HomeData(String x, String y, ResultCallBack<HomeAllBean> resultCallBack) {
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", "-1");
        map.put("version", "-1");
        map.put("current_device", "安卓");
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("wx_unionid", "");
        map.put("max_distance", "5000");
        map.put("x", x);
        map.put("y", y);
        Log.i("啦啦啦啦", "经纬度HomeData: " + x + y);
        // sign=md5(request_start_time+用户id+key_ios+每次登陆返回的key)
        String nowDate = Utils.getNowDate();
        map.put("request_start_time", nowDate);
        sign = Utils.md5(nowDate + userId + "安卓" + "1");
        map.put("sign", sign);
        Log.i("首页", "进入app时间 " + nowDate + "/n" + "进入app的sign" + sign);
        Log.i("时间", "HomeData: " + nowDate);
        apiserver.getDoodchoice(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomeAllBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeAllBean homeAllBean) {
                        if (homeAllBean != null) {
                            try {
                                resultCallBack.onSuccess(homeAllBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            Log.e("首页homeBean", "解析失败");
                        }

                    }
                });

    }

    //首页banner解析
    public void HomeBannerData(ResultCallBack<HomeBannerDean> resultCallBack) {
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", "1");
        map.put("version", "1");
        map.put("unique_identifier", "");
        map.put("current_device", "安卓");
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("page", "0");
        map.put("pageSize", "10");
        apiserver.getbannerData(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomeBannerDean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBannerDean responseBody) {
                        try {
                            resultCallBack.onSuccess(responseBody);
                            Log.i("首页banner解析", "成功" + responseBody.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}
