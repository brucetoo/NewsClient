package com.example.NewClient.bean;

import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 19:24.
 */
public class NewsCenterCategory {

    public List<CentreCategory> data;
    public List<Integer> extend;
    public int retcode;

    public static class CentreCategory {
        public List<CentreCategoryItem> children;
        public int id;
        public String title;
        public int type;
        public String url;
        public String url1;
        public String dayurl;
        public String excurl;
        public String weekurl;
    }

    public static class CentreCategoryItem {
        public int id;
        public String title;
        public int type;
        public String url;
    }
}
