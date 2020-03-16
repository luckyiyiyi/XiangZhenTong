package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.example.xiangzhentong.R;

public class ZhengfuzhengceActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhengfuzhengce);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ZhengfuzhengceActivity.this,MainActivity.class);
                intent.putExtra("position","fenlei");
                startActivity(intent);
            }
        });
        webView = (WebView)findViewById(R.id.zfzcweb);
        webView.loadUrl("file:////android_asset/html/zfzclue.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSInterface(),"zfzc");
    }
    class JSInterface{
        @JavascriptInterface
        public void intenttozfzcxx(int id){
            Log.d("测试js调用了java","测试js调用了java");
            Intent intent = new Intent();
            intent.setAction("zfzcltx");
            startActivity(intent);
        }
    }
}
