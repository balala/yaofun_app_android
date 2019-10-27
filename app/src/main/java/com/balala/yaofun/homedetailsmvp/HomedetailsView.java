package com.balala.yaofun.homedetailsmvp;

import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.bean.result.HomedetailsBean;

public interface HomedetailsView extends BaseView {
    void onSuccessHomedetails(HomedetailsBean funhomeData);

    void onFailHomedetails(String msg);
}
