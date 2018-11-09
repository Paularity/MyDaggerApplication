package com.paularity.axcd.pokedex.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.paularity.axcd.pokedex.Models.Dummy;
import com.paularity.axcd.pokedex.R;

import java.util.ArrayList;

public class DummyCardListAdapter extends BaseAdapter
{
    private static final String TAG = "ListAdapter";

    protected Context context;
    protected ArrayList<Dummy> dummy;

    protected TextView textName,textDescription,textTime;

    public DummyCardListAdapter(Context context, ArrayList<Dummy> dummy)
    {
        this.context = context;
        this.dummy = dummy;
    }

    @Override
    public int getCount() { return dummy.size(); }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return position; }



    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.card_one_layout, null);

        textName = convertView.findViewById(R.id.cardTitle);
        textDescription = convertView.findViewById(R.id.cardDescription);
        textTime = convertView.findViewById(R.id.cardTime);

        textName.setId(position);
        textName.setText( String.valueOf(dummy.get(position).getTitle()) );
        textDescription.setText(String.valueOf(dummy.get(position).getDescription()) );
        textTime.setText(String.valueOf(dummy.get(position).getTime()) );

        return convertView;
    }
}
