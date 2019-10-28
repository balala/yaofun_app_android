package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;

import java.io.IOException;

public interface Homeview extends BaseView {
    // 每日一句
    void onSuccessHome(DayBeans dayBean);

    void onFailHome(String msg);

    //首页数据解析
    void onSuccessHomeall(HomeAllBean homeAllBean) throws IOException;

    void onFailHomeall(String msg);

    //首页banner图
    void onSuccessBannerall(HomeBannerDean body) throws IOException;

    void onFailBannerall(String msg);
}
