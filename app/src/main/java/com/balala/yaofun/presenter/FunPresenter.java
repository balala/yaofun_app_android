package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.view.FunView;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.FunModel;

import java.io.IOException;

public class FunPresenter extends BasePresenter<FunView> implements ResultCallBack<FunhomeData> {
    private FunModel funModel;
//    @Override
//    protected void initModel() {
//        funModel = new FunModel();
//    }

    public void getFunData(){
        funModel.FunHomeData(this);
    }

    @Override
    public void onSuccess(FunhomeData bean) {
            mView.onSuccessFun(bean);
    }

    @Override
    public void onFail(String msg) {
            mView.onFailFun(msg);
    }
}
