package com.balala.yaofun.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.camera2.params.BlackLevelPattern;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.balala.yaofun.R;
import com.balala.yaofun.util.MapUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.balala.yaofun.R.color.black;

//implements LocationSource, AMapLocationListener
public class AmapRouteActivity extends AppCompatActivity {
    private MapView mMap;
    private Bundle savedInstanceState;
    private LinearLayout mMapll;
    private ImageView mMapback;
    /**
     * 亚运村图书大厦（北京市朝阳区）
     */
    private TextView mMaptext1;
    /**
     * 亚运村图书大厦（北京市朝阳区）
     */
    private TextView mMaptex2;
    private ImageView mMapgo;
    private AMap aMap;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private LocationSource.OnLocationChangedListener mListener;
    private CloudSearch mCloudSearch;
    private CloudSearch.Query mQuery;
    private ArrayList<CloudItem> mCloudItems;
    private String address;
    private String latitude;
    private String longitude;
    private LocationSource.OnLocationChangedListener mlistener;
    private AMapLocationClient client;
    private AMapLocationClientOption option;
    private int latitudes;
    private int longitudes;
    private UiSettings mUiSettings;
    private CameraUpdate mUpdata;
    private String name;
    private TextView mapbackground;
    private RelativeLayout maprl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initView();
    }

    private void initView() {
        // 渲染系统toolbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mMap = (MapView) findViewById(R.id.map);
        mMap.onCreate(savedInstanceState);
        mMapll = (LinearLayout) findViewById(R.id.mapll);
        maprl = (RelativeLayout) findViewById(R.id.maprl);
        mMapback = (ImageView) findViewById(R.id.mapback);
        mMaptext1 = (TextView) findViewById(R.id.maptext1);
        mMaptex2 = (TextView) findViewById(R.id.maptex2);
        mMapgo = (ImageView) findViewById(R.id.mapgo);

        Intent intent = getIntent();
        address = intent.getStringExtra("address");
        name = intent.getStringExtra("name");
        latitude = intent.getStringExtra("latitude");
        address = intent.getStringExtra("address");
        longitude = intent.getStringExtra("longitude");

        //转换为Int类型
        latitudes = Double.valueOf(latitude).intValue();
        //转换为Int类型
        longitudes = Double.valueOf(longitude).intValue();
        mMaptext1.setText(name);
        mMaptex2.setText(address);
        Log.i("经纬度啦啦", "initView: " + "latitudes" + latitudes + "longitudes" + longitudes);
        //完成当前页面操作
        mMapback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AMap aMap = null;
        if (aMap == null) {
            aMap = mMap.getMap();
        }
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。

        init();
        mMapgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                maprl.setBackground();
                View mPopView = getLayoutInflater().inflate(R.layout.mappopupitem, null);
                PopupWindow popupWindow = new PopupWindow();
                popupWindow.setContentView(mPopView);
                popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(mMap, Gravity.BOTTOM, 0, 0);
                TextView gaode = mPopView.findViewById(R.id.gaode);
                TextView baidu = mPopView.findViewById(R.id.baidu);
                TextView tengxun = mPopView.findViewById(R.id.tengxun);
                TextView mapcancel = mPopView.findViewById(R.id.mapcancel);
                gaode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (MapUtil.isGdMapInstalled()) {
                            MapUtil.openGaoDeNavi(AmapRouteActivity.this, 0, 0, null, latitudes, longitudes, address);
                        } else {
                            //这里必须要写逻辑，不然如果手机没安装该应用，程序会闪退，这里可以实现下载安装该地图应用
                            Toast.makeText(AmapRouteActivity.this, "尚未安装高德地图", Toast.LENGTH_SHORT).show();
                        }

                    }

                });
                baidu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (MapUtil.isBaiduMapInstalled()) {
                            MapUtil.openBaiDuNavi(AmapRouteActivity.this, 0, 0, null, latitudes, longitudes, address);
                        } else {
                            Toast.makeText(AmapRouteActivity.this, "尚未安装百度地图", Toast.LENGTH_SHORT).show();
                        }


                    }

                });
                tengxun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (MapUtil.isTencentMapInstalled()) {
                            MapUtil.openTencentMap(AmapRouteActivity.this, 0, 0, null, latitudes, longitudes, address);
                        } else {
                            Toast.makeText(AmapRouteActivity.this, "尚未安装腾讯地图", Toast.LENGTH_SHORT).show();
                        }

                    }

                });
                mapcancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }

                });
            }
        });
    }

    /**
     *     * 初始化AMap对象
     *    
     */

    private void init() {
        if (aMap == null) {
            aMap = mMap.getMap();
            mUiSettings = aMap.getUiSettings();
            mUiSettings.setZoomControlsEnabled(false);
            mUiSettings.setCompassEnabled(true);
            mUpdata = CameraUpdateFactory.newCameraPosition(
                    //15是缩放比例，0是倾斜度，30显示比例
                    new CameraPosition(new LatLng(latitudes, longitudes), 15, 0, 30));//这是地理位置，就是经纬度。
            aMap.moveCamera(mUpdata);//定位的方法
            drawMarkers();
        }
    }


    public void drawMarkers() {
        Marker marker = aMap.addMarker(new MarkerOptions().position(new LatLng(latitudes, longitudes))
                .draggable(true));
        marker.showInfoWindow();// 设置默认显示一个infowinfow
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMap.onDestroy();
        if (client != null) client.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMap.onPause();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMap.onSaveInstanceState(outState);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
