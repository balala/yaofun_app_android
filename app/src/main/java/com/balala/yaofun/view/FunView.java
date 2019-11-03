package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.FunhomeData;

public interface FunView extends BaseView {
    void homefunSuccess(BaseBean<FunhomeData.DataBean> bean);

    void homefunFail(String msg);
}
