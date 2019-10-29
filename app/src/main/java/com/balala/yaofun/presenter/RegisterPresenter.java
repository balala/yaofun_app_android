package com.balala.yaofun.presenter;

import android.util.Log;
import android.widget.Toast;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.RegisterBean;
import com.balala.yaofun.bean.result.VerificationCode;
import com.balala.yaofun.httpUtils.MyApp;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.RegisterModel;
import com.balala.yaofun.view.RegisterView;

import java.io.IOException;

import okhttp3.ResponseBody;

import static org.greenrobot.eventbus.EventBus.TAG;


public class RegisterPresenter extends BasePresenter<RegisterView> {

    private RegisterModel myModel;

    @Override
    protected void initModel() {
        myModel = new RegisterModel();
    }


    // 发送验证码
    public void getData(String phone) {
        myModel.GetData(phone, new ResultCallBack<VerificationResult>() {
            @Override
            public void onSuccess(VerificationResult bean) {
                if (bean != null) {

                    mView.onSS(bean);
                }
            }

            @Override
            public void onFail(String msg) {

                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onFail: " + msg);
            }
        });


    }

    // 验证验证码
    public void getData2(String phone, String code, String key) {

        myModel.GetData2(phone, code, key, new ResultCallBack<VerificationCode>() {
            @Override
            public void onSuccess(VerificationCode bean) {
                if (bean != null) {
                    mView.onSuccessyanzheng(bean);
                }

            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFail: " + msg);
            }
        });

    }

    // 注册成功
    public void getData3(String phone, String code, String key, String password) {
        myModel.getData3(phone, key, code, password, new ResultCallBack<RegisterBean>() {
            @Override
            public void onSuccess(RegisterBean bean) throws IOException {
                if (bean != null) {
                    mView.onSuccessRegister(bean);
                    Log.i("注册成功", "onSuccess: " + bean.getMsg());
                    Toast.makeText(MyApp.getInstance(), bean.getMsg(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFail(String msg) {

                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
