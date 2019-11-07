package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.MailListBean;
import com.balala.yaofun.bean.UserBean;

import java.util.List;

public interface MailListView extends BaseView {
    void mail_list_userSuccess(BaseBean<List<MailListBean>> bean);
    void mail_list_userFail(String msg);

}
