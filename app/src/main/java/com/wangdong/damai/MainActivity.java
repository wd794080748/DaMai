package com.wangdong.damai;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wangdong.damai.Tool.LogTool;
import com.wangdong.damai.Constant.ConstantUrl;
import com.wangdong.damai.bean.HomeRecyclerView;
import com.wangdong.damai.bean.StartImage;
import com.wangdong.damai.http.IOkCallBack;
import com.wangdong.damai.http.OkHttpTool;
import com.wangdong.damai.utils.ImageLoader;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {
    private ImageView imageView;
    private String context;
    private OkHttpTool okHttpTool;
    private ImageView iv;
    private String pic;
    private TextView tvSkip;
    private HomeRecyclerView resultInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityList.add(this);
        okHttpTool = OkHttpTool.newInstance(this);
        initView();
        initData();
        //定时器，设置跳转时间
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(100);
            }
        }, 3000);
    }
    //跳过按钮的点击事件
    public void click(View view){
        mHandler.sendEmptyMessage(100);
    }

    private void initData() {
        //获取开始页面的图片
        okHttpTool.okGet(ConstantUrl.MAIN_IMAGEVIEW_URL, StartImage.class, new IOkCallBack<StartImage>() {
            @Override
            public void onSucess(StartImage resultInfo) {
                pic = resultInfo.getPic();
                LogTool.LOG_D(MainActivity.class, "---" + pic);
                context = resultInfo.getContext();
                ImageLoader.loadImage(pic, imageView);
                Log.i("wangdong5", "onSucess: " + imageView.toString());
//                Picasso.with(getApplicationContext()).load(pic).into(imageView);
            }
        }, 100);
        getHomeLocalData();
    }

    private void getHomeLocalData() {
        //获取HomeRecyclerView的对象
        okHttpTool.okGet(ConstantUrl.HOME_LOCAL_DATA_URL, HomeRecyclerView.class, new IOkCallBack<HomeRecyclerView>() {

            @Override
            public void onSucess(HomeRecyclerView resultInfo) {
                //将异步获取的对象传递到主线程
                passHomeRecyclerView(resultInfo);
            }
        }, 130);
        tvSkip.setVisibility(View.VISIBLE);

    }

    private void passHomeRecyclerView(HomeRecyclerView resultInfo) {
        this.resultInfo=resultInfo;
    }

    private void initView() {
        imageView= (ImageView) findViewById(R.id.iv_mainActivity);
        tvSkip = (TextView) findViewById(R.id.tv_skip_mainactivity);

    }

    private void updateUI(){
        if(imageView.getDrawable()==null){
            imageView.setImageResource(R.drawable.wel_splash);
        }
        //将HomeRecyclerView进行传递
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), ContentActivity.class);
        intent.putExtra("homeObject", resultInfo);
        startActivity(intent);
    }
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(resultInfo!=null){
                updateUI();
            }
            super.handleMessage(msg);
        }
    };
}
