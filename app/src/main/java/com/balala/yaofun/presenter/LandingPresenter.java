package com.balala.yaofun.presenter;

import android.util.Log;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.result.LandingBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.model.LandingModel;
import com.balala.yaofun.view.LandingView;

import okhttp3.ResponseBody;

public class LandingPresenter extends BasePresenter<LandingView> {

    private LandingModel landingModel;

    @Override
    protected void initModel() {

        landingModel = new LandingModel();
    }

    public void getLandingData(String phone, String password) {
        landingModel.LandingData(phone, password, new ResultCallBack<LandingBean>() {

            @Override
            public void onSuccess(LandingBean bean) {
                if (bean != null) {
                    mView.onSuccessLanding(bean);
                    Log.i("xuzhiqi登陆model", "onSuccess: " + bean.toString());

                }

            }

            @Override
            public void onFail(String msg) {
                ToastUtil.showLong("登陆失败");
                Log.d("xuzhiqi登陆model", "onFail: " + msg);
            }
        });


    }
}
