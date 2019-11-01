package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.view.HomedetailsView;
import com.balala.yaofun.httpUtils.ResultCallBack;

import java.util.HashMap;

public class HomedetailsPersenter extends BasePresenter<HomedetailsView> {


    public void getHomedetailsdata(String id, HashMap<String, String> map) {
        ApiModel.homedetailsdata(id, map, new ResultCallBack<BaseBean<HomedetailsBean.DataBean>>() {
            @Override
            public void onSuccess(BaseBean<HomedetailsBean.DataBean> bean) {
                if (bean != null) {
                    mView.onSuccessHomedetails(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                mView.onFailHomedetails(msg);
            }
        });
    }
}
