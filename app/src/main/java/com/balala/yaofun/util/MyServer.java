package com.balala.yaofun.util;


import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.bean.result.LandingBean;
import com.balala.yaofun.bean.result.RegisterBean;
import com.balala.yaofun.bean.result.VerificationCode;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Dell on 2019/4/28.
 */

public interface MyServer {

    //   String url = "https://192.168.0.164:8088/api/";
    // String url = "http://192.168.110.144:5001/api/";
//    String url = "https://test.yaofun.vip/api/";
    String url = "http://192.168.110.131:5001/api/";
//    String url = "https://api.yaofun.vip/api";

    // http://test.yaofun.vip/api/verification_code/send
    // 发送验证码的接口 verification code
    @GET("verification_code/send")
    Observable<VerificationResult> getVerificationCode(@QueryMap HashMap<String, Object> map);


    //    http://test.yaofun.vip/verification_code/verification
    // 验证验证码的接口

    @POST("verification_code/verification")
    @FormUrlEncoded
    Observable<VerificationCode> getVerificationCodes(@FieldMap HashMap<String, Object> map2);

    // 注册接口
    @POST("user/regist")
    @FormUrlEncoded
    Observable<RegisterBean> getRegistData(@FieldMap Map<String, Object> map);

    // 登陆接口
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseBean<UserBean>> phonePwdLogin(@FieldMap Map<String, Object> map);

    // 微信登录
    @POST("user/wx_login_regist")
    @FormUrlEncoded
    Observable<BaseBean<UserBean>> wxLoginOrRegist(@FieldMap Map<String, Object> map);

    //更改密码接口
    //  http://192.168.0.164:8088/api/user/change/password?
    //api/user/change/password?
    @POST("user/change/password")
    @FormUrlEncoded
    Observable<ResponseBody> getChangePasswardData(@FieldMap Map<String, Object> map);

    //顶部每日一句
    // https://test.yaofun.vip/api/mood/one

    @GET("mood/one")
    Observable<DayBeans> getDayData(@QueryMap HashMap<String, Object> map);


    // 首页banner
//    http://test.yaofun.vip/api/rotary_planting_map/all
    @GET("rotary_planting_map/all")
    Observable<HomeBannerDean> getbannerData(@QueryMap HashMap<String, Object> map);


    //首页接口
    //http://test.yaofun.vip/api/activity/good_choice/all

    @GET("activity/good_choice/all")
    Observable<HomeAllBean> getDoodchoice(@QueryMap HashMap<String, Object> map);

    //发布活动
    //http://test.yaofun.vip/api/activity/upload
    @POST("activity/upload")
    @FormUrlEncoded
    Observable<ResponseBody> getReleaseactivitData(@FieldMap Map<String, Object> map);

    // fun团首页列表
    // http://test.yaofun.vip/api/user_group/recommend_1_8
    @GET("user_group/recommend_1_8")
    Observable<FunhomeData> getFunhomeData(@QueryMap HashMap<String, Object> map);

    @GET("activity/detail/{id}")
    Observable<HomedetailsBean> getHomedetailsData(@Path("id") String id, @QueryMap HashMap<String, Object> map);

    //  /activity/detail/5ce368ffe6b187cf63e4289a

}
