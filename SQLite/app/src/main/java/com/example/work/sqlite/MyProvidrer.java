package com.example.work.sqlite;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by work on 12.03.2017.
 */

public class MyProvidrer extends ContentProvider
{
    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static final String AUTHORITY = "com.example.work.sqlite";
    static final String PERSON_PATH = "person";
    static final Uri PERSON_CONTENT_URI= Uri.parse("content://"+AUTHORITY+"/"+PERSON_PATH);
    static final int URI_PERSON = 1;
    static final int URI_PERSON_ID = 2;
    static final String PERSON_CONTENT_TYPE= "vnd.android.cursor.dir/vnd."+AUTHORITY+"."+PERSON_PATH;
    static final String PERSON_CONTENT_ITEM_TYPE= "vnd.android.cursor.dir/vnd."+AUTHORITY+"."+PERSON_PATH;
    private MyDBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    public boolean onCreate()
    {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String tableName;
        String id;
        switch (uriMatcher.match(uri))
        {
            case URI_PERSON: {
                if (TextUtils.isEmpty(sortOrder)) {
                    sortOrder = MyObjectContruct.Name + " ASC";
                }
                tableName = Config.Table_name;
                break;
            }
            case URI_PERSON_ID: {
                id = uri.getLastPathSegment();
                if (TextUtils.isEmpty(selection)) {
                    selection = MyObjectContruct._ID + " = "+id;
                }
                else
                {
                    selection = selection + " AND" + MyObjectContruct._ID + " = "+id;
                }
                tableName = Config.Table_name;
                tableName = Config.Table_name;
                break;
            }
            default:
                throw new IllegalArgumentException("Wrong URI" + uri);
        }
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(tableName,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),PERSON_CONTENT_URI);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
