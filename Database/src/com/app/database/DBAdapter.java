package com.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
	DBHelper helper;
	SQLiteDatabase db;
	
	public DBAdapter(Context ctx) {
		helper=new DBHelper(ctx);
		db=helper.getWritableDatabase();
	}
	
	public void insertFunction(ContentValues cv){
		db.insert(DBConstant.tableName, null, cv);
	}
	
	public Cursor showFunction(){
		String[] columns=new String[]{DBConstant.rollNumber,DBConstant.name};
		return db.query(DBConstant.tableName, columns, null, null, null, null, null);
	}
}
