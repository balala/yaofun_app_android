package com.balala.yaofun.homedetailsmvp;

import android.util.Log;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.httpUtils.BaseObserver;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.util.MyServer;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class HomedetailsModel extends BaseModel implements BaseView {

//
    public void homedetailsData(String id,ResultCallBack<HomedetailsBean> resultCallBack) {
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", "-1");
        map.put("version", "-1");
        map.put("current_device", "android");
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("wx_unionid", "");
//        .subscribeOn(Schedulers.io())
        apiserver.getHomedetailsData(id,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<HomedetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomedetailsBean responseBody) {
                        try {
                            resultCallBack.onSuccess(responseBody);
                            Log.i("首页详情解析", "成功" + responseBody.getMsg());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}
