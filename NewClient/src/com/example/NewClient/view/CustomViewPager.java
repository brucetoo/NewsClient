package com.example.NewClient.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 15:42.
 */
public class CustomViewPager extends LazyViewPager {


    private boolean setTouchModle = false;

    /**
     * 实现对上层 viewpager 事件的拦截  实现onInterceptTouchEvent 和 onTouchEvent方法
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (setTouchModle)
            return super.onInterceptTouchEvent(ev);
        else
            return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (setTouchModle)
            return super.onTouchEvent(ev);
        else
            return false;
    }

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
