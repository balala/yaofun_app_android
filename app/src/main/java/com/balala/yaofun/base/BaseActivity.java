package com.balala.yaofun.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.balala.yaofun.bean.VerificationResult;

import butterknife.ButterKnife;

public abstract class BaseActivity<p extends BasePresenter, v extends BaseView> extends AppCompatActivity implements BaseView {
    protected p basePresenter;
    protected VerificationResult verificationResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        ButterKnife.bind(this);
        basePresenter = initPresenter();
        if (basePresenter != null) {
            basePresenter.bind((v) this);
        }
        initView();
        initData();
        initData2();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initData2();

    protected abstract int getlayout();

    protected abstract p initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresenter.OnDestroy();
    }

}
