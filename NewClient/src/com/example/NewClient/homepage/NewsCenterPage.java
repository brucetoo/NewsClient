package com.example.NewClient.homepage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.NewClient.MainActivity;
import com.example.NewClient.base.BasePage;
import com.example.NewClient.bean.NewsCenterCategory;
import com.example.NewClient.fragment.LeftMenuFragment;
import com.example.NewClient.utils.GsonUtils;
import com.example.NewClient.utils.HMApi;
import com.example.NewClient.utils.SharedPreUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

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
        /**
         * 提取数据，如果没联网，取缓存数据，如果联网更新数据
         */
        String value = SharedPreUtils.getString(ct,HMApi.NEWS_CENTER_CATEGORIES);
        if(!TextUtils.isEmpty(value)){
            ProcessData(value);
        }

        HttpUtils http = new HttpUtils();
        http.send(HttpRequest.HttpMethod.GET, HMApi.NEWS_CENTER_CATEGORIES,
                  new RequestCallBack<String>() {
                      @Override
                      public void onSuccess(ResponseInfo<String> responseInfo) {
                          LogUtils.d(responseInfo.result);
                          //缓存数据
                          SharedPreUtils.saveString(ct,HMApi.NEWS_CENTER_CATEGORIES,responseInfo.result);
                          ProcessData(responseInfo.result);
                      }

                      @Override
                      public void onFailure(HttpException error, String msg) {
                      }
                  });
    }

    //定义一个List 放左方menu的item
    List<String> menuItem = new ArrayList<String>();

    private void ProcessData(String result) {
        //用 gson解析 json数据实例化到 NewsCenterCategory中
        NewsCenterCategory category = GsonUtils.jsonToBean(result, NewsCenterCategory.class);
       // LogUtils.d(category.toString());
        //200表示请求成功
        if(category.retcode == 200){

          List<NewsCenterCategory.CentreCategory> data = category.data;
            for(NewsCenterCategory.CentreCategory cate :data){
                menuItem.add(cate.title);
            }
            LeftMenuFragment menuFragment = ((MainActivity)ct).getMenuFragment();
            menuFragment.initMenu(menuItem);
            menuItem.clear();
        }


















    }
}
