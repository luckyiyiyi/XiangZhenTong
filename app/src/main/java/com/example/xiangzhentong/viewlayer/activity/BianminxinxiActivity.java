package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class BianminxinxiActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianminxinxi);
        TextView grjztop = findViewById(R.id.fenleitoptext);
        grjztop.setText(R.string.bmxxtop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(BianminxinxiActivity.this,MainActivity.class);
                intent.putExtra("position","fenlei");
                startActivity(intent);
            }
        });
        webView = (WebView)findViewById(R.id.bmxxweb);
        webView.loadUrl("file:////android_asset/html/bmxx.html");
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
