package com.balala.yaofun.view;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.bean.result.HomedetailsBean;

public interface HomedetailsView extends BaseView {
    void onSuccessHomedetails(BaseBean<HomedetailsBean.DataBean> funhomeData);

    void onFailHomedetails(String msg);
}
