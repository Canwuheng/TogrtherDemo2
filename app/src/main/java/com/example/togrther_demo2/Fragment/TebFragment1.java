package com.example.togrther_demo2.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.togrther_demo2.R;

/**
 * 车管局车辆账户管理系统
 */
public class TebFragment1 extends Fragment {


    public TebFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teb_fragment1, container, false);
    }

}
