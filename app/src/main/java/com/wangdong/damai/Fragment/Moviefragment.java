package com.wangdong.damai.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangdong.damai.R;

/**
 * Created by wd794 on 2016/3/5 0005.
 */
public class Moviefragment extends BaseFragment {
    View contentview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentview == null) {
            contentview = inflater.inflate(R.layout.frg_movie, null);
        }
        return contentview;
    }
}
