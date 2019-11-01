package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.ChangeCodeBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;

import okhttp3.ResponseBody;

public interface FrogetpasswardView extends BaseView {
    void getVerificationCodesSuccess(BaseBean<CodeBean> bean);
    void getVerificationCodesFail(String msg);
    void goChangePasswordSuccess(BaseBean<UserBean> bean);
    void goChangePasswordFail(String msg);
}
