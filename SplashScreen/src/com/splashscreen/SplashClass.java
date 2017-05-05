package com.splashscreen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashClass extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread t1=new Thread(){
			public void run(){
				try {
					sleep(9000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					Intent int1=new Intent(SplashClass.this,MainActivity.class);
					startActivity(int1);
					SplashClass.this.finish();
				}
			}
		};

		t1.start();
	}
}
