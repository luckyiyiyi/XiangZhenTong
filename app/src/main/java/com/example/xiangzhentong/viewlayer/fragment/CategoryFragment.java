package com.example.xiangzhentong.viewlayer.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangzhentong.R;

public class CategoryFragment extends Fragment {

    private Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_category,container,false);
        activity = getActivity();
        return view;
    }

}
