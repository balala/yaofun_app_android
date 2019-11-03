package com.balala.yaofun.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps.MapView;
import com.balala.yaofun.R;

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
        String address = extras.getString("address");
        mMaptext1.setText(address);
        mMapback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
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
}

