package com.wangdong.damai.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.wangdong.damai.Adapter.FragmentViewAdapter;
import com.wangdong.damai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wd794 on 2016/3/5 0005.
 */
public class HomeFragmnet extends BaseFragment implements Button.OnClickListener{
    private Button localButton;
    private Button countryButton;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private FragmentStatePagerAdapter fragmentStatePagerAdapter;
    View contentView;
    private TextView lineTextView;
    private int screenWidth;
    private int one;
    private int two;
    private TranslateAnimation translateAnimation;
    private int curPos=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(contentView==null){
            contentView=inflater.inflate(R.layout.frg_home,null);
        }
        initView();
        initData();
        initUnderLine();
        localButton.setOnClickListener(this);
        countryButton.setOnClickListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                translateAnimation=new TranslateAnimation(curPos*one,position*one,0,0);
                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(200);
                lineTextView.startAnimation(translateAnimation);
                localButton.setSelected(false);
                countryButton.setSelected(false);
                if (position == 0) {
                    localButton.setSelected(true);
                } else {
                    countryButton.setSelected(true);
                }
                curPos=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return contentView;
    }
    private void initUnderLine() {
        lineTextView=(TextView)contentView.findViewById(R.id.tv_line);
        DisplayMetrics dm=getResources().getDisplayMetrics();
        screenWidth=dm.widthPixels;
        one=screenWidth/2;
        lineTextView.setWidth(one);
    }

    private void initData() {
        fragmentList=new ArrayList<>();
        //获取HomeFragment传递的对象，并继续传递到LocalHomeFragment中
        //对于activity中fragmnet里面的fragment，直接用setArgument进行两个fragment之间的传递
        LocalHomeFragment localHomeFragment = new LocalHomeFragment();
        localHomeFragment.setArguments(getArguments());
        fragmentList.add(localHomeFragment);
        fragmentList.add(new CountryHomeFragment());
        fragmentStatePagerAdapter=new FragmentViewAdapter(getFragmentManager(),fragmentList);
        viewPager.setAdapter(fragmentStatePagerAdapter);

    }

    private void initView() {
        localButton= (Button) contentView.findViewById(R.id.btn_local);
        countryButton= (Button) contentView.findViewById(R.id.btn_country);
        viewPager= (ViewPager) contentView.findViewById(R.id.vp_home);
        localButton.setSelected(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_local:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_country:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
