package com.wangdong.damai;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wd794 on 2016/3/17 0017.
 */
public class BaseActivity extends AppCompatActivity {
    //一定要是定义为static 保证在多个activity中activityList只有一个对象
    public static List<Activity> activityList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
