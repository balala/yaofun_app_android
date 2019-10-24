package com.balala.yaofun.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.balala.yaofun.R;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends Fragment {
//    @BindView(R.id.funperch)
//    ImageView mFunperch;
    @BindView(R.id.fun_searchbox)
    ImageView mFunSearchbox;
    @BindView(R.id.fun_add)
    ImageButton mFunAdd;
    @BindView(R.id.fun_rv1)
    RecyclerView mFunRv1;
    @BindView(R.id.fun_rv2)
    RecyclerView mFunRv2;
    @BindView(R.id.fun_rv3)
    RecyclerView mFunRv3;
    @BindView(R.id.fun_rv4)
    RecyclerView mFunRv4;
    @BindView(R.id.fun_rv5)
    RecyclerView mFunRv5;
    @BindView(R.id.ll)
    LinearLayout mLl;

    public FunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fun, container, false);
        return inflate;
    }




}
