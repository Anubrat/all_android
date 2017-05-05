package com.mobile.app.playingwithdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Manandhar on 5/26/16.
 */
public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context ctx) {
        super(ctx,DbConstant.DB_NAME,null,DbConstant.VERSION_CODE);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(DbConstant.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DbConstant.DELETE_QUERY);
        onCreate(db);
    }

}
