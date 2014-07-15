package com.example.NewClient.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.NewClient.R;
import com.example.NewClient.base.BaseFragment;
import com.example.NewClient.base.NewsAdapter;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:38.
 */
public class LeftMenuFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @ViewInject(R.id.lv_menu_news_center)
    private ListView newsListView;

    private View view;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.layout_left_menu, null);
        ViewUtils.inject(this, view);
        //设置newsListView点击事件
        newsListView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    private List<String> menuList = new ArrayList<String>();
    private MenuAdapter adapter;

    /**
     * 初始化 LeftFragment 的menuItem
     *
     * @param menuItem
     */
    public void initMenu(List<String> menuItem) {
        menuList.clear();
        menuList.addAll(menuItem);
        //每次点击新闻都会初始化adapter，所以把adapter抽取出，为空时才new
        if (adapter == null) {
            adapter = new MenuAdapter(ct, menuList);
            newsListView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        //  adapter.setCurPosition(0);//初始选择的位置为0
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        /**
         * 设置完点击事件后，必须在adapter的方法中加上 notifyDataSetChanged 方法通知界面更新
         */
        adapter.setCurPosition(i);
        slidingMenu.toggle();
    }


    class MenuAdapter extends NewsAdapter {
        private Context ct;
        private List<String> menuList;
        private int curPosition = 0;//初始选择的位置为0

        public MenuAdapter(Context ct, List list) {
            super(ct, list);
            this.ct = ct;
            this.menuList = list;
        }

        //定位点击的位置
        public void setCurPosition(int position) {
            curPosition = position;
            //位置 需要更新
            //**
            // 此处非常重要
            notifyDataSetChanged();
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(ct, R.layout.layout_item_menu, null);
            }
            TextView tv = (TextView) view.findViewById(R.id.tv_menu_item);
            ImageView iv = (ImageView) view.findViewById(R.id.iv_menu_item);
            tv.setText(menuList.get(i));

            //注意设置背景方法
            if (curPosition == i) {
                tv.setTextColor(getResources().getColor(R.color.red));
                iv.setBackgroundResource(R.drawable.menu_arr_select);
                view.setBackgroundResource(R.drawable.menu_item_bg_select);
            } else {
                tv.setTextColor(getResources().getColor(R.color.white));
                iv.setBackgroundResource(R.drawable.menu_arr_normal);
                view.setBackgroundResource(R.drawable.transparent);
            }

            return view;
        }
    }

}
