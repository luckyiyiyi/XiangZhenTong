package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class GerenjianzhixiangxiActivity extends AppCompatActivity {

    private WebView webView;
    private String position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenjianzhixiangxi);
        //调整状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.jianzhi));
        }
        TextView zfzctop = findViewById(R.id.fenleitoptext);
        zfzctop.setText(R.string.grjzxxtop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(GerenjianzhixiangxiActivity.this,GerenjianzhiActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        position = intent.getStringExtra("grjzposition");
        webView = (WebView)findViewById(R.id.grjzxxweb);
        webView.loadUrl("file:////android_asset/html/grjzxx.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new grjzposition(),"grjzposition");
    }
    class grjzposition{
        @JavascriptInterface
        public String grjzposition(){
            return position;
        }
    }
}
