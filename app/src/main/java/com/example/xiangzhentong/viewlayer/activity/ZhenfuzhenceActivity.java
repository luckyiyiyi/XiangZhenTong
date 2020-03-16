package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.xiangzhentong.R;

public class ZhenfuzhenceActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhenfuzhence);
        initview();
    }
    public void initview(){
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
        initweb();
    }
    public void initweb(){
        webView = (WebView)findViewById(R.id.zfzcweb);
        webView.loadUrl("file:////android_asset/html/zfzclue.html");
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
