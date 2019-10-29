package com.balala.yaofun.view;

import okhttp3.ResponseBody;

public interface PromotionalActivitiesModel {
    void onActivitySuccess(ResponseBody body);

    void onActivityFail(String str);

}
