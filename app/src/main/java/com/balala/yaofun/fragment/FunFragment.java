package com.balala.yaofun.fragment;


import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;
import com.balala.yaofun.adapter.FunArtAdapter;
import com.balala.yaofun.adapter.FunCateAdapter;
import com.balala.yaofun.adapter.FunMovieAdapter;
import com.balala.yaofun.adapter.FunSocialContactAdapter;
import com.balala.yaofun.base.BaseFragment;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.presenter.FunPresenter;
import com.balala.yaofun.view.FunView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends BaseFragment<FunPresenter, FunView> implements FunView {
    private static final String TAG = "FunFragment";

    @BindView(R.id.fun_searchbox)
    ImageView funSearchbox;
    @BindView(R.id.fun_add)
    ImageButton funAdd;
    @BindView(R.id.fun_rv1)
    RecyclerView funRv1;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.fun_rv2)
    RecyclerView funRv2;
    @BindView(R.id.fun_rv3)
    RecyclerView funRv3;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.fun_rv4)
    RecyclerView funRv4;
    @BindView(R.id.fun_rv5)
    RecyclerView funRv5;
    @BindView(R.id.tv_title3)
    TextView tvTitle3;
    @BindView(R.id.fun_rv6)
    RecyclerView funRv6;
    @BindView(R.id.fun_rv7)
    RecyclerView funRv7;
    @BindView(R.id.tv_title4)
    TextView tvTitle4;
    @BindView(R.id.fun_rv8)
    RecyclerView funRv8;
    @BindView(R.id.fun_rv9)
    RecyclerView funRv9;
    @BindView(R.id.funperch)
    ImageView funperch;
    @BindView(R.id.funsw)
    ScrollView funsw;
    @BindView(R.id.ll)
    LinearLayout ll;
//    @BindView(R.id.funperch)
//    ImageView mFunperch;

    private ArrayList<FunhomeData.DataBean> list;
    private FunMovieAdapter movieAdapter;
    private FunArtAdapter artAdapter;
    private FunCateAdapter cateAdapter;
    private FunSocialContactAdapter socialContactAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_fun;

    }

    @Override
    protected FunPresenter initGeekP() {
        return new FunPresenter();

    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        //影视
        movieAdapter = new FunMovieAdapter(getActivity(), list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv2.setLayoutManager(linearLayoutManager);
        funRv2.setAdapter(movieAdapter);
        funRv3.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv3.setAdapter(movieAdapter);

        //艺术
        artAdapter = new FunArtAdapter(getActivity(), list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv4.setLayoutManager(linearLayoutManager);
        funRv4.setAdapter(artAdapter);
        funRv5.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv5.setAdapter(artAdapter);


        //社交
        socialContactAdapter = new FunSocialContactAdapter(getActivity(), list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv6.setLayoutManager(linearLayoutManager);
        funRv6.setAdapter(socialContactAdapter);
        funRv7.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv7.setAdapter(socialContactAdapter);

        //美食
        cateAdapter = new FunCateAdapter(getActivity(), list);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv8.setLayoutManager(linearLayoutManager);
        funRv8.setAdapter(cateAdapter);
        funRv9.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv9.setAdapter(cateAdapter);

    }


    @Override
    protected void initData() {
        super.initData();
        presenter.getFunData();

    }

    @Override
    public void onSuccessFun(FunhomeData funhomeData) {

        list.add(funhomeData.getData());
        movieAdapter.setList(list);
        cateAdapter.setList(list);
        artAdapter.setList(list);
        socialContactAdapter.setList(list);

        movieAdapter.notifyDataSetChanged();
        cateAdapter.notifyDataSetChanged();
        artAdapter.notifyDataSetChanged();
        socialContactAdapter.notifyDataSetChanged();
        funperch.setVisibility(View.GONE);
        funsw.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFailFun(String msg) {
        Log.e(TAG, "onFailFun --- Error: " + msg);
    }
}
