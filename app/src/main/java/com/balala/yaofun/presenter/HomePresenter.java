package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.view.Homeview;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.HomeModel;

import java.io.IOException;
import java.util.Map;

public class HomePresenter extends BasePresenter<Homeview> {

//    private HomeModel homeModel;
//
//    @Override
//    protected void initModel() {
//        homeModel = new HomeModel();
//    }


    // 顶部每日一句
    public void getHomeData(Map<String, ? extends Object> map) {
        ApiModel.homealldata(map,new ResultCallBack<>() {
            @Override
            public void onSuccess(Object bean) {
                mView.onSuccessBannerall((HomeBannerDean) bean
                );
            }

            @Override
            public void onFail(String msg) {

            }
        });
//        homeModel.HomeDayData(new ResultCallBack<DayBeans>() {
//            @Override
//            public void onSuccess(DayBeans bean) {
//
//                if (bean != null) {
//                    mView.onSuccessHome(bean);
//                }
//            }
//
//            @Override
//            public void onFail(String msg) {
//                mView.onFailHome(msg);
//            }
//        });
    }


    // 首页列表

    public void getHomeallData(String x, String y) {
//        homeModel.HomeData(x, y, new ResultCallBack<HomeAllBean>() {
//
//            @Override
//            public void onSuccess(HomeAllBean bean) {
//                if (bean != null) {
//                    mView.onSuccessHomeall(bean);
//                }
//
//            }
//
//            @Override
//            public void onFail(String msg) {
//                mView.onFailHomeall(msg);
//
//            }
//        });
    }

    //首页banner

    public void getHomeBannerData() {
//        homeModel.HomeBannerData(new ResultCallBack<HomeBannerDean>() {
//            @Override
//            public void onSuccess(HomeBannerDean bean) {
//                if (bean!=null){
//                    mView.onSuccessBannerall(bean);
//                }
//            }
//
//            @Override
//            public void onFail(String msg) {
//                mView.onFailBannerall(msg);
//            }
//        });
    }

}
