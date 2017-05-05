package com.app.alarm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	Button b1;
	TimePicker pick;
	SharedPreferences pref;
	SharedPreferences.Editor edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pref=getSharedPreferences("pref", Context.MODE_PRIVATE);
		b1=(Button)findViewById(R.id.button1);
		pick=(TimePicker)findViewById(R.id.timePicker1);
		
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				edit=pref.edit();
				int minute=pick.getCurrentMinute();
				int hours=pick.getCurrentHour();
				edit.putInt("minute", minute);
				edit.putInt("hours", hours);
				edit.commit();
				Intent int1=new Intent(MainActivity.this,ServiceIntent.class);
				startService(int1);	
			}
		});
	}
}
