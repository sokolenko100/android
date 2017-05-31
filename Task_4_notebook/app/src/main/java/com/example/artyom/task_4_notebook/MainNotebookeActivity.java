package com.example.artyom.task_4_notebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainNotebookeActivity extends AppCompatActivity  implements View.OnClickListener
{
    public final static String EXTRA_MESSAGE = "com.example.notebook.MESSAGE";

    TextView idPerson;
    TextView fnamePerson;
    TextView lnamePerson;
    TextView mailPerson;
    TextView skypePerson;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_notebooke);
        idPerson = (TextView) findViewById(R.id.id_person);
        fnamePerson = (TextView) findViewById(R.id.fname_person);
        lnamePerson = (TextView) findViewById(R.id.sname_person);
        mailPerson = (TextView) findViewById(R.id.mail_person);
        skypePerson = (TextView) findViewById(R.id.skype_person);
        buttonSave = (Button) findViewById(R.id.save_button);

        buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.save_button:
            {
                Intent intent = new Intent(this, secondActivity.class);
             intent.putExtra(MainNotebookeActivity.EXTRA_MESSAGE,"Hello");
              startActivity(intent);
                break;
            }
        }
    }
}
