package com.example.NewClient.base;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/15
 * Time 15:51.
 */
public abstract class NewsAdapter<T,Q> extends BaseAdapter{
    /**
     * 每次调用newsadapter时 会有三个参数
     * Context
     * List<T>
     * View(listView......)  Q  表示泛型 代替可能的listview ,girdview.....
     *
     *  使该类抽象出来，就能在父类中实现下面冗余的三个方法，在子类中只需要实现 getView()方法了
     */
  private Context ct;
    private List<T> list;
    private Q view;

    public NewsAdapter(Context ct, List<T> list, Q view) {
        this.ct = ct;
        this.list = list;
        this.view = view;
    }

    public NewsAdapter(Context ct, List list) {
        this.ct = ct;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
