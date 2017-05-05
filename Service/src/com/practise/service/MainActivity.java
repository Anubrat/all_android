package com.practise.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button b1;
	Boolean isStarted=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				StartAndStopService();
			}
		});
	}
	
	public void StartAndStopService(){
		if(isStarted==false){
			isStarted=true;
			startService(new Intent(this,MyService.class));
			b1.setText("Stop");
		}else{
			isStarted=false;
			startService(new Intent(this,MyService.class));
			b1.setText("Start");
		}
	}
}