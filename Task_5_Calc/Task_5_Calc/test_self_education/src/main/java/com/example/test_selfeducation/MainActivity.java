package com.example.test_selfeducation;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btn;
    TextView textV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        textV = (TextView)  findViewById(R.id.edit_out_text);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        textV.setText("Hello World!!!!");
        Log.d("", "кнопка Cancel");
//        btn.setText("Нажата кнопка btn");
        Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_SHORT).show();
    }
}
