package com.balala.yaofun.model;

import com.balala.yaofun.base.BaseModel;
import com.balala.yaofun.base.BaseView;
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.CodeBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.bean.MailListBean;
import com.balala.yaofun.bean.UserBean;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.bean.result.HomedetailsBean;
import com.balala.yaofun.httpUtils.HttpUtils;
import com.balala.yaofun.httpUtils.ResultCallBack;
import com.balala.yaofun.httpUtils.ResultException;
import com.balala.yaofun.util.ForLog;
import com.balala.yaofun.util.MyServer;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.balala.yaofun.MyApp.BaseUrl;
import static com.balala.yaofun.MyApp.getBaseMap;


public class ApiModel extends BaseModel implements BaseView {
    private static MyServer movieService = HttpUtils.getInstance().getApiserver(BaseUrl, MyServer.class);


    //获取用户详情
    public static void getUserDetail(String user_id, Map<String, ? extends Object> map, ResultCallBack<BaseBean<UserBean>> resultCallBack) {
        setSubscribe(movieService.getUserDetail(user_id, getBaseMap(map)), resultCallBack);
    }

    //通讯录：只包含好友
    public static void mail_list_user(Map<String, ? extends Object> map, ResultCallBack<BaseBean<List<MailListBean>>> resultCallBack) {
        setSubscribe(movieService.mail_list_user(getBaseMap(map)), resultCallBack);
    }

    //微信登录或者注册
    public static void wxLoginOrRegist(Map<String, ? extends Object> map, ResultCallBack<BaseBean<UserBean>> resultCallBack) {
        setSubscribe(movieService.wxLoginOrRegist(getBaseMap(map)), resultCallBack);
    }

    //手机号密码登录
    public static void phonePwdLogin(Map<String, ? extends Object> map, ResultCallBack<BaseBean<UserBean>> resultCallBack) {
        setSubscribe(movieService.phonePwdLogin(getBaseMap(map)), resultCallBack);
    }

    //注册获取验证码
    public static void getVerificationCode(Map<String, ? extends Object> map, ResultCallBack<BaseBean<CodeBean>> resultCallBack) {
        setSubscribe(movieService.getVerificationCode(getBaseMap(map)), resultCallBack);
    }

    //注册获取验证码
    public static void getVerifyCode(Map<String, ? extends Object> map, ResultCallBack<BaseBean<CodeBean>> resultCallBack) {
        setSubscribe(movieService.getVerificationCodes(getBaseMap(map)), resultCallBack);
    }


    //注册
    public static void goRegist(Map<String, ? extends Object> map, ResultCallBack<BaseBean<UserBean>> resultCallBack) {
        setSubscribe(movieService.goRegist(getBaseMap(map)), resultCallBack);
    }

    //找回密码
    public static void goChangePassword(Map<String, ? extends Object> map, ResultCallBack<BaseBean<UserBean>> resultCallBack) {
        setSubscribe(movieService.goChangePassword(getBaseMap(map)), resultCallBack);
    }

    //获取token
    public static void getRCToken(Map<String, ? extends Object> map, ResultCallBack<BaseBean<String>> resultCallBack) {
        setSubscribe(movieService.getRCToken(getBaseMap(map)), resultCallBack);
    }


    //fun团页数据
    public static void funhomedata(Map<String, ? extends Object> map, ResultCallBack<BaseBean<FunhomeData.DataBean>> resultCallBack) {
        setSubscribe(movieService.getFunhomeData(getBaseMap(map)), resultCallBack);
    }

    //首页banner
    public static void homebannerdata(Map<String, ? extends Object> map, ResultCallBack<BaseBean<HomeBannerDean.DataBean>> resultCallBack) {
        setSubscribe(movieService.getbannerData(getBaseMap(map)), resultCallBack);
    }

    //首页每日一句
    public static void homedaydata(Map<String, ? extends Object> map, ResultCallBack<BaseBean<DayBeans.DataBean>> resultCallBack) {
        setSubscribe(movieService.getDayData(getBaseMap(map)), resultCallBack);
    }

    //首页数据
    public static void homealldata(Map<String, ? extends Object> map, ResultCallBack<BaseBean<HomeAllBean.DataBean>> resultCallBack) {
        setSubscribe(movieService.getDoodchoice(getBaseMap(map)), resultCallBack);
    }

    //首页详情数据
    public static void homedetailsdata(String id, Map<String, ? extends Object> map, ResultCallBack<BaseBean<HomedetailsBean.DataBean>> resultCallBack) {
        setSubscribe(movieService.getHomedetailsData(id, (Map<String, Object>) map), resultCallBack);
    }

    private static <T> void setSubscribe(Observable<T> observable, ResultCallBack<T> resultCallBack) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(T landingBean) {
                        ForLog.e("请求数据成功" + landingBean);
                        resultCallBack.onSuccess(landingBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        ForLog.e("请求数据失败" + e.getMessage());
                        resultCallBack.onFail(e.getMessage());
                        if (e instanceof ResultException) {
                            ForLog.e("这里说明没有登陆成功" + e);
                            resultCallBack.onFail(((ResultException) e).getMsg());
                        } else {
                            ForLog.e("这里说明请求失败，或者解析失败" + e);
                            resultCallBack.onFail("网络连接超时，请稍后再试...");
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
