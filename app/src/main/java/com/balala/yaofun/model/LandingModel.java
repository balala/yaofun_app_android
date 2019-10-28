package com.balala.yaofun.model;

import android.util.Log;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.result.LandingBean;
import com.balala.yaofun.httpUtils.BaseObserver;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.util.MyServer;
import com.balala.yaofun.util.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LandingModel extends BaseModel {

    // 登陆解析
    public void LandingData(String phone, String password, ResultCallBack<LandingBean> resultCallBack) {

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", "-1");
        map.put("version", "-1");
        map.put("current_device", "安卓");
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("wx_unionid", "");
        map.put("password", password);
        map.put("request_start_time", Utils.getNowDate());
        map.put("phone", phone);
        Log.e("xuzhiqi", "登陆信息 " + "phone" + phone + "password" + password + "time" + Utils.getNowDate());

        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        Observable<LandingBean> data4 = apiserver.getLoginData(map);
        data4.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LandingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LandingBean landingBean) {
                        if (landingBean != null) {
                            Log.e("xuzhiqi登陆model", "登陆成功: " + landingBean.getMsg());
                            ToastUtil.showLong(landingBean.getMsg());
                            try {
                                resultCallBack.onSuccess(landingBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("xuzhiqi登陆model", "登陆失败: " + e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
