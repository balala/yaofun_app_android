package com.balala.yaofun.mylandingmvp;

import android.util.Log;
import android.widget.Toast;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.result.DefaultBean;
import com.balala.yaofun.httpUtils.MyApp;
import com.balala.yaofun.httpUtils.ResultCallBack;

public class LandingPresenter extends BasePresenter<LandingView> {

    private LandingModel landingModel;

    @Override
    protected void initModel() {

        landingModel = new LandingModel();
    }

    public void getLandingData(String phone, String password) {
        landingModel.LandingData(phone, password, new ResultCallBack<DefaultBean>() {

            @Override
            public void onSuccess(DefaultBean bean) {
                if (bean != null) {
                    mView.onSuccessLanding(bean);
                    Toast.makeText(MyApp.getInstance(), bean.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFail(String msg) {

                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();

                Log.d("xuzhiqi", "onFail: " + msg);
            }
        });


    }
}
