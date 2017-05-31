package com.example.artyom.calc_4_fild_and_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etFirstValue;
    private EditText etOperand;
    private EditText etSecondValue;
    private Button btnClick;
    private EditText etResult;
    private TextView evResult;
    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        etFirstValue=(EditText) findViewById(R.id.edit_text_first_value);
        etOperand=(EditText) findViewById(R.id.edit_text_operartor_value);
        etSecondValue=(EditText) findViewById(R.id.edit_text_second_value);
        etResult =(EditText) findViewById(R.id.edit_text_result);
        evResult =(TextView) findViewById(R.id.view_text_result);
        //edit_text_result
        btnClick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
    switch (v.getId()) {
        case R.id.button_calc:
            int res = 0;
            String firstValueStr = etFirstValue.getText().toString();
            String operandStr  = etOperand.getText().toString();
            String secondValueStr  = etSecondValue.getText().toString();
            int a = Integer.parseInt(firstValueStr);
            int b = Integer.parseInt(secondValueStr);
            res = calcul( a,  b, operandStr);
            evResult.setText(String.valueOf(res));
            break;
        }
    }
    public int calcul (int a, int b, String op)
    {
        int ret = 0;
        switch(op)
        {
            case "+": ret=a+b;break;
            case "-": ret=a-b;break;
            case "*": ret=a*b;break;
            case "/": ret=a/b;break;
        }
        return ret;
    }
}
