package com.example.NewClient.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.example.NewClient.R;
import com.example.NewClient.base.BaseFragment;
import com.example.NewClient.base.BasePage;
import com.example.NewClient.homepage.*;
import com.example.NewClient.view.LazyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:16.
 */
public class HomeFragment extends BaseFragment {


    private RadioGroup radioGroup;
    private LazyViewPager lazyViewPager;
    private int checkedId = 0; //默认加载第几页

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.main_fragment, null);
        radioGroup = (RadioGroup) view.findViewById(R.id.main_radio);
        lazyViewPager = (LazyViewPager) view.findViewById(R.id.viewpager);

        return view;
    }

    //存放home的五个page
    List<BasePage> pages = new ArrayList<BasePage>();

    @Override
    public void initData(Bundle savedInstanceState) {
        //传递父类的context
        pages.add(new FunctionPage(ct));
        pages.add(new GovAffairsPage(ct));
        pages.add(new NewsCenterPage(ct));
        pages.add(new SettingPage(ct));
        pages.add(new SmartServicePage(ct));

        /**
         *  初始完数据后  在设置适配器
         */

        HomePageAdapter adapter = new HomePageAdapter(ct, pages);

        lazyViewPager.setAdapter(adapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_function:
                        //false 表示不加载中间页
                        lazyViewPager.setCurrentItem(0, false);
                        checkedId = 0;
                        break;
                    case R.id.rb_news_center:
                        lazyViewPager.setCurrentItem(1, false);
                        checkedId = 1;
                        break;
                    case R.id.rb_smart_service:
                        lazyViewPager.setCurrentItem(2, false);
                        checkedId = 2;
                        break;
                    case R.id.rb_gov_affairs:
                        lazyViewPager.setCurrentItem(3, false);
                        checkedId = 3;
                        break;
                    case R.id.rb_setting:
                        lazyViewPager.setCurrentItem(4, false);
                        checkedId = 4;
                        break;
                }
            }
        });

        radioGroup.check(checkedId);
    }

    class HomePageAdapter extends PagerAdapter {

        private Context ct;
        private List<BasePage> pages;

        public HomePageAdapter(Context ct, List<BasePage> pages) {

            this.ct = ct;
            this.pages = pages;

        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            if (view == o) {
                return true;
            }
            return false;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //获取viewpager add 子View
            ((LazyViewPager) container).addView(pages.get(position).getRootView(), 0);
            return pages.get(position).getRootView();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
          //  super.destroyItem(container, position, object);

            ((LazyViewPager) container).removeView(pages.get(position).getRootView());
        }
    }
}
