package com.example.xiangzhentong.viewlayer.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiangzhentong.R;
import com.example.xiangzhentong.adapter.LoopViewAdapter;
import com.example.xiangzhentong.gson.Forecast;
import com.example.xiangzhentong.gson.Weather;
import com.example.xiangzhentong.listener.PagerOnClickListener;
import com.example.xiangzhentong.util.Utility;
import com.example.xiangzhentong.viewlayer.activity.MainActivity;
import com.example.xiangzhentong.viewlayer.activity.WeatherActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.example.xiangzhentong.viewlayer.activity.MainActivity.setRefreshHome;

public class HomeFragment extends Fragment implements MainActivity.RefreshHome {

    private ViewPager viewPager;  //轮播图模块
    private int[] mImg;
    private int[] mImg_id;
    private String[] mDec;
    private ArrayList<ImageView> mImgList;
    private LinearLayout ll_dots_container;
    private int previousSelectedPosition = 0;
    boolean isRunning = false;
    private Activity activity;
    private View ThisView;
    private TextView city;
    private TextView hweather;
    private TextView stu;
    private TextView sugg;
    private LinearLayout forecastLayout;
    public SwipeRefreshLayout refreshhome;
    private View home;
    private View tuisong;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        ThisView = inflater.inflate(R.layout.fragment_home,container,false);
        activity = getActivity();
        initLoopView();  //实现轮播图
        initweather();
        View weather_card = ThisView.findViewById(R.id.weather_card);
        weather_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, WeatherActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });
        initrefresh();
        setRefreshHome(this);
        return ThisView;
    }

    @Override
    public void refresh() {
        init();
    }

    //    @Override
//    public void onViewCreated(View view, @Nullable Bundle saveInstanceState){
//        super.onViewCreated(view, saveInstanceState);
//        this.containerView=view.findViewById(R.id.navhomecontainer);
//    }
    public void init(){
        home.setVisibility(View.VISIBLE);
        tuisong.setVisibility(View.GONE);
    }
    private void initrefresh(){
        refreshhome = ThisView.findViewById(R.id.refresh_home);
        refreshhome.setColorSchemeResources(R.color.home);
        home = ThisView.findViewById(R.id.homere);
        tuisong = ThisView.findViewById(R.id.tuisong);
        home.setVisibility(View.VISIBLE);
        tuisong.setVisibility(View.GONE);
        refreshhome.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(home.getVisibility() == View.VISIBLE){
                    home.setVisibility(View.GONE);
                    tuisong.setVisibility(View.VISIBLE);
                }else {
                    int a = (int)((Math.random()*10));
                    TextView te = (TextView)ThisView.findViewById(R.id.te);
                    te.setText(String.valueOf(a));
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshhome.setRefreshing(false);
                    }
                },1000);
            }
        });
    }
    private void initweather(){
        city = (TextView)ThisView.findViewById(R.id.city);
        hweather = (TextView)ThisView.findViewById(R.id.weather);
        stu = (TextView)ThisView.findViewById(R.id.stu);
        sugg = (TextView)ThisView.findViewById(R.id.sugg);
        forecastLayout = (LinearLayout)ThisView.findViewById(R.id.fragment_weather_buttom);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        String weatherString = prefs.getString("weather", null);
        Weather weather = Utility.handleWeatherResponse(weatherString);
        String update = weather.basic.update.updateTime;
        if (weather != null && "ok".equals(weather.status))
            city.setText(weather.basic.cityName+"("+ update.substring(0,10) +")"+dateToWeekZhou(update.substring(0,10)));
            hweather.setText(weather.now.temperature + "℃");
            stu.setText(weather.now.more.info+"      "+weather.now.wind+"      "+weather.now.windsc+"级风力");
            sugg.setText("建议：" + weather.suggestion.sport.info);
        forecastLayout.removeAllViews();
        for (Forecast forecast : weather.forecastList) {
            View view = LayoutInflater.from(activity).inflate(R.layout.homeweatherforitem, forecastLayout, false);
            TextView dateText = (TextView) view.findViewById(R.id.day);
            TextView infoText = (TextView) view.findViewById(R.id.temp);
            TextView maxText = (TextView) view.findViewById(R.id.stu);
            dateText.setText(dateToWeek(forecast.date));
            infoText.setText(forecast.temperature.max+ "℃");
            maxText.setText(forecast.more.info);
            forecastLayout.addView(view);
        }
        Log.d("更新时间：",update.substring(0,10));
        Log.d("更新时间：",dateToWeek(update.substring(0,10)));
    }
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    public static String dateToWeekZhou(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    private void initLoopView(){
        viewPager = (ViewPager)ThisView.findViewById(R.id.loopviewpager);
        ll_dots_container = (LinearLayout)ThisView.findViewById(R.id.ll_dots_loop);

        // 图片资源id数组
        mImg = new int[]{
                R.drawable.lunbo1,
                R.drawable.lunbo2,
                R.drawable.lunbo3,
                R.drawable.lunbo4
        };

        mImg_id = new int[]{
                R.id.pager_img1,
                R.id.pager_img2,
                R.id.pager_img3,
                R.id.pager_img4
        };

        // 初始化要展示的5个ImageView
        mImgList = new ArrayList<ImageView>();
        ImageView imageView;
        View dotView;
        LinearLayout.LayoutParams layoutParams;
        for(int i=0;i<mImg.length;i++){
            //初始化要显示的图片对象
            imageView = new ImageView(this.getContext());
            imageView.setBackgroundResource(mImg[i]);
            imageView.setId(mImg_id[i]);
            imageView.setOnClickListener(new PagerOnClickListener(getContext()));
            mImgList.add(imageView);
            //加引导点
            dotView = new View(this.getContext());
            dotView.setBackgroundResource(R.drawable.dot);
            layoutParams = new LinearLayout.LayoutParams(40,40);
            if(i!=0){
                layoutParams.leftMargin=10;
            }
            //设置默认所有都不可用
            dotView.setEnabled(false);
            ll_dots_container.addView(dotView,layoutParams);
        }

        ll_dots_container.getChildAt(0).setEnabled(true);
        previousSelectedPosition=0;
        //设置适配器
        viewPager.setAdapter(new LoopViewAdapter(mImgList));
        // 把ViewPager设置为默认选中Integer.MAX_VALUE / t2，从十几亿次开始轮播图片，达到无限循环目的;
        int m = (Integer.MAX_VALUE / 2) %mImgList.size();
        int currentPosition = Integer.MAX_VALUE / 2 - m;
        viewPager.setCurrentItem(currentPosition);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                int newPosition = i % mImgList.size();
                ll_dots_container.getChildAt(previousSelectedPosition).setEnabled(false);
                ll_dots_container.getChildAt(newPosition).setEnabled(true);
                previousSelectedPosition = newPosition;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        // 开启轮询
        new Thread(){
            public void run(){
                isRunning = true;
                while(isRunning){
                    try{
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //下一条
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                        }
                    });
                }
            }
        }.start();

    }
}
