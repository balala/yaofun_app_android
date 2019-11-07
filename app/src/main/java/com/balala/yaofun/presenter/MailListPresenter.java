package com.balala.yaofun.presenter;

import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.MailListBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.model.ApiModel;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.view.ConversationView;
import com.balala.yaofun.view.MailListView;

import java.util.List;
import java.util.Map;

public class MailListPresenter extends BasePresenter<MailListView> {

    public void mail_list_user(Map<String, ? extends Object> map) {
        ApiModel.mail_list_user(map, new ResultCallBack<BaseBean<List<MailListBean>>>() {
            @Override
            public void onSuccess(BaseBean<List<MailListBean>> bean) {
                ForLog.e("请求成功" + bean);
                mView.mail_list_userSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mView.mail_list_userFail(msg);
            }
        });
    }

}
