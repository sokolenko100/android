package com.example.work.task_7_note_book;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Viktor on 18.01.2017.
 */

public class CRUDSharedPreferences {

    private static final String TAG = "CRUDSharedPreferences: ";
    public final String FREFS_NAME = "CRUD APP";
    public final String CALK_CONSTANT = "PersonBook";

    public void create(Context context, Person p) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(FREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        ResultListObj resultListObj = new ResultListObj();
        resultListObj.resList = read(context);
        resultListObj.resList.add(p);
        Gson gson = new Gson();

        String jsonRezult = gson.toJson(resultListObj);
        Log.d(TAG, jsonRezult);
        editor.putString(CALK_CONSTANT, jsonRezult);
        editor.commit();
    }

    public ArrayList<Person> read(Context context)
    {
        ResultListObj resultListObj = new ResultListObj();
        SharedPreferences sharedPreferences = context.getSharedPreferences(FREFS_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(CALK_CONSTANT)) {
            String str = sharedPreferences.getString(CALK_CONSTANT, null);
            Gson gson = new Gson();

            resultListObj.resList = gson.fromJson(str, ResultListObj.class).resList;

        } else {
            return resultListObj.resList;
        }

        return resultListObj.resList;


    }

    public void update() {

    }

    public void delete() {

    }

    private class ResultListObj
    {
        public ArrayList<Person> resList = new ArrayList<>();
    }
}
