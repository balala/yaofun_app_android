package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.FunhomeData;

public interface FunView extends BaseView {
    void onSuccessFun(FunhomeData funhomeData);

    void onFailFun(String msg);
}