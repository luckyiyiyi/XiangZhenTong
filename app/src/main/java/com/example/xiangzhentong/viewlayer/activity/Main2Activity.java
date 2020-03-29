package com.example.xiangzhentong.viewlayer.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.xiangzhentong.R;
import com.example.xiangzhentong.viewlayer.fragment.ChooseAreaFragment;

public class Main2Activity extends AppCompatActivity {
    private ChooseAreaFragment chooseAreaFragment;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chooseAreaFragment = new ChooseAreaFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.choose_area_fragment, chooseAreaFragment, chooseAreaFragment.getClass().getName())
                .show(chooseAreaFragment)
                .commit();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null) {
            Log.d("城市id",prefs.getString("weather", null));
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
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
