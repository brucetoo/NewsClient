package com.example.NewClient.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:17.
 */
public abstract class BaseFragment extends Fragment {

    public  View view;
    private Context ct;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //       onActivityCreated 是初始化数据的 q
        initData(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //传递 context
        ct = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        //        onCreateView 是初始化 View
         view = initView(inflater);
        return view;
    }

    /**
     * 初始化view
     */
    public abstract View initView(LayoutInflater inflater);

    /**
     * 初始化数据
     */
    public abstract void initData(Bundle savedInstanceState);

}
