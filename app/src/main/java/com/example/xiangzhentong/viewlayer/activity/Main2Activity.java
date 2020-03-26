package com.example.xiangzhentong.viewlayer.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xiangzhentong.R;
import com.example.xiangzhentong.viewlayer.fragment.ChooseAreaFragment;

public class Main2Activity extends AppCompatActivity {
    private ChooseAreaFragment chooseAreaFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chooseAreaFragment = new ChooseAreaFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.choose_area_fragment,chooseAreaFragment,chooseAreaFragment.getClass().getName())
                .show(chooseAreaFragment)
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
