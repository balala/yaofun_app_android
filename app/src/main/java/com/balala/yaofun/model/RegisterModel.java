package com.balala.yaofun.model;

import android.util.Log;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.IdentifyingBean;
import com.balala.yaofun.bean.VerificationBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.LandingBean;
import com.balala.yaofun.bean.result.RegisterBean;
import com.balala.yaofun.bean.result.VerificationCode;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.util.MyServer;
import com.balala.yaofun.util.Utils;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class RegisterModel extends BaseModel {
    private IdentifyingBean identifying;

    private String key;
    private int code;
    private VerificationBean verificationBean;

    //  发送验证码解析
    public void GetData(String phone, final ResultCallBack<VerificationResult> listBeanResultCallBack) {

        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        identifying = new IdentifyingBean();
        identifying.setUser_id("-1");
        identifying.setVersion("-1");
        identifying.setCurrent_device("安卓");
        Log.e("xuzhiqi", "initData: " + Utils.getNowDate());
        identifying.setRequest_start_time(Utils.getNowDate());
        identifying.setPhone(phone);
        Log.e("xuzhiqi", "initData: " + identifying.getPhone());
        identifying.setPurpose("注册");
        //设置签名
        identifying.setSign2(Utils.md5(identifying.getRequest_start_time() + identifying.getPhone() + Utils.Signs));

        Log.e("xuzhiqis", "GetData: " + identifying.getSign2());
        // 创建一个集合 来存储数据
        final HashMap<String, Object> map = new HashMap<>();
        // map.put("key",key); key
        map.put("user_id", identifying.getUser_id());
        map.put("version", identifying.getVersion());
        map.put("current_device", identifying.getCurrent_device());
        map.put("unique_identifier", "");
        map.put("user_defined_name", "");
        map.put("download_channel", "");
        map.put("phone_version", "");
        map.put("phone_model", "");
        map.put("wx_unionid", "");
        map.put("request_start_time", identifying.getRequest_start_time());
        map.put("phone", identifying.getPhone());
        map.put("purpose", identifying.getPurpose());
        map.put("sign2", identifying.getSign2());
        Observable<VerificationResult> data = apiserver.getVerificationCode(map);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VerificationResult>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(VerificationResult verificationResult) {

                        if (verificationResult != null) {
                            code = verificationResult.getData().getCode();
                            key = verificationResult.getData().getKey();
                            Log.e("发送验证码解析出来的", "onNext: " + verificationResult.getData().toString());
                            Log.e("发送验证码解析出来的", "code: " + verificationResult.getData().getCode());
                            Log.e("发送验证码解析出来的", "key: " + verificationResult.getData().getKey());
                            listBeanResultCallBack.onSuccess(verificationResult);


                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    // 验证验证码解析
    public void GetData2(String phone, String code, String key, final ResultCallBack<VerificationCode> verificationBeanResultCallBack) {
//        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
//        verificationBean = new VerificationBean();
//        verificationBean.setUser_id("-1");
//        verificationBean.setVersion("-1");
//        verificationBean.setCurrent_device("安卓");
//        Log.e("xuzhiqi", "initData: " + Utils.getNowDate());
//        verificationBean.setRequest_start_time(Utils.getNowDate());
//        verificationBean.setPhone(phone);
//        verificationBean.setCode(code);
//        verificationBean.setKey(key);
//        verificationBean.setPhone(phone);
//        Log.e("xuzhiqi", "initData: " + verificationBean.getPhone());
//        verificationBean.setPurpose("注册");
//        verificationBean.setSign2(Utils.md5(verificationBean.getRequest_start_time() + verificationBean.getPhone() + Utils.Signs));
//        //设置签名
////        verificationBean.setSign2(identifying.getSign2());
//
//        Log.e("xuzhiqi2", "GetData: " + identifying.getSign2());
//        // 创建一个集合 来存储数据
//        final HashMap<String, Object> map2 = new HashMap<>();
//        // map.put("key",key); key
//        map2.put("user_id", verificationBean.getUser_id());
//        map2.put("version", verificationBean.getVersion());
//        map2.put("current_device", verificationBean.getCurrent_device());
//        map2.put("unique_identifier", "");
//        map2.put("user_defined_name", "");
//        map2.put("download_channel", "");
//        map2.put("phone_version", "");
//        map2.put("phone_model", "");
//        map2.put("wx_unionid", "");
//        map2.put("request_start_time", verificationBean.getRequest_start_time());
//        map2.put("phone", verificationBean.getPhone());
//        map2.put("purpose", verificationBean.getPurpose());
//        map2.put("sign2", verificationBean.getSign2());
//        map2.put("key", verificationBean.getKey());
//        map2.put("code", verificationBean.getCode());
//
//        Observable<VerificationCode> data = apiserver.getVerificationCodes(map2);
//        data.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<VerificationCode>() {
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        compositeDisposable.add(d);
//                    }
//
//                    @Override
//                    public void onNext(VerificationCode verificationBean) {
//                        verificationBeanResultCallBack.onSuccess(verificationBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("xuzhiqi", "onError: " + e.getMessage());
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }

    // 注册解析方法
    public void getData3(String phone, String key, String code, String password, ResultCallBack<RegisterBean> resultCallBack) {
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        // 创建一个集合 来存储数据
        final HashMap<String, Object> map2 = new HashMap<>();
        String nowDate = Utils.getNowDate();
        // map.put("key",key); key
        map2.put("user_id", "-1");
        map2.put("version", "-1");
        map2.put("current_device", "安卓");
        map2.put("unique_identifier", "");
        map2.put("user_defined_name", "");
        map2.put("download_channel", "");
        map2.put("phone_version", "");
        map2.put("phone_model", "");
        map2.put("wx_unionid", "");
        map2.put("request_start_time", nowDate);
        map2.put("phone", phone);
        map2.put("password", password);
        map2.put("purpose", "注册");
        map2.put("sign2", Utils.md5(nowDate + phone + Utils.Signs));
        Log.e("xuzhiqi", "getData3: " + Utils.getNowDate() + "\n" + phone + "\n" + key + "\n" + code + "\n" + password);
        map2.put("key", key);
        map2.put("code", code);
        apiserver.getRegistData(map2).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean responseBody) {
                        Log.e("注册成功", "onNext: " + responseBody.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("xuzhiqi", "onNext: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
