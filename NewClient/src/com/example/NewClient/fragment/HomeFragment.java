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
import com.example.NewClient.view.CustomViewPager;
import com.example.NewClient.view.LazyViewPager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:16.
 */
public class HomeFragment extends BaseFragment {

    @ViewInject(R.id.main_radio)
    private RadioGroup radioGroup;
    @ViewInject(R.id.viewpager)
    private CustomViewPager viewPager;
    private int checkedId = R.id.rb_function; //默认加载第几页

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.main_fragment, null);
      //  radioGroup = (RadioGroup) view.findViewById(R.id.main_radio);
       // viewPager = (CustomViewPager) view.findViewById(R.id.viewpager);
        ViewUtils.inject(this, view); //注入view和事件
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

        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new LazyViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               /* //如果位置是0的话，才能出现滑动菜单。。如果是其他的tab出现的时候，滑动菜单就给屏蔽掉。
                if (position == 0) {
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                } else {
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }*/
               //SlidingMenu s = ((MainActivity)getActivity()).getSlidingMenu();
                /**
                 * 获取该位置的page，初始化数据
                 */
                BasePage page =  pages.get(position);
                page.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_function:
                        //false 表示不加载中间页
                        viewPager.setCurrentItem(0, false);
                        checkedId = 0;
                        break;
                    case R.id.rb_news_center:
                        viewPager.setCurrentItem(1, false);
                        checkedId = 1;
                        break;
                    case R.id.rb_smart_service:
                        viewPager.setCurrentItem(2, false);
                        checkedId = 2;
                        break;
                    case R.id.rb_gov_affairs:
                        viewPager.setCurrentItem(3, false);
                        checkedId = 3;
                        break;
                    case R.id.rb_setting:
                        viewPager.setCurrentItem(4, false);
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
