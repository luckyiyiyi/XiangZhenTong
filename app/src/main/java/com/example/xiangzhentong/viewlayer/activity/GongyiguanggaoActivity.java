package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class GongyiguanggaoActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gongyiguanggao);
        //调整状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.guanggao));
        }
        TextView grjztop = findViewById(R.id.fenleitoptext);
        grjztop.setText(R.string.gyggluetop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentgyggl();
            }
        });
        webView = (WebView)findViewById(R.id.gyggweb);
        webView.loadUrl("file:////android_asset/html/gygglue.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSgyggInterface(),"gygg");
    }
    class JSgyggInterface {
        @JavascriptInterface
        public void intenttogyggxx(int id) {
            Log.d("测试js调用了java", String.valueOf(id));
            Intent intent = new Intent();
            intent.putExtra("gyggposition", String.valueOf(id));
            intent.setAction("gyggltx");
            startActivity(intent);
            finish();
        }
    }
    public void intentgyggl(){
        Intent intent = new Intent();
        intent.setClass(GongyiguanggaoActivity.this,MainActivity.class);
        intent.putExtra("position","fenlei");
        startActivity(intent);
        finish();
    }
    public void onBackPressed(){
        intentgyggl();
    }
}
