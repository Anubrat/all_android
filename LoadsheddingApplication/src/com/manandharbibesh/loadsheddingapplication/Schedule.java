package com.manandharbibesh.loadsheddingapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Schedule extends Activity {
	public int h1s;
	Button b1;
	public TextView view1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.schedule_activity);
		view1=(TextView)findViewById(R.id.myGroup);
		view1.setText("Hello");
		super.onCreate(savedInstanceState);
		try{
			}catch(Exception err){
			Toast.makeText(this,err.getMessage(),Toast.LENGTH_LONG).show();
		}
	}
}
