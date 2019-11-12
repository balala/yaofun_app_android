package com.balala.yaofun.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.maps.MapView;
import com.balala.yaofun.R;

public class PromotionalMapActivity extends AppCompatActivity {


    private LinearLayout mOpenmapback;
    private LinearLayout mMapok;
    private MapView mMapView;
    private RecyclerView mMaprv;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotionalmap);
        initView();

    }


    private void initView() {
        mOpenmapback = (LinearLayout) findViewById(R.id.openmapback);
        mMapok = (LinearLayout) findViewById(R.id.mapok);
        mMapView = (MapView) findViewById(R.id.mapmap);
        mMaprv = (RecyclerView) findViewById(R.id.maprv);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

}
