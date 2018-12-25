package com.example.lanminghao201812212.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lanminghao201812212.R;

import java.util.ArrayList;
import java.util.List;

public class Frag1 extends Fragment {
    private TabLayout tabLayout;
    private ViewPager pager;
    private List<String> list = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private Frag11 aa;
    private Frag22 bb;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1,container,false);
        tabLayout = view.findViewById(R.id.tab);
        pager = view.findViewById(R.id.pager);
        tabLayout.setupWithViewPager(pager);
        aa = new Frag11();
        bb = new Frag22();

        for (int i = 0; i < 2; i++) {
            list.add("页面"+i);
        }
        fragmentList.add(aa);
        fragmentList.add(bb);
        adapter = new MyAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        return view;
    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }
    }
}
