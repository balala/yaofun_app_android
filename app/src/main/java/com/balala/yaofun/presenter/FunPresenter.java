package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.FunView;
import com.balala.yaofun.httpUtils.ResultCallBack;

import java.util.Map;

public class FunPresenter extends BasePresenter<FunView>  {

    public void funhomeData(Map<String, ? extends Object> map) {
        ApiModel.funhomedata(map, new ResultCallBack<BaseBean<FunhomeData>>() {
            @Override
            public void onSuccess(BaseBean<FunhomeData> bean) {
                ForLog.e("请求成功" + bean);
                mView.homefunSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.homefunFail(msg);
            }
        });
    }
}
