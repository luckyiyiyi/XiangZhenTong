package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class ZhenfuzhenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhenfuzhence);
        initview();
    }
    public void initview(){
        View topbarview = findViewById(R.id.fenleitop);
        topbarview.setBackgroundResource(R.color.home);
        TextView topbartext = findViewById(R.id.fenleitoptext);
        topbartext.setText(R.string.zfzclue);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ZhenfuzhenceActivity.this,MainActivity.class);
                intent.putExtra("position","fenlei");
                startActivity(intent);
            }
        });

    }
}
