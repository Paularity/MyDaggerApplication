package com.paularity.axcd.pokedex.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paularity.axcd.pokedex.Dagger.MyApplication;
import com.paularity.axcd.pokedex.Models.Dummy;
import com.paularity.axcd.pokedex.R;

import javax.inject.Inject;

public class HomeFragment extends Fragment
{
    private static final String TAG = "HomeFragment";

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Inject TabFragment tabFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ((MyApplication)getActivity().getApplication()).getAppComponent().inject(this);

        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.home_container, tabFragment, "TAB_FRAGMENT").commit();

        return view;
    }

}
