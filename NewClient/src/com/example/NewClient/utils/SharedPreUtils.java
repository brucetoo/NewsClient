package com.example.NewClient.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Bruce
 * Data 2014/7/15
 * Time 16:20.
 */
public class SharedPreUtils {
    private static SharedPreferences sp;
    private static String CP_NAME = "CONFIG";

    public static void saveString(Context ct, String key, String vaule) {
        if (sp == null)
            sp = ct.getSharedPreferences(CP_NAME, ct.MODE_PRIVATE);
        sp.edit().putString(key, vaule).commit();
    }

    public static String getString(Context ct, String key) {
        if (sp == null)
            sp = ct.getSharedPreferences(CP_NAME, ct.MODE_PRIVATE);
        return sp.getString(key, "");
    }
}
