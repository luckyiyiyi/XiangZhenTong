package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class ZhengfuzhengcexiangxiActivity extends AppCompatActivity {

    private WebView webView;
    private String position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhengfuzhengcexiangxi);
        TextView zfzctop = findViewById(R.id.fenleitoptext);
        zfzctop.setText(R.string.zfzcxxtop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentzfzcx();
            }
        });
        Intent intentget=getIntent();
        position = intentget.getStringExtra("zfzcposition");
        webView = (WebView)findViewById(R.id.zfzcxiangxiweb);
        webView.loadUrl("file:////android_asset/html/zfzcxx.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new zfzcposition(),"zfzcposition");
    }
    class zfzcposition{
        @JavascriptInterface
        public String zfzcposition(){
            return position;
        }
    }
    public void intentzfzcx(){
        Intent intent = new Intent();
        intent.setClass(ZhengfuzhengcexiangxiActivity.this,ZhengfuzhengceActivity.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        intentzfzcx();
    }
}
