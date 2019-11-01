package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.view.Homeview;
import com.balala.yaofun.httpUtils.ResultCallBack;

import java.util.Map;

public class HomePresenter extends BasePresenter<Homeview> {

    // 顶部每日一句
    public void getHomeData(Map<String, ? extends Object> map) {
        ApiModel.homedaydata(map, new ResultCallBack<BaseBean<DayBeans.DataBean>>() {
            @Override
            public void onSuccess(BaseBean<DayBeans.DataBean> bean) {
                mView.onSuccessHome(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.onFailHome(msg);
            }
        });
    }


    // 首页列表

    public void getHomeallData(Map<String, ? extends Object> map) {
        ApiModel.homealldata(map, new ResultCallBack<BaseBean<HomeAllBean.DataBean>>() {
            @Override
            public void onSuccess(BaseBean<HomeAllBean.DataBean> bean) {
                mView.onSuccessHomeall(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.onFailHomeall(msg);
            }
        });
    }

    //首页banner

    public void getHomeBannerData(Map<String, ? extends Object> map) {
        ApiModel.homebannerdata(map, new ResultCallBack<BaseBean<HomeBannerDean.DataBean>>() {
            @Override
            public void onSuccess(BaseBean<HomeBannerDean.DataBean> bean) {
                mView.onSuccessBannerall(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.onFailBannerall(msg);
            }
        });

    }

}
