package com.balala.yaofun.presenter;


import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.FrogetpasswardView;

import java.util.Map;

public class FrogetpasswardPresenter extends BasePresenter<FrogetpasswardView> {


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

    public void goChangePassword(Map<String, ? extends Object> map) {
        ApiModel.goChangePassword(map, new ResultCallBack<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> bean) {
                ForLog.e("请求成功" + bean);
                mView.goChangePasswordSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.goChangePasswordFail(msg);
            }
        });
    }
}
