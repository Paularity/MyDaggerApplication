package com.paularity.axcd.pokedex.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "SectionsPageAdapter";

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        return this.mFragmentList.get(position);
    }

    @Override
    public int getCount()
    {
        return this.mFragmentList.size();
    }

    public void addFragment(Fragment fragment)
    {
        this.mFragmentList.add(fragment);
    }

}
