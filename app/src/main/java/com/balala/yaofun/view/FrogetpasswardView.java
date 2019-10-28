package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.ChangeCodeBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.VerificationCode;

import okhttp3.ResponseBody;

public interface FrogetpasswardView extends BaseView {
    // 发送验证码
    void onSuccessFrogetpasswardfly(VerificationResult verificationResult);

    void onFailFrogetpassward(String msg);

    // 验证验证码
    void onSuccessVerificationpassward(VerificationCode verificationBean);

    void onFailVerificationpassward(String msg);

//     修改验证码
    void onSuccessAlterpassward(String str);

    void onFailAlterpassward(String msg);


}
