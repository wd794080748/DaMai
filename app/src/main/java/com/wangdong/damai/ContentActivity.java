package com.wangdong.damai;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wangdong.damai.Fragment.ClassFragment;
import com.wangdong.damai.Fragment.HomeFragmnet;
import com.wangdong.damai.Fragment.Moviefragment;
import com.wangdong.damai.Fragment.SetFragment;

public class ContentActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private RadioButton homeButton;
    private HomeFragmnet homeFragmnet;
    private ClassFragment classFragment;
    private Moviefragment moviefragment;
    private SetFragment setFragment;
    private FragmentManager fragmentManager;
    private android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        activityList.add(this);
       fragmentManager=getSupportFragmentManager();
        initView();
        radioGroup.setOnCheckedChangeListener(this);
        homeButton.setChecked(true);
    }

    private void initView() {
        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        homeButton= (RadioButton) findViewById(R.id.btn_home);
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(homeFragmnet!=null){
            fragmentTransaction.hide(homeFragmnet);
        }   if(classFragment!=null){
            fragmentTransaction.hide(classFragment);
        }   if(moviefragment!=null){
            fragmentTransaction.hide(moviefragment);
        }   if(setFragment!=null){
            fragmentTransaction.hide(setFragment);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fragmentTransaction=fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (checkedId){
            case R.id.btn_home:
                if(homeFragmnet==null){
                    homeFragmnet=new HomeFragmnet();
                    fragmentTransaction.add(R.id.fl_show,homeFragmnet);
                }else{
                    fragmentTransaction.show(homeFragmnet);
                }
                break;
            case R.id.btn_class:
                if(classFragment==null){
                    classFragment=new ClassFragment();
                    fragmentTransaction.add(R.id.fl_show,classFragment);
                    Bundle bundle=new Bundle();
                    bundle.putString("11","22");
                    classFragment.setArguments(bundle);
                }else{
                    fragmentTransaction.show(classFragment);
                }
                break;
            case R.id.btn_movie:
                if(moviefragment==null){
                    moviefragment=new Moviefragment();
                    fragmentTransaction.add(R.id.fl_show,moviefragment);
                }else{
                    fragmentTransaction.show(moviefragment);
                }
                break;
            case R.id.btn_set:
                if(setFragment==null){
                    setFragment=new SetFragment();
                    fragmentTransaction.add(R.id.fl_show,setFragment);
                }else{
                    fragmentTransaction.show(setFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
    private int mBackKeyPressedTimes = 0;

    @Override
    public void onBackPressed() {
        if (mBackKeyPressedTimes == 0) {
            Toast.makeText(this, "再按一次退出程序 ", Toast.LENGTH_SHORT).show();
            mBackKeyPressedTimes = 1;
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        mBackKeyPressedTimes = 0;
                    }
                }
            }.start();
            return;
        } else {
           for(Activity activity:activityList){
               Log.i("wangdong1", "onBackPressed: "+activityList.size());
               activity.finish();
           }
        }

        super.onBackPressed();
    }
    }
