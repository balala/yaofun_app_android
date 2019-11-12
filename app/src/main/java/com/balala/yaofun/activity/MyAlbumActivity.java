package com.balala.yaofun.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.balala.yaofun.R;
import com.balala.yaofun.adapter.ViewpagerAdapter;
import com.balala.yaofun.base.BaseActivity;
import com.balala.yaofun.base.BasePresenter;
import com.balala.yaofun.fragment.MyAlbumLeftFragment;
import com.balala.yaofun.fragment.MyAlbumRightFragment;
import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;

import butterknife.BindView;

public class MyAlbumActivity extends BaseActivity {
    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.tab)
    TabLayout tab;

    private ViewpagerAdapter viewpagerAdapters;
    @Override
    protected  int getlayout(){
        return R.layout.activity_my_album;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.black).init();
        findViewById(R.id.back).setOnClickListener(v->{
            finish();
        });
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MyAlbumLeftFragment());
        fragments.add(new MyAlbumRightFragment());
        getSupportFragmentManager();
        viewpagerAdapters =  new ViewpagerAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(viewpagerAdapters);

        vp.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
