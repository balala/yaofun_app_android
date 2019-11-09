package com.balala.yaofun.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.balala.yaofun.R;

public class PromotionalMapActivity extends AppCompatActivity implements LocationSource, AMapLocationListener {

    private MapView mMap;
    //    private MaterialSearchBar mSearchBar;
    private ListView mList;
    private AMap aMap;
    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotionalmap);
        initView();
    }

    private void initView() {
        mMap = (MapView) findViewById(R.id.map);
//        mSearchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        mList = (ListView) findViewById(R.id.list);
//在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
//        mMap.onCreate(savedInstanceState);

        //初始化地图控制器对象
        if (aMap == null) {
            aMap = mMap.getMap();
            UiSettings settings = aMap.getUiSettings();
            aMap.setLocationSource(this);//设置了定位的监听
            // 是否显示定位按钮
            settings.setMyLocationButtonEnabled(true);
            aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase
        }

    }

    private void location() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置定位间隔 默认采用连续定位模式，时间间隔为2000ms 可以自定义
        mLocationOption.setInterval(2000);
        //设置是否返回地址信息，默认返回
        mLocationOption.setNeedAddress(true);
        //设置是否允许模拟软件Mock位置结果，多为模拟GPS定位结果，默认为true，允许模拟位置
        mLocationOption.setMockEnable(true);
        //设置定位请求超时时间，默认为30秒
        mLocationOption.setHttpTimeOut(20000);
        //设置是否开启定位缓存机制 默认开启
        mLocationOption.setLocationCacheEnable(false);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }


    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        location();
    }
}
