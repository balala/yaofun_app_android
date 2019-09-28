package com.balala.yaofun.myfrogetpasswardmvp;


import android.util.Log;
import android.widget.Toast;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.ChangeCodeBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;
import com.balala.yaofun.httpUtils.MyApp;
import com.balala.yaofun.httpUtils.ResultCallBack;

import java.io.IOException;

import okhttp3.ResponseBody;

import static org.greenrobot.eventbus.EventBus.TAG;

public class FrogetpasswardPresenter extends BasePresenter<FrogetpasswardView> {

    private FrogetpasswardModel frogetpasswardModel;

    @Override
    protected void initModel() {

        frogetpasswardModel = new FrogetpasswardModel();
    }


    // 发送验证码
    public void getSendData(String phone) {
        frogetpasswardModel.GetData(phone, new ResultCallBack<VerificationResult>() {
            @Override
            public void onSuccess(VerificationResult bean) throws IOException {

                if (bean != null) {
                    mView.onSuccessFrogetpasswardfly(bean);
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
//  phone, code, key, password
    public void getVerificationData(String phone, String code, String key) {
        frogetpasswardModel.GetData2(phone, code, key, new ResultCallBack<VerificationCode>() {
            @Override
            public void onSuccess(VerificationCode bean) throws IOException {

                if (bean != null) {
                    mView.onSuccessVerificationpassward(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFail: " + msg);
            }
        });
    }


    // 修改密码
    public void getAlterData(String phone, String code, String password,String key) {

        frogetpasswardModel.ChangepasswordData(phone, code, password,key, new ResultCallBack<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody bean) throws IOException {
                if (bean != null) {
                    mView.onSuccessAlterpassward(bean.toString());
                    Toast.makeText(MyApp.getInstance(), "更改成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(MyApp.getInstance(), "更改失败", Toast.LENGTH_SHORT).show();
                Log.d("更改密码", "onFail: " + msg);
            }
        });
    }
}
