package com.practise.practiseprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Thread t1=new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch (InterruptedException e) {
					makeToast(e.getMessage());
				}
				Intent int1=new Intent(WelcomeActivity.this,MainActivity.class);
				startActivity(int1);
				WelcomeActivity.this.finish();
						
			}
		};
		t1.start();
	}
	
	public void makeToast(String str1){
		Toast.makeText(getApplicationContext(), str1, Toast.LENGTH_LONG).show();
	}
}
