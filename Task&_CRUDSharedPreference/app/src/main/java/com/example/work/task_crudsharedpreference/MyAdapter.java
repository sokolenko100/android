package com.example.work.task_crudsharedpreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by work on 27.01.2017.
 */

public class MyAdapter extends BaseAdapter
{
    private Context mContecst;
    private ArrayList<Person> personList;

    public MyAdapter(Context mContecst, ArrayList<Person> personList) {
        this.mContecst = mContecst;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return personList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if(v==null)
        {
            v= LayoutInflater.from(mContecst).inflate(R.layout.iteam_person,parent,false);
        }
      //  TextView tvName = (TextView)
        return v;
    }
}
