package com.app.databasefinale;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	public DbHelper(Context context) {
		super(context, DbConstants.DB_NAME,null,DbConstants.VERSION_CODE);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			Log.v("Message", "Message");
			db.execSQL(DbConstants.QUERY);
			
		}catch(Exception err){
			Log.v("Error", err.getMessage());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.v("Message", "UPGRADE");
		db.execSQL(DbConstants.DELETE_QUERY);
		onCreate(db);
		
	}

}
