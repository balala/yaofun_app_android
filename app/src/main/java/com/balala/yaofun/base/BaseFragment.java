package com.balala.yaofun.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseFragment<p extends BasePresenter, v extends BaseView> extends Fragment implements BaseView {
    protected p presenter;
    private Unbinder unbinder;
    private View decorView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //获取顶层视图
//        decorView = Objects.requireNonNull(getActivity()).getWindow().getDecorView();
        // 渲染系统toolbar
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View inflate = inflater.inflate(getlayoutId(), null);
        unbinder = ButterKnife.bind(this, inflate);
       // EventBus.getDefault().register(this);
        presenter = initGeekP();
        if (presenter != null) {
            presenter.bind(this);
        }
        initView();
        initListener();
        initData();
        return inflate;
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
        EventBus.getDefault().unregister(this);
        // 这么
        presenter = null;
    }
}
