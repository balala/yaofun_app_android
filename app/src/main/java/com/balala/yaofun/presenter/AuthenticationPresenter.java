package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.AuthenticationView;

import java.util.Map;

public class AuthenticationPresenter extends BasePresenter<AuthenticationView> {
    public void getVerificationCode(Map<String, ? extends Object> map) {
        ApiModel.getVerificationCode(map, new ResultCallBack<BaseBean<CodeBean>>() {
            @Override
            public void onSuccess(BaseBean<CodeBean> bean) {
                ForLog.e("请求成功" + bean);
                mView.getVerificationCodesSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.getVerificationCodesFail(msg);
            }

        });
    }

    public void getVerifyCode(Map<String, ? extends Object> map) {
        ApiModel.getVerifyCode(map, new ResultCallBack<BaseBean<CodeBean>>() {
            @Override
            public void onSuccess(BaseBean<CodeBean> bean) {
                ForLog.e("请求成功" + bean);
                mView.goVerifySuccess(bean);

            }

            @Override
            public void onFail(String msg) {
                mView.goVerifyFail(msg);
            }
        });

    }


}
