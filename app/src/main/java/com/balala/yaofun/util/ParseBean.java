//package com.balala.yaofun.util;
//
//
//import android.util.Log;
//import java.io.File;
//import java.io.IOException;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.concurrent.TimeUnit;
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import io.reactivex.Observable;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.observers.DisposableObserver;
//import io.reactivex.schedulers.Schedulers;
//import okhttp3.Cache;
//import okhttp3.CacheControl;
//import okhttp3.ConnectionPool;
//import okhttp3.HttpUrl;
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
///**
// * 封装Retrofit配置
// */
//
//public class RetrofitFactory_8090 {
//    public String TAG = "RetrofitFactory_8090";
//
//    public static final String CACHE_NAME = "quantum";
//    public static String BASE_URL = URLConstant.BASE_URL_8090;
//    private static final int DEFAULT_CONNECT_TIMEOUT = 30;
//    private static final int DEFAULT_WRITE_TIMEOUT = 30;
//    private static final int DEFAULT_READ_TIMEOUT = 30;
//    private static final String Authorization_PRE = "Bearer ";
//    private Retrofit retrofit;
//    private HttpApi httpApi;
//    /**
//     * 请求失败重连次数
//     */
//    private int RETRY_COUNT = 0;
//    private OkHttpClient.Builder okHttpBuilder;
//    private OkHttpClient.Builder reloginBuilder;
//    private String authorization = "";
//
//    //构造方法私有
//    private RetrofitFactory_8090() {
//        //手动创建一个OkHttpClient并设置超时时间
//        okHttpBuilder = new OkHttpClient.Builder();
//        /**
//         * 设置缓存
//         */
//        File cacheFile = new File(App.getInstance().app.getFilesDir(),
//                CACHE_NAME);
//
//        authorization = SPUtils.getInstance(ApplicationConfig.SP.SP_FILE)
//                .getString(ApplicationConfig.SP.Authorization_NAME, "");
//
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//        Interceptor cacheInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                if (!NetUtils.isNetworkConnected()) {
//                    request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//                }
//                Response response = chain.proceed(request);
//                if (!NetUtils.isNetworkConnected()) {
//                    int maxAge = 0;
//                    // 有网络时 设置缓存超时时间0个小时
//                    response.newBuilder()
//                            .header("Cache-Control", "public, max-age=" + maxAge)
//                            .removeHeader(CACHE_NAME)// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                            .build();
//                } else {
//                    // 无网络时，设置超时为4周
//                    int maxStale = 60 * 60 * 24 * 28;
//                    response.newBuilder()
//                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                            .removeHeader(CACHE_NAME)
//                            .build();
//                }
//                return response;
//            }
//        };
//        okHttpBuilder.cache(cache).addInterceptor(cacheInterceptor);
//
//        /**
//         * SSL认证问题
//         * */
//        TrustManager[] trustAllCerts = {new X509TrustManager() {
//            @Override
//            public X509Certificate[] getAcceptedIssuers() {
//                X509Certificate[] x509Certificates = new X509Certificate[0];
//                return x509Certificates;
//            }
//
//            @Override
//            public void checkClientTrusted(X509Certificate[] chain, String authType)
//                    throws CertificateException {
//                // Not implemented
//            }
//
//            @Override
//            public void checkServerTrusted(X509Certificate[] chain, String authType)
//                    throws CertificateException {
//                // Not implemented
//            }
//        }
//        };
//
//        try {
//            SSLContext sc = SSLContext.getInstance("TLS");
//            sc.init(null, trustAllCerts, new java.security.SecureRandom());
//            okHttpBuilder.sslSocketFactory(sc.getSocketFactory());
//            okHttpBuilder.hostnameVerifier(new HostnameVerifier() {
//
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    //强行返回true 即验证成功
//                    return true;
//                }
//            });
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        /**
//         * 设置头信息
//         */
//        Interceptor headerInterceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                LogUtil.i(authorization);
//                Request originalRequest = chain.request();
//                Request.Builder requestBuilder = originalRequest.newBuilder()
//                        .addHeader("Accept", "application/json")
//                        .addHeader("Content-Type", "application/json; charset=utf-8")
//                        .method(originalRequest.method(), originalRequest.body());
//                // 获取url
//                Request req = chain.request();
//                HttpUrl url = req.url();
//                // 判断URL是否需要添加token请求头
//                LogUtil.i(url.encodedPath() + " " + UrlFilterUtil.isCanUseToken(url.encodedPath()));
//                if (UrlFilterUtil.isCanUseToken(url.encodedPath())) {
//                    requestBuilder// 设置认证头
//                            .addHeader("Authorization", Authorization_PRE + authorization);
//                    Log.e("wz", "intercept: "+authorization );
//                }
//                //添加请求头信息，服务器进行token有效性验证
//                Request request = requestBuilder.build();
//                return chain.proceed(request);
//            }
//        };
//        okHttpBuilder.addInterceptor(headerInterceptor);
//
//
//        if (ApplicationConfig.Debug.IS_DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//                @Override
//                public void log(String message) {
//                    LogUtil.i("hello:" + message);
//                }
//            });
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            //设置 Debug Log 模式
//            okHttpBuilder.addInterceptor(loggingInterceptor);
//        }
//
//        /**
//         * 设置再次登录
//         * */
//        okHttpBuilder.addInterceptor(new LoginInterceptor());
//
//        /**
//         * 设置超时和重新连接
//         */
//        okHttpBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
//        okHttpBuilder.readTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
//        okHttpBuilder.writeTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
//        //错误重连
//        okHttpBuilder.retryOnConnectionFailure(true);
//        okHttpBuilder.connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS));
//
//        retrofit = new Retrofit.Builder()
//                .client(okHttpBuilder.build())
//                .addConverterFactory(GsonConverterFactory.create())//json转换成JavaBean
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(BASE_URL)
//                .build();
//        httpApi = retrofit.create(HttpApi.class);
//    }
//
//    //在访问HttpMethods时创建单例
//    private static class SingletonHolder {
//        private static final RetrofitFactory_8090 INSTANCE = new RetrofitFactory_8090();
//
//    }
//
//    //获取单例
//    public static RetrofitFactory_8090 getInstance() {
//        return SingletonHolder.INSTANCE;
//    }
//
//    /**
//     * 获取retrofit
//     *
//     * @return
//     */
//    public Retrofit getRetrofit() {
//        return retrofit;
//    }
//
//    public void changeBaseUrl(String baseUrl) {
//        retrofit = new Retrofit.Builder()
//                .client(okHttpBuilder.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(baseUrl)
//                .build();
//        httpApi = retrofit.create(HttpApi.class);
//    }
//
//    /**
//     * 获取httpService
//     *
//     * @return
//     */
//    public HttpApi getHttpApi() {
//        return httpApi;
//    }
//
//    /**
//     * 设置订阅 和 所在的线程环境
//     */
//    public <T> void toSubscribe(Observable<T> o, DisposableObserver<T> s) {
//
//        o.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .retry(RETRY_COUNT)//请求失败重连次数
//                .subscribe(s);
//
//    }
//
//    /**
//     * 登录或注册成功，获取authorization
//     * */
//    public void setAuthorization(String authorization) {
//        this.authorization = authorization;
//    }
//
//    // 重新登录
//    private ReLoginService reLoginService;
//
//    public ReLoginService getReloginService() {
//        if (reLoginService == null) {
//            reloginBuilder = new OkHttpClient.Builder();
//            /**
//             * 设置缓存
//             */
//            File cacheFile = new File(App.getInstance().app.getFilesDir(),
//                    CACHE_NAME);
//
//            authorization = SPUtils.getInstance(ApplicationConfig.SP.SP_FILE)
//                    .getString(ApplicationConfig.SP.Authorization_NAME, "");
//
//            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//            Interceptor cacheInterceptor = new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request();
//                    if (!NetUtils.isNetworkConnected()) {
//                        request = request.newBuilder()
//                                .cacheControl(CacheControl.FORCE_CACHE)
//                                .build();
//                    }
//                    Response response = chain.proceed(request);
//                    if (!NetUtils.isNetworkConnected()) {
//                        int maxAge = 0;
//                        // 有网络时 设置缓存超时时间0个小时
//                        response.newBuilder()
//                                .header("Cache-Control", "public, max-age=" + maxAge)
//                                .removeHeader(CACHE_NAME)// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
//                                .build();
//                    } else {
//                        // 无网络时，设置超时为4周
//                        int maxStale = 60 * 60 * 24 * 28;
//                        response.newBuilder()
//                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                                .removeHeader(CACHE_NAME)
//                                .build();
//                    }
//                    return response;
//                }
//            };
//            reloginBuilder.cache(cache).addInterceptor(cacheInterceptor);
//
//            /**
//             * SSL认证问题
//             * */
//            TrustManager[] trustAllCerts = {new X509TrustManager() {
//                @Override
//                public X509Certificate[] getAcceptedIssuers() {
//                    X509Certificate[] x509Certificates = new X509Certificate[0];
//                    return x509Certificates;
//                }
//
//                @Override
//                public void checkClientTrusted(X509Certificate[] chain, String authType)
//                        throws CertificateException {
//                    // Not implemented
//                }
//
//                @Override
//                public void checkServerTrusted(X509Certificate[] chain, String authType)
//                        throws CertificateException {
//                    // Not implemented
//                }
//            }
//            };
//
//            try {
//                SSLContext sc = SSLContext.getInstance("TLS");
//                sc.init(null, trustAllCerts, new java.security.SecureRandom());
//                reloginBuilder.sslSocketFactory(sc.getSocketFactory());
//                reloginBuilder.hostnameVerifier(new HostnameVerifier() {
//
//                    @Override
//                    public boolean verify(String hostname, SSLSession session) {
//                        //强行返回true 即验证成功
//                        return true;
//                    }
//                });
//            } catch (KeyManagementException e) {
//                e.printStackTrace();
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//
//            /**
//             * 设置头信息
//             */
//            Interceptor headerInterceptor = new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    LogUtil.i(authorization);
//                    Request originalRequest = chain.request();
//                    Request.Builder requestBuilder = originalRequest.newBuilder()
//                            .addHeader("Accept", "application/json")
//                            .addHeader("Content-Type", "application/json; charset=utf-8")
//                            .method(originalRequest.method(), originalRequest.body());
////                requestBuilder.addHeader("Authorization", "Bearer " + BaseConstant.TOKEN);//添加请求头信息，服务器进行token有效性验证
//                    Request request = requestBuilder.build();
//                    return chain.proceed(request);
//                }
//            };
//            reloginBuilder.addInterceptor(headerInterceptor);
//
//
//            if (ApplicationConfig.Debug.IS_DEBUG) {
//                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//                    @Override
//                    public void log(String message) {
//                        LogUtil.i("hello:" + message);
//                    }
//                });
//                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                //设置 Debug Log 模式
//                reloginBuilder.addInterceptor(loggingInterceptor);
//            }
//
//            reloginBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
//            reloginBuilder.readTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
//            reloginBuilder.writeTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
//            //错误重连
//            reloginBuilder.retryOnConnectionFailure(true);
//            reloginBuilder.connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS));
//
//
//            reLoginService = new Retrofit.Builder()
//                    .client(reloginBuilder.build())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .baseUrl(BASE_URL)
//                    .build().create(ReLoginService.class);
//        }
//        return reLoginService;
//
//    }
//}