package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.RegisterView;

import java.util.Map;


public class PromotionalActivitiesPresenter extends BasePresenter<RegisterView> {

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

}
