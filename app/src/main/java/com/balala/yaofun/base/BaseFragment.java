package com.balala.yaofun.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gyf.immersionbar.components.ImmersionFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment<p extends BasePresenter, v extends BaseView> extends ImmersionFragment implements BaseView {
    protected p presenter;
    private Unbinder unbinder;
    private View decorView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getlayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);

        presenter = initGeekP();
        if (presenter != null) {
            presenter.bind(this);
        }
        initView();
        initListener();
        initData();
        return inflate;
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

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected p initGeekP() {
        return null;
    }

    protected int getlayoutId() {
        return 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        // 这么
        presenter = null;
    }

    @Override
    public void initImmersionBar() {

    }
}
