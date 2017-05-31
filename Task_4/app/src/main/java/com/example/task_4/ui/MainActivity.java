package com.example.task_4.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.task_4.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText id;
    EditText name;
    EditText lname;
    EditText phone;
    EditText mail;
    EditText skype;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.et_id);
        name = (EditText) findViewById(R.id.et_name);
        lname = (EditText) findViewById(R.id.et_lname);
        phone = (EditText) findViewById(R.id.et_phone);
        mail = (EditText) findViewById(R.id.et_mail);
        skype = (EditText) findViewById(R.id.et_skype);
        btnsave = (Button) findViewById(R.id.btn_main_save);
        btnsave.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.list_persons)
        {
            Intent intent = new Intent(MainActivity.this, ListpersonActivity.class);
            showList(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void showList(Intent intent)
    {
        startActivity(intent);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case (R.id.btn_main_save):
                Intent intent = new Intent(MainActivity.this, ListpersonActivity.class);
                clearData();
                showList(intent);
                break;
            default:
                break;

        }
    }

    private void clearData()
    {
        id.setText("");
        name.setText("");
        lname.setText("");
        phone.setText("");
        mail.setText("");
        skype.setText("");
    }


}
