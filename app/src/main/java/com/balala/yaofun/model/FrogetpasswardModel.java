package com.balala.yaofun.model;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.balala.yaofun.activity.FrogetpasswardActivity;
import com.balala.yaofun.activity.GeneralActivity;
import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.bean.IdentifyingBean;
import com.balala.yaofun.bean.VerificationBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.MyApp;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.util.MyServer;
import com.balala.yaofun.util.ToastUtils;
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

public class FrogetpasswardModel extends BaseModel {
    private IdentifyingBean identifying;

    private String key;
    private int code;
    private VerificationBean verificationBean;
    private String time;

    //  发送验证码解析
    public void GetData(String phone, final ResultCallBack<VerificationResult> listBeanResultCallBack) {

        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        identifying = new IdentifyingBean();
        identifying.setUser_id("-1");
        identifying.setVersion("-1");
        identifying.setCurrent_device("安卓");
        Log.e("发送验证码解析", "initData: " + Utils.getNowDate());
        identifying.setRequest_start_time(Utils.getNowDate());
        identifying.setPhone(phone);
        Log.e("发送验证码解析", "initData: " + identifying.getPhone());
        identifying.setPurpose("找回密码");
        //设置签名
        identifying.setSign2(Utils.md5(identifying.getRequest_start_time() + identifying.getPhone() + Utils.Signs));

        Log.e("发送验证码解析", "GetData: " + identifying.getSign2());
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
                            Log.e("发送验证码解析出来的", "onNext: " + verificationResult.getData().toString()+"\n"+verificationResult.getData().getCode()+"\n"+verificationResult.getData().getKey());
                            try {
                                listBeanResultCallBack.onSuccess(verificationResult);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

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
        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
        verificationBean = new VerificationBean();
        verificationBean.setUser_id("-1");
        verificationBean.setVersion("-1");
        verificationBean.setCurrent_device("安卓");
        Log.e("xuzhiqi", "initData: " + Utils.getNowDate());
        verificationBean.setRequest_start_time(Utils.getNowDate());
        verificationBean.setPhone(phone);
        verificationBean.setCode(code);
        verificationBean.setKey(key);
        verificationBean.setPhone(phone);
        Log.e("xuzhiqi", "initData: " + verificationBean.getPhone());
        verificationBean.setPurpose("找回密码");
        verificationBean.setSign2(Utils.md5(verificationBean.getRequest_start_time() + verificationBean.getPhone() + Utils.Signs));
        //设置签名
//        verificationBean.setSign2(identifying.getSign2());

        Log.e("xuzhiqi2", "GetData: " + identifying.getSign2());
        // 创建一个集合 来存储数据
        final HashMap<String, Object> map2 = new HashMap<>();
        // map.put("key",key); key
        map2.put("user_id", verificationBean.getUser_id());
        map2.put("version", verificationBean.getVersion());
        map2.put("current_device", verificationBean.getCurrent_device());
        map2.put("unique_identifier", "");
        map2.put("user_defined_name", "");
        map2.put("download_channel", "");
        map2.put("phone_version", "");
        map2.put("phone_model", "");
        map2.put("wx_unionid", "");
        map2.put("request_start_time", verificationBean.getRequest_start_time());
        map2.put("phone", verificationBean.getPhone());
        map2.put("purpose", verificationBean.getPurpose());
        map2.put("sign2", verificationBean.getSign2());
        map2.put("key", verificationBean.getKey());
        map2.put("code", verificationBean.getCode());

        Observable<VerificationCode> data = apiserver.getVerificationCodes(map2);
        data.subscribeOn(Schedulers.io());
        data.observeOn(AndroidSchedulers.mainThread());
        data.subscribe(new Observer<VerificationCode>() {

            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(VerificationCode verificationBean) {
                try {
                    verificationBeanResultCallBack.onSuccess(verificationBean);
                    Log.e("验证验证码", "onError: " + verificationBean.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable e) {
                Log.e("验证验证码", "onError: " + e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });

    }


    // 修改密码解析
    public void ChangepasswordData(String phone, String code, String password, String key, ResultCallBack<ResponseBody> resultCallBack) {

        MyServer apiserver = HttpUtils.getInstance().getApiserver(MyServer.url, MyServer.class);
//        apiserver.getChangePasswardData()
        HashMap<String, Object> changemap = new HashMap<>();
        String nowDate = Utils.getNowDate();
        changemap.put("user_id", "-1");
        changemap.put("version", "-1");
        changemap.put("current_device", "安卓");
        changemap.put("unique_identifier", "");
        changemap.put("user_defined_name", "");
        changemap.put("download_channel", "");
        changemap.put("phone_version", "");
        changemap.put("phone_model", "");
        changemap.put("wx_unionid", "");
        changemap.put("request_start_time", nowDate);
        changemap.put("phone", phone);
        changemap.put("purpose", "找回密码");
        changemap.put("password", password);
        time = Utils.md5(nowDate + phone + Utils.Signs);
        changemap.put("sign2", time);
        changemap.put("key", key);
        changemap.put("code", code);

        Log.e("修改密码 M层 解析", "修改密码 M层 解析: " + time + "\n" + phone + "\n" + key + "\n" + code + "\n" + password + "\n" + nowDate);


        apiserver.getChangePasswardData(changemap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        try {
                            Log.i("修改密码 M层 解析", "onSubscribe: " + responseBody.string());
                           // ToastUtil.showLong("更改密码成功");
//                            startActivity(new Intent(FrogetpasswardActivity.this, GeneralActivity.class));
//                            Toast.makeText(MyApp.getInstance(), responseBody.toString(), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }


                    @Override
                    public void onError(Throwable e) {

                        ToastUtil.showLong("更改密码失败");

//                        Toast.makeText(MyApp.getInstance(), e.toString(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
