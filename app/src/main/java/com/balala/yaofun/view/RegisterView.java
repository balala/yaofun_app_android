package com.balala.yaofun.view;


import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.RegisterBean;
import com.balala.yaofun.bean.result.VerificationCode;

public interface RegisterView extends BaseView {

    void getVerificationCodesSuccess(BaseBean<CodeBean> bean);
    void getVerificationCodesFail(String msg);

//    void onSS(VerificationResult verificationResult);
//
//    void onFail(String msg);
//
//    void onSuccessyanzheng(VerificationCode verificationBean);
//
//    void onFails(String msg);
//
//
//    void onSuccessRegister(RegisterBean bean);
//
//    void onError(String error);

//    void onSuccessRegisterss(String sucess);
//
//    void onErrors(String msg);

}
