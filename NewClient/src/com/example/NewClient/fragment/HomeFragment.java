package com.example.NewClient.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.example.NewClient.R;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:16.
 */
public class HomeFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.main_fragment, null);
        return view;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
