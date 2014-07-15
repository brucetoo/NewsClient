package com.example.NewClient.utils;

import com.google.gson.Gson;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 19:59.
 */


/**
 * Json 数据转换的工具类，用泛型
 */
public class GsonUtils {
    public static <T> T jsonToBean(String json, Class<T> clz) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, clz);
        return t;
    }
}
