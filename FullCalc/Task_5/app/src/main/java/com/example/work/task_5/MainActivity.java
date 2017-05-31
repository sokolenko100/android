package com.example.work.task_5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener
{
    public final static String EXTRA_MESSAGE = "com.example.Task_5.MESSAGE";
    private Button btnClick_0;
    private Button btnClick_1;
    private Button btnClick_2;
    private Button btnClick_3;
    private Button btnClick_4;
    private Button btnClick_5;
    private Button btnClick_6;
    private Button btnClick_7;
    private Button btnClick_8;
    private Button btnClick_9;
    private Button btnClick_C;
    private Button btnClick_equals;
    private Button btnClick_mult;
    private Button btnClick_minus;
    private Button btnClick_plus;
    private Button btnClick_div;
    private TextView evResult;
    private String operandStr = "";
    private String firstNumbStr = "";
    private String secondNumbStr = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        evResult = (TextView) findViewById(R.id.edit_out_text);
        btnClick_0 = (Button) findViewById(R.id.button_0);
        btnClick_0.setOnClickListener(this);
        btnClick_1 = (Button) findViewById(R.id.button_1);
        btnClick_1.setOnClickListener(this);
        btnClick_2 = (Button) findViewById(R.id.button_2);
        btnClick_2.setOnClickListener(this);
        btnClick_3 = (Button) findViewById(R.id.button_3);
        btnClick_3.setOnClickListener(this);
        btnClick_4 = (Button) findViewById(R.id.button_4);
        btnClick_4.setOnClickListener(this);
        btnClick_5 = (Button) findViewById(R.id.button_5);
        btnClick_5.setOnClickListener(this);
        btnClick_6 = (Button) findViewById(R.id.button_6);
        btnClick_6.setOnClickListener(this);
        btnClick_7 = (Button) findViewById(R.id.button_7);
        btnClick_7.setOnClickListener(this);
        btnClick_8 = (Button) findViewById(R.id.button_8);
        btnClick_8.setOnClickListener(this);
        btnClick_9 = (Button) findViewById(R.id.button_9);
        btnClick_9.setOnClickListener(this);
        btnClick_C = (Button) findViewById(R.id.button_C);
        btnClick_C.setOnClickListener(this);
        btnClick_equals = (Button) findViewById(R.id.button_equals);
        btnClick_equals.setOnClickListener(this);
        btnClick_mult = (Button) findViewById(R.id.button_mult);
        btnClick_mult.setOnClickListener(this);
        btnClick_minus = (Button) findViewById(R.id.button_min);
        btnClick_minus.setOnClickListener(this);
        btnClick_plus = (Button) findViewById(R.id.button_plus);
        btnClick_plus.setOnClickListener(this);
        btnClick_div = (Button) findViewById(R.id.button_div);
        btnClick_div.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void chackEditString() {
        if (firstNumbStr.length() >= 2 && firstNumbStr.charAt(0) == '0') {
            firstNumbStr = firstNumbStr.replaceFirst("0", "");
        }
        if (secondNumbStr.length() >= 2 && secondNumbStr.charAt(0) == '0') {
            secondNumbStr = secondNumbStr.replaceFirst("0", "");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0: {
                if (operandStr == "") {
                    firstNumbStr += "0";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "0";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_1: {
                if (operandStr == "") {
                    firstNumbStr += "1";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "1";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_2: {
                if (operandStr == "") {
                    firstNumbStr += "2";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "2";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_3: {
                if (operandStr == "") {
                    firstNumbStr += "3";
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "3";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_4: {
                if (operandStr == "") {
                    firstNumbStr += "4";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "4";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_5: {
                if (operandStr == "") {
                    firstNumbStr += "5";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "5";
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_6: {
                if (operandStr == "") {
                    firstNumbStr += "6";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "6";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_7: {
                if (operandStr == "") {
                    firstNumbStr += "7";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "7";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_8: {
                if (operandStr == "") {
                    firstNumbStr += "8";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "8";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_9: {
                if (operandStr == "") {
                    firstNumbStr += "9";
                    this.chackEditString();
                    evResult.setText(firstNumbStr);
                } else {
                    secondNumbStr += "9";
                    this.chackEditString();
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_div: {
                if (firstNumbStr != "" && operandStr == "") {
                    operandStr = "/";
                    evResult.setText(operandStr);
                }
                break;
            }
            case R.id.button_mult: {
                if (firstNumbStr != "" && operandStr == "") {
                    operandStr = "*";
                    evResult.setText(operandStr);
                }
                break;
            }
            case R.id.button_plus: {
                if (firstNumbStr != "" && operandStr == "") {
                    operandStr = "+";
                    evResult.setText(operandStr);
                }
                break;
            }
            case R.id.button_min: {
                if (firstNumbStr != "" && operandStr == "") {
                    operandStr = "-";
                    evResult.setText(operandStr);
                }
                break;
            }
            case R.id.button_C: {
                if (operandStr == "") {
                    if (firstNumbStr.length() > 0) {
                        firstNumbStr = firstNumbStr.substring(0, firstNumbStr.length() - 1);
                    }
                    evResult.setText(firstNumbStr);
                } else {
                    if (secondNumbStr.length() > 0) {
                        secondNumbStr = secondNumbStr.substring(0, secondNumbStr.length() - 1);
                    }
                    evResult.setText(secondNumbStr);
                }
                break;
            }
            case R.id.button_equals: {
                if (firstNumbStr != "" && secondNumbStr != "") {
                    int a = Integer.parseInt(firstNumbStr);
                    int b = Integer.parseInt(secondNumbStr);
                    int res = 0;
                    res = calcul(a, b, operandStr);
                    String resultSTR= firstNumbStr +","+ operandStr+","+secondNumbStr+","+res;
                    firstNumbStr = Integer.toString(res);
                    evResult.setText(String.valueOf(firstNumbStr));
                    secondNumbStr = "";
                    operandStr = "";

                    Intent intent = new Intent(this, CRUDSharedPrefences.class);
                    intent.putExtra(MainActivity.EXTRA_MESSAGE,resultSTR);
                    startActivity(intent);
                }
                break;
            }
        }
    }

    public int calcul(int a, int b, String op) {
        int ret = 0;
        switch (op) {
            case "+":
                ret = a + b;
                break;
            case "-":
                ret = a - b;
                break;
            case "*":
                ret = a * b;
                break;
            case "/":
                ret = a / b;
                break;
        }
        return ret;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("calc Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
