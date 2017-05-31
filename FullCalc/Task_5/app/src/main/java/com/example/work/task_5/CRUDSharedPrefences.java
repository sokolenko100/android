package com.example.work.task_5;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import android.app.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by work on 23.01.2017.
 */

public class CRUDSharedPrefences {


    public static final String PREFS_NAME = "CRUD_APP";
    public static final String PERSON_CONSTANT = "Person Constant";

    public CRUDSharedPrefences() {
        super();
    }

    public void savePerson(Context context, List<Result> result) {
        SharedPreferences preferences;
        SharedPreferences.Editor editor;

        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);//почитать про прайвет моде
        editor = preferences.edit();

        Gson gson = new Gson();
        String jsonPerson = gson.toJson(result);
        editor.putString(PERSON_CONSTANT, jsonPerson);
        editor.commit();//почитать
    }

    public void addPerson(Context context, Result result) {
        List<Result> resultList = getResult(context);
        if (resultList == null) {
            resultList = new ArrayList<Result>();
        }
        resultList.add(result);
        savePerson(context, resultList);
    }

    public void removePerson(Context context, Result result) {
        List<Result> resultList = getResult(context);
        if (resultList != null) {
            resultList.remove(result);
            savePerson(context, resultList);
        }
    }

    public void updatePerson(Context context, Result newResult) {
        List<Result> resultList = getResult(context);
        if (resultList != null) {
            for (Result result : resultList) {
                if (result.equals(newResult)) result = newResult;
            }
        }
    }

    public ArrayList<Result> getResult(Context context) {
        SharedPreferences preferences;
        List<Result> resultList;

        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        if (preferences.contains(PERSON_CONSTANT)) {
            String jsonResult = preferences.getString(PERSON_CONSTANT, null);
            Gson gson = new Gson();
            Result[] resultsItems = gson.fromJson(jsonResult, Result[].class);//чиать про гсон

            resultList = Arrays.asList(resultsItems);
            resultList = new ArrayList<Result>(resultList);
        } else {
            return null;
        }
        return (ArrayList<Result>) resultList;
    }
}
