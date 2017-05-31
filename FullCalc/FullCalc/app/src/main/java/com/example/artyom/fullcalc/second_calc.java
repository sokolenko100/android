package com.example.artyom.fullcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 07.01.2017.
 */

public class second_calc extends AppCompatActivity implements View.OnClickListener {

    private Button bResult;
    private TextView evResultSec;
    private String message="";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        evResultSec = (TextView) findViewById(R.id.text_view_result);
        bResult = (Button) findViewById(R.id.button_equals);

        Intent intent = getIntent();
        message = intent.getStringExtra(calc.EXTRA_MESSAGE);
        bResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button_equals:
            {
                evResultSec.setText(message);
                break;
            }
        }
    }
}
