package com.example.NewClient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import com.example.NewClient.fragment.HomeFragment;
import com.example.NewClient.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
    /**
     * Called when the activity is first created.
     */

    private SlidingMenu slidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setBehindContentView(R.layout.left_menu_frame);

        setContentView(R.layout.main_frame);

        //Fragment fragment1 = new Fragment1();
      //  getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment1).commit();



        slidingMenu = getSlidingMenu();
        //2 设置滑动菜单是在左边出来还是右边出来
        //参数可以设置左边LEFT，也可以设置右边RIGHT ，还能设置左右LEFT_RIGHT
        slidingMenu.setMode(SlidingMenu.LEFT);
        //3 设置滑动菜单出来之后，内容页，显示的剩余宽度
        //slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_offset);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //4 设置滑动菜单的阴影 设置阴影，阴影需要在开始的时候，特别暗，慢慢的变淡
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        //5 设置阴影的宽度
        slidingMenu.setShadowWidth(R.dimen.shadow_width);

        //6 设置滑动菜单的范围
        // 第一个参数 SlidingMenu.TOUCHMODE_FULLSCREEN 可以全屏滑动
        // 第二个参数 SlidingMenu.TOUCHMODE_MARGIN 只能在边沿滑动
        // 第三个参数 SlidingMenu.TOUCHMODE_NONE 不能滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        //创建fragment
        LeftMenuFragment menuFragment = new LeftMenuFragment();
        //获取fragment的管理者
        getSupportFragmentManager()
                //开启事物
                .beginTransaction()
                        //替换
                .replace(R.id.left_menu_frame, menuFragment, "Menu")
                        //提交
                .commit();

        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, homeFragment).commit();
    }


    public void swithFragment(Fragment fragment){
        //将主界面用切换后的fragment代替
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,fragment).commit();
        slidingMenu.toggle();
    }

}
