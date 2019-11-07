package com.balala.yaofun.base;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.balala.yaofun.bean.VerificationResult;
import com.gyf.immersionbar.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;

public abstract class BaseActivity<p extends BasePresenter, v extends BaseView> extends AppCompatActivity implements BaseView {
    protected p basePresenter;
    protected VerificationResult verificationResult;
    private View decorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取顶层视图
//        decorView = getWindow().getDecorView();
        // 渲染系统toolbar
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//        hideBottomUIMenu();
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

    @Override
    public void onStart(){
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object myEvent){

    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initData2();

    protected abstract int getlayout();

    protected abstract p initPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(basePresenter!=null){
            basePresenter.OnDestroy();
        }
    }
    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;
        window.setAttributes(params);
    }

}
