package com.balala.yaofun.view;


import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.RegisterBean;
import com.balala.yaofun.bean.result.VerificationCode;

public interface RegisterView extends BaseView {

    void getVerificationCodesSuccess(BaseBean<CodeBean> bean);
    void getVerificationCodesFail(String msg);

    void goRegistSuccess(BaseBean<UserBean> bean);
    void goRegistFail(String msg);

}
