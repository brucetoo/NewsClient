package com.example.NewClient.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.NewClient.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:17.
 */

public abstract class BaseFragment extends Fragment {

    /**
     * 在定义基类 抽象类的时候 要传递Context，并且定义成public
     */
    public  View view;
    //这个传递 context给子类很重要
    public Context ct;

    public SlidingMenu slidingMenu;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //       onActivityCreated 是初始化数据
        initData(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //传递 context
        ct = getActivity();
        //获取 main的slidingmenu传递到子类
        slidingMenu = ((MainActivity)getActivity()).getSlidingMenu();
    }

    /**
     * 定义一个 对外暴露得到View的方法
     */

    public View getRootView(){
        return view;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        //        onCreateView 是初始化 View
         view = initView(inflater);
        return view;
    }

    /**
     * 初始化view   抽象出方法子类调用
     */
    public abstract View initView(LayoutInflater inflater);

    /**
     * 初始化数据
     */
    public abstract void initData(Bundle savedInstanceState);

}
