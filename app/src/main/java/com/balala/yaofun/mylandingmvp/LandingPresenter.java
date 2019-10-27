package com.balala.yaofun.mylandingmvp;

import android.util.Log;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.result.LandingBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.httpUtils.ToastUtil;

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
//                    ToastUtil.showLong(bean.getMsg());
//                    if (bean.getData().get)
                    Log.i("xuzhiqi登陆model", "onSuccess: " + bean.getMsg());

                }

            }

            @Override
            public void onFail(String msg) {

//                ToastUtil.showLong(msg);
                Log.d("xuzhiqi登陆model", "onFail: " + msg);
            }
        });


    }
}
