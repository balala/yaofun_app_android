package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;

import java.io.IOException;

public interface Homeview extends BaseView {
    // 每日一句
    void onSuccessHome(BaseBean<DayBeans.DataBean> dayBean);

    void onFailHome(String msg);

    //首页数据解析
    void onSuccessHomeall(BaseBean<HomeAllBean.DataBean> homeAllBean);

    void onFailHomeall(String msg);

    //首页banner图
    void onSuccessBannerall(BaseBean<HomeBannerDean.DataBean> body);

    void onFailBannerall(String msg);
}
