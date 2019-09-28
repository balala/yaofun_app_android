package com.balala.yaofun.mylandingmvp;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.AccountBean;
import com.balala.yaofun.bean.result.DefaultBean;

public interface LandingView extends BaseView {
    void onSuccessLanding(DefaultBean bean);

    void onErrorLanding(String error);
}
