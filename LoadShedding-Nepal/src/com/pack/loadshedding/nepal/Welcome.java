package com.pack.loadshedding.nepal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Welcome extends Activity {
 TextView view1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Thread thread=new Thread(){
			public void run(){
				try{
					
					sleep(4000);
				}catch(Exception err){
					err.printStackTrace();
				}
				Intent goToMainActivity=new Intent(Welcome.this,MainActivity.class);
				startActivity(goToMainActivity);
				Welcome.this.finish();
			}
		};
		thread.start();
	}

}
