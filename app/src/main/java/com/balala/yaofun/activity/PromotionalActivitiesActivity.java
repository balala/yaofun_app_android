package com.balala.yaofun.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.LoadFileVo;
import com.balala.yaofun.util.CustomEditText;
import com.balala.yaofun.util.OkHttp;
import com.bumptech.glide.annotation.GlideModule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;

@GlideModule
public class PromotionalActivitiesActivity extends AppCompatActivity {

    @BindView(R.id.openfunback)
    LinearLayout mOpenfunback;
    //    @BindView(R.id.openfunrv)
//    RecyclerView mOpenfunrv;
    @BindView(R.id.openfunimg)
    ImageView mOpenfunimg;
    @BindView(R.id.openfunaddimg)
    RelativeLayout mOpenfunaddimg;
    @BindView(R.id.openfun_name)
    CustomEditText mOpenfunName;
    @BindView(R.id.openfun_resume)
    CustomEditText mOpenfunResume;
    @BindView(R.id.openfun_dotext)
    CustomEditText mOpenfunDotext;
    @BindView(R.id.openfun_doback)
    ImageView mOpenfunDoback;
    @BindView(R.id.openfun_activitytext)
    CustomEditText mOpenfunActivitytext;
    @BindView(R.id.openfun_jointext)
    CustomEditText mOpenfunJointext;
    @BindView(R.id.openfuninterestback)
    ImageView mOpenfuninterestback;
    @BindView(R.id.openfun_interesttext)
    CustomEditText mOpenfunInteresttext;
    @BindView(R.id.openfun_interestback)
    ImageView mOpenfunInterestback;
    @BindView(R.id.openfun_applytext)
    TextView mOpenfunApplytext;
    @BindView(R.id.openfunapplyback)
    ImageView mOpenfunapplyback;
    @BindView(R.id.openfun_applypeoplecontent)
    CustomEditText mOpenfunApplypeoplecontent;
    @BindView(R.id.openfun_applypeopleback)
    ImageView mOpenfunApplypeopleback;
    @BindView(R.id.openfun_activitydetailsback)
    ImageView mOpenfunActivitydetailsback;
    @BindView(R.id.openfun_interestadd)
    ImageView mOpenfunInterestadd;
    @BindView(R.id.open_immediately)
    Button mOpenImmediately;
    //    private LoadPicAdapter adapter;
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    /**
     * 选择图片的返回码
     */
    public final static int SELECT_IMAGE_RESULT_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotional_activities);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.openfunback, R.id.openfunimg, R.id.openfunaddimg, R.id.openfun_name, R.id.openfun_resume, R.id.openfun_dotext, R.id.openfun_doback, R.id.openfun_activitytext, R.id.openfun_jointext, R.id.openfuninterestback, R.id.openfun_interesttext, R.id.openfun_interestback, R.id.openfun_applytext, R.id.openfunapplyback, R.id.openfun_applypeoplecontent, R.id.openfun_applypeopleback, R.id.openfun_activitydetailsback, R.id.openfun_interestadd, R.id.open_immediately})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.openfunback:
                finish();
                break;
//            case R.id.openfunrv:
//                break;
            case R.id.openfunimg:
                // 激活系统图库，选择一张图片
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                startActivityForResult(intent1, PHOTO_REQUEST_GALLERY);

                break;
            case R.id.openfunaddimg:
                break;
            case R.id.openfun_name:
                break;
            case R.id.openfun_resume:
                break;
            case R.id.openfun_dotext:
                break;
            case R.id.openfun_doback:
                break;
            case R.id.openfun_activitytext:
                break;
            case R.id.openfun_jointext:
                break;
            case R.id.openfuninterestback:
                break;
            case R.id.openfun_interesttext:
                break;
            case R.id.openfun_interestback:
                break;
            case R.id.openfun_applytext:
                break;
            case R.id.openfunapplyback:
                break;
            case R.id.openfun_applypeoplecontent:
                break;
            case R.id.openfun_applypeopleback:
                break;
            case R.id.openfun_activitydetailsback:
                break;
            case R.id.openfun_interestadd:
                break;
            case R.id.open_immediately:
                break;
        }
    }


}


