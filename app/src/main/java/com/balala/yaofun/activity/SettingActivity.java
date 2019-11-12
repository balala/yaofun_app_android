package com.balala.yaofun.activity;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.base.BaseClickEvent;
import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.dialog.CustomBaseDialog;
import com.balala.yaofun.util.ForLog;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;

import static com.balala.yaofun.MyApp.AppVersion;
import static com.balala.yaofun.MyApp.signOut;
import static com.balala.yaofun.util.DataCleanManager.getTotalCacheSize;

public class SettingActivity  extends BaseActivity {
    @BindView(R.id.tv_app_version)
    TextView tv_app_version;

    @BindView(R.id.ll_sign_out)
    View ll_sign_out;

    @BindView(R.id.ll_privacy_policy)
    View ll_privacy_policy;

    @Override
    protected int getlayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.black).init();
        findViewById(R.id.back).setOnClickListener(v->{
            finish();
        });
        ((TextView)findViewById(R.id.title)).setText(R.string.setting);
        tv_app_version.setText("V"+AppVersion);
        ll_sign_out.setOnClickListener(v->{
            new CustomBaseDialog(SettingActivity.this,new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                                signOut();
                                finish();
                }
            },new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                }
            }
            ).show();

        });
        ll_privacy_policy.setOnClickListener(v->{
            Intent intent=new Intent(SettingActivity.this,PrivacyPolicyActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.ll_about_fun).setOnClickListener(v->{
            Intent intent=new Intent(SettingActivity.this,AboutFunActivity.class);
            startActivity(intent);
        });
        try {
            getTotalCacheSize(SettingActivity.this);

        }catch (Exception e){
            ForLog.e("获取缓存",e);
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initData2() {

    }



    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
