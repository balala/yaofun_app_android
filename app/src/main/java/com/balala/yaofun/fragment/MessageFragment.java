package com.balala.yaofun.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.balala.yaofun.R;
import com.balala.yaofun.adapter.ViewpagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    private ViewpagerAdapter viewpagerAdapters;
    private TabLayout mMessageTab;
    private ViewPager mMessageVp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_message, container, false);
        initView(inflate);
        initData();
        return inflate;

    }

    private void initView(View inflate) {
        mMessageTab = inflate.findViewById(R.id.message_tab);
        mMessageVp = inflate.findViewById(R.id.message_vp);
    }

    protected void initData() {
        // 取出第一次登陆的
//        Serializable userid = SharedPrefrenceUtils.getObject(getContext(), "userid");
//        if (userid.equals(false)) {
//            Toast.makeText(getContext(), "第二次登陆完了", Toast.LENGTH_SHORT).show();
//        } else {
//            startActivity(new Intent(getContext(), LandingActivity.class));
//        }
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AuditFragment());
        fragments.add(new MessageFragment2());


        mMessageTab.addTab(mMessageTab.newTab().setText("审核"));
        mMessageTab.addTab(mMessageTab.newTab().setText("消息"));

        viewpagerAdapters = new ViewpagerAdapter(getFragmentManager(), fragments);
        mMessageVp.setAdapter(viewpagerAdapters);
        mMessageVp.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mMessageTab));
        mMessageTab.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mMessageVp.setCurrentItem(tab.getPosition());
//                mHomeTab.setClickable(true);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
