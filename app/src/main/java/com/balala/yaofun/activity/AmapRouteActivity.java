package com.balala.yaofun.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.balala.yaofun.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
        mMapback = (ImageView) findViewById(R.id.mapback);

        mMaptext1 = (TextView) findViewById(R.id.maptext1);
        mMaptex2 = (TextView) findViewById(R.id.maptex2);
        mMapgo = (ImageView) findViewById(R.id.mapgo);

        Bundle extras = getIntent().getExtras();
        address = extras.getString("address");
        latitude = extras.getString("latitude");
        longitude = extras.getString("longitude");
        //转换为Int类型
        latitudes = Double.valueOf(latitude).intValue();
        //转换为Int类型
        longitudes = Double.valueOf(longitude).intValue();
        mMaptext1.setText(address);
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

        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocatio=nStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。

        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）默认执行此种模式。
        myLocationStyle.showMyLocation(true);
        myLocationStyle.anchor(1, 1);
        myLocationStyle.strokeColor(Color.BLUE);
        myLocationStyle.strokeColor(Color.GREEN);
        myLocationStyle.strokeWidth(1);
        //        LatLng latLng = new LatLng(latitudes, longitudes);
//        aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 19));
//        //设置远小近大效果,设置刷新一次图片资源的周期。
//        MarkerOptions markerOption = new MarkerOptions();
//        markerOption.position(latLng);
//        markerOption.title(address).snippet("纬度" + latitude + "经度" + longitude);
//        markerOption.draggable(true);
//        markerOption.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
//        aMap.addMarker(markerOption);

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
