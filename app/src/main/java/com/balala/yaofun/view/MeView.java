package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.UserBean;

public interface MeView extends BaseView {
    void phonePwdLoginSuccess(BaseBean<UserBean> bean);

    void phonePwdLoginFail(String msg);

    void wxLoginOrRegistSuccess(BaseBean<UserBean> bean);

    void wxLoginOrRegistFail(String msg);




}
