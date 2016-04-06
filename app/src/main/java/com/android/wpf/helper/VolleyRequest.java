package com.android.wpf.helper;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.wpf.common.MyApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/17.
 */
public class VolleyRequest {

    public static StringRequest stringRequest;
    public static Context context;

    public static void RequestGet(Context context,String url,String tag,VolleyInterface vif){
        MyApplication.getHttpQueues().cancelAll(tag);
        stringRequest=new StringRequest(Request.Method.GET,url,vif.loadListener(),vif.errorListener());
        stringRequest.setTag(tag);
        MyApplication.getHttpQueues().add(stringRequest);
        MyApplication.getHttpQueues().start();
    }

    public static void RequestPost(Context context,String url,String tag, final HashMap<String,String>params,VolleyInterface vif){
        MyApplication.getHttpQueues().cancelAll(tag);
        stringRequest=new StringRequest(Request.Method.POST,url,vif.loadListener(),vif.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getHttpQueues().add(stringRequest);
        MyApplication.getHttpQueues().start();

    }
}
