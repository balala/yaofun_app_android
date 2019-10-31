package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.result.LandingBean;

public interface LandingView extends BaseView {
    void onSuccessLanding(LandingBean bean);

    void onErrorLanding(String error);

    void wxLoginOrRegistSuccess(BaseBean<UserBean> bean);

    void wxLoginOrRegistFail();
}
