package com.balala.yaofun.funfragmentmvp;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.httpUtils.BaseObserver;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.util.MyServer;
import com.balala.yaofun.util.Utils;

import org.greenrobot.eventbus.Subscribe;
import org.reactivestreams.Subscriber;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.internal.Util;

public class FunModel extends BaseModel {

    public void FunHomeData(ResultCallBack<FunhomeData> resultCallBack) {


        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id", "-1");
        map.put("version", "-1");
        map.put("current_device", "安卓");
        map.put("unique_identifier", "");
        map.put("download_channel", "");
        map.put("user_defined_name", "");
        map.put("phone_version", "");
        map.put("wx_unionid", "");
        map.put("phone_model", "");


        HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class)
                .getFunhomeData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<FunhomeData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FunhomeData funhomeData) {
                        if ( funhomeData.getData() != null) {
                            try {
                                resultCallBack.onSuccess(funhomeData);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }
}
