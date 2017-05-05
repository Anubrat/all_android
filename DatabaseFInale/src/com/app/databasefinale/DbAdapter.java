package com.app.databasefinale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DbAdapter {
	DbHelper helper;
	SQLiteDatabase db;
	
	public DbAdapter(Context context) {
		helper=new DbHelper(context);
		db=helper.getWritableDatabase();
	}
	
	public void savaData(ContentValues values){
		long vari=db.insert(DbConstants.TABLE_NAME, null, values);
		Log.v("Success", "Insert Success::"+vari);
	}

	public Cursor showData(){
		String columns[]=new String[]{DbConstants._ID,DbConstants._NAME};
		Cursor c=db.query(DbConstants.TABLE_NAME, columns, null, null, null, null, null);
		Log.v("Names", " "+c.getCount());
		return c;
	}
}
