package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class ZhengfuzhengceActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int themeType = prefs.getInt("themeType", 0);
        Log.d("主题状态", String.valueOf(themeType));
        if (themeType == 0) {
            setTheme(R.style.themea);
        } else {
            setTheme(R.style.themeb);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhengfuzhengce);
        TextView zfzctop = findViewById(R.id.fenleitoptext);
        zfzctop.setText(R.string.zfzcluetop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentzfzcl();
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
            Log.d("测试js调用了java",String.valueOf(id));
            Intent intent = new Intent();
            intent.putExtra("zfzcposition",String.valueOf(id));
            intent.setAction("zfzcltx");
            startActivity(intent);
            finish();
        }
    }
    public void intentzfzcl(){
//        Intent intent = new Intent();
//        intent.setClass(ZhengfuzhengceActivity.this,MainActivity.class);
//        intent.putExtra("position","fenlei");
//        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        intentzfzcl();
    }
}
