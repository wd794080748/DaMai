package com.wangdong.damai;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wangdong.damai.Tool.LogTool;
import com.wangdong.damai.Url.ConstantUrl;
import com.wangdong.damai.bean.StartImage;
import com.wangdong.damai.http.IOkCallBack;
import com.wangdong.damai.http.OkHttpTool;
import com.wangdong.damai.utils.ImageLoader;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.internal.Util;

public class MainActivity extends BaseActivity {
    private ImageView imageView;
    private String context;
    private OkHttpTool okHttpTool;
    private ImageView iv;
    private String pic;
    private TextView tvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityList.add(this);
        okHttpTool = OkHttpTool.newInstance(this);
        initView();
        initData();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(100);
            }
        }, 3000);
    }
    public void click(View view){
        mHandler.sendEmptyMessage(100);
    }

    private void initData() {

        okHttpTool.okGet(ConstantUrl.MAIN_IMAGEVIEW_URL, StartImage.class, new IOkCallBack<StartImage>() {
            @Override
            public void onSucess(StartImage resultInfo) {
                pic = resultInfo.getPic();
                LogTool.LOG_D(MainActivity.class, "---" + pic);
                context = resultInfo.getContext();
                ImageLoader.loadImage(pic, imageView);
//                Picasso.with(getApplicationContext()).load(pic).into(imageView);
            }
        }, 100);
    }

    private void initView() {
        imageView= (ImageView) findViewById(R.id.iv_mainActivity);
        tvSkip = (TextView) findViewById(R.id.tv_skip_mainactivity);

    }

    private void updateUI(){
        if(imageView.getDrawable()==null){
            imageView.setImageResource(R.drawable.wel_splash);
        }
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), ContentActivity.class);
            startActivity(intent);
    }
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            updateUI();
            super.handleMessage(msg);
        }
    };
}
