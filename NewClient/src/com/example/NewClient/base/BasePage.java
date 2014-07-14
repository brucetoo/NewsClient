package com.example.NewClient.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 10:14.
 */
public abstract class BasePage{
    /**
     *  画界面，初始化数据
     */
  private View view;
  public Context ct;

    public BasePage(Context ct) {
       this.ct = ct;
        //从上下文中获取 LayoutInflater
      LayoutInflater inflater =
              (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         view =initView(inflater);
}


    /**
     * 定义一个 对外暴露得到View的方法
     */

    public View getRootView(){
        return view;
    }

    /**
     * 初始化View
     * @param inflater
     * @return
     */
    public abstract View initView(LayoutInflater inflater) ;

    public abstract void initData();

}
