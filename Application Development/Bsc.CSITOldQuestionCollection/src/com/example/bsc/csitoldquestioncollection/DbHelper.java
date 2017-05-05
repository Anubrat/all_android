package com.example.bsc.csitoldquestioncollection;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	

	public DbHelper(Context context) {
		super(context, DbConstant.DATABASE_NAME, null, DbConstant.VERSION_CODE);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(DbConstant.CREATE_QUERY);
		}catch(Exception err){
			err.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DbConstant.DELETE_TABLE);
		onCreate(db);
	}
}
