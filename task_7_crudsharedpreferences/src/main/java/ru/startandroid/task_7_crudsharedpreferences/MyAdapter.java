package ru.startandroid.task_7_crudsharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Viktor on 27.01.2017.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Person> personList;

    public MyAdapter(Context mContext, ArrayList<Person> personList) {
        this.mContext = mContext;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null)
        {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_person, parent, false);
        }
        TextView tvName = (TextView) v.findViewById(R.id.item_name_person);
        TextView tvPhone = (TextView) v.findViewById(R.id.item_phone_person);
        ImageButton ibEdit = (ImageButton) v.findViewById(R.id.image_button_dialog);
        final Person p = personList.get(position);
        tvName.setText(p.getmName());
        tvPhone.setText(p.getmPhone());


        ibEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person.selectPerson = p;
                Intent intent = new Intent(mContext, DeteilActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        return v;
    }

}









