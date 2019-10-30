package com.balala.yaofun.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.balala.yaofun.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment2 extends Fragment {


    public MessageFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.message_fragment2, container, false);
        return inflate;
    }

}
