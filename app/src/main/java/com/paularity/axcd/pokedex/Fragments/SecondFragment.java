package com.paularity.axcd.pokedex.Fragments;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.paularity.axcd.pokedex.Adapters.DummyCardListAdapter;
import com.paularity.axcd.pokedex.Dagger.MyApplication;
import com.paularity.axcd.pokedex.Helpers.FragmentCommunicator;
import com.paularity.axcd.pokedex.Models.Dummy;
import com.paularity.axcd.pokedex.R;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondFragment extends Fragment
{
    private static final String TAG = "SecondFragment";

    @BindView(R.id.listView) ListView listView;
    ArrayList<Dummy> dummyList;
    DummyCardListAdapter adapter;

    @Inject
    ActiveTabFragment activeTabFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ((MyApplication)getActivity().getApplication()).getAppComponent().inject(this);
        View view = inflater.inflate(R.layout.second_fragment_layout, container, false);
        View headerView = getLayoutInflater().inflate(R.layout.list_header_layout,null);
        ButterKnife.bind(this, view);
        listView.addHeaderView(headerView);

        listView.setClickable(true);

        dummyList = new ArrayList<Dummy>();
        dummyList.add(new Dummy("Chris Paul","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("James Harden","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Carmelo Anthony","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Lonzo Ball","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Kyle Kuzma","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Lebron James","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Brandon Ingram","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Derrick Rose","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Kawhi Leonard","Hello World!","10:00 PM",""));
        dummyList.add(new Dummy("Kobe Bryant","Hello World!","10:00 PM",""));

        adapter = new DummyCardListAdapter(getContext(), dummyList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                int pos = position-1;
                activeTabFragment.updateTitle(dummyList.get(pos).getTitle(), dummyList.get(pos).getDescription());

            }
        });

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(final Context context)
    {
        super.onAttach(context);

    }

}

