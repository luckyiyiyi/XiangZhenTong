package com.example.xiangzhentong.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> lists;
    @Override
    public Fragment getItem(int position) {
        return lists == null?null:lists.get(position);
    }

    @Override
    public int getCount() {
        return lists == null?0:lists.size();
    }

    public HomeFragmentPagerAdapter(FragmentManager fm, List<Fragment> datas){
        super(fm);
        lists = datas;
    }
    public  HomeFragmentPagerAdapter(){
        super(null);
    }
}
