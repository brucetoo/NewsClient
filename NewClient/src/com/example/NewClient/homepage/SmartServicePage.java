package com.example.NewClient.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.NewClient.base.BasePage;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 10:12.
 */
public class SmartServicePage extends BasePage {
    /**
     * 画界面，初始化数据
     *
     * @param ct
     */
    public SmartServicePage(Context ct) {
        super(ct);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        TextView textView = new TextView(ct);
        textView.setText("我是SmartService");
        return textView;
    }

    @Override
    public void initData() {

    }
}
