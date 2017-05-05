package com.example.bsc.csitoldquestioncollection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapter {
	
	DbHelper helper;
	SQLiteDatabase db;
	
	DbAdapter(Context ctx){
		helper=new DbHelper(ctx);
		db=helper.getWritableDatabase();
	}
	
	public void onInsert(ContentValues cv){
		db.insert(DbConstant.TABLE_NAME, null, cv);
	}
	
	public Cursor onDisplay(){
		String[] columns=new String[]{DbConstant.YEAR,DbConstant.SITE};
		return db.query(DbConstant.TABLE_NAME, columns, null, null, null, null, null);
	}
	
	

}
