package com.android.wpf.bean;

/**
 * Created by Administrator on 2016/2/17.
 */
public class Userinfo {
    private String username;
    private String password;
    public Userinfo(){

    }
    public String getPassword() {
        return password;
    }

    public Userinfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Userinfo setUsername(String username) {
        this.username = username;
        return this;
    }


}
