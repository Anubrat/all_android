package com.app.databasefinale;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 text=(EditText)findViewById(R.id.name);
	}
	
	public void saveData(View v){
		ContentValues values=new ContentValues();
		values.put(DbConstants._NAME,"BIBESH");
		DbAdapter adapter=new DbAdapter(this);
		adapter.savaData(values);
	}
	
	public void showData(View v){
		DbAdapter adap=new DbAdapter(this);
		Cursor c=adap.showData();
		Log.v("Name",String.valueOf(c.getCount()));
	}
}

