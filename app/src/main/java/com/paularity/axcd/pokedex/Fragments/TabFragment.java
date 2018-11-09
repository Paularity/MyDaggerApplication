package com.paularity.axcd.pokedex.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paularity.axcd.pokedex.Adapters.SectionsPageAdapter;
import com.paularity.axcd.pokedex.Dagger.MyApplication;
import com.paularity.axcd.pokedex.Models.Dummy;
import com.paularity.axcd.pokedex.R;

import javax.inject.Inject;

public class TabFragment extends Fragment
{
    private static final String TAG = "TabFragment";

    private static final String FLAG_CURRENTLY_SELECTED_TAB_INDEX = "currentlySelectedTabIndex";

    private ViewPager viewPager;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    SectionsPageAdapter adapter;
    TabLayout tabLayout;

    @Inject SecondFragment secondFragment;
    @Inject ActiveTabFragment activeTabFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ((MyApplication)getActivity().getApplication()).getAppComponent().inject(this);

        View view = inflater.inflate(R.layout.tab_fragment_layout, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.tab_container);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        SecondFragment secondFragment = new SecondFragment();
        ActiveTabFragment activeTabFragment = new ActiveTabFragment();

        setupViewPagerTab(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Messages");
        tabLayout.getTabAt(1).setText("Active");
//        tabLayout.getTabAt(2).setText("Groups");
//        tabLayout.getTabAt(3).setText("Calls");

        if(savedInstanceState != null)
        {
            final int currentTabIndex = savedInstanceState.getInt(FLAG_CURRENTLY_SELECTED_TAB_INDEX, -1);
            if(currentTabIndex > -1)
            {
                viewPager.setCurrentItem(currentTabIndex);
            }
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
//        int i = tabLayout.getSelectedTabPosition();
//        outState.putInt("index", i);
        if(viewPager != null)
        {
            int i = viewPager.getCurrentItem();
            outState.putInt(FLAG_CURRENTLY_SELECTED_TAB_INDEX, i);
        }

    }

    private void setupViewPagerTab(ViewPager viewPager)
    {
        adapter = new SectionsPageAdapter(getChildFragmentManager());

        adapter.addFragment(secondFragment);
        adapter.addFragment(activeTabFragment);
//        adapter.addFragment(activeTabFragment);
//        adapter.addFragment(activeTabFragment);

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

    }

    public void selectTab(int position)
    {
        tabLayout.getTabAt(position).select();
        viewPager.setCurrentItem(position);
    }


}
