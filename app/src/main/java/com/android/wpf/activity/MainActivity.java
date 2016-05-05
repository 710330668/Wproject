package com.android.wpf.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.android.R;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.wpf.bean.Userinfo;
import com.android.wpf.common.BaseActivity;
import com.android.wpf.common.MyApplication;
import com.android.wpf.helper.VolleyInterface;
import com.android.wpf.helper.VolleyRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

////////测试

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置标题下面的内容
        setContentLayout(R.layout.activity_main);
        //设置标题
        setTitle("两个按钮");
        // 为左边的按钮增加监听事件
        getbtn_left().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

//       volleyGet();
//       volleyPost();
    }
    //post请求
    private void volleyPost() {
        String url="";
//        StringRequest req=new StringRequest(Request.Method.POST, url, new Response.Listener<>() {
//            @Override
//            public void onResponse(Object response) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            //传参

//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> hashmap=new HashMap<>();
//                hashmap.put("phone","12345");
//                hashmap.put("key","12346");
//                return hashmap;
//            }
//        };
//        req.setTag("abcPost");
//        MyApplication.getHttpQueues().add(req);
        Map<String,String> hashmap=new HashMap<>();
        hashmap.put("phone","12345");
        hashmap.put("key","12346");
        JSONObject jsonObject=new JSONObject(hashmap);
        JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.getHttpQueues().add(objectRequest);

    }

    //get请求
    private void volleyGet() {
        String url="";
        //建立请求对象
        VolleyRequest.RequestGet(this, url, "abcGet", new VolleyInterface(this,VolleyInterface.listener,VolleyInterface.errorListener) {
            @Override
            public void onMySuccess(String result) {

                Userinfo userInfo= JSON.parseObject(result,Userinfo.class);
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });

    }


    @Override
    protected void onStop() {
        //取消队列中的这次请求
        MyApplication.getHttpQueues().cancelAll("abcGet");
        super.onStop();
    }
}
