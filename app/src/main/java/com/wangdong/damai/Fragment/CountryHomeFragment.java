package com.wangdong.damai.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.wangdong.damai.R;
import com.wangdong.damai.View.ListViewForScrollView;
import com.wangdong.damai.http.OkHttpTool;

/**
 * Created by wd794 on 2016/3/5 0005.
 */
public class CountryHomeFragment extends BaseFragment {
    private View contentView;
    private ConvenientBanner banner;
    private TextView tvMeiRi;
    private TextView tvJinXuan;
    private TextView tvQuanGuo;
    private ListViewForScrollView lvJinXuan;
    private ListViewForScrollView lvQuanGuo;
    private ImageView iv_MeiRi1;
    private ImageView iv_MeiRi2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(contentView==null){
            contentView=inflater.inflate(R.layout.frg_home_country,null);
        }
        OkHttpTool okHttpTool=OkHttpTool.newInstance(getActivity());
        initView();
        initData();
        return contentView;
    }

    private void initData() {

    }

    private void initView() {
        banner = (ConvenientBanner)contentView.findViewById(R.id.cb_home_country_banner);
        tvMeiRi = (TextView)contentView.findViewById(R.id.tv_home_country_meiri);
        tvJinXuan = (TextView)contentView.findViewById(R.id.tv_home_country_jinxuan);
        tvQuanGuo = (TextView)contentView.findViewById(R.id.tv_home_country_quanguo);
        lvJinXuan = (ListViewForScrollView)contentView.findViewById(R.id.lv_home_country_jinxuan);
        lvQuanGuo = (ListViewForScrollView)contentView.findViewById(R.id.lv_home_country_quanguo);
        iv_MeiRi1 = (ImageView)contentView.findViewById(R.id.iv_home_country_meiri1);
        iv_MeiRi2 = (ImageView)contentView.findViewById(R.id.iv_home_country_meiri2);


    }
}
