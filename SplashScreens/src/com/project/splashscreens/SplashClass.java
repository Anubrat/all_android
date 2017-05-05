package com.project.splashscreens;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

public class SplashClass extends Activity {
	TextView view1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		view1=(TextView)findViewById(R.id.textView2);
		new CountDownTimer(4000,1000) {
			@Override
			public void onTick(long millisUntilFinished) {
			//	view1.setText(""+millisUntilFinished/1000);
				if(millisUntilFinished/1000==1){
					view1.setText(""+millisUntilFinished/1000);
				}
			}
			
			@Override
			public void onFinish() {
				view1.setText("");
			}
		}.start();
		Thread thread1=new Thread(){
			public void run(){
				try{
					sleep(3000);
					
				}catch(Exception err){
					Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
				}
				Message msgObj=handler.obtainMessage();
				Bundle b=new Bundle();
				b.putString("Status","OK");
				msgObj.setData(b);
				handler.sendMessage(msgObj);
			}
			
			Handler handler=new Handler(){
				@Override
				public void handleMessage(Message msg) {
					String aResponse=msg.getData().getString("Status");
					view1.setText(aResponse);
					Intent int1=new Intent(SplashClass.this,MainActivity.class);
					startActivity(int1);
					SplashClass.this.finish();
			
				}
				
			};
			
		};
		thread1.start();
	}
}