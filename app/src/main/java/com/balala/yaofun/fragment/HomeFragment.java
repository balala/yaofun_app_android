package com.balala.yaofun.fragment;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.balala.yaofun.R;
import com.balala.yaofun.activity.CreateFunActivity;
import com.balala.yaofun.activity.HomedetailsActivity;
import com.balala.yaofun.activity.PromotionalActivitiesActivity;
import com.balala.yaofun.activity.SearchActivity;
import com.balala.yaofun.adapter.HomeAdapter;
import com.balala.yaofun.adapter.HomeAroundAdapter;
import com.balala.yaofun.adapter.HomeRecommendAdapter;
import com.balala.yaofun.base.BaseFragment;
import com.balala.yaofun.bean.result.DayBeans;
import com.balala.yaofun.bean.result.HomeAllBean;
import com.balala.yaofun.bean.result.HomeBannerDean;
import com.balala.yaofun.presenter.HomePresenter;
import com.balala.yaofun.view.Homeview;
import com.balala.yaofun.util.ToastUtils;
import com.balala.yaofun.zxing.activity.CaptureActivity;
import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * extends BaseActivity<FrogetpasswardPresenter, FrogetpasswardView> implements FrogetpasswardView
 */
public class HomeFragment extends BaseFragment<HomePresenter, Homeview> implements Homeview {

    @BindView(R.id.home_background)
    ImageView homeBackground;
    @BindView(R.id.homescan)
    ImageView homescan;
    @BindView(R.id.codetext)
    TextView codetext;
    @BindView(R.id.daytext)
    TextView daytext;
    @BindView(R.id.monthtext)
    TextView monthtext;
    @BindView(R.id.tabootext)
    TextView tabootext;
    @BindView(R.id.people_icon)
    ImageView peopleIcon;
    @BindView(R.id.people_title)
    TextView peopleTitle;
    @BindView(R.id.people_name)
    TextView people_name;
    @BindView(R.id.people_content)
    TextView peopleContent;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.home_rl)
    RelativeLayout homeRl;
    @BindView(R.id.home_search)
    ImageView homeSearch;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.home_add)
    ImageView homeAdd;
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.recycle_view1)
    RecyclerView recycleView1;
    @BindView(R.id.recycle_view2)
    RecyclerView recycleView2;
    @BindView(R.id.recycle_view3)
    RecyclerView recycleView3;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    //    @BindView(R.id.home_search2)
//    ImageView homeSearch2;
//    @BindView(R.id.recycle_view4)
//    RecyclerView recycleView4;
    @BindView(R.id.home_outparty)
    ImageView homeOutparty;
    @BindView(R.id.home_createparty)
    ImageView homeCreateparty;
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.sw)
    ScrollView sw;
    @BindView(R.id.sitetext)
    TextView sitetext;
    @BindView(R.id.homeperchs)
    ImageView homeperchs;

    private PopupWindow popupWindow;
    private int reclen = 3;
    Timer timer = new Timer();
    private AMapLocationClientOption mLocationOption;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;//权限请求码
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    private double latitude;
    private double longitude;
    private AMapLocationClient aMapLocationClient;
    private String y;
    private String x;

    @SuppressLint("HandlerLeak")
    final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    reclen--;
                    Message message = handler.obtainMessage(1);
                    handler.sendMessageDelayed(message, 4000);
                    popupWindow.dismiss();
            }

            super.handleMessage(msg);
        }
    };
    private List<HomeBannerDean.DataBean.FirstBean> first;
    private List<HomeBannerDean.DataBean.SecondBean> second;
    private HomeAdapter homeAdapter;
    private HomeAroundAdapter homeAroundAdapter;
    private HomeRecommendAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onSuccessHome(DayBeans dayBean) {

        // 在这收值
        Log.i("每日一句话解析", "onSuccessHome: " + dayBean.toString());
//        SharedPreferences preferences = getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
//        boolean aBoolean = preferences.getBoolean("flag", false);
//        if (aBoolean) {
////            Log.i("onCheckedChanged", "第二次登陆完了");
//            getDatas();
//
//        } else {
//            codetext.setText(dayBean.getData().getNumber_time());
        daytext.setText(dayBean.getData().getSolar_time());
        monthtext.setText(dayBean.getData().getLunar_time());
        tabootext.setText(dayBean.getData().getPrompt());
        people_name.setText(dayBean.getData().getUse_time());
        homeBackground.setColorFilter(R.color.colorblacks);
        Glide.with(this).load(dayBean.getData().getImg()).into(homeBackground);
        peopleTitle.setText(dayBean.getData().getTitle());
        peopleContent.setText(dayBean.getData().getContent());
//        }

    }


    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {

        private String longitudex;
        private String latitudey;
        private String allStringMoney;

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            //初始化定位
            aMapLocationClient = new AMapLocationClient(getContext().getApplicationContext());
            //设置定位回调监听
            aMapLocationClient.setLocationListener(mLocationListener);
            latitude = aMapLocation.getLatitude();
            longitude = aMapLocation.getLongitude();
            double abs = Math.abs(longitude);
            y = String.valueOf(latitude);
            x = String.valueOf(abs);
            presenter.getHomeallData(x, y);
            Log.i("经纬度homeFragment", "纬度 ----------------" + " " + x);//获取纬度
            Log.i("经纬度homeFragment", "经度-----------------" + " " + y);//获取经度

        }
    };

    @Override
    public void onFailHome(String msg) {
        Log.i("xzq", "onFailHome: " + msg);
    }

    @Override
    public void onSuccessHomeall(HomeAllBean homeAllBean) throws IOException {

        Log.i("首页解析", "onSuccessHome: " + homeAllBean.toString());
        //热门
        List<HomeAllBean.DataBean.HotBean> hot = homeAllBean.getData().getHot();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycleView1.setLayoutManager(linearLayoutManager);
        Log.e(TAG, "onSuccessHomeall: " + first);
        homeAdapter = new HomeAdapter(getContext(), (ArrayList<HomeAllBean.DataBean.HotBean>) hot, (ArrayList<HomeBannerDean.DataBean.FirstBean>) first);
        recycleView1.setAdapter(homeAdapter);
        //展示全部的recycleView
        recycleView1.setNestedScrollingEnabled(false);
        homeAdapter.notifyDataSetChanged();
        // 解析成功显示布局
        sw.setVisibility(View.VISIBLE);

        //附近
        List<HomeAllBean.DataBean.AroundBean> around = homeAllBean.getData().getAround();
        Log.i("around", "onSuccessHomeall: " + around.toString());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recycleView2.setLayoutManager(gridLayoutManager);
        homeAroundAdapter = new HomeAroundAdapter(getContext(), (ArrayList<HomeAllBean.DataBean.AroundBean>) around);
        recycleView2.setAdapter(homeAroundAdapter);
        homeAroundAdapter.notifyDataSetChanged();
        //展示全部的recycleView
        recycleView2.setNestedScrollingEnabled(false);

        //推荐
        List<HomeAllBean.DataBean.RecommendBean> recommend = homeAllBean.getData().getRecommend();
        LinearLayoutManager linearLayout = new LinearLayoutManager(getContext());
        recycleView3.setLayoutManager(linearLayout);
        Log.e(TAG, "onSuccessHomeall: " + second);
        adapter = new HomeRecommendAdapter(getContext(), (ArrayList<HomeAllBean.DataBean.RecommendBean>) recommend, (ArrayList<HomeBannerDean.DataBean.SecondBean>) second);
        recycleView3.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //热门适配器点击事件
        homeAdapter.setOnClickListener(new HomeAdapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                String id = hot.get(position).get_id();
                Intent intent = new Intent(getContext(), HomedetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
//                startActivity(new Intent(getContext(), HomedetailsActivity.class));
            }
        });
        homeAdapter.setOnClickListenerBanner(new HomeAdapter.OnClickListenerBanner() {
            @Override
            public void OnClick(int position) {
                HomeBannerDean.DataBean.FirstBean firstBean = new HomeBannerDean.DataBean.FirstBean();
                String id = firstBean.get_id();
                Intent intent = new Intent(getContext(), HomedetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
//                startActivity(new Intent(getContext(), HomebannerdetailsActivity.class));
            }
        });

        //附近适配器点击事件
        homeAroundAdapter.setOnClickListener(new HomeAdapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                String id = around.get(position).get_id();
                Intent intent = new Intent(getContext(), HomedetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        //推荐适配器点击事件
        adapter.setOnClickListener(new HomeAdapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                String id = recommend.get(position).get_id();
                Intent intent = new Intent(getContext(), HomedetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        adapter.setOnClickListenerBanner(new HomeAdapter.OnClickListenerBanner() {
            @Override
            public void OnClick(int position) {
                HomeBannerDean.DataBean.SecondBean secondBean = new HomeBannerDean.DataBean.SecondBean();
                String id = secondBean.get_id();
                Intent intent = new Intent(getContext(), HomedetailsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onFailHomeall(String msg) {
        Log.i(TAG, "onFailHomeall: " + msg);
    }

    @Override
    public void onSuccessBannerall(HomeBannerDean body) throws IOException {
        Log.i("首页解析banner", "onSuccessBannerall: " + body);
        first = body.getData().getFirst();
        second = body.getData().getSecond();
    }


    @Override
    public void onFailBannerall(String msg) {
        Log.i(TAG, "onFailBannerall: " + msg);
    }

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_home;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initData() {
        // 开启定位
        startLocaion();
        presenter.getHomeData();
        presenter.getHomeBannerData();
    }

    @Override
    protected HomePresenter initGeekP() {
        return new HomePresenter();
    }

    @Override
    protected void initListener() {
        sitetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //倒计时 方法三
                Message message = handler.obtainMessage(1);
                handler.sendMessageDelayed(message, 1000);
                View mPopView = getLayoutInflater().inflate(R.layout.popwindow_calender, null);
                popupWindow = new PopupWindow(mPopView, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                popupWindow.showAtLocation(homeSearch, Gravity.BOTTOM, 0, 0);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
            }
        });

        homescan.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // 开启相机权限
                initCreame();

            }
        });

        homeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转搜索页面
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
            // 解析所需要的方法
        });

        //首页红色按钮添加页面
        homeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳入
                startActivity(new Intent(getContext(), PromotionalActivitiesActivity.class));
            }
        });

        //创建fun团页面
        homeCreateparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CreateFunActivity.class));
            }
        });
        // 立即组局页面
        homeOutparty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PromotionalActivitiesActivity.class));
            }
        });
        super.initListener();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initCreame() {
        // 获取相机权限
        //在执行扫描二维码之前检查是否具有打开照相机的权限
        try {
            int hasWriteContactsPermission = getContext().checkSelfPermission(Manifest.permission.CAMERA);//权限检查
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CAMERA},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;//没有权限，结束
            } else {
                // 跳转扫码页面
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showLong("权限异常");
        }

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 200://刚才的识别码
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意权限,执行我们的操作
//                    startLocaion();//开始定位
//                } else {//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
//                    Toast.makeText(getContext(), "未开启定位权限,请手动到设置去开启权限", Toast.LENGTH_LONG).show();
//                }
//                break;
//            default:
//                break;
//        }
//    }

    // 集成地图接口
    public void startLocaion() {

        // 集成地图接口
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        } else {
            Log.i(TAG, "已开启定位权限 ");

        }
        Log.i("走", "开始走了");
        mLocationClient = new AMapLocationClient(getContext().getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

    }


    // for SmartRefreshLayout
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                ClassicsFooter footer = new ClassicsFooter(context).setDrawableSize(20);
                footer.setFinishDuration(0);
                return footer;
            }
        });

    }

}

