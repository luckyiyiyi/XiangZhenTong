package com.example.xiangzhentong.viewlayer.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiangzhentong.R;
import com.example.xiangzhentong.viewlayer.fragment.CategoryFragment;
import com.example.xiangzhentong.viewlayer.fragment.HomeFragment;
import com.example.xiangzhentong.viewlayer.fragment.SetFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView navhomeimg;
    private ImageView navcatimg;
    private ImageView navsetimg;
    private TextView navhomet;
    private TextView navcatt;
    private TextView navsett;
    private TextView toptitle;
    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private SetFragment setFragment;
    private static boolean isExit = false;
    private static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
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
        setContentView(R.layout.activity_main);
        homeFragment = new HomeFragment();
        categoryFragment = new CategoryFragment();
        setFragment = new SetFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_content,homeFragment,homeFragment.getClass().getName())
                .add(R.id.main_content,categoryFragment,categoryFragment.getClass().getName())
                .add(R.id.main_content,setFragment,setFragment.getClass().getName())
                .show(homeFragment)
                .hide(categoryFragment)
                .hide(setFragment)
                .commit();
        initView();
    }

    //初始化
    private void initView(){
        navhomeimg = findViewById(R.id.homeimg);
        navcatimg = findViewById(R.id.categoryimg);
        navsetimg = findViewById(R.id.setimg);
        navhomet = findViewById(R.id.hometext);
        navcatt = findViewById(R.id.categorytext);
        navsett = findViewById(R.id.settext);
        toptitle = findViewById(R.id.toptitle);
        toptitle.setText("首页");
        View navhome = findViewById(R.id.navhome);
        navhome.setOnClickListener(MainActivity.this);
        View navcategory = findViewById(R.id.navcategory);
        navcategory.setOnClickListener(MainActivity.this);
        View navset = findViewById(R.id.navset);
        navset.setOnClickListener(MainActivity.this);
    }
    private static RefreshHome mrefreshHome;
    public interface RefreshHome{
        void refresh();
    }
    public static void setRefreshHome(RefreshHome refreshHome){
        mrefreshHome = refreshHome;
    }
    //底部导航切换页面
    public void onClick(View view){
        switch (view.getId()){
            case R.id.navhome:
                if(homeFragment.isVisible()){
                    Log.d("主页面显示：","HOME");
                    if(mrefreshHome!=null)
                    {
                        mrefreshHome.refresh();
                    }
                }
                selecthome();
                return;
            case R.id.navcategory:
                selectcat();
                return;
            case R.id.navset:
                selectset();
                return;
        }
    }
    //重置底部导航状态
    private void clearall(){
        navhomeimg.setBackgroundResource(R.drawable.homeuncheck);
        navcatimg.setBackgroundResource(R.drawable.categoryuncheck);
        navsetimg.setBackgroundResource(R.drawable.setuncheck);
        navhomet.setTextColor(Color.parseColor("#111111"));
        navcatt.setTextColor(Color.parseColor("#111111"));
        navsett.setTextColor(Color.parseColor("#111111"));
    }
    //点击底部导航按钮切换图标、文字
    private void selecthome(){
        clearall();
        navhomeimg.setBackgroundResource(R.drawable.homecheck);
        navhomet.setTextColor(Color.parseColor("#1296db"));
        getSupportFragmentManager().beginTransaction()
                .show(homeFragment)
                .hide(categoryFragment)
                .hide(setFragment)
                .commit();
        toptitle.setText("首页");
    }
    private void selectcat(){
        clearall();
        navcatimg.setBackgroundResource(R.drawable.categorycheck);
        navcatt.setTextColor(Color.parseColor("#38a3ff"));
        getSupportFragmentManager().beginTransaction()
                .hide(homeFragment)
                .show(categoryFragment)
                .hide(setFragment)
                .commit();
        toptitle.setText("分类");
    }
    private void selectset(){
        clearall();
        navsetimg.setBackgroundResource(R.drawable.setcheck);
        navsett.setTextColor(Color.parseColor("#1296db"));
        getSupportFragmentManager().beginTransaction()
                .hide(homeFragment)
                .hide(categoryFragment)
                .show(setFragment)
                .commit();
        toptitle.setText("设置");
    }
    public void onBackPressed(){
        exit();
    }
    public void exit(){
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
        }
    }
}
