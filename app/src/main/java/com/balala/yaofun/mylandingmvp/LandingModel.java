package com.balala.yaofun.mylandingmvp;

import android.util.Log;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.result.LandingBean;
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

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LandingModel extends BaseModel {

    private AccountBean accountBean;

    // 登陆解析
    public void LandingData(String phone, String password, ResultCallBack<LandingBean> resultCallBack) {
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        accountBean = new AccountBean();
        accountBean.setUser_id("-1");
        accountBean.setVersion("-1");
        accountBean.setCurrent_device("安卓");
        Log.e("xuzhiqi", "initData: " + Utils.getNowDate());
        accountBean.setRequest_start_time(Utils.getNowDate());
        accountBean.setPhone(phone);
        accountBean.setPassword(password);
        Log.e("xuzhiqi", "initData: " + accountBean.getPhone());
        //设置签名

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", accountBean.getUser_id());
        map.put("version", accountBean.getVersion());
        map.put("current_device", accountBean.getCurrent_device());
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("wx_unionid", "");
        map.put("password", accountBean.getPassword());
        map.put("request_start_time", accountBean.getRequest_start_time());
        map.put("phone", accountBean.getPhone());
        Observable<LandingBean> data4 = apiserver.getLoginData(map);
        data4.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LandingBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LandingBean landingBean) {
                        if (landingBean != null) {
                            Log.e("登陆成功出来的", "登陆成功: " + landingBean.getMsg());
//                            ToastUtil.showLong("登陆成功");

                            try {
                                resultCallBack.onSuccess(landingBean);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                        ToastUtil.showLong("登陆失败");

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
