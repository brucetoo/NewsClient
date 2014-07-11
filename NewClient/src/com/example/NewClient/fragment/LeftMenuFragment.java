package com.example.NewClient.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.NewClient.MainActivity;
import com.example.NewClient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruce
 * Data 2014/7/11
 * Time 15:38.
 */
public class LeftMenuFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listView;
    private View view;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) getActivity().findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,
                                                                android.R.id.text1,initData());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    private List<String> initData(){
          List<String> list = new ArrayList<String>();
        list.add("Bruce TOO1");
        list.add("Bruce TOO2");
        list.add("Bruce TOO3");
        list.add("Bruce TOO4");
        list.add("Bruce TOO5");
        list.add("Bruce TOO6");
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view =  inflater.inflate(R.layout.list_view,null);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

         Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new Fragment1();
                break;
            case 1:
                fragment = new Fragment1();
                break;
            case 2:
                fragment = new Fragment1();
                break;
            case 3:
                fragment = new Fragment1();
                break;
            case 4:
                fragment = new Fragment1();
                break;
            case 5:
                fragment = new Fragment1();
                break;

        }

        switchFragment(fragment);

    }

    private void switchFragment(Fragment f) {
        if(f != null){
            if(getActivity() instanceof MainActivity){
                ((MainActivity)getActivity()).swithFragment(f);
            }
        }
    }
}
