package com.manandharbibesh.loadsheddingapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Welcome extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Thread thread=new Thread(){
			public void run(){
				try{
					sleep(4000);
				}catch(Exception err){
					Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
				}
				Intent newIntent=new Intent(Welcome.this,Main.class);
				startActivity(newIntent);
				Welcome.this.finish();
			}
		};
		thread.start();
	}
}
