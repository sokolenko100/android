package com.example.work.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by work on 12.03.2017.
 */

public class MyDBHelper extends SQLiteOpenHelper
{
    public MyDBHelper(Context context) {
        super(context,Config.DB_name,null,Config.DB_version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Config.command_Crate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Config.command_Delete);
        onCreate(db);
    }
}
