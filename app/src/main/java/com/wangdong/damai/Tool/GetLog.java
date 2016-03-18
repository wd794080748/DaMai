package com.wangdong.damai.Tool;

import android.util.Log;

/**
 * Created by wd794 on 2016/3/15 0015.
 */
public class GetLog {
    private boolean debug = true;

    public void getLogi(Class clazz, String log) {
        if (debug) {
            Log.i(clazz.toString(), log);
        }
    }
}
