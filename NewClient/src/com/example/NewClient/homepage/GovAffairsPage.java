package com.example.NewClient.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.NewClient.base.BasePage;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 10:13.
 */
public class GovAffairsPage extends BasePage {
    /**
     * 画界面，初始化数据
     *
     * @param ct
     */
    public GovAffairsPage(Context ct) {
        super(ct);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        TextView textView = new TextView(ct);
        textView.setText("我是gov Affairs");
        return textView;
    }

    @Override
    public void initData() {

    }
}
