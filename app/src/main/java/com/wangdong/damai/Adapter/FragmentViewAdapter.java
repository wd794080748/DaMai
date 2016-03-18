package com.wangdong.damai.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by wd794 on 2016/3/5 0005.
 */
public class FragmentViewAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    public FragmentViewAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList==null?null:fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.size();
    }
}
