package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiangzhentong.R;

public class ThemesettingActivity extends AppCompatActivity implements View.OnClickListener {
    private int themeType;

    private Button themeblue;
    private Button themered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        themeType = prefs.getInt("themeType", 0);
        Log.d("主题状态", String.valueOf(themeType));
        if (themeType == 0) {
            setTheme(R.style.themea);
        } else {
            setTheme(R.style.themeb);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themesetting);
        TextView grjztop = findViewById(R.id.fenleitoptext);
        grjztop.setText(R.string.sjggluetop);
        View topbarbut = findViewById(R.id.fenleiback);
        topbarbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent();
            }
        });
        themeblue = (Button) findViewById(R.id.themeblue);
        themeblue.setOnClickListener(this);
        themered = (Button) findViewById(R.id.themered);
        themered.setOnClickListener(this);
    }
    public void intent(){
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.themeblue:
                changeTheme(v);
                break;
            case R.id.themered:
                changeTheme(v);
                break;
            default:
        }
    }
    public void changeTheme(View view) {
        if(themeType == 0){
            themeType = 1;
        }else {
            themeType = 0;
        }
        Log.d("主题转换：",String.valueOf(themeType));
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(ThemesettingActivity.this).edit();
        editor.putInt("themeType", themeType);
        editor.apply();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        recreate();
    //会丢失当前页面的状态，需要保持的数据做持久化保持
    }
}
