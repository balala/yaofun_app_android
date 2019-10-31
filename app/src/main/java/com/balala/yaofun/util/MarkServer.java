package com.balala.yaofun.util;

import com.balala.yaofun.bean.result.LandingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MarkServer<T> {

    // 登陆接口
    @POST("user/login")
    @FormUrlEncoded
    Observable<T> getLoginData(@FieldMap Map<String, Object> map);

}
