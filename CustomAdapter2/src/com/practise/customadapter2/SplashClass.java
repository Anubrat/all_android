package com.practise.customadapter2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SplashClass extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_splash);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		super.onCreate(savedInstanceState);
		
		Thread th=new Thread(){
			public void run() {
			try{
				sleep(3000);
				}catch(Exception err){
					Toast.makeText(getApplicationContext(),err.getMessage(),Toast.LENGTH_LONG).show();
				}

			Intent nt1=new Intent(SplashClass.this,MainActivity.class);
			startActivity(nt1);
			SplashClass.this.finish();
			}
		};
		th.start();
		
	}
	
	
}
