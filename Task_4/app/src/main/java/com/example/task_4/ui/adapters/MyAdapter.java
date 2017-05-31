package com.example.task_4.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import  com.example.task_4.model.Person;


import java.util.ArrayList;

/**
 * Created by Artyom on 15.01.2017.
 */

public class MyAdapter extends BaseAdapter implements Filterable
{
    Context mContext;
    LayoutInflater layoutInflater;
    ArrayList<Person> persons,tempItems, suggestions;

    public MyAdapter(Context mContext, ArrayList<Person> persons)
    {
        this.mContext= mContext;
        this.layoutInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.persons= persons;
        tempItems = new ArrayList<Person>(persons);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
