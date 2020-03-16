package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class ZhengduzhengcexiangxiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhengfuzhengcexiangxi);
        Intent intent=getIntent();
        String i = intent.getStringExtra("position");
        TextView a = findViewById(R.id.aa);
        a.setText(i);
    }
}
