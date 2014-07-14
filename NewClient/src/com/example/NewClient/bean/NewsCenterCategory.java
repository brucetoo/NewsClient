package com.example.NewClient.bean;

import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 19:24.
 */
public class NewsCenterCategory {

    public List<NewsCentreCategory> data;
    public List<Integer> extend;
    public int retcode;

    public static class NewsCentreCategory {
        public List<NewsCentreCategoryItem> children;
        public int id;
        public String title;
        public int type;
        public String url;
        public String url1;
        public String dayurl;
        public String excurl;
        public String weekurl;
    }

    public static class NewsCentreCategoryItem {
        public int id;
        public String title;
        public int type;
        public String url;
    }
}
