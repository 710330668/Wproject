package com.android.wpf.common;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/2/17.
 */
public class MyApplication extends Application {
    public static RequestQueue queue;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        //得到volley队列对象
        queue= Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueues(){
        return queue;
    }

    public static Context getContext(){
        return context;
    }
}
