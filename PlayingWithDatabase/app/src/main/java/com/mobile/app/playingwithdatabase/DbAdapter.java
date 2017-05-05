package com.mobile.app.playingwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Manandhar on 5/26/16.
 */
public class DbAdapter {
    public DbHelper helper;
    public Context ctx;
    public SQLiteDatabase db;

    public DbAdapter(Context ctx){
        helper=new DbHelper(ctx);
        db=helper.getWritableDatabase();
    }

    public void insert(ContentValues cv){
        //Insery
        db.insert(DbConstant.TBL_NAME,null,cv);
    }

    public Cursor showFuncton(){
        String[] columns=new String[]{DbConstant.rollNumber,DbConstant.name};
        return db.query(DbConstant.TBL_NAME,columns,null,null,null,null,null);
    }

}
