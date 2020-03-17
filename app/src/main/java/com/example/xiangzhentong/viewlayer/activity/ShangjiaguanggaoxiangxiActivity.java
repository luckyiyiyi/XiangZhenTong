package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class ShangjiaguanggaoxiangxiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangjiaguanggaoxiangxi);
        Intent intent=getIntent();
        String position = intent.getStringExtra("sjggposition");
        TextView sjj=findViewById(R.id.sjjj);
        sjj.setText(position);
    }
}
