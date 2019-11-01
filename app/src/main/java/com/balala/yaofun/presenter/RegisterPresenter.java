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


public class RegisterPresenter extends BasePresenter<RegisterView> {

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

    public void goRegist(Map<String, ? extends Object> map) {
        ApiModel.goRegist(map, new ResultCallBack<BaseBean<UserBean>>() {
            @Override
            public void onSuccess(BaseBean<UserBean> bean) {
                ForLog.e("请求成功" + bean);
                mView.goRegistSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.goRegistFail(msg);
            }
        });
    }


//    private RegisterModel myModel;
//
//    @Override
//    protected void initModel() {
//        myModel = new RegisterModel();
//    }

//
//    // 发送验证码
//    public void getData(String phone) {
//        myModel.GetData(phone, new ResultCallBack<VerificationResult>() {
//            @Override
//            public void onSuccess(VerificationResult bean) {
//                if (bean != null) {
//
//                    mView.onSS(bean);
//                }
//            }
//
//            @Override
//            public void onFail(String msg) {
//
//                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//    }
//
//    // 验证验证码
//    public void getData2(String phone, String code, String key) {
//
//        myModel.GetData2(phone, code, key, new ResultCallBack<VerificationCode>() {
//            @Override
//            public void onSuccess(VerificationCode bean) {
//                if (bean != null) {
//                    mView.onSuccessyanzheng(bean);
//                }
//
//            }
//
//            @Override
//            public void onFail(String msg) {
//                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//
//    // 注册成功
//    public void getData3(String phone, String code, String key, String password) {
//        myModel.getData3(phone, key, code, password, new ResultCallBack<RegisterBean>() {
//            @Override
//            public void onSuccess(RegisterBean bean) {
//                if (bean != null) {
//                    mView.onSuccessRegister(bean);
//                    Log.i("注册成功", "onSuccess: " + bean.getMsg());
//                    Toast.makeText(MyApp.getInstance(), bean.getMsg(), Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onFail(String msg) {
//
//                Toast.makeText(MyApp.getInstance(), msg, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

}
