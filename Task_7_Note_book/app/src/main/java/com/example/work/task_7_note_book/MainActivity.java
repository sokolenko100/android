package com.example.work.task_7_note_book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CRUDSharedPreferences crudSharedPreferences = new CRUDSharedPreferences();
        ArrayList<Person> pp = crudSharedPreferences.read(getApplicationContext());

        ListView lv = (ListView) findViewById(R.id.list_view);
        MyAdapter myAdapter = new MyAdapter(this, pp);
        lv.setAdapter(myAdapter);

        Button btnCreate = (Button) findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DeteilActivity.class);
              crudSharedPreferences.create(getApplicationContext(), new Person(22, "Vasil", "Fedorov", "fs", "gfd", "sdgfsd"));
            }
        });
    }
}
