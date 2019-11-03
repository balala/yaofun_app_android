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
import com.balala.yaofun.bean.BaseBean;
import com.balala.yaofun.bean.FunhomeData;
import com.balala.yaofun.presenter.FunPresenter;
import com.balala.yaofun.util.Utils;
import com.balala.yaofun.view.FunView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private ArrayList<BaseBean<FunhomeData.DataBean.ArtBean>> artlist;
    private ArrayList<BaseBean<FunhomeData.DataBean.FilmBean>> filmlist;
    private ArrayList<BaseBean<FunhomeData.DataBean.SocialBean>> socialist;
    private ArrayList<BaseBean<FunhomeData.DataBean.FoodBean>> foodlist;
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

    }


    @Override
    protected void initData() {
        super.initData();
        Map<String, String> map = new HashMap<>();
//        map.put("user_id", "-1");
//        map.put("version", "-1");
//        map.put("current_device", "安卓");
//        map.put("unique_identifier", "");
//        map.put("download_channel", "");
//        map.put("user_defined_name", "");
//        map.put("phone_version", "");
//        map.put("wx_unionid", "");
//        map.put("phone_model", "");
        map.put("request_start_time", Utils.getNowDate());
        presenter.funhomeData(map);
    }

    @Override
    public void homefunSuccess(BaseBean<FunhomeData.DataBean> bean) {

        funperch.setVisibility(View.GONE);
        funsw.setVisibility(View.VISIBLE);
        artlist = new ArrayList<>();
        filmlist = new ArrayList<>();
        socialist = new ArrayList<>();
        foodlist = new ArrayList<>();
        //影视
        movieAdapter = new FunMovieAdapter(getActivity(), filmlist);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv2.setLayoutManager(linearLayoutManager);
        funRv2.setAdapter(movieAdapter);
        funRv3.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv3.setAdapter(movieAdapter);

        //艺术
        artAdapter = new FunArtAdapter(getActivity(), artlist);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv4.setLayoutManager(linearLayoutManager);
        funRv4.setAdapter(artAdapter);
        funRv5.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv5.setAdapter(artAdapter);


        //社交
        socialContactAdapter = new FunSocialContactAdapter(getActivity(), socialist);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv6.setLayoutManager(linearLayoutManager);
        funRv6.setAdapter(socialContactAdapter);
        funRv7.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv7.setAdapter(socialContactAdapter);

        //美食
        cateAdapter = new FunCateAdapter(getActivity(), foodlist);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        funRv8.setLayoutManager(linearLayoutManager);
        funRv8.setAdapter(cateAdapter);
        funRv9.setLayoutManager(new LinearLayoutManager(getActivity()));
        funRv9.setAdapter(cateAdapter);

        movieAdapter.notifyDataSetChanged();
        cateAdapter.notifyDataSetChanged();
        artAdapter.notifyDataSetChanged();
        socialContactAdapter.notifyDataSetChanged();

    }

    @Override
    public void homefunFail(String msg) {
        Log.e(TAG, "onFailFun --- Error: " + msg);
    }
}
