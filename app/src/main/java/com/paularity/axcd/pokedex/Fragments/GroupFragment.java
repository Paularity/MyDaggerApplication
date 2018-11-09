package com.paularity.axcd.pokedex.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paularity.axcd.pokedex.R;

import org.w3c.dom.Text;

public class GroupFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener
{
    private static final String TAG = "SearchFragment";

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.group_fragment_layout, container, false);

        textView = (TextView) view.findViewById(R.id.txt_groups);
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        return false;
    }

    public void updateHeader(String value)
    {
        textView.setText(value);
    }


}
