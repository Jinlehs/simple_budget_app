package com.example.jl6_trialbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import org.w3c.dom.Text;

import java.util.List;

//inflates data to the entry cell
public class EntryAdapter extends ArrayAdapter<Entry>
{
    //constructor of entry adapter
    public EntryAdapter(Context context, int resource, List<Entry> entryList){
        super(context, resource, entryList);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        Entry entry = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_cell, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.itemName);
        TextView date = (TextView) convertView.findViewById(R.id.itemDate);
        TextView cost = (TextView) convertView.findViewById(R.id.itemCost1);

        name.setText(entry.getName());
        date.setText(entry.getDate());
        cost.setText(String.valueOf(entry.getCost()));


        return convertView;
    }




}
