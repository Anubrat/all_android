package com.loadshedding.newloadshedding;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button1=(Button)findViewById(R.id.myButton);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				try{
					Calendar c1=Calendar.getInstance();
					int date=c1.get(Calendar.HOUR);
					Toast.makeText(getApplicationContext(), String.valueOf(date), Toast.LENGTH_LONG).show();
				
				}catch(Exception err){
					Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
				}
			}
		});
	}
	
	
}
