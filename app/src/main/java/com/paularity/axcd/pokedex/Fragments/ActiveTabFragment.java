package com.paularity.axcd.pokedex.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.paularity.axcd.pokedex.Dagger.MyApplication;
import com.paularity.axcd.pokedex.Models.Dummy;
import com.paularity.axcd.pokedex.R;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActiveTabFragment extends Fragment
{
    private static final String TAG = "ActiveTabFragment";

    @BindView(R.id.textViewHeader)
    TextView txtHeader;

    @BindView(R.id.txt_description)
    TextView txtDesc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ((MyApplication)getActivity().getApplication()).getAppComponent().inject(this);
        View view = inflater.inflate(R.layout.active_tab_fragment_layout, container, false);
        ButterKnife.bind(this, view);

        txtHeader = view.findViewById(R.id.textViewHeader);
        txtDesc = view.findViewById(R.id.txt_description);

        return view;
    }

    public void updateTitle(String title, String description)
    {
        txtHeader.setText(title);
        txtDesc.setText(description);
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }
}
