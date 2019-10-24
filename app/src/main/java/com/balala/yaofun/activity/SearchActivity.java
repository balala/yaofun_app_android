package com.balala.yaofun.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.balala.yaofun.R;
import com.balala.yaofun.adapter.ViewPageAdapter;
import com.balala.yaofun.fragment.OneFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

// 搜索页面
public class SearchActivity extends AppCompatActivity {
    private AppCompatEditText mCommunitySearchEt;
    private ImageView mCommunitySearchIv;
    private TextView mCommunitySearchCancle;
    private TextView mCommunitySearchTvHistroysearch;
    private RecyclerView mCommunitySearchRlv;
    private ConstraintLayout mCommunitySearchFiste;
    private ViewPager mCommunitySearchVp;
    private LinearLayout mCommentSearchLast;
    private TabLayout mCommunitySearchTab;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private ViewPageAdapter viewPageAdapter;
    private SharedPreferences sp;
    private List<String> mSearchHistroyList = new ArrayList<>();
    private ImageView mTvClear;
    private FlowLayout search_fl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        initData();
        initNet();
    }

    private void initView() {
        // 渲染系统toolbar  community_search_cancle
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        mCommunitySearchEt = findViewById(R.id.community_search_et);
        mCommunitySearchIv = findViewById(R.id.community_search_iv);
        mCommunitySearchCancle = findViewById(R.id.community_search_cancle);
        mCommunitySearchTvHistroysearch = findViewById(R.id.community_search_tv_histroysearch);
        search_fl = findViewById(R.id.search_fl);
        mCommunitySearchFiste = findViewById(R.id.community_search_fiste);
        mCommunitySearchTab = findViewById(R.id.community_search_tab);
        mCommunitySearchVp = findViewById(R.id.community_search_vp);
        mCommentSearchLast = findViewById(R.id.comment_search_last);
        mTvClear = findViewById(R.id.tv_clear);
        search_fl.setVisibility(View.VISIBLE);
    }

    private void initData() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());
        fragments.add(new OneFragment());

        titles = new ArrayList<>();
        titles.add("一");
        titles.add("二");
        titles.add("三");

        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), fragments, titles);
        mCommunitySearchVp.setAdapter(viewPageAdapter);
        mCommunitySearchTab.setupWithViewPager(mCommunitySearchVp);

        sp = getSharedPreferences("search", MODE_PRIVATE);
        String keyword = sp.getString("Keyword", "");
        mSearchHistroyList.add(keyword);

        for (int i = 0; i < mSearchHistroyList.size(); i++) {
            View view = LayoutInflater.from(SearchActivity.this).inflate(R.layout.view_textview, null);
            final TextView mTv = view.findViewById(R.id.tv);
            mTv.setText(mSearchHistroyList.get(i));
            search_fl.addView(view);
            mTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this, mTv.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initNet() {
        mCommunitySearchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Keyword = mCommunitySearchEt.getText().toString();
                search_fl.setVisibility(View.VISIBLE);
                Log.d("wenjunlian", "Keyword: " + Keyword);
                mCommunitySearchEt.setText("");
                if (Keyword.length() > 0) {
                    mCommunitySearchFiste.setVisibility(View.GONE);
                    mCommentSearchLast.setVisibility(View.VISIBLE);
                    SharedPreferences.Editor edit = sp.edit();
                    mSearchHistroyList.clear();
                    mSearchHistroyList.add(Keyword);
                    for (int i = 0; i < mSearchHistroyList.size(); i++) {
                        edit.putString("Keyword", mSearchHistroyList.get(i));
                    }
                    edit.commit();
                }

            }
        });
        search_fl.setVisibility(View.GONE);
        mCommunitySearchCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCommunitySearchFiste.setVisibility(View.VISIBLE);
                mCommentSearchLast.setVisibility(View.GONE);
                search_fl.setVisibility(View.VISIBLE);
                finish();
                String keyword = sp.getString("Keyword", "");
                mSearchHistroyList.clear();
                mSearchHistroyList.add(keyword);
                for (int i = 0; i < mSearchHistroyList.size(); i++) {
                    View view = LayoutInflater.from(SearchActivity.this).inflate(R.layout.view_textview, null);
                    final TextView mTv = view.findViewById(R.id.tv);
                    mTv.setText(mSearchHistroyList.get(i));
                    search_fl.addView(view);
                    search_fl.setVisibility(View.GONE);
                    mTv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(SearchActivity.this, mTv.getText().toString(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
        mTvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchHistroyList.clear();
                search_fl.setVisibility(View.GONE);
                search_fl.clearAll();
                sp.getAll().clear();
            }
        });
    }


}
