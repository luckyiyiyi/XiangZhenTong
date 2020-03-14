package com.example.xiangzhentong.viewlayer.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangzhentong.R;
import com.example.xiangzhentong.viewlayer.activity.BianminxinxiActivity;
import com.example.xiangzhentong.viewlayer.activity.GerenjianzhiActivity;
import com.example.xiangzhentong.viewlayer.activity.GongyiguanggaoActivity;
import com.example.xiangzhentong.viewlayer.activity.ShangjiaguanggaoActivity;
import com.example.xiangzhentong.viewlayer.activity.ZhenfuzhenceActivity;

public class CategoryFragment extends Fragment{

    private Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_category,container,false);
        activity = getActivity();
        initview(view);
        return view;
    }
    public void initview(View view){
        View zfzcview = view.findViewById(R.id.zhengfuzhengce);
        zfzcview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zfzcintent = new Intent(activity, ZhenfuzhenceActivity.class);
                startActivity(zfzcintent);
            }
        });
        View bmxxview = view.findViewById(R.id.bianminxinxi);
        bmxxview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bmxxintent = new Intent(activity, BianminxinxiActivity.class);
                startActivity(bmxxintent);
            }
        });
        View grjzview = view.findViewById(R.id.gerenjianzhi);
        grjzview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent grjzintent = new Intent(activity, GerenjianzhiActivity.class);
                startActivity(grjzintent);
            }
        });
        View sjggview = view.findViewById(R.id.shangjiaguanggao);
        sjggview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sjggintent = new Intent(activity, ShangjiaguanggaoActivity.class);
                startActivity(sjggintent);
            }
        });
        View gyggview = view.findViewById(R.id.gongyiguanggao);
        gyggview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gyggintent = new Intent(activity, GongyiguanggaoActivity.class);
                startActivity(gyggintent);            }
        });
    }

}
