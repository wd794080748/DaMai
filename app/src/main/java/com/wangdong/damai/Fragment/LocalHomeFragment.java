package com.wangdong.damai.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangdong.damai.R;

import java.util.List;

/**
 * Created by wd794 on 2016/3/5 0005.
 */
public class LocalHomeFragment extends BaseFragment {
    private View contentView;
    private RecyclerView mRecyclerView;
    private List<String> titleList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(contentView==null){
            contentView=inflater.inflate(R.layout.frg_home_local,null);
        }
        initView();
        initData();
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));

        return contentView;
    }

    private void initData() {

    }

    private void initView() {
        mRecyclerView = (RecyclerView)contentView.findViewById(R.id.recyclerview_home_local);
    }
}
