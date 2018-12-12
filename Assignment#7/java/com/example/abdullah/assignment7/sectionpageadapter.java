package com.example.abdullah.assignment7;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class sectionpageadapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList=new ArrayList<>();
    private final List<String> mNames=new ArrayList<>();

    public sectionpageadapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment( Fragment f, String title)
    {
        mFragmentList.add(f);
        mNames.add(title);
    }


    public CharSequence getPageTitle(int position) {
        return mNames.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
