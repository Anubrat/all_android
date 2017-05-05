package com.example.bsc.csitoldquestioncollection;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText year,site;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		year=(EditText)findViewById(R.id.year);
		site=(EditText)findViewById(R.id.site);
	}
	
	public void upload(View v){
		String years=year.getText().toString();
		String sites=site.getText().toString();
		ContentValues values=new ContentValues();
		values.put(DbConstant.YEAR, years);
		values.put(DbConstant.SITE, sites);
		DbAdapter adap=new DbAdapter(this);
		adap.onInsert(values);				
	}
	
	public void show(View v){
		Intent showQuestion=new Intent(MainActivity.this,Question.class);
		startActivity(showQuestion);
	}
}
