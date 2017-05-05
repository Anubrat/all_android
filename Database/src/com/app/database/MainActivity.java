package com.app.database;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText roll,name;
	int i;
	Button save,show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
		roll=(EditText)findViewById(R.id.roll);
		name=(EditText)findViewById(R.id.Name);
		save=(Button)findViewById(R.id.Save);
		show=(Button)findViewById(R.id.Show);
	}
	
	public void save(View v){
		String rollNumber=roll.getText().toString();
		String names=name.getText().toString();
		ContentValues cv=new ContentValues();
		cv.put(DBConstant.rollNumber, rollNumber);
		cv.put(DBConstant.name, names);
		DBAdapter adapter=new DBAdapter(this);
		adapter.insertFunction(cv);
	}
	
	public void show(View v){
		DBAdapter adapter=new DBAdapter(this);
		Cursor c=adapter.showFunction();
		int[] rolls=new int[c.getCount()];
		i=0;
		while(c.moveToNext()){
			rolls[i]=c.getInt(c.getColumnIndex(DBConstant.rollNumber));
		i++;
		}
		Log.v("rolls", ""+rolls.length);
	}
}