package com.example.NewClient.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.NewClient.base.BasePage;
import com.example.NewClient.bean.NewsCenterCategory;
import com.example.NewClient.utils.GsonUtils;
import com.example.NewClient.utils.HMApi;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;

/**
 * Created by Bruce
 * Data 2014/7/14
 * Time 10:12.
 */
public class NewsCenterPage extends BasePage {
    /**
     * 画界面，初始化数据
     *
     * @param ct
     */
    public NewsCenterPage(Context ct) {
        super(ct);
    }

    @Override
    public View initView(LayoutInflater inflater) {
        TextView textView = new TextView(ct);
        textView.setText("我是NewS Center");
        return textView;
    }

    @Override
    public void initData() {
        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET, HMApi.NEWS_CENTER_CATEGORIES,
                  new RequestCallBack<String>() {

                      @Override
                      public void onSuccess(ResponseInfo<String> responseInfo) {
                          // textView.setText(responseInfo.result);

                          // Gson gson = new Gson();
                          // NewsCenterCategory category =
                          // gson.fromJson(responseInfo.result,
                          // NewsCenterCategory.class);
                          LogUtils.d(responseInfo.result);

                          ProcessData(responseInfo.result);
                      }

                      @Override
                      public void onFailure(HttpException error, String msg) {
                      }
                  });
    }

    private void ProcessData(String result) {
         GsonUtils.jsonToBean(result, NewsCenterCategory.class);
    }
}
