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

public class HometuisongxiangxiActivity extends AppCompatActivity {

    private WebView webView;
    private String position;
    private int po;
    private int a;
    private int b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hometuisongxiangxi);
        Intent intent = getIntent();
        position = intent.getStringExtra("hometsposition");
        po = Integer.parseInt(position);
        a = po/10;
        b = po%10;
        Log.d("传参", position);
        Log.d("页数", String.valueOf(a));
        Log.d("位置", String.valueOf(b));
        TextView zfzctop = findViewById(R.id.fenleitoptext);
        zfzctop.setText(R.string.zfzcxxtop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        webView = (WebView)findViewById(R.id.homexiangxiweb);
        webView.getSettings().setJavaScriptEnabled(true);
        if (a == 1){
            webView.loadUrl("file:////android_asset/html/gyggxx.html");
            webView.addJavascriptInterface(new gyggposition(),"gyggposition");
        }else if(a == 2){
            webView.loadUrl("file:////android_asset/html/sjggxx.html");
            webView.addJavascriptInterface(new sjggposition(),"sjggposition");
        }else if(a == 3){
            webView.loadUrl("file:////android_asset/html/zfzcxx.html");
            webView.addJavascriptInterface(new zfzcposition(),"zfzcposition");
        }
    }
    class zfzcposition{
        @JavascriptInterface
        public int zfzcposition(){
            return b;
        }
    }
    class sjggposition{
        @JavascriptInterface
        public int sjggposition(){
            return b;
        }
    }
    class gyggposition{
        @JavascriptInterface
        public int gyggposition(){
            return b;
        }
    }
}
