package com.balala.yaofun.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.LoadFileVo;
import com.balala.yaofun.util.CustomEditText;
import com.bumptech.glide.annotation.GlideModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@GlideModule
public class PromotionalActivitiesActivity extends AppCompatActivity {
    private int maximgcount = 8;        //允许选择图片最大数
    public static final int image_item_add = -1;
    public static final int request_code_select = 100;
    public static final int request_code_preview = 101;
    List<LoadFileVo> fileList = new ArrayList<>();
    @BindView(R.id.openfunback)
    LinearLayout mOpenfunback;
    //    @BindView(R.id.openfunrv)
//    RecyclerView mOpenfunrv;
    @BindView(R.id.openfunimg)
    LinearLayout mOpenfunimg;
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


    //判断点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            //当isShouldHideInput(v, ev)为true时，表示的是点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //处理Editext的光标隐藏、显示逻辑
                    mOpenfunName.clearFocus();
                    mOpenfunResume.clearFocus();
                    mOpenfunDotext.clearFocus();
                    mOpenfunActivitytext.clearFocus();
                    mOpenfunJointext.clearFocus();
                    mOpenfunInteresttext.clearFocus();
                    mOpenfunApplypeoplecontent.clearFocus();
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    // 获取文本框点击事件
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
