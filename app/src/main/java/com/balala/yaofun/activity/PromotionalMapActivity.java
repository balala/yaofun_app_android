package com.balala.yaofun.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.balala.yaofun.R;
import com.balala.yaofun.util.ALocationClientFactory;

public class PromotionalMapActivity extends AppCompatActivity implements View.OnClickListener, AMap.OnCameraChangeListener, TextWatcher, AdapterView.OnItemClickListener, AMapLocationListener {


    private ImageView mIvBack;
    private RelativeLayout mLayBack;
    /**
     * 搜索地点
     */
    private AutoCompleteTextView mEtSearch;
    private MapView mMapView;
    /**
     *
     */
    private TextView mAddress;
    private TextView mAddressDesc;
    /**
     * 确定
     */
    private Button mBtnEnsure;
    private ListView mLvData;
    private LinearLayout mLlPoi;
    private AMapLocationClient locationClient;
    private AMap aMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotionalmap);
        initView();
//        showLoadingDialog();
        //定位初始化
        locationClient = ALocationClientFactory.createLocationClient(this, ALocationClientFactory.createDefaultOption(), this);
        //开启定位
        locationClient.startLocation();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mLayBack = (RelativeLayout) findViewById(R.id.lay_back);
        mEtSearch = (AutoCompleteTextView) findViewById(R.id.et_search);
        mEtSearch.addTextChangedListener(this);
        mEtSearch.setOnItemClickListener(this);
        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.setOnClickListener(this);
//        mMapView.onCreate(savedInstanceState); // 此方法必须重写
        aMap = mMapView.getMap();
        UiSettings uiSettings = aMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(false);  //隐藏缩放按钮
        aMap.setOnCameraChangeListener(this); // 添加移动地图事件监听器
        mAddress = (TextView) findViewById(R.id.address);
        mAddressDesc = (TextView) findViewById(R.id.addressDesc);
        mBtnEnsure = (Button) findViewById(R.id.btn_ensure);
        mBtnEnsure.setOnClickListener(this);
        mLvData = (ListView) findViewById(R.id.lv_data);
        mLlPoi = (LinearLayout) findViewById(R.id.ll_poi);
//        poiAdapter = new PoiAdapter(this);
        mLvData.setOnItemClickListener(this);
//        mLvData.setAdapter(poiAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mapView:
                break;
            case R.id.btn_ensure:
                break;
        }
    }


    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onCameraChangeFinish(CameraPosition cameraPosition) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {

    }
}
