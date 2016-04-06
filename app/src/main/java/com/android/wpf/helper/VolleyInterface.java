package com.android.wpf.helper;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2016/2/17.
 */
public abstract class VolleyInterface {
    public Context mContext;
    public static Response.Listener<String> listener;
    public static Response.ErrorListener errorListener;

    public VolleyInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this.mContext = context;
        this.listener = listener;
        this.errorListener = errorListener;
    }

    public Response.Listener<String> loadListener() {
        listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onMySuccess(response);
            }
        };
        return listener;
    }

    public Response.ErrorListener errorListener() {
        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
            }
        };
        return errorListener;
    }
    public abstract void onMySuccess(String result);
    public abstract void onMyError(VolleyError error);
}
