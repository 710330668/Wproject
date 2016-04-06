package com.android.wpf.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.android.wpf.common.MyApplication;


public class SharedPrefsUtil {
  private static SharedPrefsUtil instance;

  private static final String PREFS_MODULE_INFO = "shared_prefs";

  private final SharedPreferences mSharedPreferences;

  private SharedPrefsUtil() {
    mSharedPreferences = MyApplication.getContext().getSharedPreferences(
            PREFS_MODULE_INFO, Context.MODE_PRIVATE);
  }

  public static SharedPrefsUtil getInstance() {
    if (instance == null) {
      instance = new SharedPrefsUtil();
    }
    return instance;
  }

  public SharedPreferences getSharedPreferences() {
    return mSharedPreferences;
  }

  public Editor getEditor() {
    SharedPreferences pref = getSharedPreferences();
    return pref.edit();
  }

  public String getString(String key, String defValue) {
    return getSharedPreferences().getString(key, defValue);
  }

  public int getInt(String key, int defValue) {
    return getSharedPreferences().getInt(key, defValue);
  }

  public float getFloat(String key, float defValue) {
    return getSharedPreferences().getFloat(key, defValue);
  }

  public long getLong(String key, long defValue) {
    return getSharedPreferences().getLong(key, defValue);
  }

  public boolean getBoolean(String key, boolean defValue) {
    return getSharedPreferences().getBoolean(key, defValue);
  }

  public boolean putInt(String key, int value) {
    Editor edit = getEditor();
    edit.putInt(key, value);
    boolean isSuccess = edit.commit();
    return isSuccess;
  }

  public boolean putBoolean(String key, boolean value) {
    Editor edit = getEditor();
    edit.putBoolean(key, value);
    boolean isSuccess = edit.commit();
    return isSuccess;
  }

  public boolean putFloat(String key, float value) {
    Editor edit = getEditor();
    edit.putFloat(key, value);
    boolean isSuccess = edit.commit();
    return isSuccess;
  }

  public boolean putLong(String key, long value) {
    Editor edit = getEditor();
    edit.putLong(key, value);
    boolean isSuccess = edit.commit();
    return isSuccess;
  }

  public boolean putString(String key, String value) {
    Editor edit = getEditor();
    edit.putString(key, value);
    boolean isSuccess = edit.commit();
    return isSuccess;
  }

  /**
   * 清空所有数据
   */
  public void clearAllPreferences() {
    getEditor().clear().commit();
  }
}
