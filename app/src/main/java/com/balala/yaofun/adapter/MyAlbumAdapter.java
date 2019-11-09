package com.balala.yaofun.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import com.balala.yaofun.util.ForLog;

import java.util.ArrayList;

public class MyAlbumAdapter extends PagerAdapter {

    private ArrayList<Fragment> fragments;

    public MyAlbumAdapter(ArrayList<Fragment> fragments) {
        ForLog.e("MyAlbumAdapter监听：MyAlbumAdapter");
        this.fragments = fragments;
    }


    @Override
    public int getCount() {
        ForLog.e("MyAlbumAdapter监听：getCount"+fragments.size());
        return fragments.size();
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ForLog.e("MyAlbumAdapter监听：instantiateItem");
        return fragments.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        ForLog.e("MyAlbumAdapter监听：isViewFromObject");
        return view==object;
    }
}
