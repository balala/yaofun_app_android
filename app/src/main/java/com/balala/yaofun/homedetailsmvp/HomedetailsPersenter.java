package com.balala.yaofun.homedetailsmvp;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.httpUtils.ResultCallBack;

import java.io.IOException;

import okhttp3.ResponseBody;

public class HomedetailsPersenter extends BasePresenter<HomedetailsView> {

    private HomedetailsModel homedetailsModel;

    @Override
    protected void initModel() {
        homedetailsModel = new HomedetailsModel();
    }

    public void getHomedetailsdata(String id) {
        homedetailsModel.homedetailsData(id, new ResultCallBack<HomedetailsBean>() {
            @Override
            public void onSuccess(HomedetailsBean bean) throws IOException {
                if (bean!=null){
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
