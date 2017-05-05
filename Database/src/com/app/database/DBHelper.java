package com.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

	public DBHelper(Context context){
		super(context, DBConstant.databaseName, null, DBConstant.versionCode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(DBConstant.createQuery);
			Log.v("Creation", "Completed");
		}catch(Exception err){
			err.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DBConstant.deleteQuery);
		onCreate(db);
	}
	
}