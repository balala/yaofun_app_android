package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;

public interface AuthenticationView extends BaseView {
    void getVerificationCodesSuccess(BaseBean<CodeBean> bean);
    void getVerificationCodesFail(String msg);

    void goVerifySuccess(BaseBean<CodeBean> bean);
    void goVerifyFail(String msg);

}
