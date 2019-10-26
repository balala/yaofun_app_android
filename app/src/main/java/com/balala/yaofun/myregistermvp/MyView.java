package com.balala.yaofun.myregistermvp;


import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;

public interface MyView extends BaseView {

    void onSS(VerificationResult verificationResult);

    void onFail(String msg);

    void onSuccessyanzheng(VerificationCode verificationBean);

    void onFails(String msg);


    void onSuccessRegister(String sucess);

    void onError(String error);

    void onSuccessRegisterss(String sucess);

    void onErrors(String msg);

}
