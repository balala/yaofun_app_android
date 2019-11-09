package com.balala.yaofun.util;


import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.bean.MailListBean;
import com.balala.yaofun.bean.UploadPickBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.VerificationResult;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.bean.result.RegisterBean;
import com.balala.yaofun.bean.result.VerificationCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Dell on 2019/4/28.
 */

public interface MyServer {

    //   String url = "https://192.168.0.164:8088/api/";
//    String url = "https://test.yaofun.vip/api/";
//    String url = "http://192.168.110.131:5001/api/";
    String url = "https://api.yaofun.vip/api/";


    // http://test.yaofun.vip/api/verification_code/send
    // 发送验证码的接口 verification code
    @GET("verification_code/send")
    Observable<BaseBean<CodeBean>> getVerificationCode(@QueryMap Map<String, Object> map);


    //    http://test.yaofun.vip/verification_code/verification
    // 验证验证码的接口

    @POST("verification_code/verification")
    @FormUrlEncoded
    Observable<BaseBean<CodeBean>> getVerificationCodes(@FieldMap Map<String, Object> map2);

    // 注册接口
    @POST("user/regist")
    @FormUrlEncoded
    Observable<BaseBean<UserBean>> goRegist(@FieldMap Map<String, Object> map);

    // 登陆接口
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseBean<UserBean>> phonePwdLogin(@FieldMap Map<String, Object> map);

    // 微信登录
    @POST("user/wx_login_regist")
    @FormUrlEncoded
    Observable<BaseBean<UserBean>> wxLoginOrRegist(@FieldMap Map<String, Object> map);

    //更改密码接口
    @POST("user/change/password")
    @FormUrlEncoded
    Observable<BaseBean<UserBean>> goChangePassword(@FieldMap Map<String, Object> map);

    //融云token
    @GET("rong_cloud/getToken")
    Observable<BaseBean<String>> getRCToken(@QueryMap Map<String, Object> map);

    //用户或者群组详情
    @GET("user/detail/{user_id}")
    Observable<BaseBean<UserBean>> getUserDetail(@Path("user_id") String user_id, @QueryMap Map<String, Object> map);

    //顶部每日一句
    @GET("mood/one")
    Observable<BaseBean<DayBeans.DataBean>> getDayData(@QueryMap Map<String, Object> map);


    // 首页banner
//    http://test.yaofun.vip/api/rotary_planting_map/all
    @GET("rotary_planting_map/all")
    Observable<BaseBean<HomeBannerDean.DataBean>> getbannerData(@QueryMap Map<String, Object> map);

    // 通讯录：只包含好友
    @GET("user/mail_list_user")
    Observable<BaseBean<List<MailListBean>>> mail_list_user(@QueryMap Map<String, Object> map);

    //首页接口
    //http://test.yaofun.vip/api/activity/good_choice/all

    @GET("activity/good_choice/all")
    Observable<BaseBean<HomeAllBean.DataBean>> getDoodchoice(@QueryMap Map<String, Object> map);

    //发布活动
    //http://test.yaofun.vip/api/activity/upload
    @POST("activity/upload")
    @FormUrlEncoded
    Observable<ResponseBody> getReleaseactivitData(@FieldMap Map<String, Object> map);

    // fun团首页列表
    // http://test.yaofun.vip/api/user_group/recommend_1_8
    @GET("user_group/recommend_1_8")
    Observable<BaseBean<FunhomeData.DataBean>> getFunhomeData(@QueryMap Map<String, Object> map);

    @GET("activity/detail/{id}")
    Observable<BaseBean<HomedetailsBean.DataBean>> getHomedetailsData(@Path("id") String id, @QueryMap Map<String, Object> map);

    //  /activity/detail/5ce368ffe6b187cf63e4289a

    //上传图片
    //  https://test.yaofun.vip/api/activity/upload/image
    @Multipart
    @POST("activity/upload/image")
    Observable<UploadPickBean> getActivitDataimg(@Part("images") RequestBody body, @Part MultipartBody.Part file);

}
