package com.wangdong.damai.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wd794 on 2016/3/18 0018.
 */
public class ButtonTitleList {
    public static List<String> list = null;

    public static List<String> getList(){
        list=new ArrayList<>();
        list.add("签到");
        list.add("附近");
        list.add("日历");
        list.add("演唱会");
        list.add("话剧");
        list.add("体育");
        list.add("亲子");
        list.add("音乐会");
        return list;
    }
}
