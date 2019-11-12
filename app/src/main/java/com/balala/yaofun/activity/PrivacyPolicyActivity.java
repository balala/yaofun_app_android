package com.balala.yaofun.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balala.yaofun.R;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.base.BasePresenter;
import com.gyf.immersionbar.ImmersionBar;
import com.just.agentweb.AgentWeb;

import butterknife.BindView;


public class PrivacyPolicyActivity extends BaseActivity {
    @BindView(R.id.web)
    LinearLayout web;

    @Override
    protected int getlayout() {
        return R.layout.activity_privacy_policy;
    }
    private AgentWeb mAgentWeb;

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.black).init();
        findViewById(R.id.back).setOnClickListener(v->{
            finish();
        });
        ((TextView)findViewById(R.id.title)).setText(R.string.privacy_policy);
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(web, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go("http://www.yaofun.vip/privacy.html");

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


    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}
