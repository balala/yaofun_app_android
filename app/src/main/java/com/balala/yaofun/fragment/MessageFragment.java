package com.balala.yaofun.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.balala.yaofun.R;
import com.balala.yaofun.activity.MailListActivity;
import com.balala.yaofun.adapter.ViewpagerAdapter;
import com.balala.yaofun.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment {


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
        inflate.findViewById(R.id.maillist).setOnClickListener(v->{
            startActivity(new Intent(this.getActivity(), MailListActivity.class));
        });
    }

    protected void initData() {
        // 取出第一次登陆的
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AuditFragment());
//        fragments.add(new MessageFragment2());
        ConversationListFragment mConversationListFragment=new ConversationListFragment();
        Uri uri = Uri.parse("rong://com.balala.yaofun").buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")
                .build();
        mConversationListFragment.setUri(uri);
        fragments.add(mConversationListFragment);


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
