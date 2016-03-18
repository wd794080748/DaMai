package com.wangdong.damai.bean;

import java.util.List;

/**
 * Created by wd794 on 2016/3/18 0018.
 */
public class HomeRecyclerView {
    private String title;

    @Override
    public String toString() {
        return "HomeRecyclerView{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;


}
