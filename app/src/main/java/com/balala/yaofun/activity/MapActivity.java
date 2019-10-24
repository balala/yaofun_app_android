package com.balala.yaofun.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.balala.yaofun.R;

public class MapActivity extends AppCompatActivity implements AMapLocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
//        Log.e("lgq纬度latitude",latitude+"");
//        Log.e("lgq经度longititude",longititude+"");
        double latitude = aMapLocation.getLatitude();
        double longitude = aMapLocation.getLongitude();
        Log.i("latitudemap", "onLocationChanged: " + latitude);
        Log.i("longitudemap", "onLocationChanged: " + longitude);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
