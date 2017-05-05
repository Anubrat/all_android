package com.mobile.app.databasemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Manandhar on 6/22/16.
 */
public class DbAdapter {
    public DbHelper helper;
    public Context ctx;
    public SQLiteDatabase db;

    public DbAdapter(Context ctx) {
        helper = new DbHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public void insert(ContentValues cv) {
        db.insert(DbConstant.TABLE, null, cv);
    }

    public Cursor show() {
        String[] columns = new String[]{DbConstant.name, DbConstant.age};
        return db.query(DbConstant.TABLE, columns, null, null, null, null, null);
    }
}
