package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.LandingView;

import java.util.Map;

public class LandingPresenter extends BasePresenter<LandingView> {


    public void phonePwdLogin(Map<String, ? extends Object> map) {
        ApiModel.phonePwdLogin(map, new ResultCallBack<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> bean) {
                ForLog.e("请求成功" + bean);
                mView.phonePwdLoginSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.phonePwdLoginFail(msg);
            }
        });
    }

    public void wxLoginOrRegist(Map<String, ? extends Object> map) {
        ApiModel.wxLoginOrRegist(map, new ResultCallBack<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> bean) {
                ForLog.e("请求成功" + bean);
                mView.wxLoginOrRegistSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.wxLoginOrRegistFail(msg);
            }
        });
    }


}
