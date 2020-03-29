package com.example.xiangzhentong.viewlayer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xiangzhentong.R;
import com.example.xiangzhentong.viewlayer.activity.ThemesettingActivity;

public class SetFragment extends Fragment {

    private Button themeset;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_set,container,false);
        themeset = view.findViewById(R.id.themesetting);
        themeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThemesettingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
