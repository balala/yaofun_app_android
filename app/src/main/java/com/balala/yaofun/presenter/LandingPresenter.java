package com.balala.yaofun.presenter;

import android.util.Log;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.result.LandingBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.httpUtils.ToastUtil;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.model.LandingModel;
import com.balala.yaofun.util.ACache;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.LandingView;

import java.util.HashMap;
import java.util.Map;

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
    public void wxLoginOrRegist(Map<String,? extends Object> map){
        ApiModel.wxLoginOrRegist(map, new ResultCallBack<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> bean) {
                ForLog.e("请求成功"+bean);
                mView.wxLoginOrRegistSuccess(bean);
            }
            @Override
            public void onFail(String msg) {

            }
        });
    }
}
