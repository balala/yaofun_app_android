package com.balala.yaofun.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.balala.yaofun.R;
import com.balala.yaofun.fragment.FunFragment;
import com.balala.yaofun.fragment.HomeFragment;
import com.balala.yaofun.fragment.MeFragment;
import com.balala.yaofun.fragment.MessageFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeneralActivity extends AppCompatActivity {


    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.bottom_home)
    RadioButton bottom_home;
    @BindView(R.id.bottom_fun)
    RadioButton bottom_fun;
    @BindView(R.id.bottom_message)
    RadioButton bottom_message;
    @BindView(R.id.bottom_me)
    RadioButton bottom_me;
    @BindView(R.id.rg)
    RadioGroup rg;
    private View decorView;
    private ArrayList<Fragment> mFragments;
    private FragmentManager mFragmentManager;
    private int lastFragment;

    public static final int TYPE_HEARD = 0;
    private static final int TYPE_KONWLOGE = 1;
    private static final int TYPE_WX = 2;
    private static final int TYPE_NOTACTION = 3;
    Boolean up = false;//默认false不刷新

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        ButterKnife.bind(this);

        initFragments();
        initListener();
    }

    public void initFragments() {

        // 渲染系统toolbar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        mFragments = mFragments;
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new HomeFragment());
        mFragments.add(new FunFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MeFragment());
        ShowFragmentone();
        // 隐藏下方虚拟键
        hideBottomUIMenu();
    }

    public void initListener() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_home:
                        switchFragment(TYPE_HEARD);
                        break;
                    case R.id.bottom_fun:
                        switchFragment(TYPE_KONWLOGE);
                        break;
                    case R.id.bottom_message:
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        boolean aBoolean = preferences.getBoolean("flag", false);
                        if (aBoolean) {
                            Log.i("onCheckedChanged", "第二次登陆完了");
                        } else {
                            startActivity(new Intent(GeneralActivity.this, LandingActivity.class));
                        }
                        Log.i("aBoolean", "onCheckedChanged: " + aBoolean);

                        switchFragment(TYPE_WX);
                        break;
                    case R.id.bottom_me:
                        SharedPreferences pre = getSharedPreferences("user", Context.MODE_PRIVATE);
                        boolean booleans = pre.getBoolean("flag", false);
                        if (booleans) {
                            Log.i("onCheckedChanged", "第二次登陆完了");
                        } else {
                            startActivity(new Intent(GeneralActivity.this, LandingActivity.class));
                        }
                        switchFragment(TYPE_NOTACTION);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void ShowFragmentone() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fl, mFragments.get(0));
        transaction.commit();
        bottom_home.setChecked(true);

    }

    private void switchFragment(int type) {
        Fragment fragment = mFragments.get(type);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment hideFragment = mFragments.get(lastFragment);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl, fragment);
        }
        transaction.hide(hideFragment);
        transaction.show(fragment);
        transaction.commit();
        lastFragment = type;

    }


    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
        window.setAttributes(params);
    }

}
