package com.practise.sharedandpreference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity {
	TextView myView;
	boolean pref;
	SharedPreferences myPreference;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		myPreference=getSharedPreferences("myPref", Context.MODE_PRIVATE);
		SharedPreferences.Editor edit=myPreference.edit();

		String name=myPreference.getString("Name", "Default");
		Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
		
	}
}